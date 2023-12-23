package e2;

import java.util.Comparator;

public class compTamaño implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento a1, Apartamento a2) {
        return Integer.compare(a2.getTamaño(), a1.getTamaño());
    }
}
