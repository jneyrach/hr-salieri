
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
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "airh_ast_nom_ct")
public class RelacionCentrotrabajoUnidad extends com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad {

    @Id
    @TableGenerator(name = "airh_ast_nom_ct", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_nom_ct")    
    @Column(name = "id")
    private Integer _id;

    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _updateDate;
    
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _createDate;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;

    @ManyToOne
    @JoinColumn(name = "centro_trabajo_id", referencedColumnName = "id")
    private CentroTrabajo _centroTrabajo;
    
    @ManyToOne
    @JoinColumn(name = "unidad_org_id", referencedColumnName = "id")
    private UnidadOrganizacional _unidadOrganizacional;
    
    
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
    public UnidadOrganizacional getUnidadOrganizacional() {
        return _unidadOrganizacional;
    }

    @Override
    public void setUnidadOrganizacional(com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional unidadOrganizacional) {
        this._unidadOrganizacional = (UnidadOrganizacional) unidadOrganizacional;
        super.setUnidadOrganizacional(unidadOrganizacional);
    }

    
    public RelacionCentrotrabajoUnidad() {}
    
    public RelacionCentrotrabajoUnidad(com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad model) {
    
        this._id = model.getId();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        this._autor = (Persona) model.getAutor();
        this._centroTrabajo = (CentroTrabajo) model.getCentroTrabajo();
        this._unidadOrganizacional = (UnidadOrganizacional) model.getUnidadOrganizacional();
    
    }

}
