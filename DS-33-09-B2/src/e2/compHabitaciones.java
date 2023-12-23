package e2;

import java.util.Comparator;

public class compHabitaciones implements Comparator<Apartamento> {
    @Override
    public int compare(Apartamento a1, Apartamento a2) {
        return Integer.compare(a2.getnHabitaciones(), a1.getnHabitaciones());
    }
}
