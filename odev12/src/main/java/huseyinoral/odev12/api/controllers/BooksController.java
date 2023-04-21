package huseyinoral.odev12.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import huseyinoral.odev12.business.abstracts.BookService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Book;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	
	private BookService bookService;
	
	@Autowired
	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/getall")
	public DataResult<List<BookDto>> getAll(){
		//dto burda dönecek
		DataResult<List<BookDto>> books=this.bookService.getAll();
		return books;
	};
					
	@PostMapping("/add")
	public Result add(@RequestBody BookDto bookDto) {
		return this.bookService.add(bookDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody BookDto bookDto) {
		return this.bookService.update(bookDto);
	}
	
	@DeleteMapping("/deleteByIdForOneBook")
	public Result delete( BookDto bookDto,@RequestParam int id) {
		return this.bookService.delete(bookDto,id);
	}
	
	@GetMapping("/getByListBookName")
	public DataResult<BookDto> getByBookNameAndId(@RequestParam String bookName,@RequestParam int id){
		return this.bookService.getByBookNameAndId(bookName,id);
	}
	
	
	@DeleteMapping("/delete/deleteAllForBookName")
	public DataResult<List<Book>> deleteByBookName(@RequestParam String bookName){
		return this.bookService.deleteByBookName(bookName);
	}
	
}
