
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
@Table(name = "airh_ast_def_horario")
public class DefinicionHorario extends com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario {

    @Id
    @TableGenerator(name = "airh_ast_def_horario", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_def_horario")    
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "tipo_dia_id", referencedColumnName = "id")
    private TipoDia _tipoDia;

    @ManyToOne
    @JoinColumn(name = "horario_id", referencedColumnName = "id")
    private Horario _horario;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;
    
    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _updateDate;
    
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _createDate;
    
    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaInicio;
    
    @Column(name = "fecha_termino")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaTermino;

    @Column(name = "status_")
    private String _status;
    
    @Column(name = "correlativo")
    private Integer _correlativo;
    
    @Column(name = "obs")
    private String _obs;
        
    @Column(name = "hora_ini")
    private Integer _horaInicio;
    
    @Column(name = "minu_ini")
    private Integer _minutosInicio;
    
    @Column(name = "hora_cola")
    private Integer _horaColacion;
    
    @Column(name = "minu_cola")
    private Integer _minutosColacion;
    
    @Column(name = "hora_ter")
    private Integer _horaTermino;
    
    @Column(name = "minu_ter")
    private Integer _minutosTermino;

    
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
    public TipoDia getTipoDia() {
        return _tipoDia;
    }

    @Override
    public void setTipoDia(com.synapsis.rrhh.asistencia.domainmodel.TipoDia tipoDia) {
        this._tipoDia = (TipoDia) tipoDia;
        super.setTipoDia(tipoDia);
    }

    @Override
    public Horario getHorario() {
        return _horario;
    }

    @Override
    public void setHorario(com.synapsis.rrhh.asistencia.domainmodel.Horario horario) {
        this._horario = (Horario) horario;
        super.setHorario(horario);
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
    public Date getFechaInicio() {
        return _fechaInicio;
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this._fechaInicio = fechaInicio;
        super.setFechaInicio(fechaInicio);
    }

    @Override
    public Date getFechaTermino() {
        return _fechaTermino;
    }

    @Override
    public void setFechaTermino(Date fechaTermino) {
        this._fechaTermino = fechaTermino;
        super.setFechaTermino(fechaTermino);
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
    public Integer getCorrelativo() {
        return _correlativo;
    }

    @Override
    public void setCorrelativo(Integer correlativo) {
        this._correlativo = correlativo;
        super.setCorrelativo(correlativo);
    }

    @Override
    public String getObs() {
        return _obs;
    }

    @Override
    public void setObs(String obs) {
        this._obs = obs;
        super.setObs(obs);
    }

    @Override
    public Integer getHoraInicio() {
        return _horaInicio;
    }

    @Override
    public void setHoraInicio(Integer horaInicio) {
        this._horaInicio = horaInicio;
        super.setHoraInicio(horaInicio);
    }

    @Override
    public Integer getMinutosInicio() {
        return _minutosInicio;
    }

    @Override
    public void setMinutosInicio(Integer minutosInicio) {
        this._minutosInicio = minutosInicio;
        super.setMinutosInicio(minutosInicio);
    }

    @Override
    public Integer getHoraColacion() {
        return _horaColacion;
    }

    @Override
    public void setHoraColacion(Integer horaColacion) {
        this._horaColacion = horaColacion;
        super.setHoraColacion(horaColacion);
    }

    @Override
    public Integer getMinutosColacion() {
        return _minutosColacion;
    }

    @Override
    public void setMinutosColacion(Integer minutosColacion) {
        this._minutosColacion = minutosColacion;
        super.setMinutosColacion(minutosColacion);
    }

    @Override
    public Integer getHoraTermino() {
        return _horaTermino;
    }

    @Override
    public void setHoraTermino(Integer horaTermino) {
        this._horaTermino = horaTermino;
        super.setHoraTermino(horaTermino);
    }

    @Override
    public Integer getMinutosTermino() {
        return _minutosTermino;
    }

    @Override
    public void setMinutosTermino(Integer minutosTermino) {
        this._minutosTermino = minutosTermino;
        super.setMinutosTermino(minutosTermino);
    }
    
 
    public DefinicionHorario() {}
    
    public DefinicionHorario(com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario model) {
        
        this._autor = (Persona) model.getAutor();
        this._correlativo = model.getCorrelativo();
        this._createDate = model.getCreateDate();
        this._fechaInicio = model.getFechaInicio();
        this._fechaTermino = model.getFechaTermino();
        this._horaColacion = model.getHoraColacion();
        this._horaInicio = model.getHoraInicio();
        this._horaTermino = model.getHoraTermino();
        this._horario = (Horario) model.getHorario();
        this._id = model.getId();
        this._minutosColacion = model.getMinutosColacion();
        this._minutosInicio = model.getMinutosInicio();
        this._minutosTermino = model.getMinutosTermino();
        this._obs = model.getObs();
        this._status = model.getStatus();
        this._tipoDia = (TipoDia) model.getTipoDia();
        this._updateDate = model.getUpdateDate();
        
    }
    
}
