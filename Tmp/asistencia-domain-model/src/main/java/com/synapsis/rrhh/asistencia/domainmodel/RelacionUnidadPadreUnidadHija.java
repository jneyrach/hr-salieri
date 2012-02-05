package com.synapsis.rrhh.asistencia.domainmodel;

public class RelacionUnidadPadreUnidadHija extends BaseDomainEntity {

    public enum fields { 
        
        _UNIDAD_PADRE_ID() {

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
                return "_unidadPadre._id";
            }
            
            @Override
            public String getParameterName() {
                return "_unidadPadre__id";
            }
            
            @Override
            public String getAccessorName() {
                return "UnidadPadre";
            }
            
            @Override
            public Class getClassType() {
                return Integer.class;
            }
        },
        _UNIDAD_HIJA_ID() {

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
                return "_unidadHija._id";
            }
            
            @Override
            public String getParameterName() {
                return "_unidadHija__id";
            }
            
            @Override
            public String getAccessorName() {
                return "UnidadHija";
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
	
		
	private UnidadOrganizacional _unidadHija;
	private UnidadOrganizacionalPadre _unidadPadre;
	
	
	public UnidadOrganizacional getUnidadHija() {
		return this._unidadHija;
	}
	
	public void setUnidadHija(UnidadOrganizacional unidadHija) {
		this._unidadHija = unidadHija;
	}
	
	public UnidadOrganizacionalPadre getUnidadPadre() {
		return this._unidadPadre;
	}
	
	public void setUnidadPadre(UnidadOrganizacionalPadre unidadPadre) {
		this._unidadPadre = unidadPadre;
	}
	
}
