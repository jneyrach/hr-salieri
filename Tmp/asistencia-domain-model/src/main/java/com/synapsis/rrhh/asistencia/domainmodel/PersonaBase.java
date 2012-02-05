
package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class PersonaBase extends BaseDomainEntity {

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
        _TARJETA() {

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
	private Integer _tarjeta;
	
	
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
	
	public Integer getTarjeta() {
		return _tarjeta;
	}
	
	public void setTarjeta(Integer tarjeta) {
		this._tarjeta = tarjeta;
	}	
	
}
