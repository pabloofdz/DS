package e1;

public abstract class Personal extends Integrante{

    public Personal(String nombre, String apellido, int edad, int horrocruxes) {
        super(nombre, apellido, edad, horrocruxes);

    }

    public abstract int obtenerSalario ();
    public abstract float obtenerRecompensa ();
}
