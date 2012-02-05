package com.synapsis.rrhh.asistencia.domainmodel;

public abstract class DomainModelDomainValues {

	public static final byte RELACION_CONTRACTUAL_PERSONA_EXTERNA___EN_PRACTICA_PROFESIONAL = 0;
	public static final byte RELACION_CONTRACTUAL_PERSONA_EXTERNA___EMPRESA_EXTERNA = 1;
	public static final byte RELACION_CONTRACTUAL_PERSONA_EXTERNA___COMISIONADO_EN_LA_UNIDAD = 2;
	public static final byte RELACION_CONTRACTUAL_PERSONA_EXTERNA___PERSONAL_A_HONORAIRIOS = 3;
	public static final byte RELACION_CONTRACTUAL_PERSONA_EXTERNA___OTRA_SITUACION = 4;

	public static final String JSON_RELACIONES_CONTRACTUALES_PERSONAS_EXTERNAS 
	    = "{ \"value\": {"
        + "  \"" + RELACION_CONTRACTUAL_PERSONA_EXTERNA___EN_PRACTICA_PROFESIONAL   + "\": \"En Práctica Profesional\""
        + ", \"" + RELACION_CONTRACTUAL_PERSONA_EXTERNA___EMPRESA_EXTERNA           + "\": \"Empresa Externa\""
        + ", \"" + RELACION_CONTRACTUAL_PERSONA_EXTERNA___COMISIONADO_EN_LA_UNIDAD  + "\": \"Comisionado en la Unidad\""
        + ", \"" + RELACION_CONTRACTUAL_PERSONA_EXTERNA___PERSONAL_A_HONORAIRIOS    + "\": \"A Honorarios\""
        + ", \"" + RELACION_CONTRACTUAL_PERSONA_EXTERNA___OTRA_SITUACION            + "\": \"Otra Situación\""
        + "} }";
	
	private DomainModelDomainValues() {}
	
}
