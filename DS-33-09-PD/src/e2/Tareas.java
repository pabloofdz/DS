package e2;

import java.util.ArrayList;
import java.util.List;

public class Tareas {
    private List<Tarea> listaTareas;
    private RealizacionTareas realizacion;

    public Tareas() {
        listaTareas = new ArrayList<>();
    }

    public void añadirTarea(Tarea t1, Tarea t2) {//Añade en la lista tareas con sus dependencias por orden alfabético.
        int i = 0;
        boolean esta = false;
        if (!listaTareas.isEmpty()) {
            for (Tarea t : listaTareas) {
                if (t1.getNombre().compareTo(t.getNombre()) == 0) {
                    esta = true;
                    if (t2 != null)
                        t.añadirDependencia(t2.getNombre());
                    break;
                }
            }
            if (!esta){
                for (Tarea t : listaTareas) {
                    if (t1.getNombre().compareTo(t.getNombre()) < 0) {
                        listaTareas.add(i, t1);
                        break;
                    }
                    if (i == listaTareas.size() - 1) {
                        listaTareas.add(t1);
                        break;
                    }
                    i++;
                }
            }
        }else
            listaTareas.add(t1);

    }

    public void añadirTareaDep(String tareaDep){
        if(!tareaDep.matches("[A-Z]{1}\s->\s[A-Z]{1}"))
            throw new IllegalArgumentException("El formato de la entrada no es válido.");
        else {
            String[] tareaDeps = tareaDep.split(" -> ");
            Tarea t1 = new Tarea(tareaDeps[0]);
            Tarea t2 = new Tarea(tareaDeps[1]);
            t2.añadirDependencia(t1.getNombre());
            añadirTarea(t1, null);
            añadirTarea(t2, t1);
        }
    }

    public void eliminarTarea(Tarea tarea) {
        listaTareas.remove(tarea);
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public RealizacionTareas getRealizacion() {
        return realizacion;
    }

    public void setRealizacion(RealizacionTareas realizacion) {
        this.realizacion = realizacion;
    }

    public List<Tarea> realizaTareas() {
        return realizacion.realiza(this);
    }

    public String listaTareas(List<Tarea> ltareas) {
        StringBuilder tareasRealizadas = new StringBuilder();
        int i = 0;
        for (Tarea t : ltareas) {
            if(i == ltareas.size()-1)
                tareasRealizadas.append(t.getNombre()).append("\n");
            else{
                tareasRealizadas.append(t.getNombre()).append(" - ");
                i++;
            }

        }
        return tareasRealizadas.toString();
    }

    public String toString() {
        StringBuilder tareasRealizadas = new StringBuilder();
        int i = 0;
        for (Tarea t : listaTareas) {
            if(i == listaTareas.size()-1)
                tareasRealizadas.append(t.getNombre()).append("\n");
            else{
                tareasRealizadas.append(t.getNombre()).append(" - ");
                i++;
            }

        }
        return tareasRealizadas.toString();
    }
}
