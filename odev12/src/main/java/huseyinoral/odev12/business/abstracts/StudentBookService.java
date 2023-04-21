package huseyinoral.odev12.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.BookListForStudentIdDto;
import huseyinoral.odev12.dto.concretes.BookStockDto;
import huseyinoral.odev12.dto.concretes.StudentBookDto;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.dto.concretes.StudentListForBookIdDto;
import huseyinoral.odev12.entities.concretes.StudentBook;

@Repository
public interface StudentBookService {
	
	boolean existsByStudentTc(String tc);
	
	DataResult<List<StudentListForBookIdDto>> getByBookId(int bookId);
	DataResult<List<BookListForStudentIdDto>> getByStudentTc(String tc);
	DataResult<List<BookListForStudentIdDto>> getByStudentStId(int stId);
	
	DataResult<StudentBookDto> getByStudentStIdAndBookId(int stId, int bookId); //hem veriyi burda ekleniyor hemde veriyi listelemek için getli başlıyor
}
