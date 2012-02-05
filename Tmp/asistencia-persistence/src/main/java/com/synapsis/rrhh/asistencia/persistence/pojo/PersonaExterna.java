
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "airh_ast_personas_ex")
public class PersonaExterna extends com.synapsis.rrhh.asistencia.domainmodel.PersonaExterna {

    @Id
    @TableGenerator(name = "airh_ast_personas_ex", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_personas_ex")    
    @Column(name = "id")
	private Integer _id;
    
    @Column(name = "status_")
	private String _status;
    
    @Column(name = "ind_cena")
	private String _indCena;

    @Column(name = "ind_once")
	private String _indOnce;

    @Column(name = "ind_almuerzo")
	private String _indAlmuerzo;

    @Column(name = "ind_desayuno")
	private String _indDesayuno;
	
    @Column(name = "relacion")
	private String _tipoRelacionContractual;
	
    @Column(name = "procedencia")
	private String _procedencia;
	
    @Column(name = "persona_rut")
	private String _personaRUT;
	
    @Column(name = "persona_nombre")	
	private String _nombreCompleto;
	
    @ManyToOne
    @JoinColumn(name = "centro_trabajo_id", referencedColumnName = "id")
	private CentroTrabajo _centroTrabajo;
	
    @ManyToOne
    @JoinColumn(name = "unidad_org_id", referencedColumnName = "id")
	private UnidadOrganizacional _unidadOrganizacional;

    
    public PersonaExterna() {}
    
    public PersonaExterna(com.synapsis.rrhh.asistencia.domainmodel.PersonaExterna model) {
    
        this._id = model.getId();
        this._indAlmuerzo = model.getIndAlmuerzo();
        this._indCena = model.getIndCena();
        this._indDesayuno = model.getIndDesayuno();
        this._indOnce = model.getIndOnce();
        this._status = model.getStatus();
        this._centroTrabajo = (CentroTrabajo) model.getCentroTrabajo();
        this._unidadOrganizacional = (UnidadOrganizacional) model.getUnidadOrganizacional();
        this._nombreCompleto = model.getNombreCompleto();
        this._personaRUT = model.getPersonaRUT();
        this._procedencia = model.getProcedencia();
        this._tipoRelacionContractual = model.getTipoRelacionContractual();
    
    }    
	

	@Override
	public Integer getId() {
		return this._id;
	}

	@Override
	public void setId(Integer id) {
		this._id = id;
		super.setId(id);
	}

	@Override
	public String getIndCena() {
		return this._indCena;
	}

	@Override
	public void setIndCena(String indCena) {
		this._indCena = indCena;
		super.setIndCena(indCena);
	}

	@Override
	public String getIndOnce() {
		return this._indOnce;
	}

	@Override
	public void setIndOnce(String indOnce) {
		this._indOnce = indOnce;
		super.setIndOnce(indOnce);
	}

	@Override
	public String getIndAlmuerzo() {
		return this._indAlmuerzo;
	}

	@Override
	public void setIndAlmuerzo(String indAlmuerzo) {
		this._indAlmuerzo = indAlmuerzo;
		super.setIndAlmuerzo(indAlmuerzo);
	}

	@Override
	public String getIndDesayuno() {
		return this._indDesayuno;
	}

	@Override
	public void setIndDesayuno(String indDesayuno) {
		this._indDesayuno = indDesayuno;
		super.setIndDesayuno(indDesayuno);
	}
	
    @Override
    public String getStatus() {
        return this._status;
    }

    @Override
    public void setStatus(String status) {
        this._status = status;
        super.setStatus(status);
    }

	@Override
	public String getPersonaRUT() {
		return this._personaRUT;
	}

	@Override
	public void setPersonaRUT(String personaRUT) {
		this._personaRUT = personaRUT;
		super.setPersonaRUT(personaRUT);
	}

	@Override
	public String getNombreCompleto() {
		return this._nombreCompleto;
	}

	@Override
	public void setNombreCompleto(String nombreCompleto) {
		this._nombreCompleto = nombreCompleto;
		super.setNombreCompleto(nombreCompleto);
	}

	@Override
	public String getTipoRelacionContractual() {
		return this._tipoRelacionContractual;
	}

	@Override
	public void setTipoRelacionContractual(String tipoRelacionContractual) {
		this._tipoRelacionContractual = tipoRelacionContractual;
		super.setTipoRelacionContractual(tipoRelacionContractual);
	}

	@Override
	public String getProcedencia() {
		return this._procedencia;
	}

	@Override
	public void setProcedencia(String procedencia) {
		this._procedencia = procedencia;
		super.setTipoRelacionContractual(procedencia);
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

}
