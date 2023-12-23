package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscarPorFecha implements Buscar {
    private String fecha;

    public BuscarPorFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public List<Billete> buscar(List<Billete> listaBilletes) {
        List<Billete> listaBilletes2 = new ArrayList<>();
        for (Billete b: listaBilletes) {
            if (b.getFecha().equals(fecha)) {
                listaBilletes2.add(b);
            }
        }
        return listaBilletes2;
    }

}
