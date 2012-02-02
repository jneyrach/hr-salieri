package sshr.datamodel;


public final class EntityQueryParameter {
    
    private int _parCode;
    private int _parOrdinal;
	
    private String _parName;
	
    private Class _parType;

	
    private EntityQueryParameter() { }

    public EntityQueryParameter(int parCode, int parOrdinal, String parName, Class parType) {
	
		this._parCode    = parCode;
		this._parName    = parName;
		this._parType    = parType;
		this._parOrdinal = parOrdinal;
    }


    public int getParCode() {
	
        return this._parCode;
    }

    public void setParCode(int parCode) {
	
        this._parCode = parCode;
    }

    public int getParOrdinal() {
	
        return this._parOrdinal;
    }

    public void setParOrdinal(int parOrdinal) {
	
        this._parOrdinal = parOrdinal;
    }

    public String getParName() {
	
        return this._parName;
    }

    public void setParName(String parName) {
	
        this._parName = parName;
    }

    public Class getParType() {
	
        return this._parType;
    }

    public void setParType(Class parType) {
	
        this._parType = parType;
    }

}
