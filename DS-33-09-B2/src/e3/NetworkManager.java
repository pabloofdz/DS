package e3;

import java.util.ArrayList;

public interface NetworkManager {

    void addUser(String user, ArrayList<TopicOfInterest> topicsOfInterest);
    void removeUser(String user);
    void addInterest(String user, TopicOfInterest topicOfInterest);
    void removeInterest(String user, TopicOfInterest topicOfInterest);
    ArrayList<String> getUsers();
    ArrayList<TopicOfInterest> getInterests();
    ArrayList<TopicOfInterest> getInterestsUser(String user);
}
