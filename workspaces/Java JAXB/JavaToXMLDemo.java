import java.io.FileOutputStream;

import java.util.*;
import java.io.*;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;



public class JavaToXMLDemo {
  public static void main(String[] args) throws Exception {
    JAXBContext context = JAXBContext.newInstance(Employee.class);

    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    Employee object = new Employee();
    object.setCode("CA");
    object.setName("Cath");
    object.setSalary(300);

	List<CompObj> lst = new ArrayList<CompObj>();
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));
	lst.add(new CompObj(0, "XXX", new Date()));

    object.setLst(lst);

	StringWriter _sw = new StringWriter();

	m.marshal( object, _sw );

	System.out.println("****************************************************************");
	System.out.println(_sw.toString());

    //m.marshal(object, new FileOutputStream("result.xml"));
    //m.marshal(lst, new FileOutputStream("result.xml"));

  }
}

@XmlRootElement
class Employee {
  private String code;

  private String name;

  private int salary;

  private List<CompObj> lst = new ArrayList<CompObj>();

  @XmlElementWrapper(name = "DataRows")
  @XmlElement(name = "DataRow")
  public List<CompObj> getLst() {return lst;}

  public String getCode() {
    return code;
  }

  @XmlTransient
  public void setCode(String code) {
    this.code = code;
  }

  @XmlTransient
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlTransient
  public int getSalary() {
    return salary;
  }

  public void setSalary(int population) {
    this.salary = population;
  }

  public void setLst(List<CompObj> l) {
    this.lst = l;
  }
}


class CompObj extends AbsCompObj {

	private int intv;
	private String strv;
	private Date dtv;


	public CompObj() {}

	public CompObj(int intv, String strv, Date dtv) {

		this.intv = intv;
		this.strv = strv;
		this.dtv = dtv;
		this.bintv = intv;
		this.bstrv = strv;
		this.bdtv = dtv;
	}


	public void setIntv(int intv) {this.intv = intv;}
	public void setStrv(String strv) {this.strv = strv;}
	public void setDtv(Date dtv) {this.dtv = dtv;}

	public int getIntv() {return this.intv;}
	public String getStrv() {return this.strv;}
	public Date getDtv() {return this.dtv;}

}

class AbsCompObj {

	protected int bintv;
	protected String bstrv;
	protected Date bdtv;

	public void setBintv(int bintv) {this.bintv = bintv;}
	public void setBstrv(String bstrv) {this.bstrv = bstrv;}
	public void setBdtv(Date bdtv) {this.bdtv = bdtv;}

	public int getBintv() {return this.bintv;}
	public String getBstrv() {return this.bstrv;}
	public Date getBdtv() {return this.bdtv;}

}