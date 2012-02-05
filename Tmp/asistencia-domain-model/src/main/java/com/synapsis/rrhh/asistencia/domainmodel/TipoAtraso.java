
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class TipoAtraso extends BaseDomainEntity {

    private Persona _autor;
    
    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }  
    
}
