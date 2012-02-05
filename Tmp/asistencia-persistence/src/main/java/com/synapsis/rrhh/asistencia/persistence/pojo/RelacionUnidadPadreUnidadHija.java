
package com.synapsis.rrhh.asistencia.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airh_ast_rela_unidades")
public class RelacionUnidadPadreUnidadHija extends com.synapsis.rrhh.asistencia.domainmodel.RelacionUnidadPadreUnidadHija {

    @Id
    @Column(name = "id")
    private Integer _id;

    @ManyToOne
    @JoinColumn(name = "unidad_padre_id", referencedColumnName = "id")
    private UnidadOrganizacionalPadre _unidadPadre;

    @ManyToOne
    @JoinColumn(name = "unidad_hija_id", referencedColumnName = "id")
    private UnidadOrganizacional _unidadHija;

    
	@Override
	public UnidadOrganizacional getUnidadHija() {
		return this._unidadHija;
	}
	
	@Override
	public void setUnidadHija(com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacional unidadHija) {
		this._unidadHija = (UnidadOrganizacional) unidadHija;
		super.setUnidadHija(unidadHija);
	}
	
	@Override
	public UnidadOrganizacionalPadre getUnidadPadre() {
		return this._unidadPadre;
	}
	
	@Override
	public void setUnidadPadre(com.synapsis.rrhh.asistencia.domainmodel.UnidadOrganizacionalPadre unidadPadre) {
		this._unidadPadre = (UnidadOrganizacionalPadre) unidadPadre;
		super.setUnidadPadre(unidadPadre);
	}
    
    
    public RelacionUnidadPadreUnidadHija() {}
    
    public RelacionUnidadPadreUnidadHija(com.synapsis.rrhh.asistencia.domainmodel.RelacionUnidadPadreUnidadHija model) {

    	this._unidadHija = (UnidadOrganizacional) model.getUnidadHija();
    	this._unidadPadre = (UnidadOrganizacionalPadre) model.getUnidadPadre();
    
    }
    
}
