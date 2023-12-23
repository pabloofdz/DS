package e1;

public abstract class Residente extends Integrante {
    enum Casas {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}
    private final Casas casa;

    public Residente(String nombre, String apellido, int edad, int horrocruxes, Casas casa) {
        super(nombre, apellido, edad, horrocruxes);
        this.casa = casa;
    }

    public Casas getCasa() {
        return casa;
    }
}
