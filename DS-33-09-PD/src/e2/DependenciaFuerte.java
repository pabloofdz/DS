package e2;

import java.util.ArrayList;
import java.util.List;

public class DependenciaFuerte implements RealizacionTareas {
    @Override
    public List<Tarea> realiza(Tareas tareas){
        int i = 0;
        Tarea t;
        List<Tarea> loriginal = new ArrayList<>();//Hacemos una copia de la lista original para poder resetearla y
                                                  // así realizar las tareas de otra forma.
        for (Tarea tar : tareas.getListaTareas()) {
            Tarea tar2 = new Tarea(tar.getNombre());
            List<String> ldep = new ArrayList<>(tar.getListaDependencias());
            tar2.setListaDependencias(ldep);
            loriginal.add(tar2);
        }
        List<Tarea> tareasRealizadas = new ArrayList<>();
        for (i = 0; i < tareas.getListaTareas().size(); i++) {
            t = tareas.getListaTareas().get(i);
            if (t.getListaDependencias().isEmpty()){
                tareas.eliminarTarea(t);
                for (Tarea t2:tareas.getListaTareas()) {
                    t2.eliminarDependencia(t.getNombre());
                }
                tareasRealizadas.add(t);
                i = -1;
            }
        }
        tareas.setListaTareas(loriginal);
        return tareasRealizadas;
    }
}
