package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscarPorOrigen implements Buscar {
    private String origen;

    public BuscarPorOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public List<Billete> buscar(List<Billete> listaBilletes) {
        List<Billete> listaBilletes2 = new ArrayList<>();
        for (Billete b: listaBilletes) {
            if (b.getOrigen().equals(origen)) {
                listaBilletes2.add(b);
            }
        }
        return listaBilletes2;
    }
}
