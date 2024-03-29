package sshr.domainmodel;

import sshr.domainmodel.util.XmlJAXBDateAdapter;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;


public abstract class BaseEntity <ID extends Number> implements Serializable {

    protected ID   _id;

	protected Date _createdOn;
	protected Date _updatedOn;


	protected BaseEntity() throws EntityAccessNotAllowedException {

        StackTraceElement[] e = Thread.currentThread().getStackTrace();

		// The second caller in the stack trace list must be the BaseEntity
        if (!e[1].getClassName().contains( BaseEntity.class.getSimpleName() ) ) throw new EntityAccessNotAllowedException();
	}


    public ID getID() {

        return this._id;
    }

	@XmlJavaTypeAdapter(XmlJAXBDateAdapter.class)
    public Date getCreatedOn() {

        return this._createdOn;
    }

	@XmlJavaTypeAdapter(XmlJAXBDateAdapter.class)
    public Date getUpdatedOn() {

        return this._updatedOn;
    }

    public void setID(ID id) {

        this._id = id;
    }

    public void setCreatedOn(Date createdOn) {

        this._createdOn = createdOn;
    }

    public void setUpdatedOn(Date updatedOn) {

        this._updatedOn = updatedOn;
    }


    public static <T> T newInstance(Class<T> cls) throws InstantiationException, IllegalAccessException, EntityAccessNotAllowedException {

        StackTraceElement[] e = Thread.currentThread().getStackTrace();

		// The third caller in the stack trace list must be the EntityFactory
        if (!e[2].getClassName().contains( EntityFactory.class.getSimpleName() )) throw new EntityAccessNotAllowedException();


		try {
				Constructor c = cls.getDeclaredConstructors()[0];
				c.setAccessible(true);

				return (T) c.newInstance();

		} catch (Exception ex) {

					return null;
		}
    }

}
