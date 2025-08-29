package infrastructure.commands;

import java.util.Map;
import java.util.Scanner;

import core.entities.Document;
import core.entities.ParamObj;
import core.entities.Response;
import infrastructure.DB;
import infrastructure.commands.__utils__.Utils;
import interfaceadapters.controllers.Controller;

public class CreateCommand implements ICommand<Document> {
    private final Controller controller;

    public CreateCommand(DB db) {
        controller = new Controller(db);
    }

    @Override
    public Response<Document> execute(Scanner scanner) {
        Map<String, Object> data = Utils.getData(scanner);
        
        ParamObj paramObj = new ParamObj();
        paramObj.setData(data);

        Response<Document> response = controller.create(paramObj);

        return response;
    }
}
