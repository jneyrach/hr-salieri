
package com.synapsis.rrhh.asistencia.persistence.pojo;

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

@Entity
@Table(name = "airh_ast_hojas_tiempo_r")
public class HojaTiempoHorarioReal extends com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal {

    @Id
    @TableGenerator(name = "airh_ast_hojas_tiempo_r", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_hojas_tiempo_r")
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "hoja_teorico_id")
    private HojaTiempoHorarioTeorico _hojaTiempoTeorico;

    @Column(name = "hora_ini")
    private Integer _horarioInicioHora;

    @Column(name = "minu_ini")
    private Integer _horarioInicioMinutos;

    @Column(name = "hora_ini_cola")
    private Integer _colacionInicioHora;

    @Column(name = "minu_ini_cola")
    private Integer _colacionInicioMinutos;

    @Column(name = "hora_ini_just")
    private Integer _justificacionInicioHora;

    @Column(name = "minu_ini_just")
    private Integer _justificacionInicioMinutos;

    @Column(name = "hora_ter")
    private Integer _horarioTerminoHora;

    @Column(name = "minu_ter")
    private Integer _horarioTerminoMinutos;

    @Column(name = "hora_ter_cola")
    private Integer _colacionTerminoHora;

    @Column(name = "minu_ter_cola")
    private Integer _colacionTerminoMinutos;

    @Column(name = "hora_ter_just")
    private Integer _justificacionTerminoHora;

    @Column(name = "minu_ter_just")
    private Integer _justificacionTerminoMinutos;

    @Column(name = "horas_laborales")
    private Double _totalLaboral;

    @Column(name = "horas_sobretpo")
    private Double _totalSobretiempo;

    @Column(name = "horas_incidenc")
    private Double _totalDescuento;

    @Column(name = "horas_justif")
    private Double _totalJustificado;    
    
    @ManyToOne
    @JoinColumn(name = "justificacion_id")
    private TipoJustificacion _tipoJustificacion;
    
    //@OneToMany(mappedBy = "_hojaTiempoReal", fetch = FetchType.EAGER)
    //private Set<AjusteHorarioReal> _ajustes = new HashSet<AjusteHorarioReal>();

    
    public HojaTiempoHorarioReal() {}
    
    public HojaTiempoHorarioReal(com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal model) {

            this._id = model.getId();
            this._hojaTiempoTeorico = (HojaTiempoHorarioTeorico) model.getHojaHorarioTeorico();
            this._horarioInicioHora = model.getHorarioInicioHora();
            this._horarioInicioMinutos = model.getHorarioInicioMinutos();
            this._colacionInicioHora = model.getColacionInicioHora();
            this._colacionInicioMinutos = model.getColacionInicioMinutos();
            this._justificacionInicioHora = model.getJustificacionInicioHora();
            this._justificacionInicioMinutos = model.getJustificacionInicioMinutos();
            this._horarioTerminoHora = model.getHorarioTerminoHora();
            this._horarioTerminoMinutos = model.getHorarioTerminoMinutos();
            this._colacionTerminoHora = model.getColacionTerminoHora();
            this._colacionTerminoMinutos = model.getColacionTerminoMinutos();
            this._justificacionTerminoHora = model.getJustificacionTerminoHora();
            this._justificacionTerminoMinutos = model.getJustificacionTerminoMinutos();
            this._totalLaboral = model.getTotalLaboral();
            this._totalSobretiempo = model.getTotalSobretiempo();
            this._totalDescuento = model.getTotalDescuento();
            this._totalJustificado = model.getTotalJustificado();
            this._tipoJustificacion = (TipoJustificacion) model.getTipoJustificacion();
            //this.setAjustes(model.getAjustes());
    
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

    public HojaTiempoHorarioTeorico getHojaTiempoTeorico() {
        return _hojaTiempoTeorico;
    }

    public void setHojaTiempoTeorico(com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico hojaTiempoTeorico) {
        this._hojaTiempoTeorico = (HojaTiempoHorarioTeorico) hojaTiempoTeorico;
        super.setHojaHorarioTeorico(hojaTiempoTeorico);
    }

    @Override
    public Integer getHorarioInicioHora() {
        return _horarioInicioHora;
    }

    @Override
    public void setHorarioInicioHora(Integer horarioInicioHora) {
        this._horarioInicioHora = horarioInicioHora;
        super.setHorarioInicioHora(horarioInicioHora);
    }

    @Override
    public Integer getHorarioInicioMinutos() {
        return _horarioInicioMinutos;
    }

    @Override
    public void setHorarioInicioMinutos(Integer horarioInicioMinutos) {
        this._horarioInicioMinutos = horarioInicioMinutos;
        super.setHorarioInicioMinutos(horarioInicioMinutos);
    }

    @Override
    public Integer getColacionInicioHora() {
        return _colacionInicioHora;
    }

    @Override
    public void setColacionInicioHora(Integer colacionInicioHora) {
        this._colacionInicioHora = colacionInicioHora;
        super.setColacionInicioHora(colacionInicioHora);
    }

    @Override
    public Integer getColacionInicioMinutos() {
        return _colacionInicioMinutos;
    }

    @Override
    public void setColacionInicioMinutos(Integer colacionInicioMinutos) {
        this._colacionInicioMinutos = colacionInicioMinutos;
        super.setColacionInicioMinutos(colacionInicioMinutos);
    }

    @Override
    public Integer getJustificacionInicioHora() {
        return _justificacionInicioHora;
    }

    @Override
    public void setJustificacionInicioHora(Integer justificacionInicioHora) {
        this._justificacionInicioHora = justificacionInicioHora;
        super.setJustificacionInicioHora(justificacionInicioHora);
    }

    @Override
    public Integer getJustificacionInicioMinutos() {
        return _justificacionInicioMinutos;
    }

    @Override
    public void setJustificacionInicioMinutos(Integer justificacionInicioMinutos) {
        this._justificacionInicioMinutos = justificacionInicioMinutos;
        super.setJustificacionInicioMinutos(justificacionInicioMinutos);
    }

    @Override
    public Integer getHorarioTerminoHora() {
        return _horarioTerminoHora;
    }

    @Override
    public void setHorarioTerminoHora(Integer horarioTerminoHora) {
        this._horarioTerminoHora = horarioTerminoHora;
        super.setHorarioTerminoHora(horarioTerminoHora);
    }

    @Override
    public Integer getHorarioTerminoMinutos() {
        return _horarioTerminoMinutos;
    }

    @Override
    public void setHorarioTerminoMinutos(Integer horarioTerminoMinutos) {
        this._horarioTerminoMinutos = horarioTerminoMinutos;
        super.setHorarioTerminoMinutos(horarioTerminoMinutos);
    }

    @Override
    public Integer getColacionTerminoHora() {
        return _colacionTerminoHora;
    }

    @Override
    public void setColacionTerminoHora(Integer colacionTerminoHora) {
        this._colacionTerminoHora = colacionTerminoHora;
        super.setColacionTerminoHora(colacionTerminoHora);
    }

    @Override
    public Integer getColacionTerminoMinutos() {
        return _colacionTerminoMinutos;
    }

    @Override
    public void setColacionTerminoMinutos(Integer colacionTerminoMinutos) {
        this._colacionTerminoMinutos = colacionTerminoMinutos;
        super.setColacionTerminoMinutos(colacionTerminoMinutos);
    }

    @Override
    public Integer getJustificacionTerminoHora() {
        return _justificacionTerminoHora;
    }

    @Override
    public void setJustificacionTerminoHora(Integer justificacionTerminoHora) {
        this._justificacionTerminoHora = justificacionTerminoHora;
        super.setJustificacionTerminoHora(justificacionTerminoHora);
    }

    @Override
    public Integer getJustificacionTerminoMinutos() {
        return _justificacionTerminoMinutos;
    }

    @Override
    public void setJustificacionTerminoMinutos(Integer justificacionTerminoMinutos) {
        this._justificacionTerminoMinutos = justificacionTerminoMinutos;
        super.setJustificacionTerminoMinutos(justificacionTerminoMinutos);
    }

    @Override
    public Double getTotalLaboral() {
        return _totalLaboral;
    }

    @Override
    public void setTotalLaboral(Double totalLaboral) {
        this._totalLaboral = totalLaboral;
        super.setTotalLaboral(totalLaboral);
    }

    @Override
    public Double getTotalSobretiempo() {
        return _totalSobretiempo;
    }

    @Override
    public void setTotalSobretiempo(Double totalSobretiempo) {
        this._totalSobretiempo = totalSobretiempo;
        super.setTotalSobretiempo(totalSobretiempo);
    }

    @Override
    public Double getTotalDescuento() {
        return _totalDescuento;
    }

    @Override
    public void setTotalDescuento(Double totalDescuento) {
        this._totalDescuento = totalDescuento;
        super.setTotalDescuento(totalDescuento);
    }

    @Override
    public Double getTotalJustificado() {
        return _totalJustificado;
    }

    @Override
    public void setTotalJustificado(Double totalJustificado) {
        this._totalJustificado = totalJustificado;
        super.setTotalJustificado(totalJustificado);
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
/*
	@Override
    public Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal> getAjustes() {
        
        Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal> lista = new HashSet<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal>();
        for (AjusteHorarioReal a : this._ajustes) {
                lista.add((com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal)a);
        }
        
        return lista;
    }

    @Override
    public void setAjustes(Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal> ajustes) {
               
        for (com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal a : ajustes) {
                this._ajustes.add((AjusteHorarioReal)a);
        }
        
        super.setAjustes(ajustes);
        
    }
*/
}
