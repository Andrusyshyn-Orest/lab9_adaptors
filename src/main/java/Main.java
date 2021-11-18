import adapters.MyFacebookUser;
import adapters.MyTwitterUser;
import analytics.ReportBuilder;
import client.MessageSender;
import facebook.FacebookUser;
import translationadapter.Authorization;
import translationadapter.DataBase;
import twitter.TwitterUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date currdate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date somedate = formatter.parse("18-11-2021 11:45:30");
        System.out.println(somedate);

        System.out.println(currdate);

        MessageSender msgsender = new MessageSender();

        TwitterUser twitterUser = new TwitterUser("orest@ucu.edu.ua", "Ukraine", somedate);
        MyTwitterUser mytwUser = new MyTwitterUser(twitterUser);
        System.out.println(msgsender.send("hello user from twitter", mytwUser, "Ukraine"));

        FacebookUser fbUser = new FacebookUser("orest@ucu.edu.ua", "Ukraine", somedate);
        MyFacebookUser myfbUser = new MyFacebookUser(fbUser);
        System.out.println(msgsender.send("hello user from facebook", myfbUser, "Ukraine"));

        DataBase db = new DataBase();
        Authorization authorization = new Authorization();
        if (authorization.authorize(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
    }
}
