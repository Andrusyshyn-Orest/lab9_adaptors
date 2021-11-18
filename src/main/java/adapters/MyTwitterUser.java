package adapters;

import facebook.FacebookUser;
import twitter.TwitterUser;

import java.util.Date;

public class MyTwitterUser implements User{
    private TwitterUser adaptee;
    public MyTwitterUser(TwitterUser twUser) {
        this.adaptee = twUser;
    }

    @Override
    public boolean send(String text, String country) {
        Date currdate = this.getCurrentDate();
        long diff = currdate.getTime() - adaptee.getLastActiveTime().getTime();
        if ( country.equals(adaptee.getCountry()) && diff <= 3_600_000L) {
            System.out.println("Twitter User " + adaptee.getUserMail() + " got new message: " + text);
            return true;
        }
        return false;
    }
}
