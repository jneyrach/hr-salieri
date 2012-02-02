package sshr.servicemodel;


public final class GenericCrudServiceException extends Exception {

	public GenericCrudServiceException() {
	
		super();
	}

	public GenericCrudServiceException(String msg) {
	
		super(msg);
	}

	public GenericCrudServiceException(Throwable t) {
	
		super(t);
	}

	public GenericCrudServiceException(String msg, Throwable t) {
	
		super(msg, t);
	}

}