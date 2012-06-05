package sshr.eventmodel;


public final class LogAndTraceTask implements Runnable {

	private static StringBuilder sb = null;
	
	private Log4JLogHandlerImpl logger;
	private SynchronizedLogStack<EventWrapper<?, ?>> logStack = new SynchronizedLogStack<EventWrapper<?, ?>>();
	
	public LogAndTraceTask(final SynchronizedLogStack<EventWrapper<?, ?>> logStack, final Log4JLogHandlerImpl logger) {
		
		this.logger   = logger;
		this.logStack = logStack;
	}
	
	public void addLogElement(final EventWrapper<?, ?> evt) {
		
		this.logStack.push(evt);
	}
	
	
	@Override
	public void run() 
	{
		while (!Thread.currentThread().isInterrupted())
		{
				EventWrapper<?, ?> event = null;
				
				try 
				{
					event = this.m_logStack.pop();
				}
				catch (InterruptedException ie)
				{
					//
				}
				
				switch (event.getSeverity()) 
				{
					case FATAL:
						this.m_logger.logFatal( event.getCustomMessage().length == 0 ? event.getException().getMessage() : buildMessage( event.getCustomMessage() ), event.getException());
						
						break;
		
					case ERROR:
						this.m_logger.logError( event.getCustomMessage().length == 0 ? event.getException().getMessage() : buildMessage( event.getCustomMessage() ), event.getException());
						
						break;
		
					case WARNING:
						this.m_logger.logWarning( event.getCustomMessage().length == 0 ? event.getException().getMessage() : buildMessage( event.getCustomMessage() ), event.getException());
						
						break;
		
					case INFORMATIONAL:
						this.m_logger.logInformational( event.getCustomMessage().length == 0 ? event.getException().getMessage() : buildMessage( event.getCustomMessage() ) );
					
						break;
		
					default:
				}
		}
	}
		
	private static String buildMessage(final String... msgParts) {

		if (msgParts.length == 0) return "";
		
		sb = new StringBuilder();
		
		for (final String s: msgParts) {
			
			sb.append(s);
		}

		return sb.toString();
	}
	
}
