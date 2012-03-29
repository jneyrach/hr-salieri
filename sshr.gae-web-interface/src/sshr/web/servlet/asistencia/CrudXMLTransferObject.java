package sshr.web.servlet.asistencia;


import sshr.domainmodel.BaseEntity;

import java.util.*;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "Root", namespace = "http://www.w3.org/2001/XMLSchema")
public final class CrudXMLTransferObject <T extends BaseEntity> {

	private List<T> _dataRows = new ArrayList<T>();
	private String  _dummy    = "XXX";


	@XmlElementWrapper(name = "DataRows")
	public List<T> getDataRows() {

		return this._dataRows;
	}

	public void setDataRows(List<T> dataRows) {

		this._dataRows = dataRows;
	}


	public String getDummy() {

		return this._dummy;
	}

	public void setDummy(String dummy) {

		this._dummy = dummy;
	}

}
