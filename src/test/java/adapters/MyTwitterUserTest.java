package adapters;

import twitter.TwitterUser;

import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class MyTwitterUserTest {
    private TwitterUser twUserInTime;
    private TwitterUser twUserOutTime;
    private MyTwitterUser mytwUserinTime;
    private MyTwitterUser mytwUserOutTime;
    private Date inTime;
    private Date outTime;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Date currdate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currdate);
        cal.add(Calendar.MINUTE, -30);
        inTime = cal.getTime();
        cal.add(Calendar.MINUTE, -120);
        outTime = cal.getTime();


        twUserInTime = new TwitterUser("orest@ucu.edu.ua", "Ukraine", inTime);
        twUserOutTime = new TwitterUser("orest@ucu.edu.ua", "Ukraine", outTime);

        mytwUserinTime = new MyTwitterUser(twUserInTime);
        mytwUserOutTime = new MyTwitterUser(twUserOutTime);
    }

    @org.junit.jupiter.api.Test
    void send() {
        assertTrue(mytwUserinTime.send("Hello orest", "Ukraine"));
        assertFalse(mytwUserOutTime.send("Hello orest", "Ukraine"));
    }
}