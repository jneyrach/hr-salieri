
package com.synapsis.rrhh.asistencia;
 
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.synapsis.rrhh.asistencia.domainmodel.AccesoUsuario;
import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacionalPadre;
import com.synapsis.rrhh.asistencia.exception.ApplicationServiceException;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import com.synapsis.rrhh.asistencia.exception.WebAppException;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;
import com.synapsis.rrhh.asistencia.service.AsistenciaConfiguracionSrv;
import com.synapsis.rrhh.asistencia.service.AsistenciaHojasDeTiempoAdminSrv;
import com.synapsis.rrhh.asistencia.service.AsistenciaMantenedoresSrv;
import com.synapsis.rrhh.asistencia.service.AsistenciaUtilSrv;


public class App {
    
	public static void main(String... args)  {

		try {
				// AsistenciaHojasDeTiempoAdminSrv.crearHojasDeTiempoTeoricasDePersona(autorId, rutPersona, horarioId, desde, hasta, calendarioId, correlativo, dateFormat);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
            
		
	}
	
}
