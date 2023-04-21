package huseyinoral.odev12.core.exception;


public class NullBookNameException   extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -960225847391026180L;
	private String Description ;
    private String message;
    private String statusCode;
 
    public NullBookNameException() {}
 
    public NullBookNameException(String msg, String Description, String sCode)
    {
        this.message = msg;
        this.statusCode=sCode;
        this.Description=Description ;
    }
    
    public String getMessage() {
        return this.message;
    }

    public String getStatusCode() {
        return this.statusCode;
    }
    
    public String getDescription() {
    	return this.Description;
    }
}
