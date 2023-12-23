package e2;

import java.util.ArrayList;
import java.util.List;

public class OrdenJerarquico implements RealizacionTareas {

    public boolean contieneTarea(List<Tarea> ltareas1, List<String> ltareas2){
        boolean contiene = false;
        for (Tarea t : ltareas1) {
            if(ltareas2.contains(t.getNombre())) {
                contiene = true;
                break;
            }
        }
        return contiene;
    }

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
        List<Tarea> tareasRPorNivel = new ArrayList<>();
        List<Tarea> tareasRealizadas = new ArrayList<>();
        for (i = 0; i < tareas.getListaTareas().size(); i++) {
            t = tareas.getListaTareas().get(i);
            if (t.getListaDependencias().isEmpty() || contieneTarea(tareasRPorNivel, t.getListaDependencias())){
                tareas.eliminarTarea(t);
                i--;
                tareasRealizadas.add(t);
            }
            if(i == tareas.getListaTareas().size()-1 && !tareas.getListaTareas().isEmpty()){
                tareasRPorNivel.addAll(tareasRealizadas);
                i = -1;
            }
        }
        tareas.setListaTareas(loriginal);
        return tareasRealizadas;

    }

}
