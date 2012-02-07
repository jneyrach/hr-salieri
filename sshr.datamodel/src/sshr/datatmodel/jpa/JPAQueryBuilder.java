package sshr.datamodel.jpa;

import sshr.datamodel.EntityQuery;
import sshr.datamodel.EntityQueryParameter;
import sshr.datamodel.NotEnoughtParsException;

import javax.persistence.Query;

public abstract class JPAQueryBuilder {

    public static Query buildJPA20Query(EntityQuery qryDef, Object... pars) {

		Query tmpQry = null;

        try {
                if (qryDef.getParameters().size() > 0) {
					
					// If no parameters provided and them are required....
                    if (pars == null) { 
						StringBuilder msg = new StringBuilder();
						msg.append("The Query '");
						msg.append( qryDef );
						msg.append("', for the Entity '");
						msg.append( qryDef.getEntity().getName() );
						msg.append("' has registered '");
						msg.append( qryDef.getParameters().size() );
						msg.append("' parameters and has provided 'zero'. Review the corresponding QueryCatalog.");
					
						throw new NotEnoughtParsException(msg.toString());
					}
					
					// If the number of provided parameters does not match with the required....
                    if (qryDef.getParameters().size() > pars.length) {
						StringBuilder msg = new StringBuilder();
						msg.append("La consulta '");
						msg.append( qryDef );
						msg.append("', de la entidad '");
						msg.append( qryDef.getEntity().getName() );
						msg.append("' tiene registrados '");
						msg.append( qryDef.getParameters().size() );
						msg.append("' y sólo se proporcionaron '");
						msg.append( pars.length );
						msg.append("'. Revise la configuración en el Catálogo de Consultas.");
						
						throw new NotEnoughtParsException(msg.toString());
					}
                    
					tmpQry = JPAEntityManager.createEBJQuery( qryDef.getQryText() );
					
                    for (EntityQueryParameter p : qryDef.getParameters())
							tmpQry.setParameter(p.getParName(), pars[p.getParOrdinal()] );
                
                }
            
        } finally {
		
                    return tmpQry;    
        }
        
    }
    
}
