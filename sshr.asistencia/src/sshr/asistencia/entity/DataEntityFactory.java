package sshr.asistencia.entity;

import sshr.domainmodel.BaseEntity;

import sshr.datamodel.jpa.BaseDataEntity;


public enum DataEntityFactory {

	Instance;

	
	public BaseDataEntity newDataEntity(Class<?> domainEntity) {
	
		if (domainEntity.getSimpleName().equals("PerfilHorario"))
			return (new PerfilHorario());

		if (domainEntity.getSimpleName().equals("TipoDia"))
			return (new TipoDia());

		else
			return null;
			
	}

	public Class<? extends BaseDataEntity> getClassDataEntity(Class<?> domainEntity) {
	
		if (domainEntity.getSimpleName().equals("PerfilHorario"))
			return sshr.asistencia.entity.PerfilHorario.class;
			
		if (domainEntity.getSimpleName().equals("TipoDia"))
			return sshr.asistencia.entity.TipoDia.class;

		else
			return null;
			
	}

}
