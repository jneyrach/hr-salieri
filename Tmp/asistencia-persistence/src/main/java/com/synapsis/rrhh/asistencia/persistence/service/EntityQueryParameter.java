
package com.synapsis.rrhh.asistencia.persistence.service;

public class EntityQueryParameter {
    
    private int parCode;
    private int parOrdinal;
    private String parName;
    private Class parType;

    public int getParCode() {
        return parCode;
    }

    public void setParCode(int parCode) {
        this.parCode = parCode;
    }

    public int getParOrdinal() {
        return parOrdinal;
    }

    public void setParOrdinal(int parOrdinal) {
        this.parOrdinal = parOrdinal;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName = parName;
    }

    public Class getParType() {
        return parType;
    }

    public void setParType(Class parType) {
        this.parType = parType;
    }

    public EntityQueryParameter(int parCode, int parOrdinal, String parName, Class parType) {
        this.parCode = parCode;
        this.parOrdinal = parOrdinal;
        this.parName = parName;
        this.parType = parType;
    }

}
