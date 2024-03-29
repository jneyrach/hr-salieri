package sshr.web.servlet.asistencia;

import sshr.domainmodel.BaseEntity;

import sshr.web.servlet.asistencia.CrudTransferObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.StringWriter;


public abstract class CrudXMLHelper {

	private static JAXBContext  _context;
	private static Marshaller   _m;
	private static StringWriter _sw;

/*
	static {
		try {
				_context = JAXBContext.newInstance( CrudXMLTransferObject.class );
				_m       = _context.createMarshaller();

    			_m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		} catch (Exception ex) { }
	}
*/

	public static <T extends BaseEntity> String marshal(CrudTransferObject<T> entity) {

		try {
				_context = JAXBContext.newInstance( entity.getClass() );
				_m       = _context.createMarshaller();

    			_m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				_sw = new StringWriter();

				_m.marshal( entity, _sw );


				return _sw.toString();

		} catch (Exception ex) {

					throw new RuntimeException(ex);
		}
	}

}