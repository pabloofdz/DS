package e3;

import java.util.ArrayList;
//import java.util.List;

public class NetworkManager1 implements NetworkManager{
    private final ArrayList<String> usersList;
    private final ArrayList<TopicOfInterest> interestsList;
    private final int[][] matriz;

    public NetworkManager1() {
        usersList = new ArrayList<>();
        interestsList = new ArrayList<>();
        matriz = new int[100][100];
    }

    @Override
    public void addUser(String user, ArrayList<TopicOfInterest> topicsOfInterest){ //Se puede usar ArrayList en lugar de List
        int i, j, k, a, b, size;
        size = interestsList.size();
        if(!usersList.contains(user)) {
            usersList.add(user);
            for (TopicOfInterest t : topicsOfInterest) {
                if (!interestsList.contains(t))
                    interestsList.add(t);
            }
            i = usersList.size() - 1;
            for (a = 0; a < i; a++) {
                for (b = size; b < interestsList.size(); b++)
                    matriz[a][b] = 0;
            }
            for (j = 0; j < interestsList.size(); j++) {
                matriz[i][j] = 0;
                for (k = 0; k < topicsOfInterest.size(); k++) {
                    if (interestsList.get(j) == topicsOfInterest.get(k))
                        matriz[i][j] = 1;
                }
            }
        }
    }

    @Override
    public void removeUser(String user){
        if(usersList.contains(user)) {
            User u = new User(user);
            int i, j, k, l, a, b;
            i = usersList.indexOf(user);
            for (j = 0; j < interestsList.size(); j++) {
                if (matriz[i][j] == 1)
                    u.addUserInterest(interestsList.get(j));
            }

            for (TopicOfInterest t: u.getUserInterests()){
                k = interestsList.indexOf(t);
                for (l = 0; l < usersList.size(); l++){
                    if(matriz[l][k] != 0 && l != i)
                        break;
                }
                if (l == usersList.size()){
                    interestsList.remove(k);
                    for(a = 0; a < usersList.size(); a++){
                        for(b = k; b < interestsList.size(); b++){
                            matriz[a][b] = matriz[a][b+1];
                        }
                    }
                }
            }
            usersList.remove(i);
            for(a = i; a < usersList.size(); a++){
                for(b = 0; b < interestsList.size(); b++){
                    matriz[a][b] = matriz[a+1][b];
                }
            }
        }
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        int i, j, a, b, size;
        if(usersList.contains(user)) {
            if(interestsList.contains(topicOfInterest)) {
                User u = new User(user);
                i = usersList.indexOf(user);
                for (j = 0; j < interestsList.size(); j++) {
                    if (interestsList.get(j) == topicOfInterest && matriz[i][j] == 0)
                        matriz[i][j] = 1;
                }
            } else {
                size = interestsList.size();
                i = usersList.indexOf(user);
                interestsList.add(topicOfInterest);
                for (a = 0; a < usersList.size(); a++) {
                    if (a == i)
                        matriz[a][size] = 1;
                    else
                        matriz[a][size] = 0;
                }
            }
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int a, b, i, k, l;
        if(usersList.contains(user)) {
            if(interestsList.contains(topicOfInterest)) {
                i = usersList.indexOf(user);
                k = interestsList.indexOf(topicOfInterest);
                for (l = 0; l < usersList.size(); l++){
                    if(matriz[l][k] != 0 && l != i) {
                        matriz[i][k] = 0;
                        break;
                    }
                }
                if (l == usersList.size()) {
                    interestsList.remove(k);
                    for (a = 0; a < usersList.size(); a++) {
                        for (b = k; b < interestsList.size(); b++) {
                            matriz[a][b] = matriz[a][b + 1];
                        }
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<String> getUsers(){
        return usersList;
    }

    @Override
    public ArrayList<TopicOfInterest> getInterests(){
        return interestsList;
    }

    @Override
    public ArrayList<TopicOfInterest> getInterestsUser(String user){
        if(usersList.contains(user)) {
            User u = new User(user);
            int i, j;
            i = usersList.indexOf(user);
            for (j = 0; j < interestsList.size(); j++) {
                if (matriz[i][j] == 1)
                    u.addUserInterest(interestsList.get(j));
            }
            return u.getUserInterests();
        }
        return null;
    }

    public void printMatriz() {
        int i, j;
        for(i = 0; i < usersList.size(); i++){
            for(j = 0; j < interestsList.size(); j++){
                System.out.print(matriz[i][j] + " ");
                if (j == interestsList.size()-1)
                    System.out.print("\n");
            }
        }
    }
}
