package huseyinoral.odev12.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestStundetIdAndName {
    @NotNull
    private Integer stId;

    @NotNull
    @NotBlank
    private String studentName;
}
