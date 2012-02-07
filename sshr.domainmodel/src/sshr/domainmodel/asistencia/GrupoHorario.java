package sshr.domainmodel.asistencia;

import sshr.domainmodel.BaseEntity;
import sshr.domainmodel.EntityAccessNotAllowedException;


public final class GrupoHorario extends BaseEntity<Long> {

	private String _codigo;
	private String _desc;
	
	
	public enum FIELDS {
	
        _ID() {

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
                return Long.class;
			}
		}
        ,_CODIGO() {

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
                return "_codigo";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Codigo";
            }
            
            @Override
            public Class getClassType() {
                return String.class;
            }
		}
        ,_DESC() {

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
                return "_desc";
            }
            
            @Override
            public String getParameterName() {
                return getName();
            }
            
            @Override
            public String getAccessorName() {
                return "Desc";
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
	}
	
	
	private GrupoHorario() throws EntityAccessNotAllowedException {
	
		super();
	}


	public String getDesc() {
	
		return this._desc;
	}
	
	public String getCodigo() {
	
		return this._codigo;
	}
	
	public void setDesc(String desc) {
	
		this._desc = desc;
	}
	
	public void setCodigo(String codigo) {
	
		this._codigo = codigo;
	}

}
