package huseyinoral.odev12.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import huseyinoral.odev12.business.abstracts.BookService;
import huseyinoral.odev12.business.abstracts.BookStockService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.BookStockDto;

@RestController
@RequestMapping("/api/bookStock")
public class BookStocksController {
	
	private BookStockService bookStockService;
	
	@Autowired
	public BookStocksController(BookStockService bookStockService) {
		super();
		this.bookStockService = bookStockService;
	}
	
	@GetMapping("/getBookWithStocks")
	public DataResult<BookStockDto> getByBookId(@RequestParam int bookId){
		return this.bookStockService.getByBookId(bookId);
	}
}
