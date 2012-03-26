package sshr.web.servlet.asistencia;

import sshr.web.servlet.asistencia.CrudTransferObject;

import flexjson.JSONSerializer;


public abstract class CrudJSONHelper {

	public static <T> String serialize(T entity) {

		JSONSerializer serializer = new JSONSerializer();

		for (CrudTransferObject.SKIP_FIELDS k: CrudTransferObject.SKIP_FIELDS.values())
				serializer.exclude(k.toString());


        return serializer.serialize( entity );

	}

}