package huseyinoral.odev12.business.abstracts;

import java.util.List;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.BookStockDto;
import huseyinoral.odev12.entities.concretes.BookStock;

public interface BookStockService {
	DataResult<BookStockDto> getByBookId(int bookId);
}
