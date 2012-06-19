package sshr.eventmodel.logging;

public final class LogAndTraceUtil {

	private LogAndTraceTask task;
	
	private final SynchronizedLogStack<EventWrapper<?, ?>> logStack = new SynchronizedLogStack<EventWrapper<?, ?>>();
	
	/*
	public LogAndTraceUtil(final Log4JLogHandlerImpl logger) {
    
		this.task = new LogAndTraceTask(logStack, logger);
		
		final Thread t = new Thread(this.task);
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}
    */

    public <T extends Exception> void logAndThrowException(final EventWrapper<T, ?> event) throws T {
    
        this.task.addLogElement(event);
        
        throw (T)event.getException();
    }

    public <T extends Exception> void log(final EventWrapper<T, ?> event) {
    
        this.task.addLogElement(event);
    }

    public void log(final String... msg) {
    
        this.task.addLogElement(CommonExceptionsEnum.INFO.customize(null, msg));
    }
	
}
