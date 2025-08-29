package infrastructure.commands;

import java.util.Scanner;
import core.entities.Document;
import core.entities.ParamObj;
import core.entities.Response;
import infrastructure.DB;
import infrastructure.commands.__utils__.Utils;
import interfaceadapters.controllers.Controller;

public class DeleteCommand implements ICommand<Document> {
    private final Controller controller;

    public DeleteCommand(DB db) {
        controller = new Controller(db);
    }

    @Override
    public Response<Document> execute(Scanner scanner) {
        String id = Utils.getId(scanner);
        
        ParamObj paramObj = new ParamObj();
        paramObj.setId(id);

        Response<Document> response = controller.delete(paramObj);

        return response;
    }
}
