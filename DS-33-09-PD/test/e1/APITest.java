package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APITest {
    private API a1;
    @BeforeEach
    void setUp() {
        a1 = new API();
    }

    @Test
    void añadirBillete() {
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Santiago; Destino: Vigo; Precio: 4.2; Fecha: 4/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Ourense; Destino: Pontevedra; Precio: 3.2; Fecha: 7/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n", a1.listaBilletes(a1.getListaBilletes()));
    }

    @Test
    void eliminarBillete() {
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        assertEquals("", a1.listaBilletes(a1.getListaBilletes()));
        a1.eliminarBillete(b4);
        assertEquals("", a1.listaBilletes(a1.getListaBilletes()));
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Santiago; Destino: Vigo; Precio: 4.2; Fecha: 4/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Ourense; Destino: Pontevedra; Precio: 3.2; Fecha: 7/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n", a1.listaBilletes(a1.getListaBilletes()));
        a1.eliminarBillete(b4);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Santiago; Destino: Vigo; Precio: 4.2; Fecha: 4/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n", a1.listaBilletes(a1.getListaBilletes()));
    }

    @Test
    void buscarBilletesPorDestino() {
        Buscar bpd = new BuscarPorDestino("Coruña");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpd)));
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpd)));
        Buscar bpd2 = new BuscarPorDestino("Madrid");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpd2)));
    }

    @Test
    void buscarBilletesPorFecha() {
        Buscar bpf = new BuscarPorFecha("3/12/2021");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpf)));
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpf)));
        Buscar bpf2 = new BuscarPorFecha("3/01/2022");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpf2)));
    }

    @Test
    void buscarBilletesPorOrigen() {
        Buscar bpo = new BuscarPorOrigen("Lugo");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpo)));
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpo)));
        Buscar bpo2 = new BuscarPorOrigen("Madrid");
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpo2)));
    }

    @Test
    void buscarBilletesPorPrecio() {
        Buscar bpp = new BuscarPorPrecio(3.2f);
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpp)));
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Ourense; Destino: Pontevedra; Precio: 3.2; Fecha: 7/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpp)));
        Buscar bpp2 = new BuscarPorPrecio(5.2f);
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpp2)));
    }

    @Test
    void buscarBilletesPorCriterios() {
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        Billete b2 = new Billete("Santiago", "Vigo", 4.2f, "4/12/2021");
        Billete b3 = new Billete("Lugo", "Coruña", 1.2f, "3/12/2021");
        Billete b4 = new Billete("Ourense", "Pontevedra", 3.2f, "7/12/2021");
        Billete b5 = new Billete("Vigo", "Coruña", 2.2f, "5/12/2021");
        a1.añadirBillete(b1);
        a1.añadirBillete(b2);
        a1.añadirBillete(b3);
        a1.añadirBillete(b4);
        a1.añadirBillete(b5);
        Buscar bpd = new BuscarPorDestino("Coruña");
        Buscar bpf = new BuscarPorFecha("3/12/2021");
        BuscarPorCriterios bpc = new BuscarPorCriterios(a1.buscarBilletes(bpd), a1.buscarBilletes(bpf), BuscarPorCriterios.Operación.OR);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpc)));
        Buscar bpd2 = new BuscarPorDestino("Pontevedra");
        Buscar bpc2 = new BuscarPorCriterios(a1.buscarBilletes(bpc), a1.buscarBilletes(bpd2), BuscarPorCriterios.Operación.AND);
        assertEquals("", a1.listaBilletes(a1.buscarBilletes(bpc2)));
        BuscarPorCriterios bpc3 = new BuscarPorCriterios(a1.buscarBilletes(bpc), a1.buscarBilletes(bpd2), BuscarPorCriterios.Operación.OR);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n" +
                "Origen: Lugo; Destino: Coruña; Precio: 1.2; Fecha: 3/12/2021.\n" +
                "Origen: Vigo; Destino: Coruña; Precio: 2.2; Fecha: 5/12/2021.\n" +
                "Origen: Ourense; Destino: Pontevedra; Precio: 3.2; Fecha: 7/12/2021.\n", a1.listaBilletes(a1.buscarBilletes(bpc3)));
    }

    @Test
    void listaBilletes() {
        assertEquals("", a1.listaBilletes(a1.getListaBilletes()));
        Billete b1 = new Billete("Vigo", "Coruña", 3.2f, "3/12/2021");
        a1.añadirBillete(b1);
        assertEquals("Origen: Vigo; Destino: Coruña; Precio: 3.2; Fecha: 3/12/2021.\n", a1.listaBilletes(a1.getListaBilletes()));
    }

}