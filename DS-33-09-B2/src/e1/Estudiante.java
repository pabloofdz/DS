package e1;

public class Estudiante extends Residente{

    public Estudiante(String nombre, String apellido, int edad, int horrocruxes, Casas casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
    }

    public float obtenerRecompensa() {
        float recompensa = 90 * this.getHorrocruxes();
        if (this.getCasa() == Casas.Slytherin)
            return recompensa * 2;
        else
            return recompensa;
    }

    @Override
    public String toString(){
        return getNombre() + " " + getApellido() + "(Estudiante de " + getCasa();
    }

}
