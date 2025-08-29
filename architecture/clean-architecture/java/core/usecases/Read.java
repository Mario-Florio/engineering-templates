package core.usecases;

import java.util.List;
import core.ports.IPresenter;
import core.ports.IRepository;
import core.entities.Document;
import core.entities.Response;
import core.entities.ParamObj;

public class Read {
    private final IRepository repo;
    private final IPresenter<List<Document>> presenter;

    public Read(IRepository repo, IPresenter<List<Document>> presenter) {
        this.repo = repo;
        this.presenter = presenter;
    }
    public final Response<List<Document>> execute(ParamObj params) {
        List<Document> documents = repo.read(params.filter);
        return presenter.present(documents);
    }
}
