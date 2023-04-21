package huseyinoral.odev12.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentIdVeName {
    @NotNull
    @NotEmpty
    private String studentName;
    @NotNull
    private Integer stId;

}
