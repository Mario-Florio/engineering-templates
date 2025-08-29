package core.usecases;

import core.ports.IRepository;
import core.ports.IPresenter;
import core.entities.Response;
import core.entities.Document;
import core.entities.ParamObj;

public class Create {
    private final IRepository repo;
    private final IPresenter<Document> presenter;

    public Create(IRepository repo, IPresenter<Document> presenter) {
        this.repo = repo;
        this.presenter = presenter;
    }
    public final Response<Document> execute(ParamObj params) {
        Document document = new Document(params.data);
        Document doc = repo.create(document);
        return presenter.present(doc);
    }
}
