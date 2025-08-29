package core.usecases;

import java.util.List;
import core.ports.IPresenter;
import core.ports.IRepository;
import core.entities.Document;
import core.entities.Response;
import core.entities.ParamObj;

public class ReadOne {
    private final IRepository repo;
    private final IPresenter<Document> presenter;

    public ReadOne(IRepository repo, IPresenter<Document> presenter) {
        this.repo = repo;
        this.presenter = presenter;
    }
    public final Response<Document> execute(ParamObj params) {
        List<Document> documents = repo.read(params.filter);
        return presenter.present(documents.size() > 0 ? documents.get(0) : null);
    }
}
