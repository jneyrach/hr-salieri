    package sshr.domainmodel.asistencia;
  
    import sshr.domainmodel.BaseEntity;
    import sshr.domainmodel.EntityAccessNotAllowedException;
    
    import java.util.*;
    import javax.xml.bind.annotation.*;


    
    @XmlRootElement
    public final class PeriodoAsistencia extends BaseEntity<Long> {

        private Long _id;
        private String _codigo;
        private String _nombre;
        private String _descripcion;
        private Date _fechaDeInicio;
        private Date _fechaDeTermino;
    
    
        @XmlTransient
        public enum FIELDS {
        
            ID() {
                public String getName() { return "_id"; }
            }
            ,CODIGO() {
                public String getName() { return "_codigo"; }
            }
            ,NOMBRE() {
                public String getName() { return "_nombre"; }
            }
            ,DESCRIPCION() {
                public String getName() { return "_descripcion"; }
            }
            ,FECHA_DE_INICIO() {
                public String getName() { return "_fechaDeInicio"; }
            }
            ,FECHA_DE_TERMINO() {
                public String getName() { return "_fechaDeTermino"; }
            }
            ;
        }
    
        private PeriodoAsistencia() throws EntityAccessNotAllowedException {

            super();
        }
    
        
        public Long getId() {
            
            return this._id;
        }
        
        public String getCodigo() {
            
            return this._codigo;
        }
        
        public String getNombre() {
            
            return this._nombre;
        }
        
        public String getDescripcion() {
            
            return this._descripcion;
        }
        
        public Date getFechaDeInicio() {
            
            return this._fechaDeInicio;
        }
        
        public Date getFechaDeTermino() {
            
            return this._fechaDeTermino;
        }

        
        
        public void setId(Long newValue) {
            
            this._id = newValue;
        }
        
        public void setCodigo(String newValue) {
            
            this._codigo = newValue;
        }
        
        public void setNombre(String newValue) {
            
            this._nombre = newValue;
        }
        
        public void setDescripcion(String newValue) {
            
            this._descripcion = newValue;
        }
        
        public void setFechaDeInicio(Date newValue) {
            
            this._fechaDeInicio = newValue;
        }
        
        public void setFechaDeTermino(Date newValue) {
            
            this._fechaDeTermino = newValue;
        }
        
    }
