package huseyinoral.odev12.dto.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookListForStudentIdDto {
	private int bookId;
	private String bookName;
	private int studentId;
	private String studentName;
	private String studentSurname;

}
