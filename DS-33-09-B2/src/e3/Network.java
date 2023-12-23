package e3;

import java.util.ArrayList;

public class Network {
    private final NetworkManager networkManager;

    public Network(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public void addUserNetwork(String user, ArrayList<TopicOfInterest> topicsOfInterest) {
        networkManager.addUser(user, topicsOfInterest);
    }

    public void removeUserNetwork(String user) {
        networkManager.removeUser(user);
    }

    public void addInterestNetwork(String user, TopicOfInterest topicOfInterest) {
        networkManager.addInterest(user, topicOfInterest);
    }

    public void removeInterestNetwork(String user, TopicOfInterest topicOfInterest) {
        networkManager.removeInterest(user, topicOfInterest);
    }

    public ArrayList<String> getInterestedUsersNetwork(TopicOfInterest topicOfInterest) {
        ArrayList<String> interestedUsersList = new ArrayList<>();
        for (String user : networkManager.getUsers()){
            for (TopicOfInterest topic : networkManager.getInterestsUser(user)){
                if (topic.equals(topicOfInterest)){
                    interestedUsersList.add(user);
                    break;
                }
            }
        }
        return interestedUsersList;
    }

    public ArrayList<TopicOfInterest> getCommonInterestsNetwork(String user1, String user2) {
        ArrayList<TopicOfInterest> commonInterestsList = new ArrayList<>();
        if (networkManager.getUsers().contains(user1) && networkManager.getUsers().contains(user1)) {
            for (TopicOfInterest topic1 : networkManager.getInterestsUser(user1)) {
                for (TopicOfInterest topic2 : networkManager.getInterestsUser(user2)) {
                    if (topic1.equals(topic2)) {
                        commonInterestsList.add(topic1);
                        break;
                    }
                }
            }
        }
        return commonInterestsList;
    }


    public ArrayList<TopicOfInterest> getInterestsUserNetwork(String user){
        return networkManager.getInterestsUser(user);
    }

    public ArrayList<TopicOfInterest> getInterestsNetwork(){
        return networkManager.getInterests();
    }

    public String showInfoNetwork() {
        StringBuilder info = new StringBuilder();
        int cont = 0;
        for (String user : networkManager.getUsers()){
            info.append(user).append(": ");
            for (TopicOfInterest topic : networkManager.getInterestsUser(user)){
                if (cont == networkManager.getInterestsUser(user).size() - 1)
                    info.append(topic.getTopic()).append(".\n");
                else
                    info.append(topic.getTopic()).append(", ");
                cont++;
            }
            cont = 0;
        }
        return info.toString();
    }

    public String topicsListToString(ArrayList<TopicOfInterest> topicsOfInterest){
        StringBuilder list = new StringBuilder();

        for (int i = 0; i < topicsOfInterest.size(); i++){
            if(i != topicsOfInterest.size()-1)
                list.append(topicsOfInterest.get(i).getTopic().toString()).append(", ");
            else
                list.append(topicsOfInterest.get(i).getTopic().toString()).append(".");
        }
        return list.toString();
    }

    public String usersListToString(ArrayList<String> usersList){
        StringBuilder list = new StringBuilder();

        for (int i = 0; i < usersList.size(); i++){
            if(i != usersList.size()-1)
                list.append(usersList.get(i)).append(", ");
            else
                list.append(usersList.get(i)).append(".");
        }
        return list.toString();
    }

    /*public static void main(String[] args) {
        TopicOfInterest t1 = new TopicOfInterest(TopicOfInterest.Topics.Animales);
        TopicOfInterest t2 = new TopicOfInterest(TopicOfInterest.Topics.Cocina);
        TopicOfInterest t3 = new TopicOfInterest(TopicOfInterest.Topics.Fotografía);
        TopicOfInterest t4 = new TopicOfInterest(TopicOfInterest.Topics.Cine);
        TopicOfInterest t5 = new TopicOfInterest(TopicOfInterest.Topics.Videojuegos);
        TopicOfInterest t6 = new TopicOfInterest(TopicOfInterest.Topics.Motor);

        ArrayList<TopicOfInterest> interestsListM = new ArrayList<>();
        interestsListM.add(t1);
        interestsListM.add(t2);

        ArrayList<TopicOfInterest> interestsListJ = new ArrayList<>();
        interestsListJ.add(t1);
        interestsListJ.add(t3);
        interestsListJ.add(t4);

        ArrayList<TopicOfInterest> interestsListL = new ArrayList<>();
        interestsListL.add(t5);
        interestsListL.add(t6);

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.showInfoNetwork();
        System.out.println("n1.getInterestsUser(\"Manolo\") = " + n2.getInterestsUserNetwork("Manolo"));
        System.out.println("n1.getInterests() = " + n2.getInterestsNetwork());
        for (TopicOfInterest topic :  n2.getInterestsUserNetwork("Manolo")){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");
        for (TopicOfInterest topic :  n2.getInterestsNetwork()){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");

        n2.addUserNetwork("Luis", interestsListL);
        n2.showInfoNetwork();

        System.out.println("n1.getInterestedUsers(t1) = " + n2.getInterestedUsersNetwork(t1));
        n2.removeUserNetwork("Juan");
        n2.showInfoNetwork();

        n2.removeInterestNetwork("Luis", t6);
        n2.showInfoNetwork();

        n2.addInterestNetwork("Manolo", t6);
        n2.addInterestNetwork("Manolo", t5);
        n2.showInfoNetwork();

        n2.addInterestNetwork("Luis", t6);
        n2.showInfoNetwork();

        for (TopicOfInterest topic :  n2.getCommonInterestsNetwork("Manolo", "Luis")){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");
        n2.removeInterestNetwork("Luis", t6);
        n2.showInfoNetwork();


        System.out.println("---------------------------------------------------");


        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.showInfoNetwork();
        System.out.println("n1.getInterestsUser(\"Manolo\") = " + n1.getInterestsUserNetwork("Manolo"));
        System.out.println("n1.getInterests() = " + n1.getInterestsNetwork());
        for (TopicOfInterest topic :  n1.getInterestsUserNetwork("Manolo")){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");
        for (TopicOfInterest topic :  n1.getInterestsNetwork()){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");
        nm1.printMatriz();
        n1.addUserNetwork("Luis", interestsListL);
        n1.showInfoNetwork();
        nm1.printMatriz();
        System.out.println("n1.getInterestedUsers(t1) = " + n1.getInterestedUsersNetwork(t1));
        n1.removeUserNetwork("Juan");
        n1.showInfoNetwork();
        nm1.printMatriz();
        n1.removeInterestNetwork("Luis", t6);
        n1.showInfoNetwork();
        nm1.printMatriz();
        n1.addInterestNetwork("Manolo", t6);
        n1.addInterestNetwork("Manolo", t5);
        n1.showInfoNetwork();
        nm1.printMatriz();
        n1.addInterestNetwork("Luis", t6);
        n1.showInfoNetwork();
        nm1.printMatriz();
        for (TopicOfInterest topic :  n1.getCommonInterestsNetwork("Manolo", "Luis")){
            System.out.print(topic.getTopic() + " ");
        }
        System.out.println("\n");
        n1.removeInterestNetwork("Luis", t6);
        n1.showInfoNetwork();
        nm1.printMatriz();
    }*/
}
