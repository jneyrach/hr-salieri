
package com.synapsis.rrhh.asistencia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class GenericServiceValidations {

	public static boolean dateRangeFromTo(Date dtI, Date dtT) {
		
		return !dtT.before(dtI);

	}
	
	public static List<Date> dateStringToDate(String[] dates, String dateFormat) {
		
		try {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				List<Date>       dts = new ArrayList<Date>();
			
				for (String d : dates)
					 dts.add( sdf.parse(d) );

				return dts;
				
		} catch (ParseException e) {
					return null; 
		}
			
	}
	
}
