package huseyinoral.odev12.request;

import jakarta.validation.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent2 {

    ///direk obje olarak
    //obje direk String
    //@NotNull
    //@NotEmpty
    //private String studentName;

    //@NotNull
    //private Integer stId;

   // private School school;
    //private String studentName;
    //private int stId;
    @Valid
    private StudentIdVeName studentIdVeName;

    public void validateStudentIdVeName() {
        if (studentIdVeName.getStId() == null || studentIdVeName.getStudentName() == null) {
            throw new IllegalArgumentException("Boş Değer Olamaz"); //IllegalArgumentException null olduğu zamanlarda fırlatılır
        }
    }




}
