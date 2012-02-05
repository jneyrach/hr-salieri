
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.synapsis.rrhh.asistencia.domainmodel.*;

@Entity
@Table(name = "airh_ast_accesos_usuarios")
public class AccesoUsuario extends com.synapsis.rrhh.asistencia.domainmodel.AccesoUsuario {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "acceso_id")
    private String _code;
	
    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona _usuario;
	

    public AccesoUsuario() {}
    
    public AccesoUsuario(com.synapsis.rrhh.asistencia.domainmodel.AccesoUsuario model) {
    
        this._id = model.getId();
        this._code = model.getCode();
        this._usuario = (Persona) model.getUsuario();
    
    }


    @Override
    public Persona getUsuario() {
        return _usuario;
    }

    @Override
    public void setUsuario(com.synapsis.rrhh.asistencia.domainmodel.Persona usuario) {
        this._usuario = (Persona) usuario;
        super.setUsuario(usuario);
    }

    @Override
    public Integer getId() {
        return _id;
    }

    @Override
    public void setId(Integer id) {
        this._id = id;
        super.setId(id);
    }

    @Override
    public String getCode() {
        return _code;
    }

    @Override
    public void setCode(String code) {
        this._code = code;
        super.setCode(code);
    }

}
