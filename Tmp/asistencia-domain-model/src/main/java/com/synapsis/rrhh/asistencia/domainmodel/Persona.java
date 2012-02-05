
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class Persona extends BaseDomainEntity {

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
        _NUMERO_TARJETA() {

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
                return "_tarjeta";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Tarjeta";
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
        _CENTRO_DE_TRABAJO_ID() {

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
        _TIPO_DE_CONTRATO_ID() {

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
                return "_tipoContrato._id";
            }
            
            @Override
            public String getParameterName() {
                return "_tipoContrato__id";
            }

            @Override
            public String getAccessorName() {
                return "TipoContrato";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _APELLIDO_PATERNO() {

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
        _APELLIDO_MATERNO() {

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
        _NOMBRES() {

            @Override
            public int getCode() {
                return 7;
            }
            
            @Override
            public int getOrdinal() {
                return 7;
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
        _UNIDAD_ORGANIZACIONAL_NOMBRE() {

            @Override
            public int getCode() {
                return 8;
            }
            
            @Override
            public int getOrdinal() {
                return 8;
            }
            
            @Override
            public String getName() {
                return "_unidadOrganizacional._name";
            }
            
            @Override
            public String getParameterName() {
                return "_unidadOrganizacional__name";
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

    
    private String _sexo;
    private CentroTrabajo _centroTrabajo;
    private Integer _tarjeta;
	private String _indCena;
	private String _indOnce;
	private String _indAlmuerzo;
	private String _indDesayuno;
    private UnidadOrganizacional _unidadOrganizacional;
    private TipoContrato _tipoContrato;
    private String _telefonosContacto;
    private String _direccionesContacto;
    private String _dv;


    public CentroTrabajo getCentroTrabajo() {
        return _centroTrabajo;
    }

    public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
        this._centroTrabajo = centroTrabajo;
    }
    
    public String getSexo() {
        return _sexo;
    }

    public void setSexo(String sexo) {
        this._sexo = sexo;
    }

    public String getDv() {
        return _dv;
    }

    public void setDv(String dv) {
        this._dv = dv;
    }

    public Integer getTarjeta() {
        return _tarjeta;
    }

    public void setTarjeta(Integer tarjeta) {
        this._tarjeta = tarjeta;
    }

    public UnidadOrganizacional getUnidadOrganizacional() {
        return _unidadOrganizacional;
    }

    public void setUnidadOrganizacional(UnidadOrganizacional unidadOrganizacional) {
        this._unidadOrganizacional = unidadOrganizacional;
    }

    public TipoContrato getTipoContrato() {
        return _tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this._tipoContrato = tipoContrato;
    }

    public String getTelefonosContacto() {
        return _telefonosContacto;
    }

    public void setTelefonosContacto(String telefonosContacto) {
        this._telefonosContacto = telefonosContacto;
    }

    public String getDireccionesContacto() {
        return _direccionesContacto;
    }

    public void setDireccionesContacto(String direccionesContacto) {
        this._direccionesContacto = direccionesContacto;
    }

	public String getIndCena() {
		return _indCena;
	}
	
	public void setIndCena(String indCena) {
		this._indCena = indCena;
	}
	
	public String getIndOnce() {
		return _indOnce;
	}
	
	public void setIndOnce(String indOnce) {
		this._indOnce = indOnce;
	}
	
	public String getIndAlmuerzo() {
		return _indAlmuerzo;
	}
	
	public void setIndAlmuerzo(String indAlmuerzo) {
		this._indAlmuerzo = indAlmuerzo;
	}
	
	public String getIndDesayuno() {
		return _indDesayuno;
	}

	public void setIndDesayuno(String indDesayuno) {
		this._indDesayuno = indDesayuno;
	}

}
