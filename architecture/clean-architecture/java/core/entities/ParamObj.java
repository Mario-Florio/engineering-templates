package core.entities;

import java.util.Map;

public class ParamObj {
    public String id;
    public Map<String, Object> data;
    public Map<String, Object> updatedData;
    public Filter filter;

    public ParamObj setId(String id) {
        this.id = id;
        return this;
    }
    public ParamObj setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
    public ParamObj setUpdatedData(Map<String, Object> updatedData) {
        this.updatedData = updatedData;
        return this;
    }
    public ParamObj setFilter(Filter filter) {
        this.filter = filter;
        return this;
    }
}
