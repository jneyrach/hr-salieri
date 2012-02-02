package sshr.domainmodel.asistencia;

import sshr.domainmodel.BaseEntity;
import sshr.domainmodel.EntityAccessNotAllowedException;


public final class GrupoHorario extends BaseEntity<Long> {

	private String _codigo;
	private String _desc;
	
	
	private GrupoHorario() throws EntityAccessNotAllowedException {
	
		super();
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

}
