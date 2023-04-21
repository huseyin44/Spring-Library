package huseyinoral.odev12.core.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String Description ;
    private String statusCode;
    private String message;
 
    public ErrorResponse(String message,String Description ,String statusCode)
    {
        super();
        this.statusCode=statusCode;
        this.message = message;
        this.Description=Description ;
    }
}