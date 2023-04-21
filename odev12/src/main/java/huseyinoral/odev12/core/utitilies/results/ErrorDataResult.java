package huseyinoral.odev12.core.utitilies.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String Code,String Description, String message ) {
		super(data, Code, Description,message);
		
	}
	
	public ErrorDataResult(T data, String Description) {
		super(data,Description);
	}
	
	public ErrorDataResult(String Code,String Description,String message) {
		super(null,Code,Description,message);
	}
	

	
}
