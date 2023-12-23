package e1;

public class Docente extends Personal{
    public enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones}
    public Asignaturas asignatura;

    public Docente(String nombre, String apellido, int edad, int horrocruxes, Asignaturas asignatura) {
        super(nombre, apellido, edad, horrocruxes);
        this.asignatura = asignatura;
    }

    @Override
    public int obtenerSalario() {
        if (this.asignatura == Asignaturas.Historia)
            return 200;
        else if (this.asignatura == Asignaturas.Transformaciones)
            return 400;
        else if (this.asignatura == Asignaturas.Defensa)
            return 500;
        else if (this.asignatura == Asignaturas.Herbologia)
            return 250;
        else
            return 350;
    }
    @Override
    public float obtenerRecompensa() {
        float recompensa = 50 * this.getHorrocruxes();
        if (this.asignatura == Asignaturas.Defensa)
            return recompensa * 75 / 100;
        else
            return recompensa;
    }

    @Override
    public String toString(){
        return getNombre() + " " + getApellido() + "(Docente de " + asignatura;
    }
}
