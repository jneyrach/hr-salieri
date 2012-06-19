package sshr.eventmodel.logging;

import java.util.*;


public class SynchronizedLogStack<T> {

	private List<EventWrapper<?, ?>> stack = new ArrayList<EventWrapper<?, ?>>();
    
	private boolean	open;
	
	private String stackId;

    
	public SynchronizedLogStack() {
    
		this("SynchronizedLogStack");
	}

	public SynchronizedLogStack(String stackId) {

        this.open    = true;
		this.stackId = stackId;
	}

    
	synchronized public void push(EventWrapper<?, ?> element) {

        this.stack.add(element);
        
		this.notify();
	}

	synchronized public EventWrapper<?, ?> pop() throws InterruptedException {
    
		while (this.stack.size() == 0) {
        
			if (this.open) {
            
				this.wait();
			} else {
            
                    throw new InterruptedException(this.stackId + " is closed and has no further elements to consume."); 
			}
		}

		EventWrapper<?, ?> element = this.stack.remove(0);
        
		return element;
	}

	synchronized public void close() {
    
		//Logger.getLogger(SynchronizedLogStack.class.getClass().getName()).info("closing stack: " + this.stackId);

		this.open = false;
        
		this.notifyAll();
	}
	
	synchronized public int size() {
    
		return this.stack.size();
	}

}
