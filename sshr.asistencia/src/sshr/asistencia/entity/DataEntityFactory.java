package sshr.asistencia.entity;

import sshr.domainmodel.BaseEntity;

import sshr.datamodel.jpa.BaseDataEntity;


public enum DataEntityFactory {

	Instance;

	
	public BaseDataEntity newDataEntity(Class<?> domainEntity) {
	
		if (domainEntity.getSimpleName().equals("GrupoHorario"))
			return (new GrupoHorario());

		else
			return null;
			
	}

	public Class<? extends BaseDataEntity> getClassDataEntity(Class<?> domainEntity) {
	
		if (domainEntity.getSimpleName().equals("GrupoHorario"))
			return sshr.asistencia.entity.GrupoHorario.class;

		else
			return null;
			
	}

}
