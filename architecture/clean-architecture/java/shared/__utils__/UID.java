package shared.__utils__;

import java.util.UUID;

public class UID {
    public static String uid() {
        return UUID.randomUUID().toString();
    }
}
