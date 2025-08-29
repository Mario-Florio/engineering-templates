import infrastructure.CLI;
import infrastructure.DB;

public class Main {
    private static final DB db = new DB();
    public static void main(String[] args) {
        CLI cli = new CLI(db);
        cli.run();
    }
}
