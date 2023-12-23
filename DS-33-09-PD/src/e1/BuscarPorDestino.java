package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscarPorDestino implements Buscar {
    private String destino;

    public BuscarPorDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public List<Billete> buscar(List<Billete> listaBilletes) {
        List<Billete> listaBilletes2 = new ArrayList<>();
        for (Billete b: listaBilletes) {
            if (b.getDestino().equals(destino)) {
                listaBilletes2.add(b);
            }
        }
        return listaBilletes2;
    }

}
