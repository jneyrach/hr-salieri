package sshr.datamodel;

import java.util.ArrayList;
import java.util.List;

public final class EntityQuery {

    private int _qryCode;
    private int _qryOrdinal;

    private String _qryName;
    private String _qryText;

    private boolean _singleResult;

    private Class _entity;
    private List<EntityQueryParameter> _parameters = new ArrayList<EntityQueryParameter>();
	

    public int getQryCode() {
	
        return this._qryCode;
    }

    public void setQryCode(int qryCode) {
	
        this._qryCode = qryCode;
    }

    public String getQryName() {
	
        return this._qryName;
    }

    public void setQryName(String qryName) {
	
        this._qryName = qryName;
    }

    public int getQryOrdinal() {
	
        return this._qryOrdinal;
    }

    public void setQryOrdinal(int qryOrdinal) {
	
        this._qryOrdinal = qryOrdinal;
    }

    public List<EntityQueryParameter> getParameters() {
	
        return this._parameters;
    }

    public void setParameters(List<EntityQueryParameter> parameters) {
	
        this._parameters = parameters;
    }

    public String getQryText() {
	
        return this._qryText;
    }

    public void setQryText(String qryText) {
	
        this._qryText = qryText;
    }

    public Class getEntity() {
	
        return this._entity;
    }

    public void setEntity(Class entity) {
	
        this._entity = entity;
    }

    public void addParameter(EntityQueryParameter p) {
	
        this._parameters.add(p);
    }

    public boolean isSingleResult() {
	
        return this._singleResult;
    }

    public void setSingleResult(boolean singleResult) {
	
        this._singleResult = singleResult;
    }

}
