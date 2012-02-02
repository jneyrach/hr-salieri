package sshr.eventmodel;

import sshr.eventmodel.EventFactory;
import sshr.eventmodel.DummyEvent;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestEventModelFactory {

	@Test
	public void testCreateEventFromFactory() {
	
		try {
				assertTrue( EventFactory.getNewEvent( DummyEvent.class ) != null );
		
		} catch (Exception ex) {
				System.out.println("----------------------------");
				System.out.println("ERROR:");
				ex.printStackTrace();
				System.out.println("----------------------------");
		}
		
	}

}
