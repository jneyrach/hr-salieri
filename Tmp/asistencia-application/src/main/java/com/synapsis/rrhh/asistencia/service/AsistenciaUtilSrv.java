
package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.AccesoUsuario;
import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.exception.ApplicationServiceException;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class AsistenciaUtilSrv {

     // Búsqueda estándar de Personas por filtros
     public static List<Persona> consultarPersonasPorFiltroEstandar(String... filtrosOrdenados) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 if (!filtrosOrdenados[0].isEmpty()) {
                     List<Persona> r = new ArrayList<Persona>();
                     r.add((Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(filtrosOrdenados[0])}));
                     return r;
                 }

                 Object[] pars = new Object[]{null, null, null, null, null, 
                                             filtrosOrdenados[1].isEmpty() ? "%" : "%" + filtrosOrdenados[1] + "%", 
                                             filtrosOrdenados[2].isEmpty() ? "%" : "%" + filtrosOrdenados[2] + "%", 
                                             filtrosOrdenados[3].isEmpty() ? "%" : "%" + filtrosOrdenados[3] + "%"};
                 
                 return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_FILTRO_ESTANDAR.getQueryDefinition(), pars);
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<Persona> consultarPersonasDeCentroDeTrabajoPorFiltroEstandar(List<Integer> centros, String... filtrosOrdenados) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
        	 	 // Si el parámetro R.U.T. viene con contenido y es DISTINTO DEL "*", significa que hay que buscar por R.U.T.
                 if (!filtrosOrdenados[0].isEmpty() && !filtrosOrdenados[0].equals("*")) {
                     List<Persona> r = new ArrayList<Persona>();
                     r.add((Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(filtrosOrdenados[0])}));
                     return r;
                 }
                 
        	 	 List<RelacionCentrotrabajoUnidad> rl = (List<RelacionCentrotrabajoUnidad>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDADES_ORGANIZACIONALES___PARA_VARIOS_CENTROS_DE_TRABAJO.getQueryDefinition(), new Object[]{null, centros});	
        	 	 List<Integer> unidades = new ArrayList<Integer>();
        	 	 for (RelacionCentrotrabajoUnidad rr : rl)
        	 		 	unidades.add( rr.getUnidadOrganizacional().getId() );
            	 
        	 	 // Si el parámetro R.U.T. viene con contenido y es IGUAL AL "*", significa que hay que buscar por R.U.T.
                 if (!filtrosOrdenados[0].isEmpty() && filtrosOrdenados[0].equals("*")) {
                     return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONAS___POR_UNIDADES_ORGANIZACIONALES.getQueryDefinition(), new Object[]{null, null, unidades});
                 }

                 // En último caso utiliza el resto de los filtros pasados como parámetros.
                 Object[] pars = new Object[]{null, null, unidades, null, null, 
                                             filtrosOrdenados[1].isEmpty() ? "%" : "%" + filtrosOrdenados[1] + "%", 
                                             filtrosOrdenados[2].isEmpty() ? "%" : "%" + filtrosOrdenados[2] + "%", 
                                             filtrosOrdenados[3].isEmpty() ? "%" : "%" + filtrosOrdenados[3] + "%"};
                 
                 return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONAS___POR_UNIDADES_ORGANIZACIONALES__Y__FILTRO_ESTANDAR.getQueryDefinition(), pars);
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static Persona consultarPersonasPorId(String personaId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {

                 return (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(personaId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<AccesoUsuario> consultarPermisosDeUsuario(String userId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
        	 	return (List<AccesoUsuario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERMISOS_DE_USUARIO.getQueryDefinition(), new Object[]{null, new Integer(userId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     
     public static boolean actualizarDatosPartes(String fecha) {
    	 
    	 return AsistenciaEntityManager.actualizarDatosPartes(fecha);
    	 
     }
     
}
