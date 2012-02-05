
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "airh_ast_personas_base")
public class PersonaBase extends com.synapsis.rrhh.asistencia.domainmodel.PersonaBase {

    @Id
    @Column(name = "persona_id")
    private Integer _id;

    @Column(name = "ind_cena")
	private String _indCena;

    @Column(name = "ind_once")
	private String _indOnce;

    @Column(name = "ind_almuerzo")
	private String _indAlmuerzo;

    @Column(name = "ind_desayuno")
	private String _indDesayuno;

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

	@Override
	public Integer getTarjeta() {
		return _tarjeta;
	}

	@Override
	public void setTarjeta(Integer tarjeta) {
		this._tarjeta = tarjeta;
		super.setTarjeta(tarjeta);
	}
    
    
    public PersonaBase() {}
    
    public PersonaBase(com.synapsis.rrhh.asistencia.domainmodel.PersonaBase model) {
    
        this._id = model.getId();
        this._tarjeta = model.getTarjeta();
        this._indAlmuerzo = model.getIndAlmuerzo();
        this._indCena = model.getIndCena();
        this._indDesayuno = model.getIndDesayuno();
        this._indOnce = model.getIndOnce();
    
    }    

}
