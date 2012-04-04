package sshr.datamodel;

import sshr.domainmodel.BaseEntity;

import sshr.datamodel.NoDataFoundException;

import java.util.List;


public interface EntityManager {

	public <T extends BaseEntity> T add(T entity) throws EntityManagerException;
	
	public <T extends BaseEntity> T update(T entity) throws EntityManagerException;

	public <T extends BaseEntity, U extends Number> void remove(Class<T> eClass, U id) throws EntityManagerException;

	public <T extends BaseEntity, U extends Number> T find(Class<T> eClass, U id) throws EntityManagerException;

	public <T extends BaseEntity> List<T> performQuery(QueryCatalog qrySpec, Class<T> eClass, Object... pars) throws EntityManagerException;
	
}
