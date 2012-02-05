
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
@Table(name = "airh_ast_bandeja_justif")
public class SolicitudJustificacion extends com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion {

    @Id
    @TableGenerator(name = "airh_ast_bandeja_justif", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_bandeja_justif")    
    @Column(name = "id")
    private Integer _id;

    @Column(name = "status_")
    private String _status;
    
    @Column(name = "obs_")
    private String _obs;
    
    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaDesde;
    
    @Column(name = "fecha_termino")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaHasta;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_rut", referencedColumnName = "id")
    private Persona _funcionario;

    @ManyToOne
    @JoinColumn(name = "tipo_justif_id", referencedColumnName = "id")
    private TipoJustificacion _tipoJustificacion;
    
    @Column(name = "hora_ini")
    private Integer _inicioHora;
    
    @Column(name = "minu_ini")
    private Integer _inicioMinutos;
    
    @Column(name = "hora_ter")
    private Integer _terminoHora;
    
    @Column(name = "minu_ter")
    private Integer _terminoMinutos;

    
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
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        this._status = status;
        super.setStatus(status);
    }

    @Override
    public Date getFechaDesde() {
        return _fechaDesde;
    }

    @Override
    public void setFechaDesde(Date fechaDesde) {
        this._fechaDesde = fechaDesde;
        super.setFechaDesde(fechaDesde);
    }

    @Override
    public Date getFechaHasta() {
        return _fechaHasta;
    }

    @Override
    public void setFechaHasta(Date fechaHasta) {
        this._fechaHasta = fechaHasta;
        super.setFechaHasta(fechaHasta);
    }

    @Override
    public Persona getFuncionario() {
        return _funcionario;
    }

    @Override
    public void setFuncionario(com.synapsis.rrhh.asistencia.domainmodel.Persona funcionario) {
        this._funcionario = (Persona) funcionario;
        super.setFuncionario(funcionario);
    }

    @Override
    public TipoJustificacion getTipoJustificacion() {
        return _tipoJustificacion;
    }

    @Override
    public void setTipoJustificacion(com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion tipoJustificacion) {
        this._tipoJustificacion = (TipoJustificacion) tipoJustificacion;
        super.setTipoJustificacion(tipoJustificacion);
    }

    @Override
    public Integer getInicioHora() {
        return _inicioHora;
    }

    @Override
    public void setInicioHora(Integer inicioHora) {
        this._inicioHora = inicioHora;
        super.setInicioHora(inicioHora);
    }

    @Override
    public Integer getInicioMinutos() {
        return _inicioMinutos;
    }

    @Override
    public void setInicioMinutos(Integer inicioMinutos) {
        this._inicioMinutos = inicioMinutos;
        super.setInicioMinutos(inicioMinutos);
    }

    @Override
    public Integer getTerminoHora() {
        return _terminoHora;
    }

    @Override
    public void setTerminoHora(Integer terminoHora) {
        this._terminoHora = terminoHora;
        super.setTerminoHora(terminoHora);
    }

    @Override
    public Integer getTerminoMinutos() {
        return _terminoMinutos;
    }

    @Override
    public void setTerminoMinutos(Integer terminoMinutos) {
        this._terminoMinutos = terminoMinutos;
        super.setTerminoMinutos(terminoMinutos);
    }
    
    @Override
    public String getObs() {
        return _obs;
    }

    @Override
    public void setObs(String obs) {
        this._obs = obs;
    }    


    public SolicitudJustificacion() {}
    
    public SolicitudJustificacion(com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion model) {
        
        this._fechaDesde = model.getFechaDesde();
        this._fechaHasta = model.getFechaHasta();
        this._funcionario = (Persona) model.getFuncionario();
        this._id = model.getId();
        this._inicioHora = model.getInicioHora();
        this._inicioMinutos = model.getInicioMinutos();
        this._status = model.getStatus();
        this._terminoHora = model.getTerminoHora();
        this._terminoMinutos = model.getTerminoMinutos();
        this._tipoJustificacion = (TipoJustificacion) model.getTipoJustificacion();
        this._obs = model.getObs();
        
    }

}
