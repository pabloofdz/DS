package e2;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private final String nombre;
    private List<String> listaDependencias;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.listaDependencias = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void añadirDependencia(String tarea) {
        listaDependencias.add(tarea);
    }

    public void eliminarDependencia(String tarea) {
        listaDependencias.remove(tarea);
    }

    public void eliminarDependencias() {
        listaDependencias.clear();
    }

    public List<String> getListaDependencias() {
        return listaDependencias;
    }

    public void setListaDependencias(List<String> listaDependencias) {
        this.listaDependencias = listaDependencias;
    }
}
