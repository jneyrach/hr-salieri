
package com.synapsis.rrhh.asistencia.persistence.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

@Entity
@Table(name = "airh_ast_def_cal")
public class DefinicionCalendario extends com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario {

    @Id
    @TableGenerator(name = "airh_ast_def_cal", table = "AIRH_AST_ID", pkColumnName = "PK_NAME", valueColumnName = "PK_VALUE", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "airh_ast_def_cal")    
    @Column(name = "id")
    private Integer _id;
    
    @ManyToOne
    @JoinColumn(name = "calendario_id", referencedColumnName = "id")
    private Calendario _calendario;
    
    @Column(name = "fecha_festivo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _fechaFestivo;

    
    @Override
    public Integer getId() {
        return _id;
    }

    @Override
    public void setId(Integer id) {
        this._id = id;
        super.setId(id);
    }

    @Override
    public Calendario getCalendario() {
        return _calendario;
    }

    @Override
    public void setCalendario(com.synapsis.rrhh.asistencia.domainmodel.Calendario calendario) {
        this._calendario = (Calendario) calendario;
        this.setCalendario(calendario);
    }

    @Override
    public Date getFechaFestivo() {
        return _fechaFestivo;
    }

    @Override
    public void setFechaFestivo(Date fechaFestivo) {
        this._fechaFestivo = fechaFestivo;
        this.setFechaFestivo(fechaFestivo);
    }
    
    public DefinicionCalendario() {}
    
    public DefinicionCalendario(com.synapsis.rrhh.asistencia.domainmodel.DefinicionCalendario model) {
    
        this._id = model.getId();
        this._calendario = (Calendario) model.getCalendario();
        this._fechaFestivo = model.getFechaFestivo();
    
    }
    
    
}
