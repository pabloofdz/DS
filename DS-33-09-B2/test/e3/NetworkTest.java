package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {
    private TopicOfInterest t1;
    private TopicOfInterest t2;
    private TopicOfInterest t3;
    private TopicOfInterest t4;
    private TopicOfInterest t5;
    private TopicOfInterest t6;
    private TopicOfInterest t7;
    private ArrayList<TopicOfInterest> interestsListM;
    private ArrayList<TopicOfInterest> interestsListJ;
    private ArrayList<TopicOfInterest> interestsListL;

    @BeforeEach
    void setUp() {
        //Creamos listas de intereses para tres usuarios (Manolo, Juan y Luis)
        //--------------------------------------------------------------------------------------------------------------
        t1 = new TopicOfInterest(TopicOfInterest.Topics.Animales);
        t2 = new TopicOfInterest(TopicOfInterest.Topics.Cocina);
        t3 = new TopicOfInterest(TopicOfInterest.Topics.Fotografía);
        t4 = new TopicOfInterest(TopicOfInterest.Topics.Cine);
        t5 = new TopicOfInterest(TopicOfInterest.Topics.Videojuegos);
        t6 = new TopicOfInterest(TopicOfInterest.Topics.Motor);
        t7 = new TopicOfInterest(TopicOfInterest.Topics.Bricolaje);

        interestsListM = new ArrayList<>();
        interestsListM.add(t1);
        interestsListM.add(t2);

        interestsListJ = new ArrayList<>();
        interestsListJ.add(t1);
        interestsListJ.add(t3);
        interestsListJ.add(t4);

        interestsListL = new ArrayList<>();
        interestsListL.add(t5);
        interestsListL.add(t6);
    }

    @Test
    void addUserNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());
    }

    @Test
    void removeUserNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.removeUserNetwork("Manolo");
        assertEquals("Juan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());
        n1.removeUserNetwork("Pedro");
        assertEquals("Juan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());
        n1.removeUserNetwork("Juan");
        assertEquals("", n1.showInfoNetwork());
        n1.removeUserNetwork("Pedro");
        assertEquals("", n1.showInfoNetwork());


        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.removeUserNetwork("Manolo");
        assertEquals("Juan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());
        n2.removeUserNetwork("Pedro");
        assertEquals("Juan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());
        n2.removeUserNetwork("Juan");
        assertEquals("", n2.showInfoNetwork());
        n2.removeUserNetwork("Pedro");
        assertEquals("", n2.showInfoNetwork());
    }

    @Test
    void addInterestNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.addInterestNetwork("Manolo", t6);
        n1.addInterestNetwork("Manolo", t5);
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nJuan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());
        n1.addInterestNetwork("Manolo", t5);
        n1.addInterestNetwork("Antonia", t4);
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nJuan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.addInterestNetwork("Manolo", t6);
        n2.addInterestNetwork("Manolo", t5);
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nJuan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());
        n2.addInterestNetwork("Manolo", t5);
        n2.addInterestNetwork("Antonia", t4);
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nJuan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());
    }

    @Test
    void removeInterestNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.removeInterestNetwork("Manolo", t1);
        n1.removeInterestNetwork("Juan", t4);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n1.showInfoNetwork());
        n1.removeInterestNetwork("Juan", t4);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n1.showInfoNetwork());
        n1.removeInterestNetwork("Pedro", t2);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n1.showInfoNetwork());

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.removeInterestNetwork("Manolo", t1);
        n2.removeInterestNetwork("Juan", t4);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n2.showInfoNetwork());
        n2.removeInterestNetwork("Juan", t4);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n2.showInfoNetwork());
        n2.removeInterestNetwork("Pedro", t2);
        assertEquals("Manolo: Cocina.\nJuan: Animales, Fotografía.\n", n2.showInfoNetwork());
    }

    @Test
    void getInterestedUsersNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        assertEquals("", n1.usersListToString(n1.getInterestedUsersNetwork(t1)));
        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        assertEquals("Manolo, Juan.", n1.usersListToString(n1.getInterestedUsersNetwork(t1)));
        assertEquals("", n1.usersListToString(n1.getInterestedUsersNetwork(t6)));

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        assertEquals("", n2.usersListToString(n2.getInterestedUsersNetwork(t1)));
        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        assertEquals("Manolo, Juan.", n2.usersListToString(n2.getInterestedUsersNetwork(t1)));
        assertEquals("", n2.usersListToString(n2.getInterestedUsersNetwork(t6)));

    }

    @Test
    void getCommonInterestsNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        assertEquals("", n1.topicsListToString(n1.getCommonInterestsNetwork("Manolo", "Luis")));
        //Añadimos a Manolo, Juan y a Luis
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.addUserNetwork("Luis", interestsListL);
        assertEquals("Animales.", n1.topicsListToString(n1.getCommonInterestsNetwork("Manolo", "Juan")));
        assertEquals("", n1.topicsListToString(n1.getCommonInterestsNetwork("Manolo", "Luis")));

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        assertEquals("", n2.topicsListToString(n2.getCommonInterestsNetwork("Manolo", "Luis")));
        //Añadimos a Manolo, Juan y a Luis
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.addUserNetwork("Luis", interestsListL);
        assertEquals("Animales.", n2.topicsListToString(n2.getCommonInterestsNetwork("Manolo", "Juan")));
        assertEquals("", n2.topicsListToString(n2.getCommonInterestsNetwork("Manolo", "Luis")));
    }

    @Test
    void getInterestsNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        assertEquals("", n1.topicsListToString(n1.getCommonInterestsNetwork("Manolo", "Luis")));
        //Añadimos a Manolo, Juan y a Luis
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);
        n1.addUserNetwork("Luis", interestsListL);
        //Añadimos además un topic a un usuario que no existe
        n1.addInterestNetwork("Antonia", t7);
        assertEquals("Animales, Cocina, Fotografía, Cine, Videojuegos, Motor.", n1.topicsListToString(n1.getInterestsNetwork()));
        n1.removeInterestNetwork("Antonia", t1);
        assertEquals("Animales, Cocina, Fotografía, Cine, Videojuegos, Motor.", n1.topicsListToString(n1.getInterestsNetwork()));

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        assertEquals("", n2.topicsListToString(n2.getCommonInterestsNetwork("Manolo", "Luis")));
        //Añadimos a Manolo, Juan y a Luis
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);
        n2.addUserNetwork("Luis", interestsListL);
        //Añadimos además un topic a un usuario que no existe
        n2.addInterestNetwork("Antonia", t7);
        assertEquals("Animales, Cocina, Fotografía, Cine, Videojuegos, Motor.", n2.topicsListToString(n2.getInterestsNetwork()));
        n2.removeInterestNetwork("Antonia", t1);
        assertEquals("Animales, Cocina, Fotografía, Cine, Videojuegos, Motor.", n2.topicsListToString(n2.getInterestsNetwork()));
    }

    @Test
    void getInterestsUserNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        ArrayList<TopicOfInterest> interestsListX = new ArrayList<>();
        ArrayList<TopicOfInterest> interestsListY = new ArrayList<>();
        //Añadimos a Manolo
        n1.addUserNetwork("Manolo", interestsListX);
        assertEquals(interestsListY, n1.getInterestsUserNetwork("Manolo"));
        n1.addInterestNetwork("Manolo", t7);
        interestsListY.add(t7);
        assertEquals(interestsListY, n1.getInterestsUserNetwork("Manolo"));
        assertNull(n1.getInterestsUserNetwork("Juan"));

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        ArrayList<TopicOfInterest> interestsListX2 = new ArrayList<>();
        ArrayList<TopicOfInterest> interestsListY2 = new ArrayList<>();
        //Añadimos a Manolo
        n2.addUserNetwork("Manolo", interestsListX2);
        assertEquals(interestsListY2, n2.getInterestsUserNetwork("Manolo"));
        n2.addInterestNetwork("Manolo", t7);
        interestsListY2.add(t7);
        assertEquals(interestsListY2, n2.getInterestsUserNetwork("Manolo"));
        assertNull(n2.getInterestsUserNetwork("Juan"));


    }

    @Test
    void showInfoNetwork() {
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        assertEquals("", n1.showInfoNetwork());
        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        assertEquals("Manolo: Animales, Cocina.\n", n1.showInfoNetwork());

        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        assertEquals("", n2.showInfoNetwork());
        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        assertEquals("Manolo: Animales, Cocina.\n", n2.showInfoNetwork());
    }

    @Test
    void testNetworkManager1() {
        //Usando la implementación con hashmap
        //--------------------------------------------------------------------------------------------------------------
        NetworkManager2 nm2 = new NetworkManager2();
        Network n2 = new Network(nm2);

        //Añadimos a Manolo y a Juan
        n2.addUserNetwork("Manolo", interestsListM);
        n2.addUserNetwork("Juan", interestsListJ);

        //Comprobamos que showInfoNetwork() funciona correctamente y que los usuarios se han añadido
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\n", n2.showInfoNetwork());

        //Comprobamos que getInterestsUserNetwork(String user) funciona correctamente
        assertEquals("Animales, Cocina.", n2.topicsListToString(n2.getInterestsUserNetwork("Manolo")));

        //Comprobamos que n2.getInterestsNetwork() funciona correctamente
        assertEquals("Animales, Cocina, Fotografía, Cine.", n2.topicsListToString(n2.getInterestsNetwork()));

        //Añadimos a Luis
        n2.addUserNetwork("Luis", interestsListL);

        //Comprobamos que showInfoNetwork() funciona correctamente y que Luis ha sido añadido
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\nLuis: Videojuegos, Motor.\n",
                n2.showInfoNetwork());

        //Comprobamos que getInterestedUsersNetwork(TopicOfInterest topicOfInterest) funciona correctamente
        assertEquals("Manolo, Juan.", n2.usersListToString(n2.getInterestedUsersNetwork(t1)));

        //Eliminamos a Juan
        n2.removeUserNetwork("Juan");

        //Comprobamos que showInfoNetwork() funciona correctamente y que Juan ha sido eliminado
        assertEquals("Manolo: Animales, Cocina.\nLuis: Videojuegos, Motor.\n", n2.showInfoNetwork());

        //Eliminamos el tema "Motor" de la lista de intereses de Luis
        n2.removeInterestNetwork("Luis", t6);

        //Comprobamos que "Motor" ha sido eliminado de la lista de intereses de Luis
        assertEquals("Videojuegos.", n2.topicsListToString(n2.getInterestsUserNetwork("Luis")));

        //Comprobamos que "Motor" ha sido eliminado de la lista de intereses total
        assertEquals("Animales, Cocina, Videojuegos.", n2.topicsListToString(n2.getInterestsNetwork()));

        //Añadimos los temas "Motor" y "Videojuegos" a la lista de intereses de Manolo
        n2.addInterestNetwork("Manolo", t6);
        n2.addInterestNetwork("Manolo", t5);

        //Comprobamos que showInfoNetwork() funciona correctamente y los temas han sido añadidos a la lista de intereses de Manolo
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nLuis: Videojuegos.\n", n2.showInfoNetwork());

        //Añadimos el tema "Motor" a la lista de intereses de Luis
        n2.addInterestNetwork("Luis", t6);

        //Comprobamos que showInfoNetwork() funciona correctamente y el tema "Motor" ha sido añadido a la lista de intereses de Luis
        assertEquals("Manolo: Animales, Cocina, Motor, Videojuegos.\nLuis: Videojuegos, Motor.\n", n2.showInfoNetwork());

        //Comprobamos que getCommonInterestsNetwork(String user1, String user2) funciona correctamente
        assertEquals("Motor, Videojuegos.", n2.topicsListToString(n2.getCommonInterestsNetwork("Manolo", "Luis")));

        //Eliminamos el tema "Motor" de la lista de intereses de Luis
        n2.removeInterestNetwork("Luis", t6);

        //Añadimos además un topic a un usuario que no existe
        n2.addInterestNetwork("Antonia", t3);

        //Comprobamos que, en este caso, "Motor" no ha sido eliminado de la lista de intereses total
        assertEquals("Animales, Cocina, Motor, Videojuegos.", n2.topicsListToString(n2.getInterestsNetwork()));

    }
    @Test
    void testNetworkManager2() {
        //Usando la implementación con matriz
        //--------------------------------------------------------------------------------------------------------------
        NetworkManager1 nm1 = new NetworkManager1();
        Network n1 = new Network(nm1);

        //Añadimos a Manolo y a Juan
        n1.addUserNetwork("Manolo", interestsListM);
        n1.addUserNetwork("Juan", interestsListJ);

        //Comprobamos que showInfoNetwork() funciona correctamente y que los usuarios se han añadido
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\n", n1.showInfoNetwork());

        //Comprobamos que getInterestsUserNetwork(String user) funciona correctamente
        assertEquals("Animales, Cocina.", n1.topicsListToString(n1.getInterestsUserNetwork("Manolo")));

        //Comprobamos que n2.getInterestsNetwork() funciona correctamente
        assertEquals("Animales, Cocina, Fotografía, Cine.", n1.topicsListToString(n1.getInterestsNetwork()));

        //Añadimos a Luis
        n1.addUserNetwork("Luis", interestsListL);

        //Comprobamos que showInfoNetwork() funciona correctamente y que Luis ha sido añadido
        assertEquals("Manolo: Animales, Cocina.\nJuan: Animales, Fotografía, Cine.\nLuis: Videojuegos, Motor.\n",
                n1.showInfoNetwork());

        //Comprobamos que getInterestedUsersNetwork(TopicOfInterest topicOfInterest) funciona correctamente
        assertEquals("Manolo, Juan.", n1.usersListToString(n1.getInterestedUsersNetwork(t1)));

        //Eliminamos a Juan
        n1.removeUserNetwork("Juan");

        //Comprobamos que showInfoNetwork() funciona correctamente y que Juan ha sido eliminado
        assertEquals("Manolo: Animales, Cocina.\nLuis: Videojuegos, Motor.\n", n1.showInfoNetwork());

        //Eliminamos el tema "Motor" de la lista de intereses de Luis
        n1.removeInterestNetwork("Luis", t6);

        //Comprobamos que "Motor" ha sido eliminado de la lista de intereses de Luis
        assertEquals("Videojuegos.", n1.topicsListToString(n1.getInterestsUserNetwork("Luis")));

        //Comprobamos que "Motor" ha sido eliminado de la lista de intereses total
        assertEquals("Animales, Cocina, Videojuegos.", n1.topicsListToString(n1.getInterestsNetwork()));

        //Añadimos los temas "Motor" y "Videojuegos" a la lista de intereses de Manolo
        n1.addInterestNetwork("Manolo", t6);
        n1.addInterestNetwork("Manolo", t5);

        //Comprobamos que showInfoNetwork() funciona correctamente y los temas han sido añadidos a la lista de intereses de Manolo
        assertEquals("Manolo: Animales, Cocina, Videojuegos, Motor.\nLuis: Videojuegos.\n", n1.showInfoNetwork());

        //Añadimos el tema "Motor" a la lista de intereses de Luis
        n1.addInterestNetwork("Luis", t6);

        //Comprobamos que showInfoNetwork() funciona correctamente y el tema "Motor" ha sido añadido a la lista de intereses de Luis
        assertEquals("Manolo: Animales, Cocina, Videojuegos, Motor.\nLuis: Videojuegos, Motor.\n", n1.showInfoNetwork());

        //Comprobamos que getCommonInterestsNetwork(String user1, String user2) funciona correctamente
        assertEquals("Videojuegos, Motor.", n1.topicsListToString(n1.getCommonInterestsNetwork("Manolo", "Luis")));

        //Eliminamos el tema "Motor" de la lista de intereses de Luis
        n1.removeInterestNetwork("Luis", t6);

        //Añadimos además un topic a un usuario que no existe
        n1.addInterestNetwork("Antonia", t3);

        //Comprobamos que, en este caso, "Motor" no ha sido eliminado de la lista de intereses total
        assertEquals("Animales, Cocina, Videojuegos, Motor.", n1.topicsListToString(n1.getInterestsNetwork()));
    }
}