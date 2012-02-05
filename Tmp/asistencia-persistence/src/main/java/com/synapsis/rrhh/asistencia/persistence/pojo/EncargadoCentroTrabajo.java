
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

@Entity
@Table(name = "airh_ast_enc_centros_trab")
public class EncargadoCentroTrabajo extends com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo {

    @Id
    @TableGenerator(name = "airh_ast_enc_centros_trab", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_enc_centros_trab")    
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "persona_rut", referencedColumnName = "id")
    private Persona _persona;
    
    @ManyToOne
    @JoinColumn(name = "centro_trabajo_id", referencedColumnName = "id")
    private CentroTrabajo _centroTrabajo;

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
    public Persona getPersona() {
        return _persona;
    }

    @Override
    public void setPersona(com.synapsis.rrhh.asistencia.domainmodel.Persona persona) {
        this._persona = (Persona) persona;
        super.setPersona(persona);
    }

    @Override
    public CentroTrabajo getCentroTrabajo() {
        return _centroTrabajo;
    }

    @Override
    public void setCentroTrabajo(com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo centroTrabajo) {
        this._centroTrabajo = (CentroTrabajo) centroTrabajo;
        super.setCentroTrabajo(centroTrabajo);
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

    
    public EncargadoCentroTrabajo() {}
    
    public EncargadoCentroTrabajo(com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo model) {
    
        this._id = model.getId();
        this._centroTrabajo = (CentroTrabajo) model.getCentroTrabajo();
        this._persona = (Persona) model.getPersona();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        this._autor = (Persona) model.getAutor();
    
    }

}
