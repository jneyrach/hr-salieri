package sshr.eventmodel.logging;


public interface EventWrapper <T extends Throwable, U extends Enum<?>> {

	ExceptionSeverityEnum getSeverity();
	
	String[] getCustomMessage();
	void setCustomMessage(final String... msg);
		
	T getException();
	
	Throwable getCause(); 
	void setCause(final Throwable t);
	
	U customize(final Throwable cause, final String... customMessage);
	U customize(final Throwable cause);
	
}
