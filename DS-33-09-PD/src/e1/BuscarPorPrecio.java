package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscarPorPrecio implements Buscar {
    private float precio;

    public BuscarPorPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public List<Billete> buscar(List<Billete> listaBilletes) {
        List<Billete> listaBilletes2 = new ArrayList<>();
        for (Billete b: listaBilletes) {
            if (b.getPrecio() == precio) {
                listaBilletes2.add(b);
            }
        }
        return listaBilletes2;
    }
}
