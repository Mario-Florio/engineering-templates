package core.entities;

import java.util.Map;
import java.util.HashMap;
import shared.__utils__.UID;

public class Document {
    private final Map<String, Object> properties;

    public Document(Map<String, Object> props) {
        if (!(props.get("id") instanceof String)) props.put("id", UID.uid());
        properties = new HashMap<>(props);
    }
    public Object getId() { 
        return properties.get("id");
    }
    public Object get(String key) {
        return properties.get(key);
    }
    public void set(String key, Object value) {
        properties.put(key, value);
    }
    public Map<String, Object> getAll() {
        return new HashMap<>(properties); // defensive copy
    }
}
