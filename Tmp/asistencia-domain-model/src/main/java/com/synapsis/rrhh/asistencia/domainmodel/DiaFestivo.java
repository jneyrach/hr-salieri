
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;

public abstract class DiaFestivo extends com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity {

    private Date _fechaFestivo;    
    private Persona _autor;
    
    public Date getFechaFestivo() {
        return _fechaFestivo;
    }

    public void setFechaFestivo(Date fechaFestivo) {
        this._fechaFestivo = fechaFestivo;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }
    
}
