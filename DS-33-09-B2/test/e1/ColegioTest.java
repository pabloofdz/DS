package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ColegioTest {
    private Colegio colegio;
    private Estudiante e1;
    private Fantasma f1;
    private Guardabosques g1;
    private Docente doc1;
    private Docente doc2;
    private Conserje c1;

    @BeforeEach
    void setUp() {
        colegio = new Colegio();
        e1 = new Estudiante("Hermione", "Granger", 46, 3, Residente.Casas.Gryffindor);
        f1 = new Fantasma("Barón", "Sanguinario", 46, 1, Residente.Casas.Slytherin);
        g1 = new Guardabosques("Rubeus", "Hagrid", 23, 2, true);
        doc1 = new Docente("Minerva", "McGonagall", 86, 1, Docente.Asignaturas.Transformaciones);
        doc2 = new Docente("Severus", "Snape", 86, 2, Docente.Asignaturas.Defensa);
        c1 = new Conserje("Argus", "Filch", 43, 0, true);
    }

    @Test
    void añadirIntegrante() {
        assertEquals("[]", colegio.getListaIntegrantes().toString());
        colegio.añadirIntegrante(e1);
        colegio.añadirIntegrante(f1);
        colegio.añadirIntegrante(g1);
        colegio.añadirIntegrante(doc1);
        colegio.añadirIntegrante(doc2);
        colegio.añadirIntegrante(c1);
        assertEquals("[Hermione Granger(Estudiante de Gryffindor, Barón Sanguinario(Fantasma de Slytherin, " +
                "Rubeus Hagrid(Guardabosques, Minerva McGonagall(Docente de Transformaciones, " +
                "Severus Snape(Docente de Defensa, Argus Filch(Conserje]", colegio.getListaIntegrantes().toString());
    }

    @Test
    void imprimirRecompensas() {
        assertEquals("La recompensa total del Colegio Hogwarts es de 0.0 galeones\n", colegio.imprimirRecompensas());
        colegio.añadirIntegrante(e1);
        colegio.añadirIntegrante(f1);
        colegio.añadirIntegrante(g1);
        colegio.añadirIntegrante(doc1);
        colegio.añadirIntegrante(doc2);
        colegio.añadirIntegrante(c1);
        assertEquals("""
                Hermione Granger(Estudiante de Gryffindor,3 horrocruxes): 270.0 galeones
                Barón Sanguinario(Fantasma de Slytherin,1 horrocruxes): 160.0 galeones
                Rubeus Hagrid(Guardabosques,2 horrocruxes): 150.0 galeones
                Minerva McGonagall(Docente de Transformaciones,1 horrocruxes): 50.0 galeones
                Severus Snape(Docente de Defensa,2 horrocruxes): 75.0 galeones
                Argus Filch(Conserje,0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 705.0 galeones
                """, colegio.imprimirRecompensas());
    }

    @Test
    void imprimirSalarios() {
        assertEquals("El gasto de Hogwarts en personal es de 0 galeones\n", colegio.imprimirSalarios());
        colegio.añadirIntegrante(e1);
        colegio.añadirIntegrante(f1);
        colegio.añadirIntegrante(g1);
        colegio.añadirIntegrante(doc1);
        colegio.añadirIntegrante(doc2);
        colegio.añadirIntegrante(c1);
        assertEquals("""
                Rubeus Hagrid(Guardabosques): 180 galeones
                Minerva McGonagall(Docente de Transformaciones): 400 galeones
                Severus Snape(Docente de Defensa): 500 galeones
                Argus Filch(Conserje): 160 galeones
                El gasto de Hogwarts en personal es de 1240 galeones
                """, colegio.imprimirSalarios());
    }
}