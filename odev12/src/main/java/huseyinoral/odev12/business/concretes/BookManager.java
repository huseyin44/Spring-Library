package huseyinoral.odev12.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huseyinoral.odev12.business.abstracts.BookService;
import huseyinoral.odev12.core.exception.NullBookNameException;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dataAccess.abstracts.BookDao;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Book;
import huseyinoral.odev12.entities.concretes.Student;
import jakarta.transaction.Transactional;

@Service
public class BookManager implements BookService {

	private BookDao bookDao;
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public BookManager(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public DataResult<List<BookDto>> getAll() {
		
		List<Book> books=this.bookDao.findAll();
		List<BookDto> bDto=books.stream().
				map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
		return new SuccesDataResult(bDto,"0000","Succes","Kitaplar Listelendi");
	}

	@Override
	public DataResult add(BookDto bookDto) {
		
		Book book=modelMapper.map(bookDto, Book.class);
		
		if(book.getBookName()==null  ) {
			//length
			//Nullexception gibi hata sınıfı oluşacak
			//throw new NullBookNameException();
			//Config package //REstcontrollerAdvice //exceptionhandler anatasyon
			throw new NullBookNameException("400","Fail","bookName NULL olmamalı");
		}
		
		else if(book.getBookName().length()==0) {
			throw new NullBookNameException("401","Fail","bookName boş olmamalı");
		}
		
		else if(book.getBookName()==null  ) {
			throw new NullBookNameException("402","Fail","bookWriter NULL olmamalı");
		}
		
		else if(book.getBookWriter().length()==0) {
			throw new NullBookNameException("403","Fail","bookWriter Boş olmamalı");
		}
		
		this.bookDao.save(book);
		return new SuccesDataResult(bookDao.findById(book.getId()).get(),"0000","Succes","Kitap Eklendi");
		
	}
	
	@Override
	public DataResult update(BookDto bookDto) {
		
		Book book=modelMapper.map(bookDto, Book.class);
		
		if(book.getBookName()==null  ) {
			throw new NullBookNameException("404","Fail","bookName NULL olmamalı UPDATE FAIL");
		}
		
		else if(book.getBookName().length()==0) {
			throw new NullBookNameException("405","Fail","bookName boş olmamalı UPDATE FAIL");
		}
		
		else if(book.getBookName()==null  ) {
			throw new NullBookNameException("406","Fail","bookWriter NULL olmamalı UPDATE FAIL");
		}
		
		else if(book.getBookWriter().length()==0) {
			throw new NullBookNameException("407","Fail","bookWriter Boş olmamalı UPDATE FAIL");
		}
		
		else if(bookDao.findById(book.getId()).orElse(null)==null) {
			throw new NullBookNameException("408","Fail","bookId Bulanamadı UPDATE FAIL");
		}
		
		this.bookDao.save(book);
		return new SuccesDataResult(bookDao.findById(book.getId()).get(),"0000","Succes","Kitap Güncellendi");
	}
	
	@Override
	public DataResult delete(BookDto bookDto,int id) {
		
		Book book=modelMapper.map(bookDto, Book.class);
		
		if(bookDao.findById(book.getId()).orElse(null) == null ) {
			throw new NullBookNameException("409","Fail","bookId Bulanamadı DELETE FAIL");
		}
		
		this.bookDao.deleteById(id);
		return new SuccesDataResult(book,"0000","Succes","Kitap Silindi");
	}

	@Override
	public DataResult<BookDto> getByBookNameAndId(String bookName, int id) {
		//Business kodlar olursa buraya yazılacak
		if(bookDao.findById(id).orElse(null) == null) {
			throw new NullBookNameException("411","Fail","Id Bulanamadı");
		}
		
		else if(!this.bookDao.findById(id).get().getBookName().equals(bookName) ) {
			throw new NullBookNameException("410","Fail","Id Ve BookName Aynı Olan Kitap Bulanamadı");
		}
		
		return new SuccesDataResult(this.bookDao.getByBookNameAndId(bookName,id),"0000","Succes","Id ve StudenName göre Veri Getirildi");
	}

	@Override
	@Transactional
	public DataResult<List<Book>> deleteByBookName(String bookName) {
		this.bookDao.deleteByBookName(bookName);
		return null;
	}

	

	
}
