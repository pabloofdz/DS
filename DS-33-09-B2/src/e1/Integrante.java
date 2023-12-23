package e1;

public abstract class Integrante {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final int horrocruxes;

    public Integrante(String nombre, String apellido, int edad, int horrocruxes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horrocruxes = horrocruxes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getHorrocruxes() {
        return horrocruxes;
    }

    public abstract float obtenerRecompensa ();
}
