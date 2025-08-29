package infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import core.entities.Document;
import core.entities.Filter;

public class DB {
    private final List<Document> collection;

    public DB() {
        collection = new ArrayList<Document>();
    }
    public Document create(Document doc) {
        collection.add(doc);
        return doc;
    }
    public List<Document> read(Filter filter) {
        List<Document> filtered = collection.stream()
            .filter(doc -> applyFilter(doc, filter))
            .toList();
        return filtered;
    }
    public Document update(String id, Document updatedDoc) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId().equals(id)) {
                collection.set(i, updatedDoc);
                break;
            }
        }
        return updatedDoc;
    }
    public Document delete(String id) {
        Document removed = null;

        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId().equals(id)) {
                removed = collection.remove(i);
                break;
            }
        }

        return removed;
    }
    private Boolean applyFilter(Document doc, Filter filter) {
        return filter.getAll()
                     .entrySet()
                     .stream()
                     .allMatch(entry -> Objects.equals(doc.get(entry.getKey()), entry.getValue()));
    }
}
