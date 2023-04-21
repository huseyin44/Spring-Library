package huseyinoral.odev12.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.entities.concretes.Book;

public interface BookService {
	
	DataResult<List<BookDto>>  getAll();
	DataResult add(BookDto bookDto);
	DataResult update(BookDto bookDto);
	DataResult delete(BookDto bookDto,int id);
	DataResult<BookDto> getByBookNameAndId(String bookName, int id);
	
	DataResult<List<Book>> deleteByBookName(String bookName);

	//DataResult<Book> getByBookNameAndStudentName(String bookName, String studentName); 
	
	//DataResult<List<Book>> getByBookCategoryIdIn(List<Integer> categories);

	//DataResult<List<Book>> getByBookNameAndStudentSurname (String bookName, String studentName);
}
