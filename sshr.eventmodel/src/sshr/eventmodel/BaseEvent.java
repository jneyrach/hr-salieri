package sshr.eventmodel;

import java.io.Serializable;

import java.lang.reflect.Constructor;

import java.util.EventObject;


public abstract class BaseEvent extends EventObject implements Serializable {

	protected String _myHandlerCode;


	protected BaseEvent(Object source) throws EventAccessNotAllowedException { 
	
		super(source);
	
        StackTraceElement[] e = Thread.currentThread().getStackTrace();

		// The second caller in the stack trace list must be the BaseEvent
        if (!e[1].getClassName().contains( BaseEvent.class.getSimpleName() ) ) throw new EventAccessNotAllowedException();
	}
	
	
	public String getMyEventHandlerCode() {
	
		return this._myHandlerCode;
	}
  
    public static <T> T newInstance(Class<T> cls, Object source, String myHandlerCode) throws InstantiationException, IllegalAccessException, EventAccessNotAllowedException {

        StackTraceElement[] e = Thread.currentThread().getStackTrace();

		// The third caller in the stack trace list must be the EventFactory
        if (!e[2].getClassName().contains( EventFactory.class.getSimpleName() )) throw new EventAccessNotAllowedException();

		
		try {
				Constructor c = cls.getDeclaredConstructors()[0];
				c.setAccessible(true);
				
				return (T) c.newInstance(source, myHandlerCode);
				
		} catch (Exception ex) {
					return null;
		}
    }
  
}
