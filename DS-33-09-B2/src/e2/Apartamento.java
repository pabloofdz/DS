package e2;

import java.util.*;

public class Apartamento implements Comparable<Apartamento>{
    private final int nRef;
    private final int precioBase;
    private final int tamaño;
    private final int cPostal;
    private final String calle;
    private final int numero;
    private final int piso;
    private final char puerta;
    private final int nHabitaciones;
    private final int nBaños;
    private final ArrayList<Integer> preciosPlazas;

    public Apartamento(int nRef, int precioBase, int tamaño, int cPostal, String calle, int numero,
                   int piso, char puerta, int nHabitaciones, int nBaños) {
        this.nRef = nRef;
        this.precioBase = precioBase;
        this.tamaño = tamaño;
        this.cPostal = cPostal;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.puerta = puerta;
        this.nHabitaciones = nHabitaciones;
        this.nBaños = nBaños;
        preciosPlazas = new ArrayList<>();
    }

    public int getnRef() {
        return nRef;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getcPostal() {
        return cPostal;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public char getPuerta() {
        return puerta;
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public int getnBaños() {
        return nBaños;
    }

    public ArrayList<Integer> getPreciosPlazas() {
        return preciosPlazas;
    }

    public void añadirPrecioPlaza (Integer precio) {
        preciosPlazas.add(precio);
    }

    @Override
    public int compareTo(Apartamento a) {
        return Integer.compare(a.getnRef(), this.getnRef());
        /*if (a.getnRef() < this.getnRef())
            return -1;
        else if (a.getnRef() == this.getnRef())
            return 0;
        else
            return 1;*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Apartamento a1 = (Apartamento) o;
        return this.precioBase == a1.precioBase && this.tamaño == a1.tamaño &&
                this.cPostal == a1.cPostal && Objects.equals(this.calle, a1.calle) &&
                this.numero == a1.numero && this.piso == a1.piso &&
                this.puerta == a1.puerta && this.nHabitaciones == a1.nHabitaciones &&
                this.nBaños == a1.nBaños && this.preciosPlazas.equals(a1.preciosPlazas);
    }

    @Override
    public int hashCode() {
        int result;
        result = precioBase;
        result = 31 * result + tamaño;
        result = 31 * result + cPostal;
        result = 31 * result + calle.hashCode();
        result = 31 * result + numero;
        result = 31 * result + piso;
        result = 31 * result + (int) puerta;
        result = 31 * result + nHabitaciones;
        result = 31 * result + nBaños;
        for (int p : preciosPlazas) {
            result = 31 * result + p;
        }
        return result;
    }

}
