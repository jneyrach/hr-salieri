
package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaBase;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaExterna;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionUnidadPadreUnidadHija;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAusentismo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoHora;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoSobretiempo;
import com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacionalPadre;
import com.synapsis.rrhh.asistencia.exception.ApplicationServiceException;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class AsistenciaMantenedoresSrv {

    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Ajustes de Hojas de Tiempo   ]">
    public static List<TipoAjusteHojaTiempo> consultarTiposTiposAjustesHojasTiempo() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<TipoAjusteHojaTiempo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_AJUSTE_HOJA_TIEMPO___TODOS.getQueryDefinition(), null);
            
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
            
                return (TipoAjusteHojaTiempo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_AJUSTE_HOJA_TIEMPO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
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
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoAjusteHojaTiempo(entity))
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

                if (AsistenciaMantenedoresRules.validarEliminarTipoAjusteHojaTiempo(entity))
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
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoAjusteHojaTiempo(entity))
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
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Centros de Trabajo   ]">
    public static List<CentroTrabajo> consultarCentrosDeTrabajo() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<CentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static List<CentroTrabajo> consultarCentrosDeTrabajoACTIVO() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<CentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___TODOS_ACTIVO.getQueryDefinition(), new Object[]{null, null, BaseDomainEntity.CODIGO_ESTADO_GENERICO_ACTIVO});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static CentroTrabajo consultarCentroDeTrabajoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {            
                return (CentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static Set<EncargadoCentroTrabajo> consultarEncargadosCentrosTrabajo(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {            
                CentroTrabajo c = (CentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CENTRO_DE_TRABAJO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
                
                return c.getResponsables();
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<CentroTrabajo> consultarCentrosTrabajoEncargadosAPersona(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
    	List<CentroTrabajo> lst = new ArrayList<CentroTrabajo>();
    	
        try {            
                List<EncargadoCentroTrabajo> e = (List<EncargadoCentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.ENCARGADO_CENTRO_TRABAJO___POR_RUT.getQueryDefinition(), new Object[]{null, null, new Integer(id)});
                
                for (EncargadoCentroTrabajo ec : e)
                	lst.add(ec.getCentroTrabajo());
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
        return lst;
        
    }

    public static void crearCentroTrabajo(CentroTrabajo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoCentroTrabajo(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void desvincularEncargadoCentroTrabajo(EncargadoCentroTrabajo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarDesvincularEncargadoCentroTrabajo(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }

    public static void eliminarCentroTrabajo(CentroTrabajo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarCentroTrabajo(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarCentroTrabajo(CentroTrabajo entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoCentroTrabajo(entity))
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

    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Horas   ]">
    public static List<TipoHora> consultarTiposHoras() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<TipoHora>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_HORA___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoHora consultarTipoHoraPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
            
                return (TipoHora) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_HORA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearTipoHora(TipoHora entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoHora(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarTipoHora(TipoHora entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarTipoHora(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarTipoHora(TipoHora entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoHora(entity))
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

    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Ubicaciones Geográficas   ]">
    public static List<UbicacionGeografica> consultarUbicacionesGeograficas() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<UbicacionGeografica>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UBICACION_GEOGRAFICA___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static List<UbicacionGeografica> consultarUbicacionesGeograficasACTIVO() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<UbicacionGeografica>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UBICACION_GEOGRAFICA___TODOS_ACTIVOS.getQueryDefinition(), new Object[]{null, null, BaseDomainEntity.CODIGO_ESTADO_GENERICO_ACTIVO});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static UbicacionGeografica consultarUbicacionGeograficaPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {            
                return (UbicacionGeografica) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UBICACION_GEOGRAFICA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearUbicacionGeografica(UbicacionGeografica entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoUbicacionGeografica(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarUbicacionGeografica(UbicacionGeografica entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarUbicacionGeografica(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarUbicacionGeografica(UbicacionGeografica entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoUbicacionGeografica(entity))
                    AsistenciaEntityManager.updateEntity(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    // </editor-fold>
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Sobretiempos   ]">
    public static List<TipoSobretiempo> consultarTiposSobretiempos() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<TipoSobretiempo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_SOBRETIEMPO___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoSobretiempo consultarTipoSobretiempoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {            
                return (TipoSobretiempo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_SOBRETIEMPO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearTipoSobretiempo(TipoSobretiempo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoSobretiempo(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarTipoSobretiempo(TipoSobretiempo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarTipoSobretiempo(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarTipoSobretiempo(TipoSobretiempo entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoSobretiempo(entity))
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
    
    
    
        
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Ausentismos   ]">
    public static List<TipoAusentismo> consultarTiposAusentismos() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<TipoAusentismo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_AUSENTISMO___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoAusentismo consultarTipoAusentismoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (TipoAusentismo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_AUSENTISMO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearTipoAusentismo(TipoAusentismo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoAusentismo(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarTipoAusentismo(TipoAusentismo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarTipoAusentismo(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarTipoAusentismo(TipoAusentismo entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoAusentismo(entity))
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
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Justificaciones   ]">
    public static List<TipoJustificacion> consultarTiposJustificaciones() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<TipoJustificacion>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_JUSTIFICACION___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static List<TipoJustificacion> consultarTiposJustificacionesACTIVO() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<TipoJustificacion>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_JUSTIFICACION___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoJustificacion consultarTipoJustificacionPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {            
                return (TipoJustificacion) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_JUSTIFICACION___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearTipoJustificacion(TipoJustificacion entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
            
                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoJustificacion(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarTipoJustificacion(TipoJustificacion entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarTipoJustificacion(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarTipoJustificacion(TipoJustificacion entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoJustificacion(entity))
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
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Dias   ]">
    public static List<TipoDia> consultarTiposDias() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<TipoDia>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_DIA___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoDia consultarTipoDiaPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (TipoDia) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_DIA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static TipoDia consultarTipoDiaPorNombre(String name) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (TipoDia) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_DIA___POR_NOMBRE.getQueryDefinition(), new Object[]{null, name});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearTipoDia(TipoDia entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                entity.setStatus("A");
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoDia(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarTipoDia(TipoDia entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {

                if (AsistenciaMantenedoresRules.validarEliminarTipoDia(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarTipoDia(TipoDia entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoTipoDia(entity))
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
    
    

    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Personas   ]">
    public static Persona consultarPersonaPorRut(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {

        try {
            
                return (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }    
    
    public static Persona consultarPersonaPorNumeroDeTarjea(String tarjeta) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
            
                return (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_NUMERO_DE_TARJETA.getQueryDefinition(), new Object[]{new Integer(tarjeta)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }    
    // </editor-fold>


    


    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Grupos de Horarios de Centros de Trabajo   ]">
    public static List<GrupoHorarioCentroTrabajo> consultarGruposHorario() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<GrupoHorarioCentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.GRUPO_HORARIO___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static List<GrupoHorarioCentroTrabajo> consultarTodosGruposHorarioDeCentrosDeTrabajo(List<Integer> centros) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (List<GrupoHorarioCentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.GRUPO_HORARIO___DE_CENTROS_DE_TRABAJO.getQueryDefinition(), new Object[]{null, null, centros});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<GrupoHorarioCentroTrabajo> consultarTodosGruposHorarioDeUnidadesOrganizacionales(List<Integer> unidades) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {

        try {
        		List<RelacionCentrotrabajoUnidad> lista = (List<RelacionCentrotrabajoUnidad>)AsistenciaConfiguracionSrv.consultarRelacionCentrotrabajoParaVariasUnidadesOrganizacionales(unidades);
        		
        		List<Integer> centros = new ArrayList<Integer>();
        		for (RelacionCentrotrabajoUnidad r : lista)
        			centros.add(r.getCentroTrabajo().getId());
        	
                return (List<GrupoHorarioCentroTrabajo>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.GRUPO_HORARIO___DE_CENTROS_DE_TRABAJO.getQueryDefinition(), new Object[]{null, null, centros});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static GrupoHorarioCentroTrabajo consultarGrupoHorarioCentroTrabajoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
    
        try {
                return (GrupoHorarioCentroTrabajo) AsistenciaEntityManager.qryEntity2(QueryCatalog2.GRUPO_HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static void crearGrupoHorarioCentroTrabajo(GrupoHorarioCentroTrabajo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
                entity.setStatus(BaseDomainEntity.CODIGO_ESTADO_GENERICO_ACTIVO);
                entity.setCreateDate(new Date());
                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoGrupoHorarioCentroTrabajo(entity))
                    AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void eliminarGrupoHorarioCentroTrabajo(GrupoHorarioCentroTrabajo entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
    
        try {
                if (AsistenciaMantenedoresRules.validarEliminarGrupoHorarioCentroTrabajo(entity))
                    AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }
    
    public static void actualizarGrupoHorarioCentroTrabajo(GrupoHorarioCentroTrabajo entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
    
        try {

                entity.setUpdateDate(new Date());
            
                if (AsistenciaMantenedoresRules.validarIngresoGrupoHorarioCentroTrabajo(entity))
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
   





    public static UnidadOrganizacional consultarUnidadOrganizacionalPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (UnidadOrganizacional) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static UnidadOrganizacionalPadre consultarUnidadOrganizacionalPadrePorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (UnidadOrganizacionalPadre) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL_PADRE___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static UnidadOrganizacional consultarUnidadOrganizacionalPorEncargadoId(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (UnidadOrganizacional) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___POR_ENCARGADO_ID.getQueryDefinition(), new Object[]{null, null, new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<UnidadOrganizacional> consultarUnidadesOrganizacionalesPorEncargadoId(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<UnidadOrganizacional>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___POR_ENCARGADO_ID.getQueryDefinition(), new Object[]{null, null, new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<UnidadOrganizacional> consultarUnidadesOrganizacionalesDeCentroDeTrabajo(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<UnidadOrganizacional>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL___DE_CENTRO_DE_TRABAJO.getQueryDefinition(), new Object[]{null, new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static UnidadOrganizacionalPadre consultarUnidadesOrganizacionalesPadresPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (UnidadOrganizacionalPadre) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL_PADRE___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<UnidadOrganizacionalPadre> consultarUnidadesOrganizacionalesPadresPorNombre(String nombre) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<UnidadOrganizacionalPadre>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.UNIDAD_ORGANIZACIONAL_PADRE___POR_NOMBRE.getQueryDefinition(), new Object[]{null, "%" + nombre + "%"});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<RelacionUnidadPadreUnidadHija> consultarRelacionUnidadPadreUnidadHijaPorPadreID(List<Integer> padres) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<RelacionUnidadPadreUnidadHija>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDADES_ORGANIZACIONALES___POR_PADRE_ID.getQueryDefinition(), new Object[]{padres});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    
    public static List<RelacionUnidadPadreUnidadHija> consultarRelacionUnidadPadreUnidadHijaPorHijaID(List<Integer> hijas) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<RelacionUnidadPadreUnidadHija>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.RELACION_UNIDADES_ORGANIZACIONALES___POR_HIJA_ID.getQueryDefinition(), new Object[]{null, hijas});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }
    




    public static PersonaBase consultarPersonaBasePorRut(String rut) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (PersonaBase) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA_BASE___POR_RUT.getQueryDefinition(), new Object[]{new Integer(rut)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static void crearPersonaBase(PersonaBase entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
        
        try {
        		AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }

    public static void actualizarPersonaBase(PersonaBase entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
        
        try {
        		AsistenciaEntityManager.actualizarEntidad(entity);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }

    
    
    
    public static List<PersonaExterna> consultarPersonasExternas() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<PersonaExterna>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA_EXTERNA___TODOS.getQueryDefinition(), null);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static List<PersonaExterna> consultarPersonasExternas(String centroTrabajoId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (List<PersonaExterna>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA_EXTERNA___TODOS_DE_CENTRO_TRABAJO.getQueryDefinition(), new Object[]{null, null, null, new Integer(centroTrabajoId)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static PersonaExterna consultarPersonaExternaPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
                return (PersonaExterna) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA_EXTERNA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (NoDataFoundException ex) {
                throw new NoDataFoundException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException(ex);
        }
    
    }

    public static void crearPersonaExterna(PersonaExterna entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
        
        try {
                AsistenciaEntityManager.crearEntidad(entity);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }

    public static void actualizarPersonaExterna(PersonaExterna entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
        
        try {
                AsistenciaEntityManager.actualizarEntidad(entity);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
    }

	public static void eliminarPersonaExterna(PersonaExterna entity) throws NotConnectedException, ApplicationServiceException {
        
        try {
                AsistenciaEntityManager.eliminarEntidad(entity);
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
	}

}
