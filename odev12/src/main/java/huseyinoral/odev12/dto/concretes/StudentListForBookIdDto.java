package huseyinoral.odev12.dto.concretes;

import huseyinoral.odev12.entities.concretes.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentListForBookIdDto {

	private int bookId;
	private String bookName;
	private int studentId;
	private String tc;
	private String studentName;
	private String studentSurname;

}
