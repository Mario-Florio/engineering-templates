package infrastructure.commands;

import java.util.List;
import java.util.Scanner;
import core.entities.Document;
import core.entities.Filter;
import core.entities.ParamObj;
import core.entities.Response;
import infrastructure.DB;
import infrastructure.commands.__utils__.Utils;
import interfaceadapters.controllers.Controller;

public class ReadCommand implements ICommand<List<Document>> {
    private final Controller controller;

    public ReadCommand(DB db) {
        controller = new Controller(db);
    }

    @Override
    public Response<List<Document>> execute(Scanner scanner) {
        Filter filter = Utils.getFilter(scanner);
        
        ParamObj paramObj = new ParamObj();
        paramObj.setFilter(filter);

        Response<List<Document>> response = controller.read(paramObj);

        return response;
    }
}
