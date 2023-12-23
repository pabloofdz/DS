package e1;

import java.util.ArrayList;
import java.util.List;

public class API {
    private List<Billete> listaBilletes;

    public API() {
        this.listaBilletes = new ArrayList<>();
    }

    public List<Billete> getListaBilletes() {
        return listaBilletes;
    }

    public void añadirBillete (Billete billete) {
        listaBilletes.add(billete);
    }

    public void eliminarBillete (Billete billete) { listaBilletes.remove(billete); }

    public List<Billete> buscarBilletes(Buscar busquedaBilletes) {
        return busquedaBilletes.buscar(listaBilletes);
    }

    public String listaBilletes (List<Billete> l){
        StringBuilder lBilletes = new StringBuilder();
        for (Billete b : l){
                lBilletes.append("Origen: ").append(b.getOrigen())
                    .append("; Destino: ").append(b.getDestino()).append("; Precio: ")
                    .append(b.getPrecio()).append("; Fecha: ").append(b.getFecha()).append(".\n");
        }
        return lBilletes.toString();
    }
}
