package e1;

public class Conserje extends Personal{
    private final boolean nocturnidad;

    public Conserje(String nombre, String apellido, int edad, int horrocruxes, boolean nocturnidad) {
        super(nombre, apellido, edad, horrocruxes);
        this.nocturnidad = nocturnidad;
    }

    @Override
    public int obtenerSalario() {
        if (nocturnidad)
            return 160;
        else
            return 150;
    }

    public float obtenerRecompensa() {
        return 65 * this.getHorrocruxes();
    }

    @Override
    public String toString(){
        return getNombre() + " " + getApellido() + "(Conserje";
    }
}
