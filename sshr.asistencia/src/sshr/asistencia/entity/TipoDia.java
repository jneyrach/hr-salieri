package sshr.asistencia.entity;

import sshr.datamodel.jpa.BaseDataEntity;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public final class TipoDia extends BaseDataEntity<sshr.domainmodel.asistencia.TipoDia> {

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
	public void autoPopulate(sshr.domainmodel.asistencia.TipoDia tdvo) {

		this._id        = tdvo.getID();
		this._desc      = tdvo.getDesc();
		this._codigo    = tdvo.getCodigo();
		this._nombre    = tdvo.getNombre();
		this._createdOn = tdvo.getCreatedOn();
		this._updatedOn = tdvo.getUpdatedOn();
	}

	@Override
	public sshr.domainmodel.asistencia.TipoDia reversePopulate(sshr.domainmodel.asistencia.TipoDia tdvo) {

		tdvo.setID(this._id);
		tdvo.setCodigo(this._codigo);
		tdvo.setNombre(this._nombre);
		tdvo.setDesc(this._desc);
		tdvo.setCreatedOn(this._createdOn);
		tdvo.setUpdatedOn(this._updatedOn);

		return tdvo;
	}

}
