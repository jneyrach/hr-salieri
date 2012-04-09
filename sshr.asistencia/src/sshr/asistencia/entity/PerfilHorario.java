package sshr.asistencia.entity;

import sshr.datamodel.jpa.BaseDataEntity;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public final class PerfilHorario extends BaseDataEntity<sshr.domainmodel.asistencia.PerfilHorario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	private String _desc;
	private String _codigo;
	private String _nombre;

	private Date _createdOn;
	private Date _updatedOn;


	public Long getId() {

		return this._id;
	}

	public String getDesc() {

		return this._desc;
	}

	public String getCodigo() {

		return this._codigo;
	}

	public String getNombre() {

		return this._nombre;
	}

	public void setDesc(String desc) {

		this._desc = desc;
	}

	public void setCodigo(String codigo) {

		this._codigo = codigo;
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


	@Override
	public void autoPopulate(sshr.domainmodel.asistencia.PerfilHorario phvo) {

		this._id        = phvo.getID();
		this._desc      = phvo.getDesc();
		this._codigo    = phvo.getCodigo();
		this._nombre    = phvo.getNombre();
		this._createdOn = phvo.getCreatedOn();
		this._updatedOn = phvo.getUpdatedOn();
	}

	@Override
	public sshr.domainmodel.asistencia.PerfilHorario reversePopulate(sshr.domainmodel.asistencia.PerfilHorario phvo) {

		phvo.setID(this._id);
		phvo.setCodigo(this._codigo);
		phvo.setNombre(this._nombre);
		phvo.setDesc(this._desc);
		phvo.setCreatedOn(this._createdOn);
		phvo.setUpdatedOn(this._updatedOn);

		return phvo;
	}

}
