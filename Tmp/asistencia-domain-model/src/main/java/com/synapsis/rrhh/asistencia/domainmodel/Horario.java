
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;
import java.util.Set;

public abstract class Horario extends BaseDomainEntity {

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
        _CENTRO_TRABAJO_ID() {

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


    private String _trabajaFestivo;
    private Integer _toleranciaAtrasos;
    private Integer _toleranciaSobretiempos;
    private Date _beginDate;
    private Date _dueDate;
    private Persona _autor;
    private CentroTrabajo _centroTrabajo;
    private Set<DefinicionHorario> _definicion;
    

    public Date getBeginDate() {
        return _beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this._beginDate = beginDate;
    }

    public Date getDueDate() {
        return _dueDate;
    }

    public void setDueDate(Date dueDate) {
        this._dueDate = dueDate;
    }

    public Persona getAutor() {
        return _autor;
    }

    public void setAutor(Persona autor) {
        this._autor = autor;
    }

    public String getTrabajaFestivo() {
        return _trabajaFestivo;
    }

    public void setTrabajaFestivo(String trabajaFestivo) {
        this._trabajaFestivo = trabajaFestivo;
    }

    public Set<DefinicionHorario> getDefinicion() {
        return _definicion;
    }

    public void setDefinicion(Set<DefinicionHorario> definicion) {
        this._definicion = definicion;
    }

    public CentroTrabajo getCentroTrabajo() {
        return _centroTrabajo;
    }

    public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
        this._centroTrabajo = centroTrabajo;
    }

    public Integer getToleranciaAtrasos() {
        return _toleranciaAtrasos;
    }

    public void setToleranciaAtrasos(Integer toleranciaAtrasos) {
        this._toleranciaAtrasos = toleranciaAtrasos;
    }

    public Integer getToleranciaSobretiempos() {
        return _toleranciaSobretiempos;
    }

    public void setToleranciaSobretiempos(Integer toleranciaSobretiempos) {
        this._toleranciaSobretiempos = toleranciaSobretiempos;
    }
    
    
    public abstract DefinicionHorario[] getDefinicionOrdenadaPorCorrelativo();
    
}
