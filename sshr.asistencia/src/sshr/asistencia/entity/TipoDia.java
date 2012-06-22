    package sshr.asistencia.entity;
  
    import sshr.datamodel.jpa.*;
    
    import java.util.*;
    import java.io.*;
    import javax.persistence.*;


    
    @Entity
    public final class TipoDia extends BaseDataEntity<sshr.domainmodel.asistencia.TipoDia> {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long _id;
        private String _codigo;
        private String _nombre;
        private String _descripcion;
        private Date _updatedOn;
        private Date _createdOn;
    
    
        
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
        
        public Date getUpdatedOn() {
            
            return this._updatedOn;
        }
        
        public Date getCreatedOn() {
            
            return this._createdOn;
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
        
        public void setUpdatedOn(Date newValue) {
            
            this._updatedOn = newValue;
        }
        
        public void setCreatedOn(Date newValue) {
            
            this._createdOn = newValue;
        }

        
        @Override
        public void autoPopulate(sshr.domainmodel.asistencia.TipoDia tdvo) {

            this._id = tdvo.getId();
            this._codigo = tdvo.getCodigo();
            this._nombre = tdvo.getNombre();
            this._descripcion = tdvo.getDescripcion();
            this._updatedOn = tdvo.getUpdatedOn();
            this._createdOn = tdvo.getCreatedOn();
        }

        @Override
        public sshr.domainmodel.asistencia.TipoDia reversePopulate(sshr.domainmodel.asistencia.TipoDia tdvo) {

            tdvo.setId(this._id);
            tdvo.setCodigo(this._codigo);
            tdvo.setNombre(this._nombre);
            tdvo.setDescripcion(this._descripcion);
            tdvo.setUpdatedOn(this._updatedOn);
            tdvo.setCreatedOn(this._createdOn);

            return tdvo;
        }
        
    }
