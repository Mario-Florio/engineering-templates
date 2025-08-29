package core.usecases;

import core.ports.IPresenter;
import core.ports.IRepository;
import core.entities.Document;
import core.entities.Response;
import core.entities.ParamObj;

public class Update {
    private final IRepository repo;
    private final IPresenter<Document> presenter;

    public Update(IRepository repo, IPresenter<Document> presenter) {
        this.repo = repo;
        this.presenter = presenter;
    }
    public final Response<Document> execute(ParamObj params) {
        Document updatedDoc = new Document(params.updatedData);
        Document doc = repo.update(params.id, updatedDoc);
        return presenter.present(doc);
    }   
}
