package sshr.domainmodel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class XmlJAXBDateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat _dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public String marshal(Date v) throws Exception {
	
        return this._dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
	
        return this._dateFormat.parse(v);
    }

}