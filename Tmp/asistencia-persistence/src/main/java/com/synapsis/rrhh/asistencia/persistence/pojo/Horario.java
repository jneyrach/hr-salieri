
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
@Table(name = "airh_ast_horarios")
public class Horario extends com.synapsis.rrhh.asistencia.domainmodel.Horario {

    @Id
    @TableGenerator(name = "airh_ast_horarios", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_horarios")    
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
    
    @Column(name = "tolerancia_atraso")
    private Integer _toleranciaAtrasos;
    
    @Column(name = "tolerancia_sobrt")
    private Integer _toleranciaSobretiempos;

    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _updateDate;
    
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _createDate;
    
    @Column(name = "begin_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _beginDate;

    @Column(name = "due_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _dueDate;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;
    
    @ManyToOne
    @JoinColumn(name = "centro_trabajo_id", referencedColumnName = "id")
    private CentroTrabajo _centroTrabajo;

    @Column(name = "trabaja_festivo")
    private String _trabajaFestivo;
    
    @OneToMany(mappedBy = "_horario", fetch = FetchType.EAGER)
    private Set<DefinicionHorario> _definicion = new HashSet<DefinicionHorario>();    

    
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
    public Date getBeginDate() {
        return _beginDate;
    }

    @Override
    public void setBeginDate(Date beginDate) {
        this._beginDate = beginDate;
        super.setBeginDate(beginDate);
    }

    @Override
    public Date getDueDate() {
        return _dueDate;
    }

    @Override
    public void setDueDate(Date dueDate) {
        this._dueDate = dueDate;
        super.setDueDate(dueDate);
    }

    @Override
    public String getTrabajaFestivo() {
        return _trabajaFestivo;
    }

    @Override
    public void setTrabajaFestivo(String trabajaFestivo) {
        this._trabajaFestivo = trabajaFestivo;
        super.setTrabajaFestivo(trabajaFestivo);
    }

    @Override
    public Integer getToleranciaAtrasos() {
        return _toleranciaAtrasos;
    }

    @Override
    public void setToleranciaAtrasos(Integer toleranciaAtrasos) {
        this._toleranciaAtrasos = toleranciaAtrasos;
        super.setToleranciaAtrasos(toleranciaAtrasos);
    }

    @Override
    public Integer getToleranciaSobretiempos() {
        return _toleranciaSobretiempos;
    }

    @Override
    public void setToleranciaSobretiempos(Integer toleranciaSobretiempos) {
        this._toleranciaSobretiempos = toleranciaSobretiempos;
        super.setToleranciaSobretiempos(toleranciaSobretiempos);
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
    public Set<com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario> getDefinicion() {
        
        Set<com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario> definicion = new HashSet<com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario>();
        for (DefinicionHorario dh : this._definicion) {
                definicion.add((com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario)dh);
        }
        
        return definicion;
    }

    @Override
    public void setDefinicion(Set<com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario> definicion) {
               
        for (com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario dh : definicion) {
                this._definicion.add((DefinicionHorario)dh);
        }
        
        super.setDefinicion(definicion);
        
    }
    
    
    public Horario() {}
    
    public Horario(com.synapsis.rrhh.asistencia.domainmodel.Horario model) {
    
        this._id = model.getId();
        this._code = model.getCode();
        this._name = model.getName();
        this._desc = model.getDesc();
        this._trabajaFestivo = model.getTrabajaFestivo();
        this._status = model.getStatus();
        this._toleranciaAtrasos = model.getToleranciaAtrasos();
        this._toleranciaSobretiempos = model.getToleranciaSobretiempos();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        this._beginDate = model.getBeginDate();
        this._dueDate = model.getDueDate();
        this._autor = (Persona) model.getAutor();
        this._centroTrabajo = (CentroTrabajo) model.getCentroTrabajo();
        if (model.getDefinicion() != null) this.setDefinicion(model.getDefinicion());
    
    }

    @Override
    public com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario[] getDefinicionOrdenadaPorCorrelativo() {
        
        com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario[] definicion = new com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario[this._definicion.size()];
        for (DefinicionHorario dh : this._definicion) {
                definicion[dh.getCorrelativo() - 1] = dh;
        }
        
        return definicion;
    }

}
