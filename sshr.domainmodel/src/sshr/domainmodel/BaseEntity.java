package sshr.domainmodel;

import java.io.Serializable;

import java.lang.reflect.Constructor;


public abstract class BaseEntity <ID extends Number> implements Serializable {

    private ID _id;


	protected BaseEntity() throws EntityAccessNotAllowedException { 
	
        StackTraceElement[] e = Thread.currentThread().getStackTrace();

		// The second caller in the stack trace list must be the BaseEntity
        if (!e[1].getClassName().contains( BaseEntity.class.getSimpleName() ) ) throw new EntityAccessNotAllowedException();
	}
	
  
    public ID getId() {
  
        return this._id;  
    }
    
    public void setId(ID id) {
    
        this._id = id;  
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
