package huseyinoral.odev12.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import huseyinoral.odev12.entities.concretes.Book;

@Repository
public interface BookDao extends JpaRepository<Book,Integer>{
	
	Book getByBookNameAndId(String bookName, int id);  //select * from books where book_name= bookName
	
	@Modifying
	//@Transactional
	@Query(value="Delete From Book b where b.bookName=:bookName")
	void deleteByBookName(@Param("bookName") String bookName);
	
	//Book getByBookNameAndStudentName(String bookName, String studentName); //select * from books where book_name=bookName and student_name=studentName
	
	//List<Book> getByBookCategoryIdIn(List<Integer> categories); //select * from books where category_id in(1,2,3,4)
	
	//@Query("From books where bookName=:bookName and studentName:studentName")
	//List<Book> GetByBookNameAndStudentName (String bookName, String studentName);

}
