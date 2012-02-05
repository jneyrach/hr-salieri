
package com.synapsis.rrhh.asistencia.domainmodel;

import java.io.Serializable;
import java.util.Date;

public abstract class InformeAsistencia implements Serializable {

        private Integer _id;
        private Date _fechaCalendario;
        private Date _fechaUltimaActualizacion;
        private Integer _autorId;
        private Integer _comunaId;
        private String _comunaNombre;
        private Integer _unidadId;
        private String _unidadNombre;
        private Integer _unidadEncargadoId;
        private String _unidadEncargadoNombre;
        private Integer _tipoContratoId;
        private String _tipoContratoNombre;
        private Integer _unidadDotacion;
        private Integer _presentes;
        private Integer _ausentesJustificados;
        private Integer _ausentesNoJustificados;

        
        
        
        public Integer getId() {
            return _id;
        }

        public void setId(Integer id) {
            this._id = id;
        }

        public Date getFechaCalendario() {
            return _fechaCalendario;
        }

        public void setFechaCalendario(Date fechaCalendario) {
            this._fechaCalendario = fechaCalendario;
        }

        public Date getFechaUltimaActualizacion() {
            return _fechaUltimaActualizacion;
        }

        public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
            this._fechaUltimaActualizacion = fechaUltimaActualizacion;
        }

        public Integer getAutorId() {
            return _autorId;
        }

        public void setAutorId(Integer autorId) {
            this._autorId = autorId;
        }

        public Integer getComunaId() {
            return _comunaId;
        }

        public void setComunaId(Integer comunaId) {
            this._comunaId = comunaId;
        }

        public String getComunaNombre() {
            return _comunaNombre;
        }

        public void setComunaNombre(String comunaNombre) {
            this._comunaNombre = comunaNombre;
        }

        public Integer getUnidadId() {
            return _unidadId;
        }

        public void setUnidadId(Integer unidadId) {
            this._unidadId = unidadId;
        }

        public String getUnidadNombre() {
            return _unidadNombre;
        }

        public void setUnidadNombre(String unidadNombre) {
            this._unidadNombre = unidadNombre;
        }

        public Integer getUnidadEncargadoId() {
            return _unidadEncargadoId;
        }

        public void setUnidadEncargadoId(Integer unidadEncargadoId) {
            this._unidadEncargadoId = unidadEncargadoId;
        }

        public String getUnidadEncargadoNombre() {
            return _unidadEncargadoNombre;
        }

        public void setUnidadEncargadoNombre(String unidadEncargadoNombre) {
            this._unidadEncargadoNombre = unidadEncargadoNombre;
        }

        public Integer getTipoContratoId() {
            return _tipoContratoId;
        }

        public void setTipoContratoId(Integer tipoContratoId) {
            this._tipoContratoId = tipoContratoId;
        }

        public Integer getUnidadDotacion() {
            return _unidadDotacion;
        }

        public void setUnidadDotacion(Integer unidadDotacion) {
            this._unidadDotacion = unidadDotacion;
        }

        public Integer getPresentes() {
            return _presentes;
        }

        public void setPresentes(Integer presentes) {
            this._presentes = presentes;
        }

        public Integer getAusentesJustificados() {
            return _ausentesJustificados;
        }

        public void setAusentesJustificados(Integer ausentesJustificados) {
            this._ausentesJustificados = ausentesJustificados;
        }

        public Integer getAusentesNoJustificados() {
            return _ausentesNoJustificados;
        }

        public void setAusentesNoJustificados(Integer ausentesNoJustificados) {
            this._ausentesNoJustificados = ausentesNoJustificados;
        }

        public String getTipoContratoNombre() {
            return _tipoContratoNombre;
        }

        public void setTipoContratoNombre(String tipoContratoNombre) {
            this._tipoContratoNombre = tipoContratoNombre;
        }
        
}
