
package com.synapsis.rrhh.asistencia.service;

import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.exception.BusinessRulesNotSatisfiedException;

public abstract class AsistenciaConfiguracionRules {

    public static boolean validarIngresoCalendario(Calendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarCalendario(Calendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoHorario(Horario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarHorario(Horario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarTipoAjusteHojaTiempo(TipoAjusteHojaTiempo entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoDefinicionCalendario(DefinicionCalendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarDefinicionCalendario(DefinicionCalendario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoDefinicionHorario(DefinicionHorario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarDefinicionHorario(DefinicionHorario entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarIngresoRelacionCentrotrabajoUnidad(RelacionCentrotrabajoUnidad entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

    public static boolean validarEliminarRelacionCentrotrabajoUnidad(RelacionCentrotrabajoUnidad entity) throws BusinessRulesNotSatisfiedException {
        return true;
    }

}
