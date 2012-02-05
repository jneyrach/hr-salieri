
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "airh_ast_ajustes_teorico")
public class AjusteHorarioTeorico extends com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico {

    @Id
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "hoja_teorico_id", referencedColumnName = "id")
    private HojaTiempoHorarioTeorico _hojaTiempoTeorico;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;
    
    @ManyToOne
    @JoinColumn(name = "tipo_ajuste_id", referencedColumnName = "id")
    private TipoAjusteHojaTiempo _tipoAjuste;

    @Column(name = "obs")
    private String _obs;
    
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fecha;
    
    @Column(name = "fecha_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaInicio;
    
    @Column(name = "fecha_termino")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaTermino;
    
    @Column(name = "cantidad_horas")
    private Integer _cantidadHoras;

    @Column(name = "cantidad_minutos")
    private Integer _cantidadMinutos;

    @Column(name = "hora_ini")
    private Integer _inicioHora;
    
    @Column(name = "minu_ini")
    private Integer _inicioMinutos;
    
    @Column(name = "hora_cola")
    private Integer _terminoHora;
    
    @Column(name = "minu_cola")
    private Integer _terminoMinutos;
    
    @Column(name = "hora_ter")
    private Integer _colacionHoras;
    
    @Column(name = "minu_ter")
    private Integer _colacionMinutos;    


    public AjusteHorarioTeorico() {}
    
    public AjusteHorarioTeorico(com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico model) {
        
        this._id = model.getId();
        this._hojaTiempoTeorico = (HojaTiempoHorarioTeorico) model.getHojaTiempoTeorico();
        this._fecha = model.getFecha();
        this._autor = (Persona) model.getAutor();
        this._tipoAjuste = (TipoAjusteHojaTiempo) model.getTipoAjuste();
        this._obs = model.getObs();
        this._fechaInicio = model.getFechaInicio();
        this._fechaTermino = model.getFechaTermino();
        this._cantidadHoras = model.getCantidadHoras();
        this._cantidadMinutos = model.getCantidadMinutos();
        this._inicioHora = model.getInicioHora();
        this._inicioMinutos = model.getInicioMinutos();
        this._colacionHoras = model.getColacionHoras();
        this._colacionMinutos = model.getColacionMinutos();
        this._terminoHora = model.getTerminoHora();
        this._terminoMinutos = model.getTerminoMinutos();
        
    }
    
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
    public HojaTiempoHorarioTeorico getHojaTiempoTeorico() {
        return _hojaTiempoTeorico;
    }

    @Override
    public void setHojaTiempoTeorico(com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico hojaTiempoTeorico) {
        this._hojaTiempoTeorico = (HojaTiempoHorarioTeorico) hojaTiempoTeorico;
        super.setHojaTiempoTeorico(_hojaTiempoTeorico);
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
    public TipoAjusteHojaTiempo getTipoAjuste() {
        return _tipoAjuste;
    }

    @Override
    public void setTipoAjuste(com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo tipoAjuste) {
        this._tipoAjuste = (TipoAjusteHojaTiempo) tipoAjuste;
        super.setTipoAjuste(tipoAjuste);
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
    public Date getFecha() {
        return _fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this._fecha = fecha;
        super.setFecha(fecha);
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
    public Integer getCantidadHoras() {
        return _cantidadHoras;
    }

    @Override
    public void setCantidadHoras(Integer cantidadHoras) {
        this._cantidadHoras = cantidadHoras;
        super.setCantidadHoras(cantidadHoras);
    }

    @Override
    public Integer getCantidadMinutos() {
        return _cantidadMinutos;
    }

    @Override
    public void setCantidadMinutos(Integer cantidadMinutos) {
        this._cantidadMinutos = cantidadMinutos;
        super.setCantidadMinutos(cantidadMinutos);
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
    public Integer getColacionHoras() {
        return _colacionHoras;
    }

    @Override
    public void setColacionHoras(Integer colacionHoras) {
        this._colacionHoras = colacionHoras;
        super.setColacionHoras(colacionHoras);
    }

    @Override
    public Integer getColacionMinutos() {
        return _colacionMinutos;
    }

    @Override
    public void setColacionMinutos(Integer colacionMinutos) {
        this._colacionMinutos = colacionMinutos;
        super.setColacionMinutos(colacionMinutos);
    }

}
