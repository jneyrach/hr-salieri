
package com.synapsis.rrhh.asistencia.persistence.service;

import com.synapsis.rrhh.asistencia.annotation.CustomNamedQueries;
import com.synapsis.rrhh.asistencia.annotation.CustomNamedQuery;
import com.synapsis.rrhh.asistencia.annotation.CustomNamedQueryParameter;
import com.synapsis.rrhh.asistencia.exception.NotEnoughtParsException;
import java.lang.annotation.Annotation;
import javax.persistence.Query;

public abstract class AsistenciaQueryBuilder {

    public static Query buildGenericQry(Class entity, int qryCode, Object ... pars) {

        Query tmpQry = null;

        try {
                
                mainFor:
                for (Annotation a : entity.getAnnotations()) {
                
                        if (!(a instanceof CustomNamedQueries)) continue;
                            
                        for (CustomNamedQuery q : ((CustomNamedQueries)a).value()) {

                                if (q.qryCode() != qryCode) continue;
                                
                                if (q.qryNumPars() != pars.length) throw new NotEnoughtParsException("La consulta número '" + qryCode + "', de la entidad '" + entity.getClass().getName() + "' tiene registrados '" + q.qryNumPars() + "' y sólo se proporcionaron '" + pars.length + "'. Revise la configuración en el Catálogo de Consultas.");

                                tmpQry = AsistenciaEntityManager.createEBJQuery(q.qryText());

                                if (q.qryNumPars() == 0) break mainFor;
                                    
                                for (CustomNamedQueryParameter par : q.pars())
                                    tmpQry.setParameter(par.name(), pars[par.ordinal()] );

                                break mainFor;
                                
                        }
                    
                }
                
        } catch (Exception ex) {
                tmpQry = null;
                throw new RuntimeException("Ha ocurrido un error inesperado al tratar de generar la consulta.", ex);
        } finally {
                    return tmpQry;    
        }
        
    }

    public static Query buildGenericQry2(EntityQuery qryDef, Object ... pars) {

        Query tmpQry = null;

        try {
                tmpQry = AsistenciaEntityManager.createEBJQuery(qryDef.getQryText());
                        
                if (qryDef.getParameters().size() > 0) {
                    if (pars == null) throw new NotEnoughtParsException("La consulta '" + qryDef + "', de la entidad '" + qryDef.getEntity().getName() + "' tiene registrados '" + qryDef.getParameters().size() + "' y sólo se proporcionaron 'cero'. Revise la configuración en el Catálogo de Consultas.");
                    if (qryDef.getParameters().size() > pars.length) throw new NotEnoughtParsException("La consulta '" + qryDef + "', de la entidad '" + qryDef.getEntity().getName() + "' tiene registrados '" + qryDef.getParameters().size() + "' y sólo se proporcionaron '" + pars.length + "'. Revise la configuración en el Catálogo de Consultas.");
                    
                    for (EntityQueryParameter p : qryDef.getParameters())
                        tmpQry.setParameter(p.getParName(), pars[p.getParOrdinal()] );
                
                }
            
        } catch (Exception ex) {
                tmpQry = null;
        } finally {
                    return tmpQry;    
        }
        
    }
    
}
