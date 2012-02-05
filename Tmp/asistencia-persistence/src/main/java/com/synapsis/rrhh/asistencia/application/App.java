
package com.synapsis.rrhh.asistencia.application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Query;

import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.MiembroGrupoHorario;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia;
import com.synapsis.rrhh.asistencia.persistence.service.AsistenciaEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.GenericEntityManager;
import com.synapsis.rrhh.asistencia.persistence.service.QueryCatalog2;

public class App {

    public void doStuff() {

    	try {
		    	Query  qry       = GenericEntityManager.createNativeSQL("{ call PR_ASI_ACTUALIZA_DATOS_PARTES(?, ?) }");
		    	String resultado = "";
		    	qry.setParameter(1, "20110314");
		    	qry.setParameter(2, resultado);
		    	
		    	GenericEntityManager.beginEntityTransaction();
		    	System.out.println("************: " + qry.executeUpdate());
		    	System.out.println("************: " + resultado);
		    	GenericEntityManager.commitEntityTransaction();
		    	
    	} catch (Exception ex) {
    			GenericEntityManager.rollbackEntityTransaction();
    			ex.printStackTrace();
    	}
        
    }
    
    public static void main(String... args) {
        App app = new App();
        app.doStuff();
        
        System.out.println("FINITO!");

    }
    
}

