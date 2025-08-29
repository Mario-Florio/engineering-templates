package interfaceadapters.repositories;

import java.util.List;
import core.ports.IRepository;
import infrastructure.DB;
import core.entities.Document;
import core.entities.Filter;

public class Repository implements IRepository {
    private final DB db;
    public Repository(DB db) {
        this.db = db;
    }
    @Override
    public Document create(Document doc) {
        return db.create(doc);
    }
    @Override
    public List<Document> read(Filter filter) {
        return db.read(filter);
    }
    @Override
    public Document update(String id, Document updateDoc) {
        return db.update(id, updateDoc);
    }
    @Override
    public Document delete(String id) {
        return db.delete(id);
    }
}
