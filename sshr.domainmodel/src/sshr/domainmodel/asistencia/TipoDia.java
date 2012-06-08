    package sshr.domainmodel.asistencia;
  
    import sshr.domainmodel.BaseEntity;
    import sshr.domainmodel.EntityAccessNotAllowedException;
    
    import java.util.*;
    import javax.xml.bind.annotation.*;


    
    @XmlRootElement
    public final class TipoDia extends BaseEntity<Long> {

        private Long _id;
        private String _codigo;
        private String _nombre;
        private String _descripcion;
    
    
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
            ;
        }
    
        private TipoDia() throws EntityAccessNotAllowedException {

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
        
    }
