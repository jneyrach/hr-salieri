
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airh_ast_personas")
public class Persona extends com.synapsis.rrhh.asistencia.domainmodel.Persona {

    @Id
    @Column(name = "id")
    private Integer _id;

    @Column(name = "name_")
    private String _name;
    
    @Column(name = "sexo")
    private String _sexo;
    
    @Column(name = "dv")
    private String _dv;
    
    @Column(name = "ind_cena")
	private String _indCena;

    @Column(name = "ind_once")
	private String _indOnce;

    @Column(name = "ind_almuerzo")
	private String _indAlmuerzo;

    @Column(name = "ind_desayuno")
	private String _indDesayuno;

    @ManyToOne
    @JoinColumn(name = "tipo_contrato_id", referencedColumnName = "id")
    private TipoContrato _tipoContrato;
    
    @ManyToOne
    @JoinColumn(name = "unidad_org_id", referencedColumnName = "id")
    private UnidadOrganizacional _unidadOrganizacional;
    
    @Column(name = "tarjeta")
    private Integer _tarjeta;
    
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
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        this._name = name;
        super.setName(name);
    }

    @Override
    public String getSexo() {
        return _sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this._sexo = sexo;
        super.setSexo(sexo);
    }
    
    @Override
    public String getDv() {
        return _dv;
    }

    @Override
    public void setDv(String dv) {
        this._dv = dv;
        super.setDv(dv);
    }

    @Override
    public TipoContrato getTipoContrato() {
        return _tipoContrato;
    }

    @Override
    public void setTipoContrato(com.synapsis.rrhh.asistencia.domainmodel.TipoContrato tipoContrato) {
        this._tipoContrato = (TipoContrato) tipoContrato;
        super.setTipoContrato(tipoContrato);
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

    @Override
    public Integer getTarjeta() {
        return _tarjeta;
    }

    @Override
    public void setTarjeta(Integer tarjeta) {
        this._tarjeta = tarjeta;
        super.setTarjeta(tarjeta);
    }
    
	@Override
	public String getIndCena() {
		return _indCena;
	}

	@Override
	public void setIndCena(String indCena) {
		this._indCena = indCena;
		super.setIndCena(indCena);
	}

	@Override
	public String getIndOnce() {
		return _indOnce;
	}

	@Override
	public void setIndOnce(String indOnce) {
		this._indOnce = indOnce;
		super.setIndOnce(indOnce);
	}

	@Override
	public String getIndAlmuerzo() {
		return _indAlmuerzo;
	}

	@Override
	public void setIndAlmuerzo(String indAlmuerzo) {
		this._indAlmuerzo = indAlmuerzo;
		super.setIndAlmuerzo(indAlmuerzo);
	}

	@Override
	public String getIndDesayuno() {
		return _indDesayuno;
	}

	@Override
	public void setIndDesayuno(String indDesayuno) {
		this._indDesayuno = indDesayuno;
		super.setIndDesayuno(indDesayuno);
	}    
    

    public Persona() {}
    
    public Persona(com.synapsis.rrhh.asistencia.domainmodel.Persona model) {
    
        this._id = model.getId();
        this._dv = model.getDv();
        this._name = model.getName();
        this._sexo = model.getSexo();
        this._tipoContrato = (TipoContrato) model.getTipoContrato();
        this._unidadOrganizacional = (UnidadOrganizacional) model.getUnidadOrganizacional();
        this._tarjeta = model.getTarjeta();
    
    }

}
