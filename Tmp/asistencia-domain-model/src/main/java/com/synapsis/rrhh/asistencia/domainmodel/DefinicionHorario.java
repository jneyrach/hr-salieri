
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;

public abstract class DefinicionHorario extends BaseDomainEntity {


    public enum fields { 

        _HORARIO_ID() {

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
                return "_horario._id";
            }
            
            @Override
            public String getParameterName() {
                return "_horario__id";
            }

            @Override
            public String getAccessorName() {
                return "Horario.getId";
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
    
    
    private TipoDia _tipoDia;
    private Horario _horario;
    private Integer _correlativo;
    private Persona _autor;
    private String _obs;
    private Date _fechaInicio;
    private Date _fechaTermino;
    private Integer _horaInicio;
    private Integer _minutosInicio;
    private Integer _horaColacion;
    private Integer _minutosColacion;
    private Integer _horaTermino;
    private Integer _minutosTermino;


    public TipoDia getTipoDia() {
        return _tipoDia;
    }

    public void setTipoDia(TipoDia tipoDia) {
        this._tipoDia = tipoDia;
    }

    public Horario getHorario() {
        return _horario;
    }

    public void setHorario(Horario horario) {
        this._horario = horario;
    }

    public Integer getCorrelativo() {
        return _correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this._correlativo = correlativo;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }

    public String getObs() {
        return _obs;
    }

    public void setObs(String obs) {
        this._obs = obs;
    }

    public Date getFechaInicio() {
        return _fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this._fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return _fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this._fechaTermino = fechaTermino;
    }

    public Integer getHoraInicio() {
        return _horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this._horaInicio = horaInicio;
    }

    public Integer getMinutosInicio() {
        return _minutosInicio;
    }

    public void setMinutosInicio(Integer minutosInicio) {
        this._minutosInicio = minutosInicio;
    }

    public Integer getHoraColacion() {
        return _horaColacion;
    }

    public void setHoraColacion(Integer horaColacion) {
        this._horaColacion = horaColacion;
    }

    public Integer getMinutosColacion() {
        return _minutosColacion;
    }

    public void setMinutosColacion(Integer minutosColacion) {
        this._minutosColacion = minutosColacion;
    }

    public Integer getHoraTermino() {
        return _horaTermino;
    }

    public void setHoraTermino(Integer horaTermino) {
        this._horaTermino = horaTermino;
    }

    public Integer getMinutosTermino() {
        return _minutosTermino;
    }

    public void setMinutosTermino(Integer minutosTermino) {
        this._minutosTermino = minutosTermino;
    }

}
