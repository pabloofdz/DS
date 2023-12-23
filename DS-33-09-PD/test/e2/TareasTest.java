package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TareasTest {
    private RealizacionTareas r1;
    private RealizacionTareas r2;
    private RealizacionTareas r3;

    @BeforeEach
    void setUp() {
        r1 = new DependenciaFuerte();
        r2 = new DependenciaDebil();
        r3 = new OrdenJerarquico();
    }

    @Test
    void añadirTareaDep() {
        Tareas tareas = new Tareas();
        tareas.añadirTareaDep("C -> A");
        tareas.añadirTareaDep("C -> F");
        tareas.añadirTareaDep("A -> B");
        tareas.añadirTareaDep("A -> D");
        tareas.añadirTareaDep("B -> E");
        tareas.añadirTareaDep("D -> E");
        tareas.añadirTareaDep("F -> E");
        tareas.añadirTareaDep("G -> F");
        tareas.añadirTareaDep("G -> H");
        tareas.añadirTareaDep("F -> J");
        tareas.añadirTareaDep("H -> J");
        assertEquals("A - B - C - D - E - F - G - H - J\n", tareas.listaTareas(tareas.getListaTareas()));
        assertThrows(IllegalArgumentException.class, () -> tareas.añadirTareaDep("H J"));
    }

    @Test
    void eliminarTarea() {
        Tareas tareas = new Tareas();
        Tarea t1 = new Tarea("A");
        Tarea t2 = new Tarea("B");
        t2.añadirDependencia(t1.getNombre());
        assertEquals("", tareas.listaTareas(tareas.getListaTareas()));
        tareas.eliminarTarea(t1);
        assertEquals("", tareas.listaTareas(tareas.getListaTareas()));
        tareas.añadirTarea(t1, null);
        tareas.añadirTarea(t2, t1);
        assertEquals("A - B\n", tareas.listaTareas(tareas.getListaTareas()));
        tareas.eliminarTarea(t1);
        assertEquals("B\n", tareas.listaTareas(tareas.getListaTareas()));
    }

    @Test
    void realizaTareasDependenciaFuerte() {
        Tareas tareas1 = new Tareas();
        tareas1.setRealizacion(r1);
        tareas1.realizaTareas();
        assertEquals("", tareas1.listaTareas(tareas1.getListaTareas()));
        tareas1.añadirTareaDep("C -> A");
        tareas1.añadirTareaDep("C -> F");
        tareas1.añadirTareaDep("A -> B");
        tareas1.añadirTareaDep("A -> D");
        tareas1.añadirTareaDep("B -> E");
        tareas1.añadirTareaDep("D -> E");
        tareas1.añadirTareaDep("F -> E");
        tareas1.añadirTareaDep("G -> F");
        tareas1.añadirTareaDep("G -> H");
        tareas1.añadirTareaDep("F -> J");
        tareas1.añadirTareaDep("H -> J");
        assertEquals("C - A - B - D - G - F - E - H - J\n", tareas1.listaTareas(tareas1.realizaTareas()));
        tareas1.setRealizacion(r2);
        assertEquals("C - A - B - D - E - F - G - H - J\n", tareas1.listaTareas(tareas1.realizaTareas()));
        tareas1.setRealizacion(r3);
        assertEquals("C - G - A - F - H - B - D - E - J\n", tareas1.listaTareas(tareas1.realizaTareas()));

    }
    @Test
    void realizaTareasDependenciaDebil() {
        Tareas tareas2 = new Tareas();
        tareas2.setRealizacion(r2);
        tareas2.realizaTareas();
        assertEquals("", tareas2.listaTareas(tareas2.getListaTareas()));
        tareas2.añadirTareaDep("C -> A");
        tareas2.añadirTareaDep("C -> F");
        tareas2.añadirTareaDep("A -> B");
        tareas2.añadirTareaDep("A -> D");
        tareas2.añadirTareaDep("B -> E");
        tareas2.añadirTareaDep("D -> E");
        tareas2.añadirTareaDep("F -> E");
        tareas2.añadirTareaDep("G -> F");
        tareas2.añadirTareaDep("G -> H");
        tareas2.añadirTareaDep("F -> J");
        tareas2.añadirTareaDep("H -> J");
        assertEquals("C - A - B - D - E - F - G - H - J\n", tareas2.listaTareas(tareas2.realizaTareas()));
    }

    @Test
    void realizaTareasOrdenJerarquico() {
        Tareas tareas3 = new Tareas();
        tareas3.setRealizacion(r3);
        tareas3.realizaTareas();
        assertEquals("", tareas3.listaTareas(tareas3.getListaTareas()));
        tareas3.añadirTareaDep("C -> A");
        tareas3.añadirTareaDep("C -> F");
        tareas3.añadirTareaDep("A -> B");
        tareas3.añadirTareaDep("A -> D");
        tareas3.añadirTareaDep("B -> E");
        tareas3.añadirTareaDep("D -> E");
        tareas3.añadirTareaDep("F -> E");
        tareas3.añadirTareaDep("G -> F");
        tareas3.añadirTareaDep("G -> H");
        tareas3.añadirTareaDep("F -> J");
        tareas3.añadirTareaDep("H -> J");
        tareas3.realizaTareas();
        assertEquals("C - G - A - F - H - B - D - E - J\n", tareas3.listaTareas(tareas3.realizaTareas()));
    }

    @Test
    void testToString() {
        Tareas tareas = new Tareas();
        assertEquals("", tareas.toString());
        tareas.añadirTareaDep("C -> A");
        assertEquals("A - C\n", tareas.toString());
    }
}