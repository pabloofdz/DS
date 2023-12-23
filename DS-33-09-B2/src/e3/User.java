package e3;

import java.util.ArrayList;

public class User {
    private final String username;
    private final ArrayList<TopicOfInterest> userInterests;

    public User(String username) {
        this.username = username;
        userInterests = new ArrayList<TopicOfInterest>();
    }

    public void addUserInterest (TopicOfInterest interest) {
        userInterests.add(interest);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<TopicOfInterest> getUserInterests() {
        return userInterests;
    }
}
