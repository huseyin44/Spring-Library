package huseyinoral.odev12.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import huseyinoral.odev12.business.abstracts.BookService;
import huseyinoral.odev12.business.abstracts.StudentBookService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.BookListForStudentIdDto;
import huseyinoral.odev12.dto.concretes.StudentBookDto;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.dto.concretes.StudentListForBookIdDto;
import huseyinoral.odev12.entities.concretes.Book;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.entities.concretes.StudentBook;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/studentsBooks")
public class StudentsBooksController {
	
	private StudentBookService studentBookService;
	
	@Autowired
	public StudentsBooksController(StudentBookService studentBookService) {
		super();
		this.studentBookService = studentBookService;
	}
	
	@GetMapping("/getByBook_BookName")
	public DataResult<List<StudentListForBookIdDto>> getByBookId(@RequestParam int bookId){
		return this.studentBookService.getByBookId(bookId);
	}
	
	@GetMapping("/getListBooksForStudent")
	public DataResult<List<BookListForStudentIdDto>> getByStudentStId(@RequestParam int stId){
		return this.studentBookService.getByStudentStId(stId);
	}
	
	@GetMapping("/addBooksForStudents")
	public DataResult<StudentBookDto> getByStudentStIdAndBookId(@RequestParam int stId,@RequestParam int bookId) {
		return this.studentBookService.getByStudentStIdAndBookId(stId,bookId);
	}
	
}
