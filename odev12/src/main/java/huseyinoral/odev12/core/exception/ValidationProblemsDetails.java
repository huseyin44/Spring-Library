package huseyinoral.odev12.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemsDetails extends ProblemDetails{
    private Map<String,String> validationErrors;  //hangialan,ne hatası var
}
