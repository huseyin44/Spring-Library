package huseyinoral.odev12.request;

import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent {
	@NotNull
	private Integer stId;

	@Size(min = 11,max = 11)
	@NotNull
	private String tc;

	@NotNull
	private String studentName;

	@NotNull
	private String studentSurname;

	private Integer age;

	private Lesson lesson;



}
