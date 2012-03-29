import java.io.FileOutputStream;

import java.util.*;
import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));
	lst.add(new CompObj(0, "XXX"));

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

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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


class CompObj {

	private int intv;
	private String strv;


	public CompObj() {}

	public CompObj(int intv, String strv) {

		this.intv = intv;
		this.strv = strv;
	}


	public void setIntv(int intv) {this.intv = intv;}
	public void setStrv(String strv) {this.strv = strv;}

	public int getIntv() {return this.intv;}
	public String getStrv() {return this.strv;}

}
