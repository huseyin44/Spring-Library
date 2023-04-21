package huseyinoral.odev12.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.BookListForStudentIdDto;
import huseyinoral.odev12.dto.concretes.BookStockDto;
import huseyinoral.odev12.dto.concretes.StudentBookDto;
import huseyinoral.odev12.entities.concretes.BookStock;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.entities.concretes.StudentBook;

@Repository
public interface StudentBookDao extends JpaRepository<StudentBook,Integer> {
	
	boolean existsByStudentTc(String tc);
	
	List<StudentBook> getByBookId(int bookId);
	List<StudentBook> getByStudentTc(String tc);
	List<StudentBook> getByStudentStId(int stId);
	
	StudentBook getByStudentStIdAndBookId(int stId, int bookId);
	
	
}
