package com.synapsis.rrhh.asistencia.domainmodel;

import java.util.Date;

public class SolicitudJustificacion extends BaseDomainEntity {

	public static final String ESTADO_SOLICITUD_PENDIENTE = "P";
	public static final String ESTADO_SOLICITUD_RECHAZADA = "R";
	public static final String ESTADO_SOLICITUD_APROBADA  = "A";
	public static final String ESTADO_SOLICITUD_NULA      = "N";
	
	public static final String JSON_ESTADOS_PAPELETAS_JUSTIFICACIONES = "{ \"value\": {\"" + ESTADO_SOLICITUD_APROBADA + "\": \"Aprobada\", \"" + ESTADO_SOLICITUD_RECHAZADA + "\": \"Rechazada\", \"" + ESTADO_SOLICITUD_PENDIENTE + "\": \"Pendiente\", \"" + ESTADO_SOLICITUD_NULA + "\": \"Nula\"} }";

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
                return "_funcionario._id";
            }
            
            @Override
            public String getParameterName() {
                return "_funcionario__id";
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
        _TIPO_JUSTIFICACION_ID() {

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
                return "_tipoJustificacion._id";
            }
            
            @Override
            public String getParameterName() {
                return "_tipoJustificacion__id";
            }
            
            @Override
            public String getAccessorName() {
                return "TipoJustificacion";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _UNIDAD_ORG_ID_DE_PERSONA_SOLICITANTE() {

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
                return "_funcionario._unidadOrganizacional._id";
            }
            
            @Override
            public String getParameterName() {
                return "_funcionario__unidadOrganizacional__id";
            }
            
            @Override
            public String getAccessorName() {
                return "";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _FECHA_DESDE() {

            @Override
            public int getCode() {
                return 4;
            }
            
            @Override
            public int getOrdinal() {
                return 4;
            }
            
            @Override
            public String getName() {
                return "_fechaDesde";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "FechaDesde";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _FECHA_HASTA() {

            @Override
            public int getCode() {
                return 5;
            }
            
            @Override
            public int getOrdinal() {
                return 5;
            }
            
            @Override
            public String getName() {
                return "_fechaHasta";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "FechaHasta";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _STATUS() {

            @Override
            public int getCode() {
                return 6;
            }
            
            @Override
            public int getOrdinal() {
                return 6;
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
                return String.class;
            }
        };
        
        public abstract int getCode();

        public abstract int getOrdinal();

        public abstract String getName();

        public abstract String getParameterName();

        public abstract String getAccessorName();

        public abstract Class getClassType();
    };
    
    
    private Persona _funcionario;
    private TipoJustificacion _tipoJustificacion;
    private Date _fechaDesde;
    private Date _fechaHasta;
    private Integer _inicioHora;
    private Integer _inicioMinutos;
    private Integer _terminoHora;
    private Integer _terminoMinutos;
    private String _obs;

    
    public Persona getFuncionario() {
        return _funcionario;
    }

    public void setFuncionario(Persona funcionario) {
        this._funcionario = funcionario;
    }

    public TipoJustificacion getTipoJustificacion() {
        return _tipoJustificacion;
    }

    public void setTipoJustificacion(TipoJustificacion tipoJustificacion) {
        this._tipoJustificacion = tipoJustificacion;
    }

    public Date getFechaDesde() {
        return _fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this._fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return _fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this._fechaHasta = fechaHasta;
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

    public String getObs() {
        return _obs;
    }

    public void setObs(String obs) {
        this._obs = obs;
    }

}
