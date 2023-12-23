package e1;

public class Billete {
    private final String origen;
    private final String destino;
    private final float precio;
    private final String fecha;

    public Billete(String origen, String destino, float precio, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }
}
