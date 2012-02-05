
package com.synapsis.rrhh.asistencia.domainmodel;

public class RelacionCentrotrabajoUnidad extends BaseDomainEntity {

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
        _CENTRO_DE_TRABAJO_ID() {

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
        },
        _UNIDAD_ORGANIZACIONAL_ID() {

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
                return "_unidadOrganizacional._id";
            }
            
            @Override
            public String getParameterName() {
                return "_unidadOrganizacional__id";
            }
            
            @Override
            public String getAccessorName() {
                return "UnidadOrganizacional";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _UNIDAD_ORGANIZACIONAL() {

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
                return "_unidadOrganizacional";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "UnidadOrganizacional";
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


    private CentroTrabajo _centroTrabajo;
    private UnidadOrganizacional _unidadOrganizacional;
    private Persona _autor;


    public CentroTrabajo getCentroTrabajo() {
        return _centroTrabajo;
    }

    public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
        this._centroTrabajo = centroTrabajo;
    }

    public UnidadOrganizacional getUnidadOrganizacional() {
        return _unidadOrganizacional;
    }

    public void setUnidadOrganizacional(UnidadOrganizacional unidadOrganizacional) {
        this._unidadOrganizacional = unidadOrganizacional;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }

}
