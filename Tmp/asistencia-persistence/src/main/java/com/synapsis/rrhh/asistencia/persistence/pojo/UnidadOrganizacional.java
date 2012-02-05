
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airh_ast_unidades_org")
public class UnidadOrganizacional extends com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "name_")
    private String _name;
    
    @ManyToOne
    @JoinColumn(name = "comuna_id", referencedColumnName = "id")
    private Comuna _comuna;

    @ManyToOne
    @JoinColumn(name = "encargado", referencedColumnName = "id")
    private Persona _encargado;

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
    public Comuna getComuna() {
        return _comuna;
    }

    @Override
    public void setComuna(com.synapsis.rrhh.asistencia.domainmodel.Comuna comuna) {
        this._comuna = (Comuna) comuna;
        super.setComuna(comuna);
    }

    @Override
    public Persona getEncargado() {
        return _encargado;
    }

    @Override
    public void setEncargado(com.synapsis.rrhh.asistencia.domainmodel.Persona encargado) {
        this._encargado = (Persona) encargado;
        super.setEncargado(encargado);
    }

    public UnidadOrganizacional() {}
    
    public UnidadOrganizacional(com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional model) {
    
        this._id = model.getId();
        this._name = model.getName();
        this._comuna = (Comuna) model.getComuna();
        this._encargado = (Persona) model.getEncargado();
    
    }

}
