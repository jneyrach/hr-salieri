    package sshr.domainmodel.asistencia;
  
    import sshr.domainmodel.BaseEntity;
    import sshr.domainmodel.EntityAccessNotAllowedException;
    
    import java.util.*;
    import javax.xml.bind.annotation.*;


    
    @XmlRootElement
    public final class PerfilHorarioByPeriodoAsistencia extends BaseEntity<Long> {

        private Long _id;
        private PeriodoAsistencia _periodoDeAsistencia;
        private PerfilHorario _perfilDeHorario;
    
    
        @XmlTransient
        public enum FIELDS {
        
            ID() {
                public String getName() { return "_id"; }
            }
            ,PERIODO_DE_ASISTENCIA() {
                public String getName() { return "_periodoDeAsistencia"; }
            }
            ,PERFIL_DE_HORARIO() {
                public String getName() { return "_perfilDeHorario"; }
            }
            ;
        }
    
        private PerfilHorarioByPeriodoAsistencia() throws EntityAccessNotAllowedException {

            super();
        }
    
        
        public Long getId() {
            
            return this._id;
        }
        
        public PeriodoAsistencia getPeriodoDeAsistencia() {
            
            return this._periodoDeAsistencia;
        }
        
        public PerfilHorario getPerfilDeHorario() {
            
            return this._perfilDeHorario;
        }

        
        
        public void setId(Long newValue) {
            
            this._id = newValue;
        }
        
        public void setPeriodoDeAsistencia(PeriodoAsistencia newValue) {
            
            this._periodoDeAsistencia = newValue;
        }
        
        public void setPerfilDeHorario(PerfilHorario newValue) {
            
            this._perfilDeHorario = newValue;
        }
        
    }
