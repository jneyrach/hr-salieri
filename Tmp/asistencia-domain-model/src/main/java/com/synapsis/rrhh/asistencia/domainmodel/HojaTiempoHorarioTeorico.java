
package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class HojaTiempoHorarioTeorico extends BaseDomainEntity {

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
        _PERSONA_RUT() {

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
        _FECHA_CALENDARIO() {

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
                return "_fechaCalendario";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "FechaCalendario";
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
    private Date _fechaCalendario;
    private Horario _horario;
    private TipoDia _tipoDia;
    private Integer _correlativo;
    private Integer _inicioHora;
    private Integer _inicioMinutos;
    private Integer _terminoHora;
    private Integer _terminoMinutos;
    private Integer _colacionHoras;
    private Integer _colacionMinutos;
    private String _prefijoDia;
    private Persona _autor;
    private HojaTiempoHorarioReal _marcas;
    private Set<AjusteHorarioTeorico> _ajustes = new HashSet<AjusteHorarioTeorico>();
    

    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona persona) {
        this._persona = persona;
    }

    public Date getFechaCalendario() {
        return _fechaCalendario;
    }

    public void setFechaCalendario(Date fechaCalendario) {
        this._fechaCalendario = fechaCalendario;
    }

    public Horario getHorario() {
        return _horario;
    }

    public void setHorario(Horario horario) {
        this._horario = horario;
    }

    public TipoDia getTipoDia() {
        return _tipoDia;
    }

    public void setTipoDia(TipoDia tipoDia) {
        this._tipoDia = tipoDia;
    }

    public Integer getCorrelativo() {
        return _correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this._correlativo = correlativo;
    }

    public Integer getInicioHora() {
        return _inicioHora;
    }

    public void setInicioHora(Integer inicioHora) {
        this._inicioHora = inicioHora;
    }

    public Integer getInicioMinutos() {
        return _inicioMinutos;
    }

    public void setInicioMinutos(Integer inicioMinutos) {
        this._inicioMinutos = inicioMinutos;
    }

    public Integer getTerminoHora() {
        return _terminoHora;
    }

    public void setTerminoHora(Integer terminoHora) {
        this._terminoHora = terminoHora;
    }

    public Integer getTerminoMinutos() {
        return _terminoMinutos;
    }

    public void setTerminoMinutos(Integer terminoMinutos) {
        this._terminoMinutos = terminoMinutos;
    }

    public Integer getColacionHoras() {
        return _colacionHoras;
    }

    public void setColacionHoras(Integer colacionHoras) {
        this._colacionHoras = colacionHoras;
    }

    public Integer getColacionMinutos() {
        return _colacionMinutos;
    }

    public void setColacionMinutos(Integer colacionMinutos) {
        this._colacionMinutos = colacionMinutos;
    }

    public Set<AjusteHorarioTeorico> getAjustes() {
        return _ajustes;
    }

    public void setAjustes(Set<AjusteHorarioTeorico> ajustes) {
        this._ajustes = ajustes;
    }

    public HojaTiempoHorarioReal getMarcas() {
        return _marcas;
    }

    public void setMarcas(HojaTiempoHorarioReal marcas) {
        this._marcas = marcas;
    }

	public String getPrefijoDia() {
		return _prefijoDia;
	}

	public void setPrefijoDia(String prefijoDia) {
		this._prefijoDia = prefijoDia;
	}

	public Persona getAutor() {
		return _autor;
	}

	public void setAutor(Persona autor) {
		this._autor = autor;
	}
	
}
