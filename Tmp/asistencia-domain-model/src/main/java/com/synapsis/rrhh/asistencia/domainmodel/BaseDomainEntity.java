
package com.synapsis.rrhh.asistencia.domainmodel;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseDomainEntity implements Serializable {

    public static final String CODIGO_ESTADO_GENERICO_ACTIVO = "A";
    public static final String CODIGO_ESTADO_GENERICO_INACTIVO = "I";
    public static final String CODIGO_ESTADO_GENERICO_SUSPENDIDO = "S";
    
    public static final String NOMBRE_ESTADO_GENERICO_ACTIVO = "Activo";
    public static final String NOMBRE_ESTADO_GENERICO_INACTIVO = "Inactiov";
    public static final String NOMBRE_ESTADO_GENERICO_SUSPENDIDO = "Suspendido";
    
    public static final String JSON_ESTADOS_ESTANDAR = "{ \"value\": {\"A\": \"Activo\", \"S\": \"Suspendido\"} }";

    private Integer _id;
    private String _code;
    private String _name;
    private String _desc;
    private String _status;
    private Date _createDate;
    private Date _queryDate;
    private Date _updateDate;
    
    public Integer getId() {
        return this._id;
    }

    public String getCode() {
        return this._code;
    }

    public String getName() {
        return this._name;
    }

    public String getDesc() {
        return this._desc;
    }

    public Date getQueryDate() {
        return this._queryDate;
    }

    public Date getUpdateDate() {
        return this._updateDate;
    }

    public void setId(Integer newValue) {
        this._id = newValue;
    }

    public void setCode(String newValue) {
        this._code = newValue;
    }

    public void setName(String newValue) {
        this._name = newValue;
    }

    public void setDesc(String newValue) {
        this._desc = newValue;
    }

    public void setQueryDate(Date newValue) {
        this._queryDate = newValue;
    }

    public void setUpdateDate(Date newValue) {
        this._updateDate = newValue;
    }
    
    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        this._status = status;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        this._createDate = createDate;
    }
    
}
