package sshr.asistencia.entity;

import sshr.datamodel.jpa.BaseDataEntity;

import java.util.*;
import java.io.*;
import javax.persistence.*;


@Entity
public final class Periodo extends BaseDataEntity<sshr.domainmodel.asistencia.Periodo> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	private String _desc;
	private String _nombre;
	private String _bitacora;

	private Date _fechaInicio;
	private Date _fechaTermino;
	private Date _createdOn;
	private Date _updatedOn;


	public Long getId() {

		return this._id;
	}

	public String getDesc() {

		return this._desc;
	}

	public String getBitacora() {

		return this._bitacora;
	}

	public String getNombre() {

		return this._nombre;
	}
	
	public Date getFechaInicio() {
	
		return this._fechaInicio;
	}
	
	public Date getFechaTermino() {
	
		return this._fechaTermino;
	}

	
	public void setDesc(String desc) {

		this._desc = desc;
	}

	public void setBitacora(String bitacora) {

		this._bitacora = bitacora;
	}

	public void setNombre(String nombre) {

		this._nombre = nombre;
	}

	public void setId(Long id) {

		this._id = id;
	}

    public void setCreatedOn(Date createdOn) {

        this._createdOn = createdOn;
    }

    public void setUpdatedOn(Date updatedOn) {

        this._updatedOn = updatedOn;
    }

    public void setFechaInicio(Date fechaInicio) {

        this._fechaInicio = fechaInicio;
    }

    public void setFechaTermino(Date fechaTermino) {

        this._fechaTermino = fechaTermino;
    }

	
	@Override
	public void autoPopulate(sshr.domainmodel.asistencia.Periodo tdvo) {

		this._id        = tdvo.getID();
		this._desc      = tdvo.getDesc();
		this._bitacora  = tdvo.getBitacora();
		this._nombre    = tdvo.getNombre();
		this._createdOn = tdvo.getCreatedOn();
		this._updatedOn = tdvo.getUpdatedOn();
	}

	@Override
	public sshr.domainmodel.asistencia.Periodo reversePopulate(sshr.domainmodel.asistencia.Periodo tdvo) {

		tdvo.setID(this._id);
		tdvo.setBitacora(this._bitacora);
		tdvo.setNombre(this._nombre);
		tdvo.setDesc(this._desc);
		tdvo.setCreatedOn(this._createdOn);
		tdvo.setUpdatedOn(this._updatedOn);

		return tdvo;
	}

}
