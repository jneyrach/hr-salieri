package sshr.domainmodel;


public class DummyEntity extends BaseEntity {

	private String _name;
	private String _code;
	
	
	private DummyEntity() throws EntityAccessNotAllowedException {
	
		super();
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
