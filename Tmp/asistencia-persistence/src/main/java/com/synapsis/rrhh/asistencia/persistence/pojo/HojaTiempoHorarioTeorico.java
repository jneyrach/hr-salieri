
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.sql.Timestamp;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "airh_ast_hojas_tiempo_t")
public class HojaTiempoHorarioTeorico extends com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico {

    @Id
    @TableGenerator(name = "airh_ast_hojas_tiempo_t", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_hojas_tiempo_t")
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona _persona;

    @Column(name = "fecha_calendario")
    @Temporal(TemporalType.DATE)
    private Date _fechaCalendario;

    @ManyToOne
    @JoinColumn(name = "horario_id", referencedColumnName = "id")
    private Horario _horario;

    @ManyToOne
    @JoinColumn(name = "tipo_dia_id", referencedColumnName = "id")
    private TipoDia _tipoDia;
    
    @Column(name = "dia_correlativo")
    private Integer _correlativo;

    @Column(name = "hora_ini")
    private Integer _inicioHora;

    @Column(name = "minu_ini")
    private Integer _inicioMinutos;

    @Column(name = "hora_ter")
    private Integer _terminoHora;

    @Column(name = "minu_ter")
    private Integer _terminoMinutos;

    @Column(name = "hora_cola")
    private Integer _colacionHoras;

    @Column(name = "minu_cola")
    private Integer _colacionMinutos;
    
    @Column(name = "prefijo_dia")
    private String _prefijoDia;
    
    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _updateDate;
    
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _createDate;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Persona _autor;

    //@OneToMany(mappedBy = "_hojaTiempoTeorico", fetch = FetchType.EAGER)
    //private Set<AjusteHorarioTeorico> _ajustes = new HashSet<AjusteHorarioTeorico>();
    
    @OneToOne(optional = true, mappedBy = "_hojaTiempoTeorico", fetch = FetchType.EAGER)
    private HojaTiempoHorarioReal _marcas;

    
    public HojaTiempoHorarioTeorico() {}
    
    public HojaTiempoHorarioTeorico(com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico model) {
        
        this._id = model.getId();
        this._persona = (Persona) model.getPersona();
        this._fechaCalendario = model.getFechaCalendario();
        this._horario = (Horario) model.getHorario();
        this._tipoDia = (TipoDia) model.getTipoDia();
        this._correlativo = model.getCorrelativo();
        this._inicioHora = model.getInicioHora();
        this._inicioMinutos = model.getInicioMinutos();
        this._terminoHora = model.getTerminoHora();
        this._terminoMinutos = model.getTerminoMinutos();
        this._colacionHoras = model.getColacionHoras();
        this._colacionMinutos = model.getColacionMinutos();
        this._prefijoDia = model.getPrefijoDia();
        this._autor = (Persona) model.getAutor();
        this._createDate = model.getCreateDate();
        this._updateDate = model.getUpdateDate();
        //this.setAjustes(model.getAjustes());
        this._marcas = (HojaTiempoHorarioReal) model.getMarcas();
        
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
    public Persona getPersona() {
        return _persona;
    }

    @Override
    public void setPersona(com.synapsis.rrhh.asistencia.domainmodel.Persona persona) {
        this._persona = (Persona) persona;
        super.setPersona(persona);
    }
    
    @Override
    public Date getFechaCalendario() {
        return _fechaCalendario;
    }

    
    @Override
    public void setFechaCalendario(Date fechaCalendario) {
        this._fechaCalendario = fechaCalendario;
        super.setFechaCalendario(fechaCalendario);
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
    public TipoDia getTipoDia() {
        return _tipoDia;
    }

    @Override
    public void setTipoDia(com.synapsis.rrhh.asistencia.domainmodel.TipoDia tipoDia) {
        this._tipoDia = (TipoDia) tipoDia;
        super.setTipoDia(tipoDia);
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

/*    
    @Override
    public Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico> getAjustes() {
        
        Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico> lista = new HashSet<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico>();
        for (AjusteHorarioTeorico a : this._ajustes) {
                lista.add((com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico)a);
        }
        
        return lista;
    }

    
    @Override
    public void setAjustes(Set<com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico> ajustes) {
               
        for (com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico a : ajustes) {
                this._ajustes.add((AjusteHorarioTeorico)a);
        }
        
        super.setAjustes(ajustes);
        
    }
*/
    @Override
    public HojaTiempoHorarioReal getMarcas() {
        return this._marcas;
    }

    @Override
    public void setMarcas(com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal marcas) {
        this._marcas = (HojaTiempoHorarioReal) marcas;
        super.setMarcas(marcas);
    }

    @Override
	public String getPrefijoDia() {
		return _prefijoDia;
	}

    @Override
	public void setPrefijoDia(String prefijoDia) {
		this._prefijoDia = prefijoDia;
		super.setPrefijoDia(prefijoDia);
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

}
