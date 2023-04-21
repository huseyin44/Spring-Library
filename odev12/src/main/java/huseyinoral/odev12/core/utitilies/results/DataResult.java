package huseyinoral.odev12.core.utitilies.results;

public class DataResult<T> extends Result {
	
	private T data;
	
	public DataResult(T data,String Code,String Description, String message) {
		super(Code,Description, message);
		this.data=data;
	}

	public DataResult(T data,String Description) {
		super(Description);
		this.data=data;
	}

	public T getData() {
		return this.data;
	}
	
}
