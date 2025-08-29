package infrastructure.commands;

import java.util.Map;
import java.util.Scanner;
import core.entities.Document;
import core.entities.ParamObj;
import core.entities.Response;
import infrastructure.DB;
import infrastructure.commands.__utils__.Utils;
import interfaceadapters.controllers.Controller;

public class UpdateCommand implements ICommand<Document> {
    private final Controller controller;

    public UpdateCommand(DB db) {
        controller = new Controller(db);
    }

    @Override
    public Response<Document> execute(Scanner scanner) {
        String id = Utils.getId(scanner);
        Map<String, Object> updateData = Utils.getData(scanner);
        
        ParamObj paramObj = new ParamObj();
        paramObj.setId(id).setUpdatedData(updateData);

        Response<Document> response = controller.update(paramObj);

        return response;
    }
}
