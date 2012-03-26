package sshr.asistencia.entity;

import sshr.datamodel.jpa.BaseDataEntity;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public final class GrupoHorario extends BaseDataEntity<sshr.domainmodel.asistencia.GrupoHorario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;

	private String _desc;
	private String _codigo;

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

	public void setDesc(String desc) {

		this._desc = desc;
	}

	public void setCodigo(String codigo) {

		this._codigo = codigo;
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
	public void autoPopulate(sshr.domainmodel.asistencia.GrupoHorario ghvo) {

		this._id        = ghvo.getID();
		this._desc      = ghvo.getDesc();
		this._codigo    = ghvo.getCodigo();
		this._createdOn = ghvo.getCreatedOn();
		this._updatedOn = ghvo.getUpdatedOn();
	}

	@Override
	public sshr.domainmodel.asistencia.GrupoHorario reversePopulate(sshr.domainmodel.asistencia.GrupoHorario ghvo) {

		ghvo.setID(this._id);
		ghvo.setCodigo(this._codigo);
		ghvo.setDesc(this._desc);
		ghvo.setCreatedOn(this._createdOn);
		ghvo.setUpdatedOn(this._updatedOn);

		return ghvo;
	}

}
