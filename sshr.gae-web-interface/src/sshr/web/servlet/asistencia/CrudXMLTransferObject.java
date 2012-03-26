package sshr.web.servlet.asistencia;


import sshr.domainmodel.BaseEntity;

import java.util.*;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


@XmlRootElement//(name = "Root")
public final class CrudXMLTransferObject <T extends BaseEntity> {

	private List<T> _dataRows = new ArrayList<T>();
	private String  _dummy    = "XXX";


	//@XmlElement(name = "DataRow")
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
