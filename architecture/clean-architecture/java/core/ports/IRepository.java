package core.ports;

import java.util.List;
import core.entities.Document;
import core.entities.Filter;

public interface IRepository {
    public Document create(Document doc);
    public List<Document> read(Filter filter);
    public Document update(String id, Document updatedDoc);
    public Document delete(String id);
}
