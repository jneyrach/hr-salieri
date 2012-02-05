
package com.synapsis.rrhh.asistencia.persistence.service;

import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.AjusteHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
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
import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NoSingleResultException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;
import java.util.List;
import javax.persistence.Query;


public abstract class AsistenciaEntityManager extends GenericEntityManager {
    
	public static boolean actualizarDatosPartes(String fechaInformes) {
		
		try {
		    	Query  qry = GenericEntityManager.createNativeSQL("{ call PR_ASI_ACTUALIZA_DATOS_PARTES(?) }");
		    	
		    	qry.setParameter(1, fechaInformes);
		    	
		    	GenericEntityManager.beginEntityTransaction();
		    	
		    	int result = qry.executeUpdate();
		    	
		    	GenericEntityManager.commitEntityTransaction();
			
				return (result == 1);
			
		} catch (Exception ex) {
				GenericEntityManager.rollbackEntityTransaction();
				return false;
		}
		
	}
	
	
    public static Object consultarPorId(Class theClass, String id) throws NoDataFoundException, NotConnectedException {
        
        return getEntityByID(theClass, new Integer(id));
        
    }
    
    public static void crearEntidad(Object entity) throws NotConnectedException {

        Object tmp = converToPojo(entity);

        createEntity(tmp);

    }

    public static void actualizarEntidad(Object entity) throws NotConnectedException {

        Object tmp = converToPojo(entity);

        updateEntity(tmp);

    }

    public static void eliminarEntidad(BaseDomainEntity entity) throws NotConnectedException, NoDataFoundException {

        BaseDomainEntity b = converToPojo(entity);
        
        Object o = getEntityByID(b.getClass(), b.getId());

        deleteEntity(o);
        
    }    
    
    public static Object qryEntity2(EntityQuery qryDef, Object... pars) throws NoDataFoundException, NotConnectedException {

        Query qry = AsistenciaQueryBuilder.buildGenericQry2(qryDef, pars);
        
        List result = getListByQueryObject(qry);
        
        if (qryDef.isSingleResult())
            return result.get(0);
        else
            return result;
        
    }

    public static BaseDomainEntity converToPojo(Object from) {

        if (from.getClass().getSimpleName().equalsIgnoreCase(Persona.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.Persona tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.Persona((Persona) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(CentroTrabajo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.CentroTrabajo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.CentroTrabajo((CentroTrabajo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(AjusteHorarioReal.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.AjusteHorarioReal tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.AjusteHorarioReal((AjusteHorarioReal) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(AjusteHorarioTeorico.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.AjusteHorarioTeorico tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.AjusteHorarioTeorico((AjusteHorarioTeorico) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(Calendario.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.Calendario tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.Calendario((Calendario) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(DefinicionCalendario.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionCalendario tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionCalendario((DefinicionCalendario) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(DiaFestivo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.DiaFestivo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.DiaFestivo((DiaFestivo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(EncargadoCentroTrabajo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.EncargadoCentroTrabajo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.EncargadoCentroTrabajo((EncargadoCentroTrabajo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(HojaTiempoHorarioReal.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioReal tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioReal((HojaTiempoHorarioReal) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(HojaTiempoHorarioTeorico.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico((HojaTiempoHorarioTeorico) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(Horario.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.Horario tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.Horario((Horario) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoAjusteHojaTiempo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo((TipoAjusteHojaTiempo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoAtraso.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoAtraso tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoAtraso((TipoAtraso) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoAusentismo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoAusentismo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoAusentismo((TipoAusentismo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoDia.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia((TipoDia) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoHora.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoHora tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoHora((TipoHora) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoJustificacion.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoJustificacion tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoJustificacion((TipoJustificacion) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(TipoSobretiempo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.TipoSobretiempo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.TipoSobretiempo((TipoSobretiempo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(UbicacionGeografica.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.UbicacionGeografica tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.UbicacionGeografica((UbicacionGeografica) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(UnidadOrganizacional.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional((UnidadOrganizacional) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(DefinicionHorario.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionHorario tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionHorario((DefinicionHorario) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(RelacionCentrotrabajoUnidad.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad((RelacionCentrotrabajoUnidad) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(EncargadoCentroTrabajo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.EncargadoCentroTrabajo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.EncargadoCentroTrabajo((EncargadoCentroTrabajo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(GrupoHorarioCentroTrabajo.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.GrupoHorarioCentroTrabajo tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.GrupoHorarioCentroTrabajo((GrupoHorarioCentroTrabajo) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(MiembroGrupoHorario.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.MiembroGrupoHorario tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.MiembroGrupoHorario((MiembroGrupoHorario) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(SolicitudJustificacion.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion((SolicitudJustificacion) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(PersonaBase.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.PersonaBase tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.PersonaBase((PersonaBase) from);
            return tmp;
        } else if (from.getClass().getSimpleName().equalsIgnoreCase(PersonaExterna.class.getSimpleName())) {
            com.synapsis.rrhh.asistencia.persistence.pojo.PersonaExterna tmp = new com.synapsis.rrhh.asistencia.persistence.pojo.PersonaExterna((PersonaExterna) from);
            return tmp;
        }
        
        return null;
    
    }

}
