package e2;

import java.util.Comparator;

public class compPrecioTotal implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento a1, Apartamento a2) {
        int precioTotal1 = 0, precioTotal2 = 0;
        if (a1.getPreciosPlazas().isEmpty())
            precioTotal1 = a1.getPrecioBase();
        else {
            for (int p : a1.getPreciosPlazas()) {
                precioTotal1 = precioTotal1 + p;
            }
        }
        if (a2.getPreciosPlazas().isEmpty())
            precioTotal2 = a2.getPrecioBase();
        else {
            for (int p : a2.getPreciosPlazas()) {
                precioTotal2 = precioTotal2 + p;
            }
        }
        return Integer.compare(precioTotal2, precioTotal1);
    }
}
