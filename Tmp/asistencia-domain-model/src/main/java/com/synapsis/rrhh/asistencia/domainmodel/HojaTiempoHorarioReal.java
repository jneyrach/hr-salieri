
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.HashSet;
import java.util.Set;

public abstract class HojaTiempoHorarioReal extends BaseDomainEntity {

    private HojaTiempoHorarioTeorico _hojaHorarioTeorico;
    
    private Integer _horarioInicioHora;
    private Integer _horarioInicioMinutos;
    private Integer _colacionInicioHora;
    private Integer _colacionInicioMinutos;
    private Integer _justificacionInicioHora;
    private Integer _justificacionInicioMinutos;
    private Integer _horarioTerminoHora;
    private Integer _horarioTerminoMinutos;
    private Integer _colacionTerminoHora;
    private Integer _colacionTerminoMinutos;
    private Integer _justificacionTerminoHora;
    private Integer _justificacionTerminoMinutos;
    private Double _totalLaboral;
    private Double _totalSobretiempo;
    private Double _totalDescuento;
    private Double _totalJustificado;
    private TipoJustificacion _tipoJustificacion;
    
    private Set<AjusteHorarioReal> _ajustes = new HashSet<AjusteHorarioReal>();

    public HojaTiempoHorarioTeorico getHojaHorarioTeorico() {
        return _hojaHorarioTeorico;
    }

    public void setHojaHorarioTeorico(HojaTiempoHorarioTeorico hojaHorarioTeorico) {
        this._hojaHorarioTeorico = hojaHorarioTeorico;
    }

    public Integer getHorarioInicioHora() {
        return _horarioInicioHora;
    }

    public void setHorarioInicioHora(Integer horarioInicioHora) {
        this._horarioInicioHora = horarioInicioHora;
    }

    public Integer getHorarioInicioMinutos() {
        return _horarioInicioMinutos;
    }

    public void setHorarioInicioMinutos(Integer horarioInicioMinutos) {
        this._horarioInicioMinutos = horarioInicioMinutos;
    }

    public Integer getColacionInicioHora() {
        return _colacionInicioHora;
    }

    public void setColacionInicioHora(Integer colacionInicioHora) {
        this._colacionInicioHora = colacionInicioHora;
    }

    public Integer getColacionInicioMinutos() {
        return _colacionInicioMinutos;
    }

    public void setColacionInicioMinutos(Integer colacionInicioMinutos) {
        this._colacionInicioMinutos = colacionInicioMinutos;
    }

    public Integer getJustificacionInicioHora() {
        return _justificacionInicioHora;
    }

    public void setJustificacionInicioHora(Integer justificacionInicioHora) {
        this._justificacionInicioHora = justificacionInicioHora;
    }

    public Integer getJustificacionInicioMinutos() {
        return _justificacionInicioMinutos;
    }

    public void setJustificacionInicioMinutos(Integer justificacionInicioMinutos) {
        this._justificacionInicioMinutos = justificacionInicioMinutos;
    }

    public Integer getHorarioTerminoHora() {
        return _horarioTerminoHora;
    }

    public void setHorarioTerminoHora(Integer horarioTerminoHora) {
        this._horarioTerminoHora = horarioTerminoHora;
    }

    public Integer getHorarioTerminoMinutos() {
        return _horarioTerminoMinutos;
    }

    public void setHorarioTerminoMinutos(Integer horarioTerminoMinutos) {
        this._horarioTerminoMinutos = horarioTerminoMinutos;
    }

    public Integer getColacionTerminoHora() {
        return _colacionTerminoHora;
    }

    public void setColacionTerminoHora(Integer colacionTerminoHora) {
        this._colacionTerminoHora = colacionTerminoHora;
    }

    public Integer getColacionTerminoMinutos() {
        return _colacionTerminoMinutos;
    }

    public void setColacionTerminoMinutos(Integer colacionTerminoMinutos) {
        this._colacionTerminoMinutos = colacionTerminoMinutos;
    }

    public Integer getJustificacionTerminoHora() {
        return _justificacionTerminoHora;
    }

    public void setJustificacionTerminoHora(Integer justificacionTerminoHora) {
        this._justificacionTerminoHora = justificacionTerminoHora;
    }

    public Integer getJustificacionTerminoMinutos() {
        return _justificacionTerminoMinutos;
    }

    public void setJustificacionTerminoMinutos(Integer justificacionTerminoMinutos) {
        this._justificacionTerminoMinutos = justificacionTerminoMinutos;
    }

    public Double getTotalLaboral() {
        return _totalLaboral;
    }

    public void setTotalLaboral(Double totalLaboral) {
        this._totalLaboral = totalLaboral;
    }

    public Double getTotalSobretiempo() {
        return _totalSobretiempo;
    }

    public void setTotalSobretiempo(Double totalSobretiempo) {
        this._totalSobretiempo = totalSobretiempo;
    }

    public Double getTotalDescuento() {
        return _totalDescuento;
    }

    public void setTotalDescuento(Double totalDescuento) {
        this._totalDescuento = totalDescuento;
    }

    public Double getTotalJustificado() {
        return _totalJustificado;
    }

    public void setTotalJustificado(Double totalJustificado) {
        this._totalJustificado = totalJustificado;
    }

    public Set<AjusteHorarioReal> getAjustes() {
        return _ajustes;
    }

    public void setAjustes(Set<AjusteHorarioReal> ajustes) {
        this._ajustes = ajustes;
    }

	public TipoJustificacion getTipoJustificacion() {
		return _tipoJustificacion;
	}

	public void setTipoJustificacion(TipoJustificacion tipoJustificacion) {
		this._tipoJustificacion = tipoJustificacion;
	}

}
