
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;

public abstract class DefinicionCalendario extends com.synapsis.rrhh.asistencia.domainmodel.BaseDomainEntity {

    public enum fields { 
        
        _FECHA_FERIADO() {

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
                return "_fechaFestivo";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "FechaFestivo";
            }
            
            @Override
            public Class getClassType() {
                return java.util.Date.class;
            }
        },
        _CALENDARIO_ID() {

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
                return "_calendario._id";
            }
            
            @Override
            public String getParameterName() {
                return "_calendario__id";
            }
            
            @Override
            public String getAccessorName() {
                return "Calendario.getId";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
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


    private Calendario _calendario;
    private Date _fechaFestivo;


    public Calendario getCalendario() {
        return _calendario;
    }

    public void setCalendario(Calendario calendario) {
        this._calendario = calendario;
    }

    public Date getFechaFestivo() {
        return _fechaFestivo;
    }

    public void setFechaFestivo(Date fechaFestivo) {
        this._fechaFestivo = fechaFestivo;
    }

}
