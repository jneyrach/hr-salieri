package sshr.domainmodel.asistencia;

import sshr.domainmodel.BaseEntity;
import sshr.domainmodel.EntityAccessNotAllowedException;

import java.util.*;
import javax.xml.bind.annotation.*;


@XmlRootElement
public final class Periodo extends BaseEntity<Long> {

	private String _nombre;
	private String _desc;
	private String _bitacora;
	
	private Date _fechaInicio;
	private Date _fechaTermino;


    @XmlTransient
	public enum FIELDS {

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
                return Long.class;
			}
		}
        ,_NOMBRE() {

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
                return "_nombre";
            }

            @Override
            public String getParameterName() {
                return getName();
            }

            @Override
            public String getAccessorName() {
                return "Nombre";
            }

            @Override
            public Class getClassType() {
                return String.class;
            }
		}
        ,_DESC() {

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
		}
        ,_FECHA_INICIO() {

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
                return "_fechaInicio";
            }

            @Override
            public String getParameterName() {
                return getName();
            }

            @Override
            public String getAccessorName() {
                return "FechaInicio";
            }

            @Override
            public Class getClassType() {
                return String.class;
            }
		}
        ,_FECHA_TERMINO() {

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
                return "_fechaTermino";
            }

            @Override
            public String getParameterName() {
                return getName();
            }

            @Override
            public String getAccessorName() {
                return "FechaTermino";
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


	private Periodo() throws EntityAccessNotAllowedException {

		super();
	}


	public String getDesc() {

		return this._desc;
	}

	public String getNombre() {

		return this._nombre;
	}
	
	public Date getFechaInicio() {
	
		return this._fechaInicio;
	}

	public Date getFechaTermino() {
	
		return this._fechaTermino;
	}

	public String getBitacora() {

		return this._bitacora;
	}

	
	public void setDesc(String desc) {

		this._desc = desc;
	}

	public void setNombre(String nombre) {

		this._nombre = nombre;
	}

	public void setFechaInicio(Date fechaInicio) {

		this._fechaInicio = fechaInicio;
	}
	
	public void setFechaTermino(Date fechaTermino) {

		this._fechaTermino = fechaTermino;
	}
	
	public void setBitacora(String bitacora) {

		this._bitacora = bitacora;
	}
	
}
