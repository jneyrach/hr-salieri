package sshr.eventmodel.logging;


public final class EventWrapperUtil<T extends EventWrapper<?, ?>> {
	
    private final T evtWrapper;
	
	
	public EventWrapperUtil(final T evtWrapper) {
    
		this.evtWrapper = evtWrapper;
	}
	
	
	public T customize(final Throwable cause, final String... customMessage) {
    
		this.evtWrapper.setCustomMessage(customMessage);
		
		if (cause != null) {
        
			this.evtWrapper.setCause( cause );
			this.evtWrapper.getException().initCause(cause);
		}
		
		return this.evtWrapper;
	}

	public T customize(final Throwable cause) 
	{
		this.evtWrapper.setCustomMessage( cause.getMessage() );
		this.evtWrapper.setCause( cause );
		this.evtWrapper.getException().initCause(cause);
		
		return this.evtWrapper;
	}

}
