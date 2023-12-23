package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class gestionApartamentos {
    private final ArrayList<Apartamento> listaApartamentos;
    private Comparator<Apartamento> criterioComp;

    public ArrayList<Apartamento> getListaApartamentos() {
        return listaApartamentos;
    }

    public Comparator<Apartamento> getCriterioComp() {
        return criterioComp;
    }

    public gestionApartamentos() {
        listaApartamentos = new ArrayList<>();
        criterioComp = null;
    }

    public void cambiarCriterioComp (Comparator<Apartamento> comparator){
        criterioComp = comparator;
    }

    public void añadirApartamento (Apartamento apartamento) {
        listaApartamentos.add(apartamento);
    }

    public String listaOrdenada (){
        StringBuilder listaOrdenada = new StringBuilder();
        if (criterioComp == null)
            Collections.sort(listaApartamentos);
        else
            Collections.sort(listaApartamentos, criterioComp);
        int i = 1;
        for (Apartamento a : listaApartamentos){
            listaOrdenada.append(i).append(". Núm. de referencia: ").append(a.getnRef())
                    .append("; Precio base: ").append(a.getPrecioBase()).append("; Tamaño: ")
                    .append(a.getTamaño()).append("; Dirección: C/").append(a.getCalle())
                    .append(", Nº").append(a.getNumero()).append(", ")
                    .append(a.getPiso()).append("º ").append(a.getPuerta())
                    .append(", CP: ").append(a.getcPostal()).append("; Núm. de habitaciones: ")
                    .append(a.getnHabitaciones()).append("; Núm. de baños: ").append(a.getnBaños())
                    .append("; Precios de las plazas: ").append(a.getPreciosPlazas()).append(".\n");

            i++;
        }
        return listaOrdenada.toString();
    }
}
