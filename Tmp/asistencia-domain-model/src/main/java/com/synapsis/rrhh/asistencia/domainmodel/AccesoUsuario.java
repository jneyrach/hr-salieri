
package com.synapsis.rrhh.asistencia.domainmodel;

import com.synapsis.rrhh.asistencia.domainmodel.Persona;

public abstract class AccesoUsuario extends BaseDomainEntity {

    public enum fields {
        
        _PERMISO_ID() {

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
                return "_code";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Code";
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
                return "_usuario._id";
            }
            
            @Override
            public String getParameterName() {
                return "_usuario__id";
            }
            
            @Override
            public String getAccessorName() {
                return "Usuario";
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

    
	private Persona _usuario;

	public Persona getUsuario() {
		return _usuario;
	}

	public void setUsuario(Persona usuario) {
		this._usuario = usuario;
	}
	
}
