
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;


@Entity
@Table(name = "airh_ast_centros_trabajo")
public class CentroTrabajo extends com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo {

    @Id
    @TableGenerator(name = "airh_ast_centros_trabajo", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_centros_trabajo")
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
    
    @ManyToOne
    @JoinColumn(name = "ubi_geo_id", referencedColumnName = "id")
    private UbicacionGeografica _ubicacionGeografica;
    
    @OneToMany(mappedBy = "_centroTrabajo", targetEntity = EncargadoCentroTrabajo.class, fetch = FetchType.EAGER)
    private Set<EncargadoCentroTrabajo> _responsables = new HashSet<EncargadoCentroTrabajo>();
    
    
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

    @Override
    public UbicacionGeografica getUbicacionGeografica() {
        return _ubicacionGeografica;
    }

    @Override
    public void setUbicacionGeografica(com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica ubicacionGeografica) {
        this._ubicacionGeografica = (UbicacionGeografica) ubicacionGeografica;
        super.setUbicacionGeografica(ubicacionGeografica);
    }

    @Override
    public Set<com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo> getResponsables() {
        
        Set<com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo> responsables = new HashSet<com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo>();
        for (EncargadoCentroTrabajo e : this._responsables) {
                responsables.add((com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo)e);
        }
        
        return responsables;
    }

    @Override
    public void setResponsables(Set<com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo> responsables) {
               
        for (com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo e : responsables) {
                this._responsables.add((EncargadoCentroTrabajo)e);
        }
        
        super.setResponsables(responsables);
        
    }

    
    public CentroTrabajo() {}
    
    public CentroTrabajo(com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo model) {
    
        this._id = model.getId();
        this._code = model.getCode();
        this._name = model.getName();
        this._desc = model.getDesc();
        this._status = model.getStatus();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        this._autor = (Persona) model.getAutor();
        this._ubicacionGeografica = (UbicacionGeografica) model.getUbicacionGeografica();
        this.setResponsables(model.getResponsables());
    
    }

}
