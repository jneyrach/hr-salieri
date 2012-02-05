
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class TipoContrato extends BaseDomainEntity {

    private Integer _orden;

    public Integer getOrden() {
        return _orden;
    }

    public void setOrden(Integer orden) {
        this._orden = orden;
    }
    
}
