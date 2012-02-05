
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class PersonaExterna extends BaseDomainEntity {

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
        _RUT() {

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
                return "_personaRUT";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "PersonaRUT";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _TIPO_RELACION_CONTRACTUAL() {

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
                return "_tipoRelacionContractual";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "TipoRelacionContractual";
            }
            
            @Override
            public Class getClassType() {
                return String.class;
            }
        },
        _CENTRO_TRABAJO_ID() {

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

    
    private String _indCena;
	private String _indOnce;
	private String _indAlmuerzo;
	private String _indDesayuno;
	private String _tipoRelacionContractual;
	private String _procedencia;
	private String _personaRUT;
	private String _nombreCompleto;
	private CentroTrabajo _centroTrabajo;
	private UnidadOrganizacional _unidadOrganizacional;
	
	
	public String getIndCena() {
		return this._indCena;
	}
	
	public void setIndCena(String indCena) {
		this._indCena = indCena;
	}
	
	public String getIndOnce() {
		return this._indOnce;
	}
	
	public void setIndOnce(String indOnce) {
		this._indOnce = indOnce;
	}
	
	public String getIndAlmuerzo() {
		return this._indAlmuerzo;
	}
	
	public void setIndAlmuerzo(String indAlmuerzo) {
		this._indAlmuerzo = indAlmuerzo;
	}
	
	public String getIndDesayuno() {
		return this._indDesayuno;
	}

	public void setIndDesayuno(String indDesayuno) {
		this._indDesayuno = indDesayuno;
	}
	
	public String getTipoRelacionContractual() {
		return this._tipoRelacionContractual;
	}
	
	public void setTipoRelacionContractual(String tipoRelacionContractual) {
		this._tipoRelacionContractual = tipoRelacionContractual;
	}
	
	public String getProcedencia() {
		return this._procedencia;
	}
	
	public void setProcedencia(String procedencia) {
		this._procedencia = procedencia;
	}

	public String getPersonaRUT() {
		return this._personaRUT;
	}
	
	public void setPersonaRUT(String personaRUT) {
		this._personaRUT = personaRUT;
	}

	public String getNombreCompleto() {
		return this._nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this._nombreCompleto = nombreCompleto;
	}

	public CentroTrabajo getCentroTrabajo() {
		return this._centroTrabajo;
	}
	
	public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
		this._centroTrabajo = centroTrabajo;
	}

	public UnidadOrganizacional getUnidadOrganizacional() {
		return this._unidadOrganizacional;
	}
	
	public void setUnidadOrganizacional(UnidadOrganizacional unidadOrganizacional) {
		this._unidadOrganizacional = unidadOrganizacional;
	}

}
