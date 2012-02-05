
package com.synapsis.rrhh.asistencia.domainmodel;

public class MiembroGrupoHorario extends BaseDomainEntity {

    public enum fields {
        
        _ID() {

            @Override
            public int getCode() {
                return 0;
            }
            
            @Override
            public int getOrdinal() {
                return 0;
            }
            
            @Override
            public String getName() {
                return "_id";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Id";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _GRUPO_HORARIO_ID() {

            @Override
            public int getCode() {
                return 1;
            }
            
            @Override
            public int getOrdinal() {
                return 1;
            }
            
            @Override
            public String getName() {
                return "_grupoHorario._id";
            }
            
            @Override
            public String getParameterName() {
                return "_grupoHorario__id";
            }
            
            @Override
            public String getAccessorName() {
                return "GrupoHorario";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _PERSONA_RUT() {

            @Override
            public int getCode() {
                return 2;
            }
            
            @Override
            public int getOrdinal() {
                return 2;
            }
            
            @Override
            public String getName() {
                return "_persona._id";
            }
            
            @Override
            public String getParameterName() {
                return "_persona__id";
            }
            
            @Override
            public String getAccessorName() {
                return "Persona";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _PERSONA() {

            @Override
            public int getCode() {
                return 3;
            }
            
            @Override
            public int getOrdinal() {
                return 3;
            }
            
            @Override
            public String getName() {
                return "_persona";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Persona";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _PERSONA_UNIDAD_ORG_ID() {

            @Override
            public int getCode() {
                return 4;
            }
            
            @Override
            public int getOrdinal() {
                return 4;
            }
            
            @Override
            public String getName() {
                return "_persona._unidadOrganizacional._id";
            }
            
            @Override
            public String getParameterName() {
                return "_persona__unidadOrganizacional__id";
            }
            
            @Override
            public String getAccessorName() {
                return "Persona";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        };
        
        public abstract int getCode();

        public abstract int getOrdinal();

        public abstract String getName();

        public abstract String getParameterName();

        public abstract String getAccessorName();

        public abstract Class getClassType();
    };
    
    
    private GrupoHorarioCentroTrabajo _grupoHorario;
    private Persona _persona;
    private Persona _autor;

    
    public GrupoHorarioCentroTrabajo getGrupoHorario() {
        return _grupoHorario;
    }

    public void setGrupoHorario(GrupoHorarioCentroTrabajo grupoHorario) {
        this._grupoHorario = grupoHorario;
    }

    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona persona) {
        this._persona = persona;
    }
    
    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }  

}
