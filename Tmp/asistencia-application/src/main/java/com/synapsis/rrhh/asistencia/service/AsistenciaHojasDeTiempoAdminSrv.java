
package com.synapsis.rrhh.asistencia.service;
 
import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.InformeAsistencia;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.exception.ApplicationServiceException;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NoSingleResultException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsistenciaHojasDeTiempoAdminSrv {
    
    public static List<SolicitudJustificacion> buscarSolicitudesJustificacion() throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                return (List<SolicitudJustificacion>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.SOLICITUD_JUSTIFICACION___TODOS.getQueryDefinition(), new Object[]{null});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static List<SolicitudJustificacion> buscarSolicitudesJustificacionDeUnidadOrganizacional(String unidadOrgId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
               return (List<SolicitudJustificacion>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.SOLICITUD_JUSTIFICACION___TODOS__PARA_UNIDAD_ORGANIZACIONAL.getQueryDefinition(), new Object[]{null, null, null, new Integer(unidadOrgId)});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
   }

    public static List<SolicitudJustificacion> buscarSolicitudesJustificacionDeUnidadesOrganizacionales(List<Integer> unidades) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
               return (List<SolicitudJustificacion>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.SOLICITUD_JUSTIFICACION___TODOS__PARA_VARIAS_UNIDADES_ORGANIZACIONALES.getQueryDefinition(), new Object[]{null, null, null, unidades});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
   }
    
    public static SolicitudJustificacion buscarSolicitudJustificacionPorId(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                return (SolicitudJustificacion)AsistenciaEntityManager.qryEntity2(QueryCatalog2.SOLICITUD_JUSTIFICACION___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
        	 	//return (SolicitudJustificacion)AsistenciaEntityManager.getEntityByID(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class, new Integer(id));
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }

    public static Persona buscarPersonaPorTarjeta(String numeroTarjeta) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                return (Persona)AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_NUMERO_DE_TARJETA.getQueryDefinition(), new Object[]{null, new Integer(numeroTarjeta)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static HojaTiempoHorarioTeorico buscarDiaHojaTiempoTeoricoDePersona(String fecha, String personaRut, String formatoFecha) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
                Date tmpFecha = sdf.parse(fecha);
             
                return (HojaTiempoHorarioTeorico)AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA.getQueryDefinition(), new Object[]{null, new Integer(personaRut), tmpFecha});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }

    public static HojaTiempoHorarioTeorico buscarDiaHojaTiempoTeoricoPorID(String id) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                return (HojaTiempoHorarioTeorico)AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }

    public static List<HojaTiempoHorarioTeorico> buscarRangoHojaTiempoTeoricoDePersona(String fechaDesde, String fechaHasta, String personaRut, String formatoFecha) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
                Date tmpDesde = sdf.parse(fechaDesde);
                Date tmpHasta = sdf.parse(fechaHasta);
             
                return (List<HojaTiempoHorarioTeorico>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_RANGO_DE_FECHA.getQueryDefinition(), new Object[]{null, new Integer(personaRut), tmpDesde, tmpHasta});
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static List<HojaTiempoHorarioTeorico> buscarRangoHojaTiempoTeoricoGrupoDePersonas(String fechaDesde, String fechaHasta, String personasRut, String formatoFecha) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
        
        try {
               SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
               Date tmpDesde = sdf.parse(fechaDesde);
               Date tmpHasta = sdf.parse(fechaHasta);
               
               List<Integer> ruts = new ArrayList<Integer>();
               String[] parRuts = personasRut.split(",");
               for (String r : parRuts)
            	   ruts.add(new Integer(r));
               
               return (List<HojaTiempoHorarioTeorico>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_GRUPO_DE_PERSONAS_POR_RANGO_DE_FECHA.getQueryDefinition(), new Object[]{null, ruts, tmpDesde, tmpHasta});
            
        } catch (NotConnectedException ex) {
                throw new NotConnectedException(ex);
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }
    
   }
   
    public static void crearHojaTiempoHorarioReal(HojaTiempoHorarioReal hoja) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                AsistenciaEntityManager.crearEntidad(hoja);
             
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static void actualizarHojaTiempoHorarioReal(HojaTiempoHorarioReal hoja) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                AsistenciaEntityManager.actualizarEntidad(hoja);
             
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static void actualizarHojaTiempoHorarioTeorico(HojaTiempoHorarioTeorico hoja, HojaTiempoHorarioReal real, boolean crearHojaTiempoReal) throws ApplicationServiceException, NotConnectedException, NoDataFoundException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();

                     real.setHojaHorarioTeorico(hoja);
                 
                     if (crearHojaTiempoReal)
                         AsistenciaEntityManager.crearEntidad(real);
                     else
                         AsistenciaEntityManager.actualizarEntidad(real);

                     AsistenciaEntityManager.actualizarEntidad(hoja);
                     
                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
             
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
    }
    
    public static void crearOActualizarHojaTiempoReal(String formatoFecha
    		                                        ,String fechaInicio
    		                                        ,String fechaTermino
    		                                        ,String marcaEntrada
    		                                        ,String marcaSalida
    		                                        ,String horaJustificacionInicio
    		                                        ,String horaJustificacionTermino
    		                                        ,String justificacionId
    		                                        ,String tipoDiaId
    		                                        ,String autorId
    		                                        ,String personaId  )
    
    throws ApplicationServiceException, NotConnectedException, NoDataFoundException, BusinessRulesNotSatisfiedException {
        
    	// Valida los datos de entrada y obtiene sus valores en caso de estar correctos.
    	Map<String, Object> operData = AsistenciaHojaTiempoAdminRules
    										.validarIngresoHojaTiempoHorarioReal(formatoFecha
                                                                                ,fechaInicio
                                                                                ,fechaTermino
                                                                                ,marcaEntrada
                                                                                ,marcaSalida
                                                                                ,horaJustificacionInicio
                                                                                ,horaJustificacionTermino
                                                                                ,justificacionId
                                                                                ,tipoDiaId
                                                                                ,autorId
                                                                                ,personaId    );
    	
    	if (!operData.containsKey(ServicesSetup.DEFAULT_OPERATION_RESULT_OK_NAME)) {
    		
    		StringBuilder msg = new StringBuilder();
    		for (String s : (String[])operData.get(ServicesSetup.DEFAULT_OPERATION_RESULT_MESSAGE_NAME)) {
    			msg.append(s);
    			msg.append("\n");
    		}
    		
    		throw new BusinessRulesNotSatisfiedException(msg.toString());
    		
    	}
    	
        try {
                // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                //AsistenciaEntityManager.beginEntityTransaction();
        	
	            GregorianCalendar gc  = (GregorianCalendar) GregorianCalendar.getInstance();
	            gc.setTime( (Date)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._FECHA_INICIO.getParameterName()) );
	            
        		@SuppressWarnings("unchecked")
				List<HojaTiempoHorarioTeorico> list = (List<HojaTiempoHorarioTeorico>)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._HOJAS_DE_TIEMPO.getParameterName());
				for (HojaTiempoHorarioTeorico t : list) {
        			
		                HojaTiempoHorarioReal r = t.getMarcas();
		                boolean crear = (t.getMarcas() == null);
		                if (t.getMarcas() == null)
		                    r = (HojaTiempoHorarioReal) AsistenciaDomainEntityFactory.getNewInstance(HojaTiempoHorarioReal.class);
		                
		                t.setUpdateDate(new Date());	                
		                t.setAutor( (Persona)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._AUTOR.getParameterName()) );
	
		                // La Marca de Entrada
	                    r.setHorarioInicioHora( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___HORA.getParameterName()) );
	                	r.setHorarioInicioMinutos( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___MINUTOS.getParameterName()) );
		                
		                // La Marca de Salida
	                	r.setHorarioTerminoHora( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___HORA.getParameterName()) );
	                	r.setHorarioTerminoMinutos( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___MINUTOS.getParameterName()) );
	
		                // La Marca de Justificación
		    			r.setJustificacionInicioHora( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_HORA.getParameterName()) );
		            	r.setJustificacionInicioMinutos( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_MINUTOS.getParameterName()) );
		            	r.setJustificacionTerminoHora( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_HORA.getParameterName()) );
		            	r.setJustificacionTerminoMinutos( (Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_MINUTOS.getParameterName()) );
		    			r.setTipoJustificacion( (TipoJustificacion)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._TIPO_JUSTIFICACION.getParameterName()) );
	
		    			
		                // El registro de Marcas es creado / actualizado.
		                AsistenciaHojasDeTiempoAdminSrv.actualizarHojaTiempoHorarioTeorico(t, r, crear);
		                
		                // Finalmente, continúa la secuencia del rango de fechas y verifica si debe salir del ciclo.
	                    gc.roll(Calendar.DAY_OF_YEAR, true);
        			
        		}
        	
                //AsistenciaEntityManager.commitEntityTransaction();
                // </editor-fold>
            
        } catch (Exception ex) {
                throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
        }

   }

   public static void replicarMarcasEnHojasDeTiempo(String hojasTiempoIDs, String autorId) throws ApplicationServiceException, NotConnectedException, NoDataFoundException, BusinessRulesNotSatisfiedException {

		try {
				// <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
				//AsistenciaEntityManager.beginEntityTransaction();
			
				List<Integer> theIDs = new ArrayList<Integer>();
				for (String s : hojasTiempoIDs.split(","))
					theIDs.add(new Integer(s));
				
				List<HojaTiempoHorarioTeorico> list = (List<HojaTiempoHorarioTeorico>)AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___POR_VARIOS_IDS.getQueryDefinition(), new Object[]{theIDs});
				
				for (HojaTiempoHorarioTeorico t : list) {
				
						HojaTiempoHorarioReal r = t.getMarcas();
						boolean crear = (t.getMarcas() == null);
						if (t.getMarcas() == null)
							r = (HojaTiempoHorarioReal) AsistenciaDomainEntityFactory.getNewInstance(HojaTiempoHorarioReal.class);
						
						t.setUpdateDate(new Date());
						t.setAutor( (Persona)AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorId)}) );
						
						// La Marca de Entrada
						r.setHorarioInicioHora( t.getInicioHora() );
						r.setHorarioInicioMinutos( t.getInicioMinutos() );
						
						// La Marca de Salida
						r.setHorarioTerminoHora( t.getTerminoHora() );
						r.setHorarioTerminoMinutos( t.getTerminoMinutos() );
						
						
						// El registro de Marcas es creado / actualizado.
						AsistenciaHojasDeTiempoAdminSrv.actualizarHojaTiempoHorarioTeorico(t, r, crear);
				
				}
				
				//AsistenciaEntityManager.commitEntityTransaction();
				// </editor-fold>
		
		} catch (Exception ex) {
				throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
		}

   }
    
    
    public static void crearHojasDeTiempoTeoricasDePersona(String autorId, String rutPersona, String horarioId, String desde, String hasta, String calendarioId, String correlativo, String dateFormat) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                 //AsistenciaEntityManager.beginEntityTransaction();
                 
                 
			             SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			             Horario    h = (Horario)    AsistenciaEntityManager.qryEntity2(QueryCatalog2.HORARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(horarioId)});
			             Persona    p = (Persona)    AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(rutPersona)});
			             Persona    a = (Persona)    AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorId)});
			             Calendario c = null;
			
			             if (!calendarioId.equals("0"))
			             	c = (Calendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.CALENDARIO___POR_ID.getQueryDefinition(), new Object[]{new Integer(calendarioId)});
			
			             GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
			             gc.setTime(sdf.parse(desde));
			             Date diaFin = sdf.parse(hasta);
			             boolean fc = true;

			             theWhile:
			             while (diaFin.after(gc.getTime()) || diaFin.compareTo(gc.getTime()) == 0) {
			                 
			                    int from = 0;
			                    if (fc) {
			                        from = (Integer.parseInt(correlativo) - 1);
			                        fc = false;
			                    }
			
			                    for (int i = from; i < h.getDefinicionOrdenadaPorCorrelativo().length; i++) {
			                            DefinicionHorario dh = h.getDefinicionOrdenadaPorCorrelativo()[i];
			                            HojaTiempoHorarioTeorico hoja = new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioTeorico();
			                            DefinicionCalendario     dc   = null;
			                            
			                            try {
			                                	   hoja = (HojaTiempoHorarioTeorico) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA.getQueryDefinition(), new Object[]{null, p.getId(), gc.getTime()});
			                            } catch (Exception ex) { }
			                            
			                            try {
			 	                               if (c != null)
			 	                            	   dc = (DefinicionCalendario) AsistenciaEntityManager.qryEntity2(QueryCatalog2.DEFINICION_CALENDARIO___POR_FECHA.getQueryDefinition(), new Object[]{null, null, null, gc.getTime()});
			 	                               
			 	                       } catch (Exception ex) { }
			
			                        	   hoja.setColacionHoras(dh.getHoraColacion());
			                            hoja.setColacionMinutos(dh.getMinutosColacion());
			                            hoja.setCorrelativo(dh.getCorrelativo());
			                            hoja.setCreateDate(new Date());
			                            hoja.setFechaCalendario(gc.getTime());
			                            hoja.setHorario(h);
			                            hoja.setInicioHora(dh.getHoraInicio());
			                            hoja.setInicioMinutos(dh.getMinutosInicio());
			                            hoja.setPersona(p);
			                            hoja.setStatus(BaseDomainEntity.CODIGO_ESTADO_GENERICO_ACTIVO);
			                            hoja.setTerminoHora(dh.getHoraTermino());
			                            hoja.setTerminoMinutos(dh.getMinutosTermino());
			                            hoja.setTipoDia(dh.getTipoDia());
			                            hoja.setCreateDate(new Date());
			                            hoja.setUpdateDate(new Date());
			                            hoja.setAutor(a);
			                            
			                            if (dh.getHorario().getTrabajaFestivo().equalsIgnoreCase("N") && dc != null)
			                         	   hoja.setPrefijoDia("1");
			                            else
			                         	   hoja.setPrefijoDia(dh.getTipoDia().getCode());
			                            
			                            if (hoja.getId() == null)
			                         	   AsistenciaEntityManager.crearEntidad(hoja);
			                            else
			                         	   AsistenciaEntityManager.actualizarEntidad(hoja);
			                                    
			                            gc.roll(Calendar.DAY_OF_YEAR, true);
			                            if (gc.getTime().after(diaFin)) break theWhile;
			                    }
			             }
                     

                 //AsistenciaEntityManager.commitEntityTransaction();
                 // </editor-fold>
                 
         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException("Not connected to Database!", ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
        	 	throw new RuntimeException(ex);
                 //throw new ApplicationServiceException("Erro, revise la programaciÃ³n mensual del RUT: " + rutPersona + ".", ex);
         }
    
     }
    
     public static void crearSolicitudJustificacionJU(SolicitudJustificacion entity, String autorId) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
         
         try {
             // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
             //AsistenciaEntityManager.beginEntityTransaction();

	 				 Persona autor = (Persona)AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorId)});
                     GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
                     gc.setTime(entity.getFechaDesde());
                     Date diaFin = entity.getFechaHasta();

                     theWhile:{
                     while (diaFin.after(gc.getTime()) || diaFin.compareTo(gc.getTime()) == 0) {
                         
                                HojaTiempoHorarioTeorico hoja = null;
                                try {
                                        hoja = (HojaTiempoHorarioTeorico) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA.getQueryDefinition(), new Object[]{null, entity.getFuncionario().getId(), gc.getTime()});
                                } 
                                catch (NoDataFoundException ex) { } 
                                
                                if (hoja == null) break theWhile;
                                
                                HojaTiempoHorarioReal real = hoja.getMarcas();

                                if (real == null) real = new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioReal();
                                
                                hoja.setAutor(autor);
                                hoja.setUpdateDate(new Date());
                                real.setJustificacionInicioHora(entity.getInicioHora());
                                real.setJustificacionInicioMinutos(entity.getInicioMinutos());
                                real.setJustificacionTerminoHora(entity.getTerminoHora());
                                real.setJustificacionTerminoMinutos(entity.getTerminoMinutos());
                                real.setHojaHorarioTeorico(hoja);
                                real.setTipoJustificacion(entity.getTipoJustificacion());
                                

                                AsistenciaEntityManager.actualizarEntidad(real);
                                AsistenciaEntityManager.actualizarEntidad(hoja);

                                gc.roll(Calendar.DAY_OF_YEAR, true);
                                if (gc.getTime().after(diaFin)) break theWhile;
                            }
                     }
                     
             //AsistenciaEntityManager.commitEntityTransaction();
             // </editor-fold>
             
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
    
     public static void crearSolicitudJustificacion(SolicitudJustificacion entity) throws ApplicationServiceException, BusinessRulesNotSatisfiedException, NotConnectedException {
     
         try {
                 entity.setCreateDate(new Date());
                 entity.setUpdateDate(new Date());
                 entity.setStatus("P");
             
                 if (AsistenciaHojaTiempoAdminRules.validarIngresoSolicitudJustificacion(entity))
                     AsistenciaEntityManager.crearEntidad(entity);
                 
                 else
                	 throw new BusinessRulesNotSatisfiedException("Existe un problema con su solicitud, verifique el rango de fechas.");
             
         } catch (BusinessRulesNotSatisfiedException ex) {
                 throw new BusinessRulesNotSatisfiedException(ex);
         } catch (NotConnectedException ex) {
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
     
     public static void eliminarSolicitudJustificacion(SolicitudJustificacion entity) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
         
         try {
             	if (AsistenciaHojaTiempoAdminRules.validarEliminarSolicitudJustificacion(entity))
             		AsistenciaEntityManager.eliminarEntidad(entity);
             	        	 
	     } catch (BusinessRulesNotSatisfiedException ex) {
             throw new BusinessRulesNotSatisfiedException(ex);
	     } catch (NotConnectedException ex) {
	             throw new NotConnectedException(ex);
	     } catch (Exception ex) {
	             throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
	     }
	 
	 }
     public static void actualizarSolicitudJustificacion(SolicitudJustificacion entity, String autorId) throws ApplicationServiceException, NotConnectedException, BusinessRulesNotSatisfiedException {
     
         try {
                 entity.setUpdateDate(new Date());             
                 
                 if (entity.getStatus().equalsIgnoreCase(SolicitudJustificacion.ESTADO_SOLICITUD_RECHAZADA))
                     AsistenciaEntityManager.actualizarEntidad(entity);
                 
                 else if (entity.getStatus().equalsIgnoreCase(SolicitudJustificacion.ESTADO_SOLICITUD_APROBADA)) {
                             // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                             //AsistenciaEntityManager.beginEntityTransaction();

                	 				 Persona autor = (Persona)AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorId)});
                                     GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
                                     gc.setTime(entity.getFechaDesde());
                                     Date diaFin = entity.getFechaHasta();

                                     theWhile:{
                                     while (diaFin.after(gc.getTime()) || diaFin.compareTo(gc.getTime()) == 0) {
                                         
                                                HojaTiempoHorarioTeorico hoja = null;
                                                try {
                                                        hoja = (HojaTiempoHorarioTeorico) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA.getQueryDefinition(), new Object[]{null, entity.getFuncionario().getId(), gc.getTime()});
                                                } 
                                                catch (NoDataFoundException ex) { } 
                                                
                                                if (hoja == null) break theWhile;
                                                
                                                HojaTiempoHorarioReal real = hoja.getMarcas();

                                                if (real == null) real = new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioReal();
                                                
                                                hoja.setAutor(autor);
                                                hoja.setUpdateDate(new Date());
                                                real.setJustificacionInicioHora(entity.getInicioHora());
                                                real.setJustificacionInicioMinutos(entity.getInicioMinutos());
                                                real.setJustificacionTerminoHora(entity.getTerminoHora());
                                                real.setJustificacionTerminoMinutos(entity.getTerminoMinutos());
                                                real.setHojaHorarioTeorico(hoja);
                                                real.setTipoJustificacion(entity.getTipoJustificacion());
                                                

                                                AsistenciaEntityManager.actualizarEntidad(real);
                                                AsistenciaEntityManager.actualizarEntidad(hoja);

                                                gc.roll(Calendar.DAY_OF_YEAR, true);
                                                if (gc.getTime().after(diaFin)) break theWhile;
                                            }
                                     }
                                     
                                     AsistenciaEntityManager.actualizarEntidad(entity);
                            
                             //AsistenciaEntityManager.commitEntityTransaction();
                             // </editor-fold>
                 } else if (entity.getStatus().equalsIgnoreCase(SolicitudJustificacion.ESTADO_SOLICITUD_NULA)) {
                         // <editor-fold defaultstate="expanded" desc=" [  on a single transaction  ] ">
                         //AsistenciaEntityManager.beginEntityTransaction();

            	 				 Persona autor = (Persona)AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(autorId)});
                                 GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
                                 gc.setTime(entity.getFechaDesde());
                                 Date diaFin = entity.getFechaHasta();

                                 theWhile:{
                                 while (diaFin.after(gc.getTime()) || diaFin.compareTo(gc.getTime()) == 0) {
                                     
                                            HojaTiempoHorarioTeorico hoja = null;
                                            try {
                                                    hoja = (HojaTiempoHorarioTeorico) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA.getQueryDefinition(), new Object[]{null, entity.getFuncionario().getId(), gc.getTime()});
                                            } 
                                            catch (NoDataFoundException ex) { } 
                                            
                                            if (hoja == null) break theWhile;
                                            
                                            HojaTiempoHorarioReal real = hoja.getMarcas();

                                            if (real == null) real = new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioReal();
                                            
                                            hoja.setAutor(autor);
                                            hoja.setUpdateDate(new Date());
                                            real.setJustificacionInicioHora(null);
                                            real.setJustificacionInicioMinutos(null);
                                            real.setJustificacionTerminoHora(null);
                                            real.setJustificacionTerminoMinutos(null);
                                            real.setHojaHorarioTeorico(hoja);
                                            real.setTipoJustificacion(null);
                                            

                                            AsistenciaEntityManager.actualizarEntidad(real);
                                            AsistenciaEntityManager.actualizarEntidad(hoja);

                                            gc.roll(Calendar.DAY_OF_YEAR, true);
                                            if (gc.getTime().after(diaFin)) break theWhile;
                                        }
                                 }
                                 
                                 AsistenciaEntityManager.actualizarEntidad(entity);
                        
                         //AsistenciaEntityManager.commitEntityTransaction();
                         // </editor-fold>
                 }
             
         } catch (NotConnectedException ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new NotConnectedException(ex);
         } catch (Exception ex) {
                 //AsistenciaEntityManager.rollbackEntityTransaction();
                 throw new ApplicationServiceException("Se produjo un error inesperado.", ex);
         }
     
     }
    
}
