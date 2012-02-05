
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "airh_ast_tipos_atrasos")
public class TipoAtraso extends com.synapsis.rrhh.asistencia.domainmodel.TipoAtraso {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "name_")
    private String _name;
    
    @Column(name = "code_")
    private String _code;
    
    @Column(name = "desc_")
    private String _desc;
    
    @Column(name = "status_")
    private String _status;
    
    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _updateDate;
    
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _createDate;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;
    
    
    
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
    public String getDesc() {
        return _desc;
    }

    @Override
    public void setDesc(String desc) {
        this._desc = desc;
        super.setDesc(desc);
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        this._status = status;
        super.setStatus(status);
    }

    @Override
    public Date getUpdateDate() {
        return _updateDate;
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        this._updateDate = updateDate;
        super.setUpdateDate(updateDate);
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this._createDate = createDate;
        super.setCreateDate(createDate);
    }
    
    @Override
    public Persona getAutor() {
        return _autor;
    }

    @Override
    public void setAutor(com.synapsis.rrhh.asistencia.domainmodel.Persona autor) {
        this._autor = (Persona) autor;
        super.setAutor(autor);
    }

    
    public TipoAtraso() {}
    
    public TipoAtraso(com.synapsis.rrhh.asistencia.domainmodel.TipoAtraso model) {
    
        this._id = model.getId();
        this._code = model.getCode();
        this._name = model.getName();
        this._desc = model.getDesc();
        this._status = model.getStatus();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        this._autor = (Persona) model.getAutor();
    
    }

}
