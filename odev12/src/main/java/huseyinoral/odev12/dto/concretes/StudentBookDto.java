package huseyinoral.odev12.dto.concretes;

import huseyinoral.odev12.entities.concretes.Book;
import huseyinoral.odev12.entities.concretes.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentBookDto {
	private int id;
	private int stId;
	private int bookId;
}
