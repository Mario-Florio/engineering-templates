package infrastructure.commands;

import java.util.Scanner;
import core.entities.Document;
import core.entities.Filter;
import core.entities.ParamObj;
import core.entities.Response;
import infrastructure.DB;
import infrastructure.commands.__utils__.Utils;
import interfaceadapters.controllers.Controller;

public class ReadOneCommand implements ICommand<Document> {
    private final Controller controller;

    public ReadOneCommand(DB db) {
        controller = new Controller(db);
    }

    @Override
    public Response<Document> execute(Scanner scanner) {
        Filter filter = Utils.getFilter(scanner);
        
        ParamObj paramObj = new ParamObj();
        paramObj.setFilter(filter);

        Response<Document> response = controller.readOne(paramObj);

        return response;
    }
}
