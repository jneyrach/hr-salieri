package sshr.asistencia;

import sshr.datamodel.QueryCatalog;
import sshr.datamodel.EntityQuery;
import sshr.datamodel.EntityQueryParameter;

import sshr.datamodel.jpa.BaseDataEntity;


public abstract class AsistenciaQueryCatalog {

    public static QueryCatalog GENERIC___ALL() {
        
		return (new QueryCatalog() {
				@Override
				public EntityQuery getQuerySpecification() { 
				
					return null;
				}
		
				@Override
				public EntityQuery getQuerySpecification(Class<?> eclass) {

					EntityQuery q = new EntityQuery();
					q.setQryText(" select o from " + eclass.getSimpleName() + " o ");
					q.setSingleResult(false);
					q.setEntity(eclass);
					
					return q;
				}
		});
    }

	
 }
