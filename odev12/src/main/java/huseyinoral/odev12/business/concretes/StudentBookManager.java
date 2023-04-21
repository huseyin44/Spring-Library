package huseyinoral.odev12.business.concretes;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huseyinoral.odev12.business.abstracts.StudentBookService;
import huseyinoral.odev12.core.exception.NullBookNameException;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dataAccess.abstracts.BookDao;
import huseyinoral.odev12.dataAccess.abstracts.BookStockDao;
import huseyinoral.odev12.dataAccess.abstracts.StudentBookDao;
import huseyinoral.odev12.dataAccess.abstracts.StudentDao;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.BookListForStudentIdDto;
import huseyinoral.odev12.dto.concretes.BookStockDto;
import huseyinoral.odev12.dto.concretes.StudentBookDto;
import huseyinoral.odev12.dto.concretes.StudentListForBookIdDto;
import huseyinoral.odev12.entities.concretes.Book;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.entities.concretes.StudentBook;

@Service
public class StudentBookManager implements StudentBookService {
	
	@Autowired
	private BookStockDao bookStockDao; //Stock bilgisini sorgulamada kullanmak için @Autowired ile farklı dao çağrılıyor
	
	//@Autowired
	//private StudentDao studentDao;
	
	@Autowired
	private BookDao bookDao;
	
	private StudentBookDao studentBookDao;
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public StudentBookManager(StudentBookDao studentBookDao) {
		super();
		this.studentBookDao = studentBookDao;
	}

	@Override
	public DataResult<List<StudentListForBookIdDto>> getByBookId(int bookId) {
		return new SuccesDataResult(this.studentBookDao.getByBookId(bookId),"0000","Succes","Öğrenciler Getirildi Kitap ID YE GÖRE");
		
		//List<StudentBook> books=this.studentBookDao.getByBookId(bookId);
		//List<StudentBook> bDto=books.stream().
				//map(book -> modelMapper.map(book,StudentBook.class)).collect(Collectors.toList());
	
		//return new SuccesDataResult(bDto,"0000","Succes","Kitaplar ID YE GÖRE ÖĞRENCİLER LİSTELENDİ");
	}

	@Override
	public DataResult<List<BookListForStudentIdDto>> getByStudentTc(String tc) {
		
		System.out.println(studentBookDao.getByStudentTc(tc));
		
		if(studentBookDao.existsByStudentTc(tc)==true) {
			throw new NullBookNameException("580","Fail","TC BULUNAMADI");
		}
		
		return new SuccesDataResult(this.studentBookDao.getByStudentTc(tc),"0000","Succes","Bir Öğrencinin Sahip Olduğu Kitaplar");
	}

	@Override
	public boolean existsByStudentTc(String tc) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public DataResult<List<BookListForStudentIdDto>> getByStudentStId(int stId) {
		return new SuccesDataResult(this.studentBookDao.getByStudentStId(stId),"0000","Succes","Bir Öğrencinin Sahip Olduğu Kitaplar");
	}
	

	@Override
	public DataResult<StudentBookDto> getByStudentStIdAndBookId(int stId, int bookId) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, 300 + 1);
		StudentBookDto studentDto =new StudentBookDto(randomNum,stId,bookId);
		
		StudentBook studentBook=modelMapper.map(studentDto, StudentBook.class);
		
		if( bookStockDao.findById(bookId).get().getUnitsInStock()<1 ) {
			throw new NullBookNameException("462","Fail","STOCKDA KİTAP YOK ");
		}
		
		else if(bookDao.findById(bookId).orElse(null)==null) {
			throw new NullBookNameException("463","Fail","bookID Bulanamadı");
		}
		
		//else if(studentDao.findById(stId).orElse(null)==null) {
			//throw new NullBookNameException("464","Fail","studentId Bulanamadı");
		//}
		
		else if(this.studentBookDao.getByStudentStIdAndBookId(stId, bookId)!=null) {
			
			 if(this.studentBookDao.getByStudentStIdAndBookId(stId, bookId).getBook().getId()==bookId 
					&& this.studentBookDao.getByStudentStIdAndBookId(stId, bookId).getStudent().getStId()==stId){
						throw new NullBookNameException("465","Fail","Öğrenci Adına Aynı Kitap Kayıtlı");
				}
		}
		
		this.studentBookDao.save(studentBook);

		return new SuccesDataResult(this.studentBookDao.getByStudentStIdAndBookId(stId, bookId),"0000","Succes","Öğrenciye Kitap Eklendi");
	}



}
