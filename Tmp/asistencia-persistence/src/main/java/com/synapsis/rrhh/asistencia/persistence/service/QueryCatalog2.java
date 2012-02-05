
package com.synapsis.rrhh.asistencia.persistence.service;

import com.synapsis.rrhh.asistencia.domainmodel.AccesoUsuario;
import com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity;
import com.synapsis.rrhh.asistencia.domainmodel.Calendario;
import com.synapsis.rrhh.asistencia.domainmodel.CentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario;
import com.synapsis.rrhh.asistencia.domainmodel.DefinicionHorario;
import com.synapsis.rrhh.asistencia.domainmodel.EncargadoCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.GrupoHorarioCentroTrabajo;
import com.synapsis.rrhh.asistencia.domainmodel.HojaTiempoHorarioTeorico;
import com.synapsis.rrhh.asistencia.domainmodel.Horario;
import com.synapsis.rrhh.asistencia.domainmodel.MiembroGrupoHorario;
import com.synapsis.rrhh.asistencia.domainmodel.Persona;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaBase;
import com.synapsis.rrhh.asistencia.domainmodel.PersonaExterna;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionCentrotrabajoUnidad;
import com.synapsis.rrhh.asistencia.domainmodel.RelacionUnidadPadreUnidadHija;
import com.synapsis.rrhh.asistencia.domainmodel.SolicitudJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAjusteHojaTiempo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoAusentismo;
import com.synapsis.rrhh.asistencia.domainmodel.TipoDia;
import com.synapsis.rrhh.asistencia.domainmodel.TipoHora;
import com.synapsis.rrhh.asistencia.domainmodel.TipoJustificacion;
import com.synapsis.rrhh.asistencia.domainmodel.TipoSobretiempo;
import com.synapsis.rrhh.asistencia.domainmodel.UbicacionGeografica;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional;
import com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacionalPadre;

public enum QueryCatalog2 {
    
    PERMISOS_DE_USUARIO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + AccesoUsuario.class.getSimpleName() + " o where o." + AccesoUsuario.fields._PERSONA_RUT.getName() + " = :" + AccesoUsuario.fields._PERSONA_RUT.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.AccesoUsuario.class);
            q.addParameter(new EntityQueryParameter(AccesoUsuario.fields._PERSONA_RUT.getCode(),
            		                                AccesoUsuario.fields._PERSONA_RUT.getOrdinal(),
                                                    AccesoUsuario.fields._PERSONA_RUT.getParameterName(),
                                                    AccesoUsuario.fields._PERSONA_RUT.getClassType() ));
            
            return q;
        }
    },
    SOLICITUD_JUSTIFICACION___DE_PERSONA__POR_FECHA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select   o "
                       + "   from     " + SolicitudJustificacion.class.getSimpleName() + " o "
                       + "  where   o." + SolicitudJustificacion.fields._PERSONA_RUT.getName() + " =  :" + SolicitudJustificacion.fields._PERSONA_RUT.getParameterName() + " "
                       + "    and ((o." + SolicitudJustificacion.fields._FECHA_DESDE.getName() 
                       + "               between :" + SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "1   "
                       + "                   and :" + SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "1 ) "
                       + "     or  (o." + SolicitudJustificacion.fields._FECHA_HASTA.getName() 
                       + "               between :" + SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "2   "
                       + "                   and :" + SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "2 ) "
                       
                       + "     or  ( :" + SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "3"
                       + "               between o." + SolicitudJustificacion.fields._FECHA_DESDE.getName() + "   "
                       + "                   and o." + SolicitudJustificacion.fields._FECHA_HASTA.getName() + ")  "
                       + "     or  ( :" + SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "3"
                       + "               between o." + SolicitudJustificacion.fields._FECHA_DESDE.getName() + "   "
                       + "                   and o." + SolicitudJustificacion.fields._FECHA_HASTA.getName() + ")) "
                       );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class);
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._PERSONA_RUT.getCode(),
                                                    SolicitudJustificacion.fields._PERSONA_RUT.getOrdinal(),
                                                    SolicitudJustificacion.fields._PERSONA_RUT.getParameterName(),
                                                    SolicitudJustificacion.fields._PERSONA_RUT.getClassType() ));
            
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_DESDE.getCode(),
                                                    2,
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "1",
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getClassType() ));     
            
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_DESDE.getCode(),
                                                    3,
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "2",
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getClassType() ));
            
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_DESDE.getCode(),
                                                    4,
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getParameterName() + "3",
                                                    SolicitudJustificacion.fields._FECHA_DESDE.getClassType() ));

            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_HASTA.getCode(),
                                                    5,
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "1",
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getClassType() ));
            
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_HASTA.getCode(),
                                                    6,
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "2",
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getClassType() ));            
            
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._FECHA_HASTA.getCode(),
                                                    7,
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + "3",
                                                    SolicitudJustificacion.fields._FECHA_HASTA.getClassType() ));            

            return q;
        }
    },
    SOLICITUD_JUSTIFICACION___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o "
                       + "   from   " + SolicitudJustificacion.class.getSimpleName() + " o "
                       + "  where o." + SolicitudJustificacion.fields._ID.getName() + " = :" + SolicitudJustificacion.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class);
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._ID.getCode(),
                                                    SolicitudJustificacion.fields._ID.getOrdinal(),
                                                    SolicitudJustificacion.fields._ID.getParameterName(),
                                                    SolicitudJustificacion.fields._ID.getClassType() ));            
            
            return q;
        }
    },
    SOLICITUD_JUSTIFICACION___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + SolicitudJustificacion.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class);
            
            return q;
        }
    },
    SOLICITUD_JUSTIFICACION___TODOS__PARA_UNIDAD_ORGANIZACIONAL() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(true);
            q.setQryText(" select o  "
            		   + "   from    " + SolicitudJustificacion.class.getSimpleName() + " o "
            		   + "  where  o." + SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getName()
            		   + "        = :" + SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getParameterName()
            		   );
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class);
            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getCode(),
            		                                SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getOrdinal(),
                                                    SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getParameterName(),
                                                    SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getClassType() ));            
            
            return q;
        }
    },
    SOLICITUD_JUSTIFICACION___TODOS__PARA_VARIAS_UNIDADES_ORGANIZACIONALES() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o  "
            		   + "   from    " + SolicitudJustificacion.class.getSimpleName() + " o "
            		   + "  where  o." + SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getName()
            		   + "     in  (:" + SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getParameterName() + ") "
            		   );
            /*
            q.setQryText(" select o "
                       + "   from   " + SolicitudJustificacion.class.getSimpleName() + " o "
                       + "  where o." + SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getName()
                       + "       in (select s." + UnidadOrganizacional.fields._ID.getName() 
                       + "             from   " + UnidadOrganizacional.class.getSimpleName() + " s  "
                       + "            where s." + UnidadOrganizacional.fields._ENCARGADO_RUT.getName() 
                       + "                =  :" + UnidadOrganizacional.fields._ENCARGADO_RUT.getParameterName() + " ) "
                       + " order by o." + SolicitudJustificacion.fields._STATUS.getParameterName() + " desc "
                       + "        , o." + SolicitudJustificacion.fields._FECHA_HASTA.getParameterName() + " desc ");
            */
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.SolicitudJustificacion.class);

            q.addParameter(new EntityQueryParameter(SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getCode(),
            										SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getOrdinal(),
            		                                SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getParameterName(),
            		                                SolicitudJustificacion.fields._UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE.getClassType() ));            

            return q;
        }
    },
    HOJA_TIEMPO_TEORICA___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + HojaTiempoHorarioTeorico.class.getSimpleName() + " o "
                       + "  where o." + HojaTiempoHorarioTeorico.fields._ID.getName() + " = :" + HojaTiempoHorarioTeorico.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico.class);
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._ID.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getClassType() ));            
            return q;
        }
    },
    HOJA_TIEMPO_TEORICA___POR_VARIOS_IDS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + HojaTiempoHorarioTeorico.class.getSimpleName() + " o "
                       + "  where o." + HojaTiempoHorarioTeorico.fields._ID.getName() + " in (:" + HojaTiempoHorarioTeorico.fields._ID.getParameterName() + ") ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico.class);
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._ID.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._ID.getClassType() ));            
            return q;
        }
    },
    HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_RANGO_DE_FECHA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + HojaTiempoHorarioTeorico.class.getSimpleName() + " o "
                       + "  where o." + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getName() + " = :" + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName() + " "
                       + "    and o." + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getName() 
                       + " between :" + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "1 "
                       + "     and :" + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "2 "
                       + " order by o._fechaCalendario "
                       );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico.class);
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getClassType() ));            
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "1",
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getClassType() ));            
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getOrdinal() + 1,
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "2",
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getClassType() ));            
            return q;
        }
    },
    HOJA_TIEMPO_TEORICA___DE_GRUPO_DE_PERSONAS_POR_RANGO_DE_FECHA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + HojaTiempoHorarioTeorico.class.getSimpleName() + " o "
                       + "  where o." + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getName() + " in (:" + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName() + ") "
                       + "    and o." + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getName() 
                       + " between :" + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "1 "
                       + "     and :" + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "2 "
                       + " order by o._fechaCalendario "
                       );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico.class);
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getClassType() ));            
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "1",
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getClassType() ));            
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getOrdinal() + 1,
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + "2",
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getClassType() ));            
            return q;
        }
    },
    HOJA_TIEMPO_TEORICA___DE_PERSONA_POR_FECHA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + HojaTiempoHorarioTeorico.class.getSimpleName() + " o "
                       + "  where o." + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getName() + " = :" + HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName() + " "
                       + "    and o." + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getName() + " = :" + HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.HojaTiempoHorarioTeorico.class);
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._PERSONA_RUT.getClassType() ));            
            q.addParameter(new EntityQueryParameter(HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getCode(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getOrdinal(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getParameterName(),
                                                    HojaTiempoHorarioTeorico.fields._FECHA_CALENDARIO.getClassType() ));            
            return q;
        }
    },
    RELACION_MIEMBROS___DE_GRUPO_HORARIO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + MiembroGrupoHorario.class.getSimpleName() + " o "
                       + "  where o." + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getName() + " = :" + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.MiembroGrupoHorario.class);
            q.addParameter(new EntityQueryParameter(MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getCode(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getOrdinal(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getClassType() ));            
            return q;
        }
    },
    MIEMBROS_DE_GRUPO_HORARIO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o." + MiembroGrupoHorario.fields._PERSONA.getName()
                       + "   from   " + MiembroGrupoHorario.class.getSimpleName() + " o "
                       + "  where o." + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getName() + " = :" + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getCode(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getOrdinal(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getClassType() ));            
            return q;
        }
    },
    MIEMBROS_DE_GRUPO_HORARIO_Y_UNIDAD_ORGANIZACIONAL() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o." + MiembroGrupoHorario.fields._PERSONA.getName()
                       + "   from   " + MiembroGrupoHorario.class.getSimpleName() + " o "
                       + "  where o." + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getName() + " = :" + MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName() + " "
                       + "    and o." + MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getName() + " in (:" + MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getParameterName() + ") "
                       );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getCode(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getOrdinal(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getParameterName(),
                                                    MiembroGrupoHorario.fields._GRUPO_HORARIO_ID.getClassType() ));            
            q.addParameter(new EntityQueryParameter(MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getCode(),
                    								MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getOrdinal(),
                    								MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getParameterName(),
                    								MiembroGrupoHorario.fields._PERSONA_UNIDAD_ORG_ID.getClassType() ));
            return q;
        }
    },
    GRUPO_HORARIO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + GrupoHorarioCentroTrabajo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.GrupoHorarioCentroTrabajo.class);
            
            return q;
        }
    },
    GRUPO_HORARIO___DE_CENTROS_DE_TRABAJO() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( " select  o "
            		    + "   from    " + GrupoHorarioCentroTrabajo.class.getSimpleName() + " o "
            		    + "  where  o." + GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getName() + " in (:"
            		    + GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName() 
            		    + ") ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.GrupoHorarioCentroTrabajo.class);
            q.addParameter(new EntityQueryParameter(GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getCode(),
                                                    GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getOrdinal(),
                                                    GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName(),
                                                    GrupoHorarioCentroTrabajo.fields._CENTRO_TRABAJO_ID.getClassType() ));
            
            return q;
        }
    },
    GRUPO_HORARIO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + GrupoHorarioCentroTrabajo.class.getSimpleName() + " o where o." + GrupoHorarioCentroTrabajo.fields._ID.getName() + " = :" + GrupoHorarioCentroTrabajo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.GrupoHorarioCentroTrabajo.class);
            q.addParameter(new EntityQueryParameter(GrupoHorarioCentroTrabajo.fields._ID.getCode(),
                                                    GrupoHorarioCentroTrabajo.fields._ID.getOrdinal(),
                                                    GrupoHorarioCentroTrabajo.fields._ID.getParameterName(),
                                                    GrupoHorarioCentroTrabajo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    RELACION_ENCARGADOS___DE_CENTRO_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + EncargadoCentroTrabajo.class.getSimpleName() + " o "
                       + "  where o." + EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getName() + " = :" + EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.EncargadoCentroTrabajo.class);
            q.addParameter(new EntityQueryParameter(EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getCode(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getOrdinal(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getClassType() ));            
            return q;
        }
    },
    ENCARGADOS___DE_CENTRO_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o." + EncargadoCentroTrabajo.fields._PERSONA.getName()
                       + "   from   " + EncargadoCentroTrabajo.class.getSimpleName() + " o "
                       + "  where o." + EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getName() + " = :" + EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getCode(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getOrdinal(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getParameterName(),
                                                    EncargadoCentroTrabajo.fields._CENTRO_TRABAJO_ID.getClassType() ));            
            return q;
        }
    },
    ENCARGADO_CENTRO_TRABAJO___POR_RUT() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + EncargadoCentroTrabajo.class.getSimpleName() + " o "
                       + "  where o." + EncargadoCentroTrabajo.fields._PERSONA_ID.getName() + " = :" + EncargadoCentroTrabajo.fields._PERSONA_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(EncargadoCentroTrabajo.fields._PERSONA_ID.getCode(),
                                                    EncargadoCentroTrabajo.fields._PERSONA_ID.getOrdinal(),
                                                    EncargadoCentroTrabajo.fields._PERSONA_ID.getParameterName(),
                                                    EncargadoCentroTrabajo.fields._PERSONA_ID.getClassType() ));            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacional.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacional.fields._ID.getName() 
                       + "        =:" + UnidadOrganizacional.fields._ID.getParameterName() );
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional.class);
            q.addParameter(new EntityQueryParameter(UnidadOrganizacional.fields._ID.getCode(),
                                                    UnidadOrganizacional.fields._ID.getOrdinal(),
                                                    UnidadOrganizacional.fields._ID.getParameterName(),
                                                    UnidadOrganizacional.fields._ID.getClassType() ));
            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL_PADRE___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacionalPadre.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacionalPadre.fields._ID.getName() 
                       + "        =:" + UnidadOrganizacionalPadre.fields._ID.getParameterName() );
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacionalPadre.class);
            q.addParameter(new EntityQueryParameter(UnidadOrganizacionalPadre.fields._ID.getCode(),
            										UnidadOrganizacionalPadre.fields._ID.getOrdinal(),
            										UnidadOrganizacionalPadre.fields._ID.getParameterName(),
            										UnidadOrganizacionalPadre.fields._ID.getClassType() ));
            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL_PADRE___POR_NOMBRE() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacionalPadre.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacionalPadre.fields._NAME.getName() 
                       + "   like  :" + UnidadOrganizacionalPadre.fields._NAME.getParameterName() + " and 1=1 " );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacionalPadre.class);
            q.addParameter(new EntityQueryParameter(UnidadOrganizacionalPadre.fields._NAME.getCode(),
            										UnidadOrganizacionalPadre.fields._NAME.getOrdinal(),
            										UnidadOrganizacionalPadre.fields._NAME.getParameterName(),
            										UnidadOrganizacionalPadre.fields._NAME.getClassType() ));
            
            return q;
        }
    },
    RELACION_UNIDADES_ORGANIZACIONALES___POR_PADRE_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select  o "
                       + "   from    " + RelacionUnidadPadreUnidadHija.class.getSimpleName() + " o "
                       + "  where  o." + RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getName() 
                       + "     in  (:" + RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getParameterName() + ") " );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionUnidadPadreUnidadHija.class);
            q.addParameter(new EntityQueryParameter(RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getCode(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getOrdinal(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getParameterName(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_PADRE_ID.getClassType() ));
            
            return q;
        }
    },
    RELACION_UNIDADES_ORGANIZACIONALES___POR_HIJA_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select  o "
                       + "   from    " + RelacionUnidadPadreUnidadHija.class.getSimpleName() + " o "
                       + "  where  o." + RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getName() 
                       + "     in  (:" + RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getParameterName() + ") " );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionUnidadPadreUnidadHija.class);
            q.addParameter(new EntityQueryParameter(RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getCode(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getOrdinal(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getParameterName(),
            										RelacionUnidadPadreUnidadHija.fields._UNIDAD_HIJA_ID.getClassType() ));
            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL___POR_ENCARGADO_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacional.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacional.fields._ENCARGADO_RUT.getName() 
                       + "        =:" + UnidadOrganizacional.fields._ENCARGADO_RUT.getParameterName() );
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional.class);
            q.addParameter(new EntityQueryParameter(UnidadOrganizacional.fields._ENCARGADO_RUT.getCode(),
                                                    UnidadOrganizacional.fields._ENCARGADO_RUT.getOrdinal(),
                                                    UnidadOrganizacional.fields._ENCARGADO_RUT.getParameterName(),
                                                    UnidadOrganizacional.fields._ENCARGADO_RUT.getClassType() ));
            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL___SIN_CENTRO_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacional.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacional.fields._ID.getName() 
                       + "   not in (select s." + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL.getName() 
                                                + "."
                                                + UnidadOrganizacional.fields._ID.getName()
                                     + " from " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " s) "
                       + "  order by o._name "); 
            
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional.class);
            
            return q;
        }
    },
    UNIDAD_ORGANIZACIONAL___SIN_CENTRO_DE_TRABAJO__Y__POR_UNIDAD_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o "
                       + "   from   " + UnidadOrganizacional.class.getSimpleName() + " o "
                       + "  where o." + UnidadOrganizacional.fields._ID.getName() 
                       + "   not in (select s." + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL.getName() 
                                                + "."
                                                + UnidadOrganizacional.fields._ID.getName()
                       + "             from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " s) "
                       + "    and o." + UnidadOrganizacional.fields._ID.getName() + " in (:" + UnidadOrganizacional.fields._ID.getParameterName() + ") "
                       + "  order by o._name "
                       ); 
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional.class);
            q.addParameter(new EntityQueryParameter(UnidadOrganizacional.fields._ID.getCode(),
            										UnidadOrganizacional.fields._ID.getOrdinal(),
            										UnidadOrganizacional.fields._ID.getParameterName(),
            										UnidadOrganizacional.fields._ID.getClassType() ));            
            
            return q;
        }
    },
    RELACION_UNIDAD_ORGANIZACIONAL___SINGLE___DE_UNIDAD_ORGANIZACIONAL() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o " 
                       + "   from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " o "
                       + "  where o." + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getName() + " = :" + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad.class);
            q.addParameter(new EntityQueryParameter(RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getCode(),
                                                    RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getOrdinal(),
                                                    RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName(),
                                                    RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getClassType() ));            
            return q;
        }
    },
    RELACION_UNIDADES_ORGANIZACIONALES___PARA_VARIOS_CENTROS_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o " 
                       + "   from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " o "
                       + "  where o." + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getName() + " in (:" + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName() + ") ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad.class);
            q.addParameter(new EntityQueryParameter(RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getCode(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getOrdinal(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getClassType() ));            
            return q;
        }
    },
    RELACION_UNIDAD_ORGANIZACIONAL___DE_CENTRO_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o " 
                       + "   from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " o "
                       + "  where o." + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getName() + " = :" + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad.class);
            q.addParameter(new EntityQueryParameter(RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getCode(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getOrdinal(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getClassType() ));            
            return q;
        }
    },
    RELACION_UNIDAD_ORGANIZACIONAL_Y_CENTRO_TRABAJO___DE_VARIAS_UNIDADES_ORGANIZACIONALES() {
            
            @Override
            public EntityQuery getQueryDefinition() {
                EntityQuery q = new EntityQuery();
                q.setQryText(" select o " 
                           + "   from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " o "
                           + "  where o." + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getName() + " in (:" + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName() + ") ");
                q.setSingleResult(false);
                q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.RelacionCentrotrabajoUnidad.class);
                q.addParameter(new EntityQueryParameter(RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getCode(),
                                                        RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getOrdinal(),
                                                        RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName(),
                                                        RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL_ID.getClassType() ));            
                return q;
            }
        },
    UNIDAD_ORGANIZACIONAL___DE_CENTRO_DE_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o." + RelacionCentrotrabajoUnidad.fields._UNIDAD_ORGANIZACIONAL.getName() 
                       + "   from   " + RelacionCentrotrabajoUnidad.class.getSimpleName() + " o "
                       + "  where o." + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getName() + " = :" + RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UnidadOrganizacional.class);
            q.addParameter(new EntityQueryParameter(RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getCode(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getOrdinal(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getParameterName(),
                                                    RelacionCentrotrabajoUnidad.fields._CENTRO_DE_TRABAJO_ID.getClassType() ));            
            return q;
        }
    },
    DEFINICION_HORARIO___DE_HORARIO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + DefinicionHorario.class.getSimpleName() + " o where o." + DefinicionHorario.fields._HORARIO_ID.getName() + " = :" + DefinicionHorario.fields._HORARIO_ID.getParameterName() + " ");
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionHorario.class);
            q.addParameter(new EntityQueryParameter(DefinicionHorario.fields._HORARIO_ID.getCode(),
                                                    DefinicionHorario.fields._HORARIO_ID.getOrdinal(),
                                                    DefinicionHorario.fields._HORARIO_ID.getParameterName(),
                                                    DefinicionHorario.fields._HORARIO_ID.getClassType() ));            
            
            return q;
        }
    },
    DEFINICION_HORARIO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + DefinicionHorario.class.getSimpleName() + " o where o." + DefinicionHorario.fields._ID.getName() + " = :" + DefinicionHorario.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionHorario.class);
            q.addParameter(new EntityQueryParameter(DefinicionHorario.fields._ID.getCode(),
                                                    DefinicionHorario.fields._ID.getOrdinal(),
                                                    DefinicionHorario.fields._ID.getParameterName(),
                                                    DefinicionHorario.fields._ID.getClassType() ));
            
            return q;
        }
    },
    DEFINICION_CALENDARIO___DE_CALENDARIO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + DefinicionCalendario.class.getSimpleName() + " o where o." + DefinicionCalendario.fields._CALENDARIO_ID.getName() + " = :" + DefinicionCalendario.fields._CALENDARIO_ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionCalendario.class);
            q.addParameter(new EntityQueryParameter(DefinicionCalendario.fields._CALENDARIO_ID.getCode(),
                                                    DefinicionCalendario.fields._CALENDARIO_ID.getOrdinal(),
                                                    DefinicionCalendario.fields._CALENDARIO_ID.getParameterName(),
                                                    DefinicionCalendario.fields._CALENDARIO_ID.getClassType() ));            
            return q;
        }
    },
    DEFINICION_CALENDARIO___POR_FECHA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + DefinicionCalendario.class.getSimpleName() + " o where o." + DefinicionCalendario.fields._FECHA_FERIADO.getName() + " = :" + DefinicionCalendario.fields._FECHA_FERIADO.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionCalendario.class);
            q.addParameter(new EntityQueryParameter(DefinicionCalendario.fields._FECHA_FERIADO.getCode(),
                                                    DefinicionCalendario.fields._FECHA_FERIADO.getOrdinal(),
                                                    DefinicionCalendario.fields._FECHA_FERIADO.getParameterName(),
                                                    DefinicionCalendario.fields._FECHA_FERIADO.getClassType() ));
            
            return q;
        }
    },
    DEFINICION_CALENDARIO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + DefinicionCalendario.class.getSimpleName() + " o where o." + DefinicionCalendario.fields._ID.getName() + " = :" + DefinicionCalendario.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.DefinicionCalendario.class);
            q.addParameter(new EntityQueryParameter(DefinicionCalendario.fields._ID.getCode(),
                                                    DefinicionCalendario.fields._ID.getOrdinal(),
                                                    DefinicionCalendario.fields._ID.getParameterName(),
                                                    DefinicionCalendario.fields._ID.getClassType() ));
            
            return q;
        }
    },
    AJUSTE_HOJA_TIEMPO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoAjusteHojaTiempo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo.class);
            
            return q;
        }
    },
    AJUSTE_HOJA_TIEMPO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoAjusteHojaTiempo.class.getSimpleName() + " o where o." + TipoAjusteHojaTiempo.fields._ID.getName() + " = :" + TipoAjusteHojaTiempo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo.class);
            q.addParameter(new EntityQueryParameter(TipoAjusteHojaTiempo.fields._ID.getCode(),
                                                    TipoAjusteHojaTiempo.fields._ID.getOrdinal(),
                                                    TipoAjusteHojaTiempo.fields._ID.getParameterName(),
                                                    TipoAjusteHojaTiempo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    CALENDARIO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + Calendario.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Calendario.class);
            
            return q;
        }
    },
    CALENDARIO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + Calendario.class.getSimpleName() + " o where o." + Calendario.fields._ID.getName() + " = :" + Calendario.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Calendario.class);
            q.addParameter(new EntityQueryParameter(Calendario.fields._ID.getCode(),
                                                    Calendario.fields._ID.getOrdinal(),
                                                    Calendario.fields._ID.getParameterName(),
                                                    Calendario.fields._ID.getClassType() ));
            
            return q;
        }
    },
    HORARIO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + Horario.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Horario.class);
            
            return q;
        }
    },
    HORARIO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + Horario.class.getSimpleName() + " o where o." + Horario.fields._ID.getName() + " = :" + Horario.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Horario.class);
            q.addParameter(new EntityQueryParameter(Horario.fields._ID.getCode(),
                                                    Horario.fields._ID.getOrdinal(),
                                                    Horario.fields._ID.getParameterName(),
                                                    Horario.fields._ID.getClassType() ));
            
            return q;
        }
    },
    HORARIO___DE_CENTRO_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText( "   select o "
                        + "     from   " + Horario.class.getSimpleName() + " o "
                        + "    where o." + Horario.fields._CENTRO_TRABAJO_ID.getName() + " = :" + Horario.fields._CENTRO_TRABAJO_ID.getParameterName() 
                        + " order by o." + Horario.fields._CENTRO_TRABAJO_ID.getName());
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Horario.class);
            q.addParameter(new EntityQueryParameter(Horario.fields._CENTRO_TRABAJO_ID.getCode(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getOrdinal(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getParameterName(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getClassType() ));
            
            return q;
        }
    },
    HORARIO___DE_VARIOS_CENTROS_TRABAJO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText( "   select o "
                        + "     from   " + Horario.class.getSimpleName() + " o "
                        + "    where o." + Horario.fields._CENTRO_TRABAJO_ID.getName() + " in (:" + Horario.fields._CENTRO_TRABAJO_ID.getParameterName() + ") " 
                        + " order by o." + Horario.fields._CENTRO_TRABAJO_ID.getName());
            q.setSingleResult(false);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Horario.class);
            q.addParameter(new EntityQueryParameter(Horario.fields._CENTRO_TRABAJO_ID.getCode(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getOrdinal(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getParameterName(),
                                                    Horario.fields._CENTRO_TRABAJO_ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_AJUSTE_HOJA_TIEMPO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoAjusteHojaTiempo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo.class);
            
            return q;
        }
    },
    TIPO_AJUSTE_HOJA_TIEMPO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoAjusteHojaTiempo.class.getSimpleName() + " o where o." + TipoAjusteHojaTiempo.fields._ID.getName() + " = :" + TipoAjusteHojaTiempo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAjusteHojaTiempo.class);
            q.addParameter(new EntityQueryParameter(TipoAjusteHojaTiempo.fields._ID.getCode(),
                                                    TipoAjusteHojaTiempo.fields._ID.getOrdinal(),
                                                    TipoAjusteHojaTiempo.fields._ID.getParameterName(),
                                                    TipoAjusteHojaTiempo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_HORA___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoHora.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoHora.class);
            
            return q;
        }
    },
    TIPO_HORA___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoHora.class.getSimpleName() + " o where o." + TipoHora.fields._ID.getName() + " = :" + TipoHora.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoHora.class);
            q.addParameter(new EntityQueryParameter(TipoHora.fields._ID.getCode(),
                                                    TipoHora.fields._ID.getOrdinal(),
                                                    TipoHora.fields._ID.getParameterName(),
                                                    TipoHora.fields._ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_DIA___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoDia.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia.class);
            
            return q;
        }
    },
    TIPO_DIA___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoDia.class.getSimpleName() + " o where o." + TipoDia.fields._ID.getName() + " = :" + TipoDia.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia.class);
            q.addParameter(new EntityQueryParameter(TipoDia.fields._ID.getCode(),
                                                    TipoDia.fields._ID.getOrdinal(),
                                                    TipoDia.fields._ID.getParameterName(),
                                                    TipoDia.fields._ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_DIA___POR_NOMBRE() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoDia.class.getSimpleName() + " o where o." + TipoDia.fields._NAME.getName() + " = :" + TipoDia.fields._NAME.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoDia.class);
            q.addParameter(new EntityQueryParameter(TipoDia.fields._NAME.getCode(),
                                                    TipoDia.fields._NAME.getOrdinal(),
                                                    TipoDia.fields._NAME.getParameterName(),
                                                    TipoDia.fields._NAME.getClassType() ));
            
            return q;
        }
    },
    TIPO_AUSENTISMO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoAusentismo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAusentismo.class);
            
            return q;
        }
    },
    TIPO_AUSENTISMO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoAusentismo.class.getSimpleName() + " o where o." + TipoAusentismo.fields._ID.getName() + " = :" + TipoAusentismo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoAusentismo.class);
            q.addParameter(new EntityQueryParameter(TipoAusentismo.fields._ID.getCode(),
                                                    TipoAusentismo.fields._ID.getOrdinal(),
                                                    TipoAusentismo.fields._ID.getParameterName(),
                                                    TipoAusentismo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_JUSTIFICACION___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoJustificacion.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoJustificacion.class);
            
            return q;
        }
    },
    TIPO_JUSTIFICACION___TODOS_ACTIVO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( " select  o " 
            		    + "   from    " + TipoJustificacion.class.getSimpleName() + " o "
            		    + "  where  o." + TipoJustificacion.fields._NAME.getParameterName() 
            		    + "         ='" + BaseDomainEntity.CODIGO_ESTADO_GENERICO_ACTIVO + "' "
            		    );
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoJustificacion.class);
            
            return q;
        }
    },
    TIPO_JUSTIFICACION___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoJustificacion.class.getSimpleName() + " o where o." + TipoJustificacion.fields._ID.getName() + " = :" + TipoJustificacion.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoJustificacion.class);
            q.addParameter(new EntityQueryParameter(TipoJustificacion.fields._ID.getCode(),
                                                    TipoJustificacion.fields._ID.getOrdinal(),
                                                    TipoJustificacion.fields._ID.getParameterName(),
                                                    TipoJustificacion.fields._ID.getClassType() ));
            
            return q;
        }
    },
    TIPO_SOBRETIEMPO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + TipoSobretiempo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoSobretiempo.class);
            
            return q;
        }
    },
    TIPO_SOBRETIEMPO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + TipoSobretiempo.class.getSimpleName() + " o where o." + TipoSobretiempo.fields._ID.getName() + " = :" + TipoSobretiempo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.TipoSobretiempo.class);
            q.addParameter(new EntityQueryParameter(TipoSobretiempo.fields._ID.getCode(),
                                                    TipoSobretiempo.fields._ID.getOrdinal(),
                                                    TipoSobretiempo.fields._ID.getParameterName(),
                                                    TipoSobretiempo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    CENTRO_DE_TRABAJO___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + CentroTrabajo.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.CentroTrabajo.class);
            
            return q;
        }
    },
    CENTRO_DE_TRABAJO___TODOS_ACTIVO() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( " select  o "
            		    + "   from    " + CentroTrabajo.class.getSimpleName() + " o "
            		    + "  where  o." + CentroTrabajo.fields._STATUS.getName() + " = :" + CentroTrabajo.fields._STATUS.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.CentroTrabajo.class);
            q.addParameter(new EntityQueryParameter(CentroTrabajo.fields._STATUS.getCode(),
                    								CentroTrabajo.fields._STATUS.getOrdinal(),
                    								CentroTrabajo.fields._STATUS.getParameterName(),
                    								CentroTrabajo.fields._STATUS.getClassType() ));
            
            return q;
        }
    },
    CENTRO_DE_TRABAJO___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + CentroTrabajo.class.getSimpleName() + " o where o." + CentroTrabajo.fields._ID.getName() + " = :" + CentroTrabajo.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.CentroTrabajo.class);
            q.addParameter(new EntityQueryParameter(CentroTrabajo.fields._ID.getCode(),
                                                    CentroTrabajo.fields._ID.getOrdinal(),
                                                    CentroTrabajo.fields._ID.getParameterName(),
                                                    CentroTrabajo.fields._ID.getClassType() ));
            
            return q;
        }
    },
    UBICACION_GEOGRAFICA___TODOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o from " + UbicacionGeografica.class.getSimpleName() + " o ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UbicacionGeografica.class);
            
            return q;
        }
    },
    UBICACION_GEOGRAFICA___TODOS_ACTIVOS() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( "    select o "
            		    + "      from   " + UbicacionGeografica.class.getSimpleName() + " o "
            		    + "     where o." + UbicacionGeografica.fields._STATUS.getName() + " = :" + UbicacionGeografica.fields._STATUS.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UbicacionGeografica.class);
            q.addParameter(new EntityQueryParameter(UbicacionGeografica.fields._STATUS.getCode(),
            										UbicacionGeografica.fields._STATUS.getOrdinal(),
            										UbicacionGeografica.fields._STATUS.getParameterName(),
            										UbicacionGeografica.fields._STATUS.getClassType() ));            
            
            return q;
        }
    },
    UBICACION_GEOGRAFICA___POR_ID() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setQryText(" select o from " + UbicacionGeografica.class.getSimpleName() + " o where o." + UbicacionGeografica.fields._ID.getName() + " = :" + UbicacionGeografica.fields._ID.getParameterName() + " ");
            q.setSingleResult(true);
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.UbicacionGeografica.class);
            q.addParameter(new EntityQueryParameter(UbicacionGeografica.fields._ID.getCode(),
                                                    UbicacionGeografica.fields._ID.getOrdinal(),
                                                    UbicacionGeografica.fields._ID.getParameterName(),
                                                    UbicacionGeografica.fields._ID.getClassType() ));
            
            return q;
        }
    },
    PERSONA___POR_RUT() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(true);
            q.setQryText(" select o from " + Persona.class.getSimpleName() + " o where o." + Persona.fields._ID.getName() + " = :" + Persona.fields._ID.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(Persona.fields._ID.getCode(),
                                                    Persona.fields._ID.getOrdinal(),
                                                    Persona.fields._ID.getParameterName(),
                                                    Persona.fields._ID.getClassType() ));            
            
            return q;
        }
    },
    PERSONA_EXTERNA___TODOS() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( "   select o "
            		    + "     from   " + PersonaExterna.class.getSimpleName() + " o "
            		    + " order by o." + PersonaExterna.fields._TIPO_RELACION_CONTRACTUAL.getName() + " "
            		    );
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.PersonaExterna.class);
            
            return q;
        }
    },
    PERSONA_EXTERNA___TODOS_DE_CENTRO_TRABAJO() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText( "   select o "
            		    + "     from   " + PersonaExterna.class.getSimpleName() + " o "
            		    + "    where o." + PersonaExterna.fields._CENTRO_TRABAJO_ID.getName() + " = :" + PersonaExterna.fields._CENTRO_TRABAJO_ID.getParameterName()
            		    + " order by o." + PersonaExterna.fields._TIPO_RELACION_CONTRACTUAL.getName() + " "
            		    );
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.PersonaExterna.class);
            q.addParameter(new EntityQueryParameter(PersonaExterna.fields._CENTRO_TRABAJO_ID.getCode(),
            										PersonaExterna.fields._CENTRO_TRABAJO_ID.getOrdinal(),
            										PersonaExterna.fields._CENTRO_TRABAJO_ID.getParameterName(),
            										PersonaExterna.fields._CENTRO_TRABAJO_ID.getClassType() ));            
            
            return q;
        }
    },
    PERSONA_EXTERNA___POR_ID() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(true);
            q.setQryText(" select o from " + PersonaExterna.class.getSimpleName() + " o where o." + PersonaExterna.fields._ID.getName() + " = :" + PersonaExterna.fields._ID.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.PersonaExterna.class);
            q.addParameter(new EntityQueryParameter(PersonaExterna.fields._ID.getCode(),
            										PersonaExterna.fields._ID.getOrdinal(),
            										PersonaExterna.fields._ID.getParameterName(),
            										PersonaExterna.fields._ID.getClassType() ));            
            
            return q;
        }
    },
    PERSONA_BASE___POR_RUT() {

        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(true);
            q.setQryText(" select o from " + PersonaBase.class.getSimpleName() + " o where o." + PersonaBase.fields._ID.getName() + " = :" + PersonaBase.fields._ID.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.PersonaBase.class);
            q.addParameter(new EntityQueryParameter(PersonaBase.fields._ID.getCode(),
            										PersonaBase.fields._ID.getOrdinal(),
                                                    PersonaBase.fields._ID.getParameterName(),
                                                    PersonaBase.fields._ID.getClassType() ));            
            
            return q;
        }
    },
    PERSONA___POR_NUMERO_DE_TARJETA() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(true);
            q.setQryText(" select o from " + Persona.class.getSimpleName() + " o where o." + Persona.fields._NUMERO_TARJETA.getName() + " = :" + Persona.fields._NUMERO_TARJETA.getParameterName() + " ");
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(Persona.fields._NUMERO_TARJETA.getCode(),
                                                    Persona.fields._NUMERO_TARJETA.getOrdinal(),
                                                    Persona.fields._NUMERO_TARJETA.getParameterName(),
                                                    Persona.fields._NUMERO_TARJETA.getClassType() ));
            
            return q;
        }
    },
    PERSONA___POR_FILTRO_ESTANDAR() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o "
                       + "   from   " + Persona.class.getSimpleName() + " o "
                       + "  where o." + Persona.fields._APELLIDO_PATERNO.getName()             + " like :" + Persona.fields._APELLIDO_PATERNO.getParameterName() + " "
                       );
            
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(Persona.fields._APELLIDO_PATERNO.getCode(),
                                                    Persona.fields._APELLIDO_PATERNO.getOrdinal(),
                                                    Persona.fields._APELLIDO_PATERNO.getParameterName(),
                                                    Persona.fields._APELLIDO_PATERNO.getClassType() ));
            
            return q;
        }
    },
    PERSONAS___POR_UNIDADES_ORGANIZACIONALES__Y__FILTRO_ESTANDAR() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o "
                       + "   from   " + Persona.class.getSimpleName() + " o "
                       + "  where o." + Persona.fields._APELLIDO_PATERNO.getName()         + " like  :" + Persona.fields._APELLIDO_PATERNO.getParameterName() + " "
                       + "    and o." + Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getName() + " IN   (:" + Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName() + ") ");
            
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(Persona.fields._APELLIDO_PATERNO.getCode(),
                                                    Persona.fields._APELLIDO_PATERNO.getOrdinal(),
                                                    Persona.fields._APELLIDO_PATERNO.getParameterName(),
                                                    Persona.fields._APELLIDO_PATERNO.getClassType() ));
            q.addParameter(new EntityQueryParameter(Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getCode(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getOrdinal(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getClassType() ));
            
            return q;
        }
    },
    PERSONAS___POR_UNIDADES_ORGANIZACIONALES() {
        
        @Override
        public EntityQuery getQueryDefinition() {
            EntityQuery q = new EntityQuery();
            q.setSingleResult(false);
            q.setQryText(" select o "
                       + "   from   " + Persona.class.getSimpleName() + " o "
                       + "  where o." + Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getName() + " IN (:" + Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName() + ") ");
            
            q.setEntity(com.synapsis.rrhh.asistencia.persistence.pojo.Persona.class);
            q.addParameter(new EntityQueryParameter(Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getCode(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getOrdinal(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getParameterName(),
                                                    Persona.fields._UNIDAD_ORGANIZACIONAL_ID.getClassType() ));
            
            return q;
        }
    };

    public abstract EntityQuery getQueryDefinition();

    
    public static final String SP_ACTUALIZAR_DATOS_PARTES = "{ call PR_ASI_ACTUALIZA_DATOS_PARTES(?, ?) }";
    
}
