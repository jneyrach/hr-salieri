package sshr.datamodel;

import sshr.domainmodel.BaseEntity;

import sshr.datamodel.NoDataFoundException;

import java.util.List;


public interface EntityManager {

	public <T extends BaseEntity> T add(T entity) throws EntityManagerException;
	
	public <T extends BaseEntity> T update(T entity) throws EntityManagerException;

	public <T extends BaseEntity> void remove(T entity) throws EntityManagerException;

	public <T extends BaseEntity, U extends Number> T find(Class<T> eClass, U id) throws EntityManagerException, NoDataFoundException;

	public <T extends BaseEntity> List<T> findAll(Class<T> entityClass) throws EntityManagerException;

	public <T extends BaseEntity> List<T> performQuery(EntityQuery qryDef, Object... pars) throws EntityManagerException;
	
}
