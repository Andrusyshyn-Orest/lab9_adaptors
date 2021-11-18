package client;

import adapters.User;

public class MessageSender {
    public boolean send(String text, User user, String country) {
        return user.send(text, country);
    };
}
