
package com.synapsis.rrhh.asistencia.service;

public final class ServicesSetup {

	public static final String DEFAULT_OPERATION_RESULT_MESSAGE_NAME = "ResultMessage";
	public static final String DEFAULT_OPERATION_RESULT_OK_NAME = "ResultOK";


	
	
	public enum OPERATION_SETUP___CREAR_MARCAS {
		
		_PERSONA_ID() {
			@Override
			public String getParameterName() {return "PersonaID";}
		},
		_FECHA_INICIO() {
			@Override
			public String getParameterName() {return "FechaInicio";}
		},
		_FECHA_TERMINO() {
			@Override
			public String getParameterName() {return "FechaTermino";}
		},
		_TIPO_DIA() {
			@Override
			public String getParameterName() {return "TipoDia";}
		},
		_AUTOR() {
			@Override
			public String getParameterName() {return "Autor";}
		},
		_TIPO_JUSTIFICACION() {
			@Override
			public String getParameterName() {return "TipoJustificacion";}
		},
		_HOJAS_DE_TIEMPO() {
			@Override
			public String getParameterName() {return "HojasDeTiempo";}
		},
		_MARCA_ENTRADA___HORA() {
			@Override
			public String getParameterName() {return "MarcaEntradaHora";}
		},
		_MARCA_ENTRADA___MINUTOS() {
			@Override
			public String getParameterName() {return "MarcaEntradaMinutos";}
		},
		_MARCA_SALIDA___HORA() {
			@Override
			public String getParameterName() {return "MarcaSalidaHora";}
		},
		_MARCA_SALIDA___MINUTOS() {
			@Override
			public String getParameterName() {return "MarcaSalidaMinutos";}
		},
		_MARCA_JUSTIFICACION___TERMINO_HORA() {
			@Override
			public String getParameterName() {return "MarcaJustificacionTerminoHora";}
		},
		_MARCA_JUSTIFICACION___TERMINO_MINUTOS() {
			@Override
			public String getParameterName() {return "MarcaJustificacionTerminoMinutos";}
		},
		_MARCA_JUSTIFICACION___INICIO_HORA() {
			@Override
			public String getParameterName() {return "MarcaJustificacionInicioHora";}
		},
		_MARCA_JUSTIFICACION___INICIO_MINUTOS() {
			@Override
			public String getParameterName() {return "MarcaJustificacionInicioMinutos";}
		};

		public abstract String getParameterName();
		
	};
	
}
