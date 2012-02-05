
package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.MiembroGrupoHorario;
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

public abstract class AsistenciaConfiguracionSrv {

    
     // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Horarios y sus Definiciones   ]">
     public static List<Horario> consultarHorarios() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<Horario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___TODOS.getQueryDefinition(), null);
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static List<Horario> consultarHorariosDeCentroDeTrabajo(String centroTrabajoId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<Horario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___DE_CENTRO_TRABAJO.getQueryDefinition(), new Object[]{null, null, new Integer(centroTrabajoId)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<Horario> consultarHorariosPorVariosCentrosDeTrabajo(List<Integer> centros) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
                 return (List<Horario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___DE_VARIOS_CENTROS_TRABAJO.getQueryDefinition(), new Object[]{null, null, centros});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<DefinicionHorario> consultarDefinicionHorarioPorIDHorario(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
             
                 //Horario h = (Horario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
                 return (List<DefinicionHorario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_HORARIO___DE_HORARIO.getQueryDefinition(), new Object[]{null, null, new Integer(id)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static Horario consultarHorarioPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (Horario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static DefinicionHorario consultarDefinicionHorarioPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (DefinicionHorario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void crearHorario(Horario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoHorario(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarHorario(Horario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 if (!AsistenciaConfiguracionRules.validarEliminarHorario(entity)) throw new BusinessRulesNotSatisfiedException("El objetvo entregado no cumplió con las validaciones de negocio.");

                 AsistenciaEntityManager.eliminarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarHorario(Horario entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());             
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoHorario(entity))
                     AsistenciaEntityManager.actualizarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void crearDefinicionHorario(DefinicionHorario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();
                     
                     // Verifica el correlativo
                     entity.setCorrelativo(new Integer( (entity.getHorario().getDefinicion().size() + 1) ));

                     if (AsistenciaConfiguracionRules.validarIngresoDefinicionHorario(entity))
                         AsistenciaEntityManager.crearEntidad(entity);
                     
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarDefinicionHorario(DefinicionHorario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 if (!AsistenciaConfiguracionRules.validarEliminarDefinicionHorario(entity)) throw new BusinessRulesNotSatisfiedException("El objeto recibido no pasó la prueba de validación de regla de negocio.");

                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();

                     DefinicionHorario tmp = (DefinicionHorario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_HORARIO___POR_ID.getQueryDefinition(), new Object[]{entity.getId()});

                     String horarioId = tmp.getHorario().getId().toString();

                     AsistenciaEntityManager.eliminarEntidad(entity);

                     // Reorganiza los correlativos una vez eliminado cualquiera de los registros de la definición de horario.
                     try {
                             int idx = 1;
                             List<DefinicionHorario> list = null;
                             list = AsistenciaConfiguracionSrv.consultarDefinicionHorarioPorIDHorario(horarioId);
                             
                             for (DefinicionHorario def : list) {

                                 if (def.getId().intValue() != entity.getId().intValue()) {                         
                                     def.setCorrelativo(new Integer(idx));
                                     def.setUpdateDate(new Date());
                                     AsistenciaEntityManager.updateEntity(def);
                                     idx++;
                                 }

                             }
                            
                     } catch (NoDataFoundException ex) {}

                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
                 
         } catch (BusinessRulesNotSatisfiedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarDefinicionHorario(DefinicionHorario entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 ////AsistenciaEntityManager.beginEntityTransaction();
                     
                     DefinicionHorario tmp = (DefinicionHorario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_HORARIO___POR_ID.getQueryDefinition(), new Object[]{entity.getId()});

                     tmp.setTipoDia( entity.getTipoDia() );
                     tmp.setAutor( entity.getAutor() );
                     tmp.setHoraInicio( entity.getHoraInicio() );
                     tmp.setMinutosInicio( entity.getMinutosInicio() );
                     tmp.setHoraTermino( entity.getHoraTermino() );
                     tmp.setMinutosTermino( entity.getMinutosTermino() );
                     tmp.setHoraColacion( entity.getHoraColacion() );
                     tmp.setMinutosColacion( entity.getMinutosColacion() );
                     tmp.setObs( entity.getObs() );
                     tmp.setStatus( entity.getStatus() );
                     tmp.setUpdateDate(new Date());
                     
                     entity.setUpdateDate(new Date());
                     entity.setCorrelativo(tmp.getCorrelativo());
                     entity.setCreateDate(tmp.getCreateDate());

                     if (AsistenciaConfiguracionRules.validarIngresoDefinicionHorario(entity))
                         AsistenciaEntityManager.actualizarEntidad(entity);
             
                 ////AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>

         } catch (BusinessRulesNotSatisfiedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     // </editor-fold>
    



     // <editor-fold defaultstate="collapsed" desc="[   Mantención de Calendarios y de sus Definicines   ]">
     public static List<Calendario> consultarCalendarios() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<Calendario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CALENDARIO___TODOS.getQueryDefinition(), null);
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static Calendario consultarCalendarioPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
             
                 return (Calendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CALENDARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static Set<DefinicionCalendario> consultarDefinicionCalendarioPorIDCalendario(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
             
                 Calendario cal = (Calendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CALENDARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
                 
                 return cal.getDefinicion();
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static DefinicionCalendario consultarDefinicionCalendariosPorFecha(Date fecha) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {             
                 return (DefinicionCalendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_CALENDARIO___POR_FECHA.getQueryDefinition(), new Object[]{fecha});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void actualizarDefinicionCalendarios(String[] theDates, Integer calendarioID) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();
                 
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Calendario       c   = (Calendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CALENDARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(calendarioID)});

                        for (DefinicionCalendario df : c.getDefinicion())
                            AsistenciaEntityManager.eliminarEntidad(df);

                        if (theDates != null) if (theDates.length > 0)
	                        for (String date : theDates) {
	                                try {
		                                	DefinicionCalendario dc = new com.synapsis.rrhh.asistencia.to.DefinicionCalendario();
	                                		dc.setFechaFestivo(sdf.parse(date));
	    	                                dc.setCalendario(c);
	    	                            	
	    	                                AsistenciaEntityManager.crearEntidad(dc);
	                                } catch (java.text.ParseException ex) {}
	                        }
             
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>

         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void crearCalendario(Calendario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoCalendario(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarCalendario(Calendario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
 
                 if (AsistenciaConfiguracionRules.validarEliminarCalendario(entity))
                     AsistenciaEntityManager.eliminarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarCalendario(Calendario entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoCalendario(entity))
                     AsistenciaEntityManager.actualizarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void crearDefinicionCalendario(DefinicionCalendario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoDefinicionCalendario(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarDefinicionCalendario(DefinicionCalendario entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
 
                 if (AsistenciaConfiguracionRules.validarEliminarDefinicionCalendario(entity))
                     AsistenciaEntityManager.eliminarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarDefinicionCalendario(DefinicionCalendario entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoDefinicionCalendario(entity))
                     AsistenciaEntityManager.actualizarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     // </editor-fold>


     
     
     // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Ajustes de Horarios   ]">
     public static List<TipoAjusteHojaTiempo> consultarTipoAjusteHojaTiempos() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<TipoAjusteHojaTiempo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.AJUSTE_HOJA_TIEMPO___TODOS.getQueryDefinition(), null);
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static TipoAjusteHojaTiempo consultarTipoAjusteHojaTiempoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
             
                 return (TipoAjusteHojaTiempo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.AJUSTE_HOJA_TIEMPO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static void crearTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoTipoAjusteHojaTiempo(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
 
                 if (AsistenciaConfiguracionRules.validarEliminarTipoAjusteHojaTiempo(entity))
                     AsistenciaEntityManager.eliminarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoTipoAjusteHojaTiempo(entity))
                     AsistenciaEntityManager.actualizarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     // </editor-fold>
     

     
     
     // <editor-fold defaultstate="collapsed" desc="[   Mantención las Nóminas de los Centros de Trabajo   ]">
     public static List<UnidadOrganizacional> consultarUnidadesDeCentroDeTrabajo(String centroTrabajoId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<UnidadOrganizacional>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___DE_CENTRO_DE_TRABAJO.getQueryDefinition(), new Object[]{null, new Integer(centroTrabajoId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }
     
     public static List<UnidadOrganizacional> consultarUnidadesSinCentroDeTrabajo() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<UnidadOrganizacional>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___SIN_CENTRO_DE_TRABAJO.getQueryDefinition(), null);
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<UnidadOrganizacional> consultarUnidadesSinCentroDeTrabajo(List<Integer> hijas) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
                 return (List<UnidadOrganizacional>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___SIN_CENTRO_DE_TRABAJO__Y__POR_UNIDAD_ID.getQueryDefinition(), new Object[]{hijas});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static RelacionCentrotrabajoUnidad consultarRelacionCentrotrabajoUnidadDeUnidadOrganizacional(String unidadOrganizacionalId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (RelacionCentrotrabajoUnidad) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDAD_ORGANIZACIONAL___SINGLE___DE_UNIDAD_ORGANIZACIONAL.getQueryDefinition(), new Object[]{null, null, new Integer(unidadOrganizacionalId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<RelacionCentrotrabajoUnidad> consultarRelacionCentrotrabajoParaVariasUnidadesOrganizacionales(List<Integer> unidades) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
                 return (List<RelacionCentrotrabajoUnidad>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDAD_ORGANIZACIONAL_Y_CENTRO_TRABAJO___DE_VARIAS_UNIDADES_ORGANIZACIONALES.getQueryDefinition(), new Object[]{null, null, unidades});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void crearRelacionCentrotrabajoUnidad(RelacionCentrotrabajoUnidad entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoRelacionCentrotrabajoUnidad(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarRelacionCentrotrabajoUnidad(RelacionCentrotrabajoUnidad entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
 
                 if (AsistenciaConfiguracionRules.validarEliminarRelacionCentrotrabajoUnidad(entity))
                     AsistenciaEntityManager.eliminarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarRelacionCentrotrabajoUnidad(RelacionCentrotrabajoUnidad entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());
                 entity.setUpdateDate(new Date());
             
                 if (AsistenciaConfiguracionRules.validarIngresoRelacionCentrotrabajoUnidad(entity))
                     AsistenciaEntityManager.actualizarEntidad(entity);
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void actualizarRelacionCentrotrabajoUnidad(String centroTrabajoId, String autorRut, String... unidades) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException, NoDataFoundException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();

                 inTran: {
                        try {
                                List<RelacionCentrotrabajoUnidad> lst = (List<RelacionCentrotrabajoUnidad>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDAD_ORGANIZACIONAL___DE_CENTRO_DE_TRABAJO.getQueryDefinition(), new Object[]{null, new Integer(centroTrabajoId)});
                                
                                for (RelacionCentrotrabajoUnidad r : lst)
                                    AsistenciaEntityManager.eliminarEntidad(r);
                        
                        } catch (NoDataFoundException ex) {}
                        
                        if (unidades.length == 0) break inTran;
                 
                        CentroTrabajo ct = (CentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___POR_ID.getQueryDefinition(), new Object[]{new Integer(centroTrabajoId)});
                        Persona p = (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorRut)});
                        
                        for (String uc : unidades) {
                        		try {
		                                RelacionCentrotrabajoUnidad r = new com.synapsis.rrhh.asistencia.to.RelacionCentrotrabajoUnidad();
		                                UnidadOrganizacional u = (UnidadOrganizacional) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___POR_ID.getQueryDefinition(), new Object[]{new Integer(uc)});
		                                r.setCentroTrabajo(ct);
		                                r.setUnidadOrganizacional(u);
		                                r.setCreateDate(new Date());
		                                r.setUpdateDate(new Date());
		                                r.setAutor(p);
		                                
		                                AsistenciaEntityManager.crearEntidad(r);
                        		} catch (Exception ex) {}
                        }
                 }
                 
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
             
         } catch (NoDataFoundException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NoDataFoundException("Uno de los datos requeridos para crear la relación centro-trabajo y unidad ya no está disponible.", ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     // </editor-fold>
     
     
     
     
     // <editor-fold defaultstate="collapsed" desc="[   Mantención de los Encargados de los Centros de Trabajo   ]">
     public static List<Persona> consultarEncargadosDeCentroDeTrabajo(String centroTrabajoId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.ENCARGADOS___DE_CENTRO_DE_TRABAJO.getQueryDefinition(), new Object[]{null, null, null, new Integer(centroTrabajoId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void actualizarEncargadosDeCentroTrabajo(String centroTrabajoId, String autorRut, String... encargados) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException, NoDataFoundException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();

                 inTran: {
                        try {
                                List<EncargadoCentroTrabajo> lst = (List<EncargadoCentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_ENCARGADOS___DE_CENTRO_DE_TRABAJO.getQueryDefinition(), new Object[]{null, null, null, new Integer(centroTrabajoId)});
                                
                                for (EncargadoCentroTrabajo e : lst)
                                    AsistenciaEntityManager.eliminarEntidad(e);
                        
                        } catch (NoDataFoundException ex) {}
                        
                        if (encargados.length == 0) break inTran;
                 
                        CentroTrabajo ct = (CentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___POR_ID.getQueryDefinition(), new Object[]{new Integer(centroTrabajoId)});
                        Persona autor = (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorRut)});
                        
                        for (String e : encargados) {
                                EncargadoCentroTrabajo r = new com.synapsis.rrhh.asistencia.to.EncargadoCentroTrabajo();
                                Persona responsable = (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(e)});
                                r.setCentroTrabajo(ct);
                                r.setPersona(responsable);
                                r.setCreateDate(new Date());
                                r.setUpdateDate(new Date());
                                r.setAutor(autor);
                                
                                AsistenciaEntityManager.crearEntidad(r);
                        }
                 }
                 
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
             
         } catch (NoDataFoundException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NoDataFoundException("Uno de los datos requeridos para crear la relación centro-trabajo y unidad ya no está disponible.", ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     // </editor-fold>




     // <editor-fold defaultstate="collapsed" desc="[   Mantención de los Encargados de los Centros de Trabajo   ]">
     public static List<Persona> consultarMiembrosGrupoHorario(String grupoHorarioId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.MIEMBROS_DE_GRUPO_HORARIO.getQueryDefinition(), new Object[]{null, new Integer(grupoHorarioId)});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static List<Persona> consultarMiembrosGrupoHorarioYUnidadOrganizacional(String grupoHorarioId, List<Integer> unidades) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
         
         try {
                 return (List<Persona>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.MIEMBROS_DE_GRUPO_HORARIO_Y_UNIDAD_ORGANIZACIONAL.getQueryDefinition(), new Object[]{null, new Integer(grupoHorarioId), null, null, unidades});
                 
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (NoDataFoundException ex) {
                 throw new NoDataFoundException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException(ex);
         }
     
     }

     public static void actualizarMiembrosDeGrupoHorario(String grupoHorarioId, String autorRut, String... miembros) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException, NoDataFoundException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();

                 inTran: {
                        try {
                                List<MiembroGrupoHorario> lst = (List<MiembroGrupoHorario>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_MIEMBROS___DE_GRUPO_HORARIO.getQueryDefinition(), new Object[]{null, new Integer(grupoHorarioId)});
                                
                                for (MiembroGrupoHorario e : lst)
                                    AsistenciaEntityManager.eliminarEntidad(e);
                        
                        } catch (NoDataFoundException ex) {}
                        
                        if (miembros.length == 0) break inTran;
                 
                        GrupoHorarioCentroTrabajo gh = (GrupoHorarioCentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.GRUPO_HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(grupoHorarioId)});
                        Persona autor = (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorRut)});
                        
                        for (String e : miembros) {
                                MiembroGrupoHorario r = new com.synapsis.rrhh.asistencia.to.MiembroGrupoHorario();
                                Persona responsable = (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(e)});
                                r.setGrupoHorario(gh);
                                r.setPersona(responsable);
                                r.setCreateDate(new Date());
                                r.setUpdateDate(new Date());
                                r.setAutor(autor);
                                
                                AsistenciaEntityManager.crearEntidad(r);
                        }
                 }
                 
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
             
         } catch (NoDataFoundException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NoDataFoundException("Uno de los datos requeridos para crear la relación centro-trabajo y unidad ya no está disponible.", ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     // </editor-fold>




}
