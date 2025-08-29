package interfaceadapters.controllers;

import java.util.List;
import core.entities.Document;
import core.entities.Response;
import core.entities.ParamObj;
import core.usecases.Create;
import core.usecases.Read;
import core.usecases.ReadOne;
import core.usecases.Update;
import infrastructure.DB;
import core.usecases.Delete;
import interfaceadapters.presenters.Presenter;
import interfaceadapters.repositories.Repository;

public class Controller {
    private final Repository repo;

    public Controller(DB db) {
        repo = new Repository(db);
    }
    public Response<Document> create(ParamObj params) {
        Presenter<Document> presenter = new Presenter<Document>();
        Create useCase = new Create(repo, presenter);
        return useCase.execute(params);
    }
    public Response<List<Document>> read(ParamObj params) {
        Presenter<List<Document>> presenter = new Presenter<List<Document>>();
        Read useCase = new Read(repo, presenter);
        return useCase.execute(params);
    }
    public Response<Document> readOne(ParamObj params) {
        Presenter<Document> presenter = new Presenter<Document>();
        ReadOne useCase = new ReadOne(repo, presenter);
        return useCase.execute(params);
    }
    public Response<Document> update(ParamObj params) {
        Presenter<Document> presenter = new Presenter<Document>();
        Update useCase = new Update(repo, presenter);
        return useCase.execute(params);
    }
    public Response<Document> delete(ParamObj params) {
        Presenter<Document> presenter = new Presenter<Document>();
        Delete useCase = new Delete(repo, presenter);
        return useCase.execute(params);
    }
}
