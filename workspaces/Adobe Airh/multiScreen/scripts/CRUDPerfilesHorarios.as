	import mx.controls.*; 
	import mx.events.*;
	import mx.rpc.http.*; 
	import mx.rpc.events.*; 
	import mx.collections.*;

	
	[Bindable]
	public var xmlData:XML;

	
	private function loadData():void 
	{ 
		try
		{
			updateRequest.addEventListener("result", updateResult); 
			updateRequest.addEventListener("fault", httpFault); 

			dataRequest.addEventListener("result", httpResult); 
			dataRequest.addEventListener("fault", httpFault); 
			dataRequest.send();
		}
		catch (e:Error)
		{
			Alert.show("Error: Se produjo un error de inicialización.\n" + e.message);
		}
	} 

	public function updateResult(event:ResultEvent): void
	{
		dataRequest.send();
	}
	
	public function httpResult(event:ResultEvent):void 
	{ 
		xmlData = new XML(event.result);
	} 

	public function httpFault(event:FaultEvent):void 
	{ 
		var faultstring:String = event.fault.faultString; 
		Alert.show("Ha ocurrido un error:\n" + faultstring); 
	} 

	private function submitGuardar():void 
	{
		if (nombre.text == "" || desc.text == "")
		{
			Alert.show("Error: Ni el campo 'nombre' ni el campo 'descripción' pueden estar en blanco.");
			return;
		}
		else
		{
			Alert.yesLabel = "Si";
			Alert.noLabel  = "No";
				
			Alert.show("¿Desea actualizar / crear el registro?", "", Alert.YES | Alert.NO, this, performGuardar);
		}
	}

	private function performGuardar(usrResp:CloseEvent):void 
	{
		if (usrResp.detail == Alert.NO) return;
		
		try
		{
			var url:String = "";
			
			if (ID.text == "")
			{
				url = "http://mirhrh.appspot.com/AsistenciaCrudCreatePerfilHorario?desc=" + desc.text + "&codigo=" + codigo.text + "&nombre=" + nombre.text;
				updateRequest.url = url;
				updateRequest.send();
			}
			else
			{
				url = "http://mirhrh.appspot.com/AsistenciaCrudUpdatePerfilHorario?desc=" + desc.text + "&codigo=" + codigo.text + "&ID=" + ID.text + "&nombre=" + nombre.text;
				updateRequest.url = url;
				updateRequest.send();
			}
		}
		catch (e:Error)
		{
			Alert.show("Error: " + e.message);
		}

		nuevoRegistro();
	}   

	private function submitDelete():void 
	{
		if (ID.text == "")
		{
			Alert.show("Error: Debe seleccionar un registro primero.");
			return;
		}
		else
		{
			Alert.yesLabel = "Si";
			Alert.noLabel  = "No";
				
			Alert.show("¿Desea eliminar el registro?", "", Alert.YES | Alert.NO, this, performDelete);
		}
	}

	private function performDelete(usrResp:CloseEvent):void {

		if (usrResp.detail == Alert.NO) return;
		
		try
		{
			var url:String = "http://mirhrh.appspot.com/AsistenciaCrudRemovePerfilHorario?ID=" + ID.text;
			
			updateRequest.url = url;
			
			updateRequest.send();
		}
		catch (e:Error)
		{
			Alert.show("Error: " + e.message);
		}
			
		nuevoRegistro();
	}   

	public function nuevoRegistro():void {

		gridPerfilHorario.selectedIndex = -1;
		
		ID.text     = "";
		codigo.text = "";
		nombre.text = "";
		desc.text   = "";
		fAct.text   = "";
		fCrea.text  = "";
	}   
