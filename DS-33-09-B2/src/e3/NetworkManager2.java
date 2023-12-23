package e3;

import java.util.*;

public class NetworkManager2 implements NetworkManager {
    Map<String,ArrayList<TopicOfInterest>> map;

    public NetworkManager2() {
        map = new LinkedHashMap<String,ArrayList<TopicOfInterest>>();
    }

    @Override
    public void addUser(String user, ArrayList<TopicOfInterest> topicsOfInterest) {
        if (!map.containsKey(user))
            map.put(user, topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        map.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if (map.containsKey(user)) {
            ArrayList<TopicOfInterest> interestsList;
            interestsList = map.get(user);
            if(!interestsList.contains(topicOfInterest))
                interestsList.add(topicOfInterest);
            map.replace(user, interestsList);
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if (map.containsKey(user)) {
            ArrayList<TopicOfInterest> interestsList;
            interestsList = map.get(user);
            interestsList.remove(topicOfInterest);
            map.replace(user, interestsList);
        }
    }
    @Override
    public ArrayList<String> getUsers(){//DIF ARRAYLIST Y LIST??
        return new ArrayList<>(map.keySet());
    }

    @Override
    public ArrayList<TopicOfInterest> getInterests(){
        ArrayList<TopicOfInterest> totalInterestsList = new ArrayList<>();
        for (String user : map.keySet()){
            ArrayList<TopicOfInterest> interestsList;
            interestsList = map.get(user);
            for (TopicOfInterest t : interestsList){
                if (!totalInterestsList.contains(t))
                    totalInterestsList.add(t);
            }
        }
        return totalInterestsList;
    }

    @Override
    public ArrayList<TopicOfInterest> getInterestsUser(String user){
        if(map.get(user)!=null)
            return new ArrayList<>(map.get(user));
        else
            return null;
    }
}
