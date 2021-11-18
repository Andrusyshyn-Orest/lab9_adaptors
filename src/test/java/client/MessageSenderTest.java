package client;

import adapters.MyFacebookUser;
import adapters.MyTwitterUser;
import facebook.FacebookUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter.TwitterUser;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {
    private TwitterUser twUserInTime;
    private TwitterUser twUserOutTime;
    private MyTwitterUser mytwUserinTime;
    private MyTwitterUser mytwUserOutTime;

    private FacebookUser fbUserInTime;
    private FacebookUser fbUserOutTime;
    private MyFacebookUser myfbUserinTime;
    private MyFacebookUser myfbUserOutTime;

    private Date inTime;
    private Date outTime;

    private MessageSender sender = new MessageSender();


    @BeforeEach
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

        fbUserInTime = new FacebookUser("orest@ucu.edu.ua", "Ukraine", inTime);
        fbUserOutTime = new FacebookUser("orest@ucu.edu.ua", "Ukraine", outTime);

        myfbUserinTime = new MyFacebookUser(fbUserInTime);
        myfbUserOutTime = new MyFacebookUser(fbUserOutTime);
    }

    @Test
    void send() {
        assertTrue(sender.send("Hello orest", myfbUserinTime, "Ukraine"));
        assertTrue(sender.send("Hello orest", mytwUserinTime, "Ukraine"));

        assertFalse(sender.send("Hello orest", myfbUserOutTime, "Ukraine"));
        assertFalse(sender.send("Hello orest", mytwUserOutTime, "Ukraine"));

    }
}