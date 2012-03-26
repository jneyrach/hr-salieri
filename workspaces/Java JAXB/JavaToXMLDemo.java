import java.io.FileOutputStream;

import java.util.*;
import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

public class JavaToXMLDemo {
  public static void main(String[] args) throws Exception {
    JAXBContext context = JAXBContext.newInstance(Employee.class);

    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    Employee object = new Employee();
    object.setCode("CA");
    object.setName("Cath");
    object.setSalary(300);

	List<Date> lst = new ArrayList<Date>();
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());
	lst.add(new Date());

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

  private List<Date> lst = new ArrayList<Date>();

  public List<Date> getLst() {return lst;}

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

  public void setLst(List<Date> l) {
    this.lst = l;
  }
}