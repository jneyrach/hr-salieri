
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class EncargadoCentroTrabajo extends BaseDomainEntity {

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
        _PERSONA() {

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
        _PERSONA_ID() {

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
        _CENTRO_TRABAJO() {

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
                return "_centroTrabajo";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "CentroTrabajo";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _CENTRO_TRABAJO_ID() {

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
                return "_centroTrabajo._id";
            }
            
            @Override
            public String getParameterName() {
                return "_centroTrabajo__id";
            }
            
            @Override
            public String getAccessorName() {
                return "CentroTrabajo";
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
    
    
    private Persona _persona;
    private Persona _autor;
    private CentroTrabajo _centroTrabajo;

    
    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona persona) {
        this._persona = persona;
    }
    
    public CentroTrabajo getCentroTrabajo() {
        return _centroTrabajo;
    }

    public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
        this._centroTrabajo = centroTrabajo;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }
    
}
