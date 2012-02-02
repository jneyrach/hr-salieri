package sshr.asistencia;

import sshr.eventmodel.BaseEvent;
import sshr.eventmodel.EventHandler;
import sshr.eventmodel.EventValidationException;


public enum AsistenciaCrudEventHandler implements EventHandler {

	INSTANCE;

	
	@Override
	public String getEvtHandlerID() {
	
		return "AsistenciaCrudEventHandler";
	}

	@Override
    public <T extends BaseEvent> void fireEvent(T evt) throws EventValidationException {
	
	}
	
	@Override
	public <T extends BaseEvent> void reportError(T evt) {
	
	}

}
