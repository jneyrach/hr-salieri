package sshr.eventmodel;

import java.util.Map;


public interface EventModel <T extends EventHandler, K extends Number> {
    
    public void addEventHandler(K key, T h);
    
    public void removeEventHandler(K key);
    
    public Map<K, T> getEventHandlers();
    
    public T getEventHandler(K key);
    
}
