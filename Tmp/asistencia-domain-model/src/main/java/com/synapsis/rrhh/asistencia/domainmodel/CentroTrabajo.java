
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.HashSet;
import java.util.Set;

public abstract class CentroTrabajo extends BaseDomainEntity {

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
        _NAME() {

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
                return "_name";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Name";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _STATUS() {

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
                return "_status";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Status";
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

    private Persona _autor;
    private UbicacionGeografica _ubicacionGeografica;
    private Set<EncargadoCentroTrabajo> _responsables = new HashSet<EncargadoCentroTrabajo>();
    
    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }  

    public UbicacionGeografica getUbicacionGeografica() {
        return _ubicacionGeografica;
    }

    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        this._ubicacionGeografica = ubicacionGeografica;
    }
    
    public Set<EncargadoCentroTrabajo> getResponsables() {
        return _responsables;
    }

    public void setResponsables(Set<EncargadoCentroTrabajo> responsables) {
        this._responsables = responsables;
    }

}
