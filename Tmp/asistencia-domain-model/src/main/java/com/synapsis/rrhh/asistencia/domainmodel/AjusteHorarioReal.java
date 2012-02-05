
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;

public abstract class AjusteHorarioReal extends BaseDomainEntity {

    private HojaTiempoHorarioReal _hojaTiempoReal;
    private Persona _autor;
    private Persona _persona;
    private TipoAjusteHojaTiempo _tipoAjuste;
    private String _obs;
    private Date _fecha;
    private Date _fechaInicio;
    private Date _fechaTermino;
    private Integer _cantidadHoras;
    private Integer _cantidadMinutos;
    private Integer _inicioHora;
    private Integer _inicioMinutos;
    private Integer _terminoHora;
    private Integer _terminoMinutos;
    private Integer _colacionHoras;
    private Integer _colacionMinutos;    

    public HojaTiempoHorarioReal getHojaTiempoReal() {
        return _hojaTiempoReal;
    }

    public void setHojaTiempoHorarioReal(HojaTiempoHorarioReal _hojaTiempoReal) {
        this._hojaTiempoReal = _hojaTiempoReal;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }

    public TipoAjusteHojaTiempo getTipoAjuste() {
        return _tipoAjuste;
    }

    public void setTipoAjuste(TipoAjusteHojaTiempo tipoAjuste) {
        this._tipoAjuste = tipoAjuste;
    }

    public Date getFechaInicio() {
        return _fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this._fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return _fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this._fechaTermino = fechaTermino;
    }

    public Integer getCantidadHoras() {
        return _cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this._cantidadHoras = cantidadHoras;
    }

    public Integer getCantidadMinutos() {
        return _cantidadMinutos;
    }

    public void setCantidadMinutos(Integer cantidadMinutos) {
        this._cantidadMinutos = cantidadMinutos;
    }

    public Integer getInicioHora() {
        return _inicioHora;
    }

    public void setInicioHora(Integer inicioHora) {
        this._inicioHora = inicioHora;
    }

    public Integer getInicioMinutos() {
        return _inicioMinutos;
    }

    public void setInicioMinutos(Integer inicioMinutos) {
        this._inicioMinutos = inicioMinutos;
    }

    public Integer getTerminoHora() {
        return _terminoHora;
    }

    public void setTerminoHora(Integer terminoHora) {
        this._terminoHora = terminoHora;
    }

    public Integer getTerminoMinutos() {
        return _terminoMinutos;
    }

    public void setTerminoMinutos(Integer terminoMinutos) {
        this._terminoMinutos = terminoMinutos;
    }

    public Integer getColacionHoras() {
        return _colacionHoras;
    }

    public void setColacionHoras(Integer colacionHoras) {
        this._colacionHoras = colacionHoras;
    }

    public Integer getColacionMinutos() {
        return _colacionMinutos;
    }

    public void setColacionMinutos(Integer colacionMinutos) {
        this._colacionMinutos = colacionMinutos;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date fecha) {
        this._fecha = fecha;
    }

    public String getObs() {
        return _obs;
    }

    public void setObs(String obs) {
        this._obs = obs;
    }

    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona persona) {
        this._persona = persona;
    }

}
