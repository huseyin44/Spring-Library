package huseyinoral.odev12.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import huseyinoral.odev12.entities.concretes.BookStock;

@Repository
public interface BookStockDao extends JpaRepository<BookStock,Integer> {
	
	BookStock getByBookId(int bookId);
	
}
