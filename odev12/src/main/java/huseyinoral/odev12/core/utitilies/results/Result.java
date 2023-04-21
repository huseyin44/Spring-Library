package huseyinoral.odev12.core.utitilies.results;

public class Result {
	
	private String Code;
	private String Description ;
	private String message;
	
	public Result(String Description) {
		this.Description=Description;
	}
	
	public Result(String Code,String Description, String message) {
		this.Code=Code;
		this.Description=Description;
		this.message=message;
	}
	
	public String getCode() {
		return this.Code;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public String getMessage() {
		return this.message;
	}
}
