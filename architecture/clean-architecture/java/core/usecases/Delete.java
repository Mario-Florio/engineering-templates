package core.usecases;

import core.ports.IPresenter;
import core.ports.IRepository;
import core.entities.Document;
import core.entities.Response;
import core.entities.ParamObj;

public class Delete {
    private final IRepository repo;
    private final IPresenter<Document> presenter;

    public Delete(IRepository repo, IPresenter<Document> presenter) {
        this.repo = repo;
        this.presenter = presenter;
    }
    public final Response<Document> execute(ParamObj params) {
        Document doc = repo.delete(params.id);
        return presenter.present(doc);
    }   
}
