package core.entities;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    private final Map<String, Object> properties;

    public Filter(Map<String, Object> props) {
        if (props != null) properties = new HashMap<>(props);
        else properties = new HashMap<>();
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
