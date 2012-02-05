
package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DiaFestivo;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioReal;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAtraso;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAusentismo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoHora;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoSobretiempo;
import com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;


public abstract class AsistenciaMantenedoresRules {

    public static boolean validarEncargadoCentroTrabajo(EncargadoCentroTrabajo responsable) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (responsable.getCentroTrabajo() == null) throw new BusinessRulesNotSatisfiedException("El atributo CentroTrabajo no puede ser nulo.");
                
                return true;
                
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarNuevoEncargadoCentroTrabajo\".", ex);
        }
    
    }
    
    public static boolean validarIngresoCentroTrabajo(CentroTrabajo centro) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (centro.getName() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"nombre\" no puede ser nulo.");
                if (centro.getDesc() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Descripción\" no puede ser nulo.");
                //if (centro.get() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Ubicación Geográfica\" no puede ser nulo.");
                
                return true;
                
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarIngresoCentroTrabajo\".", ex);
        }
    
    }
    
    public static boolean validarEliminarCentroTrabajo(CentroTrabajo centro) throws BusinessRulesNotSatisfiedException {
    
        try {
                //if ("Existen registros históricos asociados?") throw new BusinessRulesNotSatisfiedException("No se puede eliminar este Centro de Trabajo ya que existen registros históricos de asistencia.");
                
                return true;
                
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarEliminarCentroTrabajo\".", ex);
        }
    
    }
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Ausentismos   ]">
    public static boolean validarIngresoTipoAusentismo(TipoAusentismo tipoAusentismo) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (tipoAusentismo.getName() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"nombre\" no puede ser nulo.");
                if (tipoAusentismo.getDesc() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Descripción\" no puede ser nulo.");
                if (tipoAusentismo.getCode() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Códio\" no puede ser nulo.");
                //if (tipoAusentismo.getAutor() == null) throw new BusinessRulesNotSatisfiedException("Debe identificar al autor del registro.");
                
                return true;
                
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarIngresoTipoAusentismo\".", ex);
        }
    
    }
    
    public static boolean validarEdicionTipoAusentismo(TipoAusentismo tipoAusentismo) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (tipoAusentismo.getName() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"nombre\" no puede ser nulo.");
                if (tipoAusentismo.getDesc() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Descripción\" no puede ser nulo.");
                if (tipoAusentismo.getCode() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Códio\" no puede ser nulo.");
                if (tipoAusentismo.getAutor() == null) throw new BusinessRulesNotSatisfiedException("Debe identificar al autor del registro.");
                
                return true;
                
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarEdicionTipoAusentismo\".", ex);
        }
    
    }
    // </editor-fold>
    

    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="[   Mantención de Tipos de Días   ]">
    public static boolean validarIngresoTipoDia(TipoDia tipoDia) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (tipoDia.getName() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"nombre\" no puede ser nulo.");
                if (tipoDia.getDesc() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Descripción\" no puede ser nulo.");
                if (tipoDia.getCode() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Códio\" no puede ser nulo.");
                //if (tipoAusentismo.getAutor() == null) throw new BusinessRulesNotSatisfiedException("Debe identificar al autor del registro.");
                
                return true;
                
        } catch (BusinessRulesNotSatisfiedException ex) {
                throw new BusinessRulesNotSatisfiedException(ex);
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarIngresoTipoDia\".", ex);
        }
    
    }
    
    public static boolean validarEdicionTipoDia(TipoDia tipoDia) throws BusinessRulesNotSatisfiedException {
    
        try {
                if (tipoDia.getName() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"nombre\" no puede ser nulo.");
                if (tipoDia.getDesc() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Descripción\" no puede ser nulo.");
                if (tipoDia.getCode() == null) throw new BusinessRulesNotSatisfiedException("El atributo \"Códio\" no puede ser nulo.");
                
                return true;
                
        } catch (Exception ex) {
                throw new RuntimeException("Ha ocurrido un error inesperado ejecutando \"MantenedoresRules.validarEdicionTipoDia\".", ex);
        }
    
    }

    public static boolean validarEliminarTipoDia(TipoDia entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoJustificacion(TipoJustificacion entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoJustificacion(TipoJustificacion entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoAusentismo(TipoAusentismo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoAtraso(TipoAtraso entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoAtraso(TipoAtraso entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoSobretiempo(TipoSobretiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoSobretiempo(TipoSobretiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoUbicacionGeografica(UbicacionGeografica entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarUbicacionGeografica(UbicacionGeografica entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoHora(TipoHora entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoHora(TipoHora entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoEncargadoCentroTrabajo(EncargadoCentroTrabajo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarDesvincularEncargadoCentroTrabajo(EncargadoCentroTrabajo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoHorario(Horario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarHorario(Horario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarDiaFestivo(DiaFestivo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoDiaFestivo(DiaFestivo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoCalendario(Calendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarCalendario(Calendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoDefinicionCalendario(DefinicionCalendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarDefinicionCalendario(DefinicionCalendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoGrupoHorarioCentroTrabajo(GrupoHorarioCentroTrabajo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarGrupoHorarioCentroTrabajo(GrupoHorarioCentroTrabajo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    // </editor-fold>
    
}
