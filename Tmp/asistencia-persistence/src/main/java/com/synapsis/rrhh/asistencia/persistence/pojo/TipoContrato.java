
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

@Entity
@Table(name = "airh_ast_tipos_contratos")
public class TipoContrato extends com.synapsis.rrhh.asistencia.domainmodel.TipoContrato {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "name_")
    private String _name;

    @Column(name = "orden")
    private Integer _orden;

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
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        this._name = name;
        super.setName(name);
    }

    @Override
    public Integer getOrden() {
        return _orden;
    }

    @Override
    public void setOrden(Integer orden) {
        this._orden = orden;
        super.setOrden(orden);
    }
    
    public TipoContrato() {}
    
    public TipoContrato(com.synapsis.rrhh.asistencia.domainmodel.TipoContrato model) {
    
        this._id = model.getId();
        this._name = model.getName();
        this._orden = model.getOrden();
    
    }

}
