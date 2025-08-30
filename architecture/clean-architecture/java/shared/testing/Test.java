package shared.testing;

public class Test {
    static private final String GREEN_FG = "\u001B[32m";
    static private final String RED_FG = "\u001B[31m";
    static private final String RESET_FG = "\u001B[0m";
    static private final String CHECKMARK = "\u2714";
    static private final String X = "\u2716";

    static public void it(String name, Runnable test) {
        try {
            test.run();
            System.out.println(GREEN_FG+CHECKMARK+" "+name+RESET_FG);
        } catch (Exception exception) {
            System.out.println(RED_FG+X+" "+name+RESET_FG);
        }
    }
    static public void is(Boolean condition) throws RuntimeException {
        if (!condition) {
            throw new RuntimeException();
        }
    }
}
