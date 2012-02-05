
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class UnidadOrganizacional extends BaseDomainEntity {
    
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
        _ENCARGADO_RUT() {

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
                return "_encargado._id";
            }
            
            @Override
            public String getParameterName() {
                return "_encargado__id";
            }
            
            @Override
            public String getAccessorName() {
                return "Encargado";
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


    private Comuna _comuna;
    private Persona _encargado;


    public Comuna getComuna() {
        return _comuna;
    }

    public void setComuna(Comuna comuna) {
        this._comuna = comuna;
    }

    public Persona getEncargado() {
        return _encargado;
    }

    public void setEncargado(Persona encargado) {
        this._encargado = encargado;
    }
    
}
