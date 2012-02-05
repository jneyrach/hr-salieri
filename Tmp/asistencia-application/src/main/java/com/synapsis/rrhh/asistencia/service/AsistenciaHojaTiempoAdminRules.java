
package com.synapsis.rrhh.asistencia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;
import com.synapsis.rrhh.asistencia.service.ServicesSetup.OPERATION_SETUP___CREAR_MARCAS;

public abstract class AsistenciaHojaTiempoAdminRules {

    public static boolean validarIngresoTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoHojaTiempoHorarioReal(HojaTiempoHorarioReal entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarHojaTiempoHorarioReal(HojaTiempoHorarioReal entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoHojaTiempoHorarioTeorico(HojaTiempoHorarioTeorico entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarHojaTiempoHorarioTeorico(HojaTiempoHorarioTeorico entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoAjusteHorarioTeorico(AjusteHorarioTeorico entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarAjusteHorarioTeorico(AjusteHorarioTeorico entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoAjusteHorarioReal(AjusteHorarioReal entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarAjusteHorarioReal(AjusteHorarioReal entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoSolicitudJustificacion(SolicitudJustificacion entity) throws BusinessRulesNotSatisfiedException {
        
    	boolean isValid = false;
    	
    	try {
    			List<SolicitudJustificacion> lst = 
    				(List<SolicitudJustificacion>) 
    					AsistenciaEntityManager
    						.qryEntity2(QueryCatalog2.SOLICITUD_JUSTIFICACION___DE_PERSONA__POR_FECHA.getQueryDefinition(), 
    								    new Object[]{null, 
    							                    entity.getFuncionario().getId(), 
    							                    entity.getFechaDesde(), 
    							                    entity.getFechaDesde(), 
    							                    entity.getFechaDesde(), 
    							                    entity.getFechaHasta(), 
    							                    entity.getFechaHasta(), 
    							                    entity.getFechaHasta() });
    			
    			throw new BusinessRulesNotSatisfiedException("Ya existe una solicitud que contempla el rango de fechas que usted está solicitando.");
    			
    	} catch (NoDataFoundException ex) {
    				isValid = true;
    	} catch (Exception ex) { }
    	
    	return isValid;
    	
    }

	public static boolean validarEliminarSolicitudJustificacion(SolicitudJustificacion entity) throws BusinessRulesNotSatisfiedException {
		
		if (entity.getStatus().equalsIgnoreCase("P")) return true;
		
		throw new BusinessRulesNotSatisfiedException("Solo se permiten eliminar Papeletas en estado Pendiente.");
		
	}
    
    public static Map<String, Object> validarIngresoHojaTiempoHorarioReal(String formatoFecha
                                                                         ,String fechaInicio
                                                                         ,String fechaTermino
                                                                         ,String marcaEntrada
                                                                         ,String marcaSalida
                                                                         ,String horaJustificacionInicio
                                                                         ,String horaJustificacionTermino
                                                                         ,String justificacionId
                                                                         ,String tipoDiaId
                                                                         ,String autorId
                                                                         ,String personaId    )
    
    throws BusinessRulesNotSatisfiedException, NotConnectedException {
        
    	Map<String, Object> operData = new Hashtable<String, Object>();
    	List<String>        msgs     = new ArrayList<String>();
    	boolean             noe      = true;

    	
    	// val01: Verifica el formato del rut de la persona
		val01:{
    			try {
    					operData.put(OPERATION_SETUP___CREAR_MARCAS._PERSONA_ID.getParameterName(), new Integer(Integer.parseInt(personaId)));

    			} catch (NumberFormatException ex) {
    						msgs.add( "El R.U.T. pasado como parámetro debe ser solamente la parte numérica." );
    						noe = false;
    			}
		}

    	
    	// val02: Verifica el formato y rangos de fecha pasados como parámetro
		val02:{
    			List<Date> rangoFechas = GenericServiceValidations.dateStringToDate(new String[]{fechaInicio, fechaTermino}, formatoFecha);

    			if (rangoFechas == null) {
    				msgs.add( "Existe un problema con el formato de fechas, no se pudieron transformar todos los valores a fechas con el formato dado." );
					noe = false;
    			}

    			if (!GenericServiceValidations.dateRangeFromTo(rangoFechas.get(0), rangoFechas.get(1))) {
    				msgs.add( "La fecha de Inicio NO puede ser superior a la fecha de Término." );
					noe = false;
    			}

				operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._FECHA_INICIO.getParameterName(), rangoFechas.get(0));
				operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._FECHA_TERMINO.getParameterName(), rangoFechas.get(1));						
		}
    		
		
		// val03: Verifica que las hojas de tiempo estén creadas
		val03:{
				List<HojaTiempoHorarioTeorico> hojas = 
					AsistenciaServiceValidations
						.verificarHojasDeTiempoCreadasParaRangoDeFechas(
									(Date)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._FECHA_INICIO.getParameterName()),
									(Date)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._FECHA_TERMINO.getParameterName()),
									(Integer)operData.get(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._PERSONA_ID.getParameterName())
								);

				if (hojas == null) {
					msgs.add( "No se han creado todas las hojas de tiempo correspondiente al rango de fecha dado." );
					noe = false;
				}
				
				operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._HOJAS_DE_TIEMPO.getParameterName(), hojas);
		}
		
		
		// val04: Verifica que exista el registro de la persona nombrada como autor.
		val04:{
				Persona p = (Persona) AsistenciaServiceValidations.verificaSiExisteEntidadPorID(Persona.class, autorId);

				if (p == null) {
					msgs.add( "No existe el registro del R.U.T. de persona pasado como autor." );
					noe = false;
				} else
						operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._AUTOR.getParameterName(), p);
					
		}
		
		
		// val05: Verifica que los registros de horas estén en el formato correcto y en los rangos correctos.
		val05:{
	            // La Marca de Entrada
	            if (!(marcaEntrada == null) & !marcaEntrada.isEmpty())
		            try {
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___HORA.getParameterName(), new Integer(Integer.parseInt(marcaEntrada.substring(0, 2))));
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___MINUTOS.getParameterName(), new Integer(Integer.parseInt(marcaEntrada.substring(3, 5))));
		            	
		            } catch (NumberFormatException ex) {
								msgs.add( "La marca de entrada no viene en el formato correcto HH:MM, ej.: 09:01" );
								noe = false;
		            }
		        else {
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___HORA.getParameterName(), null);
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_ENTRADA___MINUTOS.getParameterName(), null);
		        }
	            	
	            // La Marca de Salida
	            if (!(marcaSalida == null) & !marcaSalida.isEmpty())
		            try {
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___HORA.getParameterName(), new Integer(Integer.parseInt(marcaSalida.substring(0, 2))));
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___MINUTOS.getParameterName(), new Integer(Integer.parseInt(marcaSalida.substring(3, 5))));
		            	
		            } catch (NumberFormatException ex) {
								msgs.add( "La marca de salida no viene en el formato correcto HH:MM, ej.: 09:01" );
								noe = false;
		            }
		        else {
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___HORA.getParameterName(), null);
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_SALIDA___MINUTOS.getParameterName(), null);
		        }
		}
	            
		// val06: Verifica los datos de Justificación.
		val06:{
	            // Las Marcas de Justificación
	            if (!(horaJustificacionInicio == null))
	            if (!horaJustificacionInicio.isEmpty())
		            try {
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_HORA.getParameterName(), new Integer(Integer.parseInt(horaJustificacionInicio.substring(0, 2))));
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_MINUTOS.getParameterName(), new Integer(Integer.parseInt(horaJustificacionInicio.substring(3, 5))));
		            	
		            } catch (NumberFormatException ex) {
								msgs.add( "La marca de inicio de la Justificación no viene en el formato correcto HH:MM, ej.: 09:01" );
								noe = false;
		            }
		        else {
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_HORA.getParameterName(), null);
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___INICIO_MINUTOS.getParameterName(), null);
		        }

	            if (!(horaJustificacionTermino == null))
	            if (!horaJustificacionTermino.isEmpty())
		            try {
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_HORA.getParameterName(), new Integer(Integer.parseInt(horaJustificacionTermino.substring(0, 2))));
		            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_MINUTOS.getParameterName(), new Integer(Integer.parseInt(horaJustificacionTermino.substring(3, 5))));
		            	
		            } catch (NumberFormatException ex) {
								msgs.add( "La marca de término de la Justificación no viene en el formato correcto HH:MM, ej.: 09:01" );
								noe = false;
		            }
		        else {
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_HORA.getParameterName(), null);
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._MARCA_JUSTIFICACION___TERMINO_MINUTOS.getParameterName(), null);
		        }

	            if (!(horaJustificacionInicio == null) && !(horaJustificacionTermino == null))
	            if (!horaJustificacionInicio.isEmpty() && !horaJustificacionTermino.isEmpty()) {
					TipoJustificacion tp = (TipoJustificacion) AsistenciaServiceValidations.verificaSiExisteEntidadPorID(TipoJustificacion.class, autorId);
	
					if (tp == null) {
						msgs.add( "No existe el registro de Tipo de Justificación pasado como parámetro." );
						noe = false;
					} else
							operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._TIPO_JUSTIFICACION.getParameterName(), tp);
	            } else
	            		operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._TIPO_JUSTIFICACION.getParameterName(), null);

		}
		
		
		// Finalmente indica que todo resultó OK
		if (noe)
			operData.put(ServicesSetup.DEFAULT_OPERATION_RESULT_OK_NAME, "OK");
		else
			operData.put(ServicesSetup.DEFAULT_OPERATION_RESULT_MESSAGE_NAME, msgs);
        

		return operData;

    }
    
}


/*

		// val04: Verifica que existe el tipo de día especificado
		val04:{
				TipoDia t = (TipoDia) AsistenciaServiceValidations.verificaSiExisteEntidadPorID(TipoDia.class, tipoDiaId); 

				if (t == null) {
					msgs.add( "No existe el Tipo de Día pasado como parámetro." );
					noe = false;
				} else
						operData.put(ServicesSetup.OPERATION_SETUP___CREAR_MARCAS._TIPO_DIA.getParameterName(), t);
					
		}

*/
