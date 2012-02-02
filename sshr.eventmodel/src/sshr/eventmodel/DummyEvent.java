package sshr.eventmodel;


public class DummyEvent extends BaseEvent {

	private String _name;
	private String _code;
	
	
	private DummyEvent(Object source, String myHandlerCode) throws EventAccessNotAllowedException {
	
		super(source);
		
		this._myHandlerCode = myHandlerCode;
	}


	public String getName() {
	
		return this._name;
	}
	
	public String getCode() {
	
		return this._code;
	}
	
	public void setName(String name) {
	
		this._name = name;
	}
	
	public void setCode(String code) {
	
		this._code = code;
	}

}
