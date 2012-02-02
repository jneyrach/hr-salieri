package sshr.eventmodel;


public enum EventFactory {

    Instance();


    public static <T extends BaseEvent> T getNewEvent(Class<T> cls, Object source, String evtHandlerCode) {

		try {
				return BaseEvent.newInstance( cls, source, evtHandlerCode );
				
		} catch (InstantiationException ex) { 
		
					throw new RuntimeException("Unexpected error occured.", ex);
		} catch (IllegalAccessException ex) { 
		
					throw new RuntimeException("Unexpected error occured.", ex);
		} catch (EventAccessNotAllowedException ex) { 
		
					throw new RuntimeException("Unexpected error occured.", ex);
		}

	}

}
