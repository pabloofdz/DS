package e1;

import java.util.ArrayList;

public class Colegio {
    private final ArrayList<Integrante> listaIntegrantes;

    public Colegio() {
        listaIntegrantes = new ArrayList<>();
    }

    public void añadirIntegrante (Integrante integrante) {
        listaIntegrantes.add(integrante);
    }

    public ArrayList<Integrante> getListaIntegrantes() {
        return listaIntegrantes;
    }

    public String imprimirRecompensas () {
        StringBuilder listaRecompensas = new StringBuilder();
        float recompensaTotal = 0;
        for (Integrante i : listaIntegrantes) {
            recompensaTotal = recompensaTotal + i.obtenerRecompensa();
            listaRecompensas.append(i).append(",").append(i.getHorrocruxes()).append(" horrocruxes): ")
                    .append(i.obtenerRecompensa()).append(" galeones\n");
        }
        listaRecompensas.append("La recompensa total del Colegio Hogwarts es de ").append(recompensaTotal).append(" galeones\n");
        return listaRecompensas.toString();
    }


    public String imprimirSalarios () {
        StringBuilder listaSalarios = new StringBuilder();
        int salarioTotal = 0;
        for (Integrante i : listaIntegrantes){
            if (i instanceof Personal){
                salarioTotal = salarioTotal + ((Personal) i).obtenerSalario();
                listaSalarios.append(i).append("): ").append(((Personal) i).obtenerSalario()).append(" galeones\n");
            }
        }
        listaSalarios.append("El gasto de Hogwarts en personal es de ").append(salarioTotal).append(" galeones\n");
        return listaSalarios.toString();
    }
}


