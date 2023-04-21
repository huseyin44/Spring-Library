package huseyinoral.odev12.core.utitilies.results;

public class SuccesDataResult<T> extends DataResult<T> {

	public SuccesDataResult(T data, String Code,String Description,String message ) {
		super(data, Code,Description,message);
		
	}
	
	
	public SuccesDataResult(String Code,String Description,String message) {
		super(null,Code,Description,message);
	}
	
	
	
}
