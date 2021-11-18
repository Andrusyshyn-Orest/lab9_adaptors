package adapters;

import facebook.FacebookUser;

import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class MyFacebookUserTest {
    private FacebookUser fbUserInTime;
    private FacebookUser fbUserOutTime;
    private MyFacebookUser myfbUserinTime;
    private MyFacebookUser myfbUserOutTime;
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


        fbUserInTime = new FacebookUser("orest@ucu.edu.ua", "Ukraine", inTime);
        fbUserOutTime = new FacebookUser("orest@ucu.edu.ua", "Ukraine", outTime);

        myfbUserinTime = new MyFacebookUser(fbUserInTime);
        myfbUserOutTime = new MyFacebookUser(fbUserOutTime);
    }

    @org.junit.jupiter.api.Test
    void send() {
        assertTrue(myfbUserinTime.send("Hello orest", "Ukraine"));
        assertFalse(myfbUserOutTime.send("Hello orest", "Ukraine"));
    }
}