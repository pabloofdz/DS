package e1;

public class Fantasma extends Residente{

    public Fantasma(String nombre, String apellido, int edad, int horrocruxes, Residente.Casas casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
    }
    public float obtenerRecompensa() {
        float recompensa = 80 * this.getHorrocruxes();
        if (this.getCasa() == Casas.Slytherin)
            return recompensa * 2;
        else
            return recompensa;
    }

    @Override
    public String toString(){
        return getNombre() + " " + getApellido() + "(Fantasma de " + getCasa();
    }
}
