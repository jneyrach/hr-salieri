package sshr.eventmodel;

import com.experian.common.converter.ConvertException;
import com.experian.common.logger.impl.Log4JLogHandlerImpl;


public final class LogAndTraceUtil 
{
	private LogAndTraceTask m_task;
	
	private final SynchronizedLogStack<EventWrapper<?, ?>> m_logStack = new SynchronizedLogStack<EventWrapper<?, ?>>();
	
	
	// -------------------------------------------------------------
	// constructors
	// -------------------------------------------------------------
	public LogAndTraceUtil(final Log4JLogHandlerImpl logger)
	{
		this.m_task = new LogAndTraceTask(m_logStack, logger);
		
		final Thread t = new Thread(this.m_task);
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}

	// -------------------------------------------------------------
	// override toString(), equals() and hashCode() methods
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// override super class methods
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// implementing interface methods
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// sets and gets for attributes
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// public methods
	// -------------------------------------------------------------
		/**
		 * Takes an event, and logs it to the predefined log, also throws the given exception within the event. 
		 * @param event The event wrapper object
		 * @return none.
		 * @throws ConvertException
		 * 
		 * */
		public <T extends Exception> void logAndThrowException(final EventWrapper<T, ?> event) throws T 
		{
			this.m_task.addLogElement(event);
			
			throw (T)event.getException();
		}
	
		public <T extends Exception> void log(final EventWrapper<T, ?> event) 
		{
			this.m_task.addLogElement(event);
		}
	
		public void log(final String... msg) 
		{
			this.m_task.addLogElement(CommonExceptionsEnum.INFO.customize(null, msg));
		}
	
	// -------------------------------------------------------------
	// private and protected methods
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// static methods
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// inner classes
	// -------------------------------------------------------------

}
