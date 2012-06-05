package sshr.eventmodel;


public final class EventWrapperUtil<T extends EventWrapper<?, ?>> 
{
	private final T m_evtWrapper;
	
	
	public EventWrapperUtil(final T evtWrapper) 
	{
		this.m_evtWrapper = evtWrapper;
	}
	
	
	public T customize(final Throwable cause, final String... customMessage) 
	{
		this.m_evtWrapper.setCustomMessage(customMessage);
		
		if (cause != null) 
		{
			this.m_evtWrapper.setCause( cause );
			this.m_evtWrapper.getException().initCause(cause);
		}
		else
		{
		}
		
		return this.m_evtWrapper;
	}

	public T customize(final Throwable cause) 
	{
		this.m_evtWrapper.setCustomMessage( cause.getMessage() );
		this.m_evtWrapper.setCause( cause );
		this.m_evtWrapper.getException().initCause(cause);
		
		return this.m_evtWrapper;
	}

}
