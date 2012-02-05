package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.DiaFestivo;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.MiembroGrupoHorario;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaBase;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaExterna;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAtraso;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAusentismo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoHora;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoSobretiempo;
import com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacionalPadre;

public final class AsistenciaDomainEntityFactory {

	public static Object getNewInstance(Class clazz) throws ClassNotFoundException {
		
        if (clazz.equals(Persona.class))
            return new com.synapsis.rrhh.asistencia.to.Persona();
        
        else if (clazz.equals(CentroTrabajo.class))
            return new com.synapsis.rrhh.asistencia.to.CentroTrabajo();
        
        else if (clazz.equals(AjusteHorarioReal.class))
            return new com.synapsis.rrhh.asistencia.to.AjusteHorarioReal();
        
        else if (clazz.equals(AjusteHorarioTeorico.class))
            return new com.synapsis.rrhh.asistencia.to.AjusteHorarioTeorico();
        
        else if (clazz.equals(Calendario.class))
            return new com.synapsis.rrhh.asistencia.to.Calendario();
        
        else if (clazz.equals(DefinicionCalendario.class))
            return new com.synapsis.rrhh.asistencia.to.DefinicionCalendario();
        
        else if (clazz.equals(DiaFestivo.class))
            return new com.synapsis.rrhh.asistencia.to.DiaFestivo();
        
        else if (clazz.equals(EncargadoCentroTrabajo.class))
            return new com.synapsis.rrhh.asistencia.to.EncargadoCentroTrabajo();
        
        else if (clazz.equals(HojaTiempoHorarioReal.class))
            return new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioReal();
        
        else if (clazz.equals(HojaTiempoHorarioTeorico.class))
            return new com.synapsis.rrhh.asistencia.to.HojaTiempoHorarioTeorico();
        
        else if (clazz.equals(Horario.class))
            return new com.synapsis.rrhh.asistencia.to.Horario();
        
        else if (clazz.equals(TipoAjusteHojaTiempo.class))
            return new com.synapsis.rrhh.asistencia.to.TipoAjusteHojaTiempo();
        
        else if (clazz.equals(TipoAtraso.class))
            return new com.synapsis.rrhh.asistencia.to.TipoAtraso();
        
        else if (clazz.equals(TipoAusentismo.class))
            return new com.synapsis.rrhh.asistencia.to.TipoAusentismo();
        
        else if (clazz.equals(TipoDia.class))
            return new com.synapsis.rrhh.asistencia.to.TipoDia();
        
        else if (clazz.equals(TipoHora.class))
            return new com.synapsis.rrhh.asistencia.to.TipoHora();
        
        else if (clazz.equals(TipoJustificacion.class))
            return new com.synapsis.rrhh.asistencia.to.TipoJustificacion();
        
        else if (clazz.equals(TipoSobretiempo.class))
            return new com.synapsis.rrhh.asistencia.to.TipoSobretiempo();
        
        else if (clazz.equals(UbicacionGeografica.class))
            return new com.synapsis.rrhh.asistencia.to.UbicacionGeografica();
        
        else if (clazz.equals(UnidadOrganizacional.class))
            return new com.synapsis.rrhh.asistencia.to.UnidadOrganizacional();
        
        else if (clazz.equals(DefinicionHorario.class))
            return new com.synapsis.rrhh.asistencia.to.DefinicionHorario();
        
        else if (clazz.equals(RelacionCentrotrabajoUnidad.class))
            return new com.synapsis.rrhh.asistencia.to.RelacionCentrotrabajoUnidad();
        
        else if (clazz.equals(EncargadoCentroTrabajo.class))
            return new com.synapsis.rrhh.asistencia.to.EncargadoCentroTrabajo();
        
        else if (clazz.equals(GrupoHorarioCentroTrabajo.class))
            return new com.synapsis.rrhh.asistencia.to.GrupoHorarioCentroTrabajo();
        
        else if (clazz.equals(MiembroGrupoHorario.class))
            return new com.synapsis.rrhh.asistencia.to.MiembroGrupoHorario();
        
        else if (clazz.equals(SolicitudJustificacion.class))
            return new com.synapsis.rrhh.asistencia.to.SolicitudJustificacion();
        
        else if (clazz.equals(PersonaBase.class))
            return new com.synapsis.rrhh.asistencia.to.PersonaBase();
        
        else if (clazz.equals(PersonaExterna.class))
            return new com.synapsis.rrhh.asistencia.to.PersonaExterna();	

        else if (clazz.equals(UnidadOrganizacionalPadre.class))
            return new com.synapsis.rrhh.asistencia.to.UnidadOrganizacionalPadre();	

        else
        	throw new ClassNotFoundException("No se ha implementado la clase solicitada: \"" + clazz.getName() + "\"");
		
	}
	
}
