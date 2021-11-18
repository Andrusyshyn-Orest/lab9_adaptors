package adapters;

import java.util.Date;

public interface User {
    boolean send(String text, String country);
    public default Date getCurrentDate() {
        return new Date();
    }
}
