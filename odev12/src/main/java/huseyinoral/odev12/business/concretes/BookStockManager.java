package huseyinoral.odev12.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import huseyinoral.odev12.business.abstracts.BookStockService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dataAccess.abstracts.BookStockDao;
import huseyinoral.odev12.dto.concretes.BookDto;
import huseyinoral.odev12.dto.concretes.BookStockDto;
import huseyinoral.odev12.entities.concretes.Book;
import huseyinoral.odev12.entities.concretes.BookStock;

@Service
public class BookStockManager implements BookStockService{
	
	private BookStockDao bookStockDao;
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public BookStockManager(BookStockDao bookStockDao) {
		super();
		this.bookStockDao = bookStockDao;
	}

	@Override
	public DataResult<BookStockDto> getByBookId(int bookId) {
		return new SuccesDataResult(this.bookStockDao.getByBookId(bookId),"0000","Succes","Kitap Bilgisi Ve Stock Bilgisi Getirildi");
	}
	

	
}
