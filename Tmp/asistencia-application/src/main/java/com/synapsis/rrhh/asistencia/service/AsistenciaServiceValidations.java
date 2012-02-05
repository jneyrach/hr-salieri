
package com.synapsis.rrhh.asistencia.service;

import java.util.Date;
import java.util.List;

import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;

public class AsistenciaServiceValidations {

	public static List<HojaTiempoHorarioTeorico> verificarHojasDeTiempoCreadasParaRangoDeFechas(Date dtI, Date dtT, Integer personaId) {
		
		try {
				List<HojaTiempoHorarioTeorico> hojas = (List<HojaTiempoHorarioTeorico>) AsistenciaEntityManager.qryEntity2(QueryCatalog2.HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_RANGO_DE_FECHA.getQueryDefinition(), new Object[]{null, personaId, dtI, dtT});
				
				long diffDates = (( ((dtT.getTime() - dtI.getTime()) / 86000000L) + 1 ));
				
				if (hojas.size() != diffDates)
					return null;
				else
					return hojas;
		
		} catch (Exception ex) {
					return null;
		}
		
	}
	
	public static Object verificaSiExisteEntidadPorID(Class clazz, String id) {
		
		try {
				String cln = clazz.getSimpleName();
			
				if (cln.equals(TipoDia.class.getSimpleName()))
					return (TipoDia) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_DIA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
				
				if (cln.equals(Persona.class.getSimpleName()))
					return (Persona) AsistenciaEntityManager.qryEntity2(QueryCatalog2.PERSONA___POR_RUT.getQueryDefinition(), new Object[]{new Integer(id)});
				
				if (cln.equals(TipoJustificacion.class.getSimpleName()))
					return (TipoJustificacion) AsistenciaEntityManager.qryEntity2(QueryCatalog2.TIPO_DIA___POR_ID.getQueryDefinition(), new Object[]{new Integer(id)});
				
				else
					return null;

		} catch (Exception ex) {
					return null;
		}
		
	}
	 

}
