
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class TipoAjusteHojaTiempo extends BaseDomainEntity {

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
        };
        
        public abstract int getCode();

        public abstract int getOrdinal();

        public abstract String getName();

        public abstract String getParameterName();

        public abstract String getAccessorName();

        public abstract Class getClassType();
    };


    public static String ACCION_AUMENTA_TIEMPO_LABORAL = "+";
    public static String ACCION_DISMINUYE_TIEMPO_LABORAL = "-";
    public static String NOMBRE_ACCION_AUMENTA_TIEMPO_LABORAL = "Aumenta";
    public static String NOMBRE_ACCION_DISMINUYE_TIEMPO_LABORAL = "Disminuye";
    

    private String _modificacion;
    private Persona _autor;


    public String getModificacion() {
        return _modificacion;
    }

    public void setModificacion(String modificacion) {
        this._modificacion = modificacion;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }  

}
