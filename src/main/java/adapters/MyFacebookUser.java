package adapters;

import facebook.FacebookUser;

import java.util.Date;

public class MyFacebookUser implements User{
    private FacebookUser adaptee;
    public MyFacebookUser(FacebookUser fbUser) {
        this.adaptee = fbUser;
    }

    @Override
    public boolean send(String text, String country) {
        Date currdate = this.getCurrentDate();
        long diff = currdate.getTime() - adaptee.getUserActiveTime().getTime();
        if ( country.equals(adaptee.getUserCountry()) && diff <= 3_600_000L) {
            System.out.println("Facebook User " + adaptee.getEmail() + " got new message: " + text);
            return true;
        }
        return false;
    }
}
