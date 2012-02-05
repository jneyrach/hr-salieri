
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class TipoJustificacion extends BaseDomainEntity {

	public static final byte COLUMNA_A4_COMISION = 0;
	public static final byte COLUMNA_A4_OTROS = 1;
	public static final byte COLUMNA_A4_PERMISOS = 2;	
	public static final byte COLUMNA_A4_FERIADOS = 3;
	public static final byte COLUMNA_A4_LICENCIAS_MEDICAS = 4;
	
	public static final String JSON_UBICACIONES_COLUMNAS_A4_CONTRALORIA = "{ \"value\": {"
		                                                                + "  \"" + COLUMNA_A4_COMISION          + "\": \"COMISIÓN\""
	                                                                    + ", \"" + COLUMNA_A4_OTROS             + "\": \"OTROS\""
	                                                                    + ", \"" + COLUMNA_A4_PERMISOS          + "\": \"PERMISOS\""
	                                                                    + ", \"" + COLUMNA_A4_FERIADOS          + "\": \"FERIADOS\""
	                                                                    + ", \"" + COLUMNA_A4_LICENCIAS_MEDICAS + "\": \"LICENCIAS MÉDICAS\""
	                                                                    + "} }";

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
        _ESTADO() {

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


    private String _esCompensable;
    private String _columnaAnexo4;
    private Persona _autor;
    

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }  
    
    public String getEsCompensable() {
        return _esCompensable;
    }

    public void setEsCompensable(String esCompensable) {
        this._esCompensable = esCompensable;
    }  

    public String getColumnaAnexo4() {
        return _columnaAnexo4;
    }

    public void setColumnaAnexo4(String columnaAnexo4) {
        this._columnaAnexo4 = columnaAnexo4;
    }  

}
