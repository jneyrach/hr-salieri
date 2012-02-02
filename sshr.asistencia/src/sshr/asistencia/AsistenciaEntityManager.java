package sshr.asistencia;

import sshr.asistencia.entity.DataEntityFactory;

import sshr.domainmodel.BaseEntity;
import sshr.domainmodel.EntityFactory;
import sshr.domainmodel.EntityAccessNotAllowedException;
import sshr.domainmodel.asistencia.GrupoHorario;

import sshr.datamodel.EntityQuery;
import sshr.datamodel.EntityManager;
import sshr.datamodel.NoDataFoundException;
import sshr.datamodel.EntityManagerException;
import sshr.datamodel.jpa.JPAEntityManager;
import sshr.datamodel.jpa.BaseDataEntity;

import java.util.List;


public final class AsistenciaEntityManager implements EntityManager {

	@Override
	public <T extends BaseEntity> T add(T entity) throws EntityManagerException {

		BaseDataEntity ne = DataEntityFactory.Instance.newDataEntity( entity.getClass() );
		ne.autoPopulate( (T)entity );
	
		ne = (BaseDataEntity)JPAEntityManager.createEntity(ne);
		
		return (T)ne.reversePopulate( (T)entity );
	}
	
	@Override
	public <T extends BaseEntity> T update(T entity) throws EntityManagerException {

		BaseDataEntity ne = DataEntityFactory.Instance.newDataEntity( entity.getClass() );
		ne.autoPopulate( (T)entity );
	
		ne = (BaseDataEntity)JPAEntityManager.updateEntity(ne);
		
		return (T)ne.reversePopulate( (T)entity );
	}

	@Override
	public <T extends BaseEntity> void remove(T entity) throws EntityManagerException { 
	
		BaseDataEntity ne = DataEntityFactory.Instance.newDataEntity( entity.getClass() );
		ne.autoPopulate( (T)entity );
	
		ne = (BaseDataEntity)JPAEntityManager.updateEntity(ne);
		
		JPAEntityManager.deleteEntity(ne);
	}

	@Override
	public <T extends BaseEntity, U extends Number> T find(Class<T> eClass, U id) throws EntityManagerException, NoDataFoundException {
	
		Class a = DataEntityFactory.Instance.getClassDataEntity(eClass);
		
		BaseDataEntity bde = JPAEntityManager.getEntityByID(a, id);
		
		T de;
		try {
				de = EntityFactory.Instance.getNewEntity( eClass );
				
		} catch (Exception ex) {
			
					throw new EntityManagerException(ex);
		}
	
		de = (T)bde.reversePopulate( de );
	
		return de;
	}

	@Override
	public <T extends BaseEntity> List<T> findAll(Class<T> entityClass) throws EntityManagerException {
	
		return null;
	}

	@Override
	public <T extends BaseEntity> List<T> performQuery(EntityQuery qryDef, Object... pars) throws EntityManagerException {
	
		return null;
	}

}
