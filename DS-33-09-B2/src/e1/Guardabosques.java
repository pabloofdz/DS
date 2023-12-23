package e1;

public class Guardabosques extends Personal{
    private final boolean nocturnidad;

    public Guardabosques(String nombre, String apellido, int edad, int horrocruxes, boolean nocturnidad) {
        super(nombre, apellido, edad, horrocruxes);
        this.nocturnidad = nocturnidad;
    }

    @Override
    public int obtenerSalario() {
        if (nocturnidad)
            return 180;
        else
            return 170;
    }

    @Override
    public float obtenerRecompensa() {
        return 75 * this.getHorrocruxes();
    }

    @Override
    public String toString(){
        return getNombre() + " " + getApellido() + "(Guardabosques";
    }
}
