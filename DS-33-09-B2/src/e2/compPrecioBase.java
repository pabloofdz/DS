package e2;

import java.util.Comparator;

public class compPrecioBase implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento a1, Apartamento a2) {
        return Integer.compare(a2.getPrecioBase(), a1.getPrecioBase());
    }
}
