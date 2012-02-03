package sshr.web.servlet.asistencia;

import sshr.web.servlet.asistencia.CrudJSONTransferObject;

import flexjson.JSONSerializer;


public abstract class CrudJSONHelper {

	public static <T> String serialize(T entity) {

		JSONSerializer serializer = new JSONSerializer();

		for (CrudJSONTransferObject.SKIP_FIELDS k: CrudJSONTransferObject.SKIP_FIELDS.values())
				serializer.exclude(k.toString());
		
		
        return serializer.serialize( entity );
	
	}

}