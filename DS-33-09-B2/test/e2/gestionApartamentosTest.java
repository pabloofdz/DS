package e2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gestionApartamentosTest {
    private gestionApartamentos g1;
    private Apartamento a1;
    private Apartamento a2;
    private Apartamento a3;
    private Apartamento a4;
    private Apartamento a5;

    @BeforeEach
    void setUp() {
        //Creamos 5 apartamentos con sus correspondientes plazas de garaje
        //--------------------------------------------------------------------------------------------------------------
        g1 = new gestionApartamentos();
        a1 = new Apartamento(1234, 1500, 100, 15186,
                "Cervantes", 11, 3, 'A', 3, 2);
        a1.añadirPrecioPlaza(150);
        a1.añadirPrecioPlaza(80);
        a1.añadirPrecioPlaza(70);

        a2 = new Apartamento(4321, 1300, 70, 27780,
                "Góngora", 33, 6, 'C', 4, 1);
        a2.añadirPrecioPlaza(10);
        a2.añadirPrecioPlaza(10);
        a2.añadirPrecioPlaza(10);

        a3 = new Apartamento(3154, 1600, 60, 27340,
                "Quevedo", 63, 4, 'B', 2, 1);
        a3.añadirPrecioPlaza(50);
        a3.añadirPrecioPlaza(30);
        a3.añadirPrecioPlaza(90);

        a4 = new Apartamento(3154, 1600, 60, 27340,
                "Quevedo", 63, 4, 'B', 2, 1);
        a4.añadirPrecioPlaza(50);
        a4.añadirPrecioPlaza(30);
        a4.añadirPrecioPlaza(90);

        a5 = new Apartamento(3154, 1600, 60, 27340,
                "Quevedo", 63, 4, 'B', 2, 1);
        a5.añadirPrecioPlaza(60);
        a5.añadirPrecioPlaza(20);
        a5.añadirPrecioPlaza(90);
    }

    @Test
    void cambiarCriterioComp() {
        assertNull(g1.getCriterioComp());

        compPrecioBase cpb = new compPrecioBase();
        g1.cambiarCriterioComp(cpb);
        assertEquals(cpb, g1.getCriterioComp());

        compPrecioTotal cpt = new compPrecioTotal();
        g1.cambiarCriterioComp(cpt);
        assertEquals(cpt, g1.getCriterioComp());

        compTamaño ct = new compTamaño();
        g1.cambiarCriterioComp(ct);
        assertEquals(ct, g1.getCriterioComp());

        compHabitaciones cnh = new compHabitaciones();
        g1.cambiarCriterioComp(cnh);
        assertEquals(cnh, g1.getCriterioComp());
    }

    @Test
    void añadirApartamento() {
        //Añadimos apartamentos a la lista
        g1.añadirApartamento(a1);
        g1.añadirApartamento(a2);
        g1.añadirApartamento(a3);
        assertEquals(3, g1.getListaApartamentos().size());
    }

    @Test
    void listaOrdenada() {
        //Añadimos apartamentos a la lista
        g1.añadirApartamento(a1);
        g1.añadirApartamento(a2);
        g1.añadirApartamento(a3);
        assertEquals("""
                1. Núm. de referencia: 4321; Precio base: 1300; Tamaño: 70; Dirección: C/Góngora, Nº33, 6º C, CP: 27780; Núm. de habitaciones: 4; Núm. de baños: 1; Precios de las plazas: [10, 10, 10].
                2. Núm. de referencia: 3154; Precio base: 1600; Tamaño: 60; Dirección: C/Quevedo, Nº63, 4º B, CP: 27340; Núm. de habitaciones: 2; Núm. de baños: 1; Precios de las plazas: [50, 30, 90].
                3. Núm. de referencia: 1234; Precio base: 1500; Tamaño: 100; Dirección: C/Cervantes, Nº11, 3º A, CP: 15186; Núm. de habitaciones: 3; Núm. de baños: 2; Precios de las plazas: [150, 80, 70].
                """, g1.listaOrdenada());

        //Seleccionamos como criterio de comparación el precio base
        g1.cambiarCriterioComp(new compPrecioBase());
        assertEquals("""
                1. Núm. de referencia: 3154; Precio base: 1600; Tamaño: 60; Dirección: C/Quevedo, Nº63, 4º B, CP: 27340; Núm. de habitaciones: 2; Núm. de baños: 1; Precios de las plazas: [50, 30, 90].
                2. Núm. de referencia: 1234; Precio base: 1500; Tamaño: 100; Dirección: C/Cervantes, Nº11, 3º A, CP: 15186; Núm. de habitaciones: 3; Núm. de baños: 2; Precios de las plazas: [150, 80, 70].
                3. Núm. de referencia: 4321; Precio base: 1300; Tamaño: 70; Dirección: C/Góngora, Nº33, 6º C, CP: 27780; Núm. de habitaciones: 4; Núm. de baños: 1; Precios de las plazas: [10, 10, 10].
                """, g1.listaOrdenada());

        //Cambiamos el criterio de comparación a precio total
        g1.cambiarCriterioComp(new compPrecioTotal());
        assertEquals("""
                1. Núm. de referencia: 1234; Precio base: 1500; Tamaño: 100; Dirección: C/Cervantes, Nº11, 3º A, CP: 15186; Núm. de habitaciones: 3; Núm. de baños: 2; Precios de las plazas: [150, 80, 70].
                2. Núm. de referencia: 3154; Precio base: 1600; Tamaño: 60; Dirección: C/Quevedo, Nº63, 4º B, CP: 27340; Núm. de habitaciones: 2; Núm. de baños: 1; Precios de las plazas: [50, 30, 90].
                3. Núm. de referencia: 4321; Precio base: 1300; Tamaño: 70; Dirección: C/Góngora, Nº33, 6º C, CP: 27780; Núm. de habitaciones: 4; Núm. de baños: 1; Precios de las plazas: [10, 10, 10].
                """, g1.listaOrdenada());

        //Cambiamos el criterio de comparación a Tamaño
        g1.cambiarCriterioComp(new compTamaño());
        assertEquals("""
                1. Núm. de referencia: 1234; Precio base: 1500; Tamaño: 100; Dirección: C/Cervantes, Nº11, 3º A, CP: 15186; Núm. de habitaciones: 3; Núm. de baños: 2; Precios de las plazas: [150, 80, 70].
                2. Núm. de referencia: 4321; Precio base: 1300; Tamaño: 70; Dirección: C/Góngora, Nº33, 6º C, CP: 27780; Núm. de habitaciones: 4; Núm. de baños: 1; Precios de las plazas: [10, 10, 10].
                3. Núm. de referencia: 3154; Precio base: 1600; Tamaño: 60; Dirección: C/Quevedo, Nº63, 4º B, CP: 27340; Núm. de habitaciones: 2; Núm. de baños: 1; Precios de las plazas: [50, 30, 90].
                """, g1.listaOrdenada());

        //Cambiamos el criterio de comparación a número de habitaciones
        g1.cambiarCriterioComp(new compHabitaciones());
        assertEquals("""
                1. Núm. de referencia: 4321; Precio base: 1300; Tamaño: 70; Dirección: C/Góngora, Nº33, 6º C, CP: 27780; Núm. de habitaciones: 4; Núm. de baños: 1; Precios de las plazas: [10, 10, 10].
                2. Núm. de referencia: 1234; Precio base: 1500; Tamaño: 100; Dirección: C/Cervantes, Nº11, 3º A, CP: 15186; Núm. de habitaciones: 3; Núm. de baños: 2; Precios de las plazas: [150, 80, 70].
                3. Núm. de referencia: 3154; Precio base: 1600; Tamaño: 60; Dirección: C/Quevedo, Nº63, 4º B, CP: 27340; Núm. de habitaciones: 2; Núm. de baños: 1; Precios de las plazas: [50, 30, 90].
                """, g1.listaOrdenada());
    }
    @Test
    void testEquals() {
        //Comprobamos el equals()
        assertEquals(a4, a3);
        assertNotEquals(a4, a1);
        assertNotEquals(a4, a5);
    }
    @Test
    void testHashcode() {
        //Comprobamos el hashCode()
        assertEquals(a4.hashCode(), a3.hashCode());
        assertNotEquals(a4.hashCode(), a1.hashCode());
        assertNotEquals(a4.hashCode(), a5.hashCode());
    }

}