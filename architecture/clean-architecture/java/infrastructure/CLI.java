package infrastructure;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import shared.__utils__.Console;
import core.entities.Response;
import infrastructure.commands.CreateCommand;
import infrastructure.commands.DeleteCommand;
import infrastructure.commands.ICommand;
import infrastructure.commands.ReadCommand;
import infrastructure.commands.ReadOneCommand;
import infrastructure.commands.UpdateCommand;

public class CLI {
    private static final Console console = new Console();
    private final Map<String, ICommand<?>> commands = new HashMap<>();
    // TOKENS
    private static final String CREATE = "CREATE";
    private static final String READ = "READ";
    private static final String READONE = "READONE";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String EXIT = "EXIT";
    private static final String MAINMENU = "MAINMENU";

    public CLI(DB db) {
        commands.put(CREATE, new CreateCommand(db));
        commands.put(READ, new ReadCommand(db));
        commands.put(READONE, new ReadOneCommand(db));
        commands.put(UPDATE, new UpdateCommand(db));
        commands.put(DELETE, new DeleteCommand(db));
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);

        mainMenu(scanner);

        scanner.close();

    }
    private void mainMenu(Scanner scanner) {
        String question = "\n"+
                          "1. Create\n"+
                          "2. Read\n"+
                          "3. ReadOne\n"+
                          "4. Update\n"+
                          "5. Delete\n"+
                          "6. exit\n";

        System.out.print(question);
        String answer = scanner.nextLine();
        String TOKEN = parseAnswer(answer);

        if (TOKEN == EXIT) {

            scanner.close();
            console.log("Exiting now...");
            System.exit(0);

        } else if (TOKEN == MAINMENU) {

            mainMenu(scanner);

        } else {

            ICommand<?> command = commands.get(TOKEN);

            if (command != null) {

                Response<?> response = command.execute(scanner);
                if (response != null && response.success == true) console.log(response.data);

            } else {
                
                console.log("Invalid option.");
            }
        }

        mainMenu(scanner);
    }
    private static String parseAnswer(String answer) {
        switch(answer.toLowerCase()) {
            case "1":
            case "create":
            case "1. create":
                return CREATE;
            case "2":
            case "read":
            case "2. read":
                return READ;
            case "3":
            case "readone":
            case "3.readone":
                return READONE;
            case "4":
            case "update":
            case "4. update":
                return UPDATE;
            case "5":
            case "delete":
            case "5. delete":
                return DELETE;
            case "6":
            case "exit":
            case "6. exit":
                return EXIT;
            default:
                return MAINMENU;
        }
    }
}
