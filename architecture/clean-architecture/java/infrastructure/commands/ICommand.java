package infrastructure.commands;

import java.util.Scanner;
import core.entities.Response;

public interface ICommand<T> {
    public Response<T> execute(Scanner scanner);
}
