
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airh_ast_comunas")
public class Comuna extends com.synapsis.rrhh.asistencia.domainmodel.Comuna {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "name_")
    private String _name; 

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

    public Comuna() {}
    
    public Comuna(com.synapsis.rrhh.asistencia.domainmodel.Comuna model) {
    
        this._id = model.getId();
        this._name = model.getName();
    
    }

}
