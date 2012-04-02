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
import sshr.datamodel.QueryCatalog;
import sshr.datamodel.jpa.JPAEntityManager;
import sshr.datamodel.jpa.BaseDataEntity;
import sshr.datamodel.jpa.JPAQueryBuilder;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Query;


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
	public <T extends BaseEntity> List<T> performQuery(QueryCatalog qrySpec, Class<T> entityClass, Object... pars) throws EntityManagerException {

		try {
				EntityQuery qs = qrySpec.getQuerySpecification(entityClass);

				Query qry = JPAQueryBuilder.buildJPA20Query( qs, pars );

				Class cls = DataEntityFactory.Instance.getClassDataEntity( entityClass );

				List<T> tmp = new ArrayList<T>();

				List<BaseDataEntity> lbde = JPAEntityManager.getListByQueryObject( qry, cls );

				for (BaseDataEntity bde: lbde)

						tmp.add( convertToDomainEntity( bde, entityClass) );


				return tmp;

		} catch (NoDataFoundException ex) {

					throw new EntityManagerException("No records were found.", ex);

		} catch (Exception ex) {

					return null;
		}
	}

	private <T extends BaseEntity, U extends BaseDataEntity> T convertToDomainEntity(U bde, Class<T> entityClass) throws EntityManagerException {

		T de;
		try {
				de = EntityFactory.Instance.getNewEntity( entityClass );

		} catch (Exception ex) {

					throw new EntityManagerException(ex);
		}

		de = (T)bde.reversePopulate( de );

		return de;
	}

}
