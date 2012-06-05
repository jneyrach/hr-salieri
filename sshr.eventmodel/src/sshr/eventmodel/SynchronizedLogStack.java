package sshr.eventmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SynchronizedLogStack<T>
{
	private List<EventWrapper<?, ?>> m_stack = new ArrayList<EventWrapper<?, ?>>();
	private boolean	m_open;
	
	private String m_stackId;

	// -------------------------------------------------------------
	// constructors
	// -------------------------------------------------------------
	public SynchronizedLogStack()
	{
		this("SynchronizedLogStack");
	}

	public SynchronizedLogStack(String stackId)
	{
		this.m_open = true;
		this.m_stackId = stackId;
		
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
	synchronized public void push(EventWrapper<?, ?> element)
	{
		this.m_stack.add(element);
		this.notify();
	}

	synchronized public EventWrapper<?, ?> pop() throws InterruptedException
	{
		while (this.m_stack.size() == 0)
		{
			if (this.m_open)
			{
				this.wait();
			}
			else
			{
				throw new InterruptedException(this.m_stackId + " is closed and has no further elements to consume."); 
			}
		}

		EventWrapper<?, ?> element = this.m_stack.remove(0);
		return element;
	}

	synchronized public void close()
	{
		Logger.getLogger(SynchronizedLogStack.class.getClass().getName()).info("closing stack: " + this.m_stackId);

		this.m_open = false;
		this.notifyAll();
	}
	
	
	synchronized public int size()
	{
		return this.m_stack.size();
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

