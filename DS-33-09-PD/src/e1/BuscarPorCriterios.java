package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscarPorCriterios implements Buscar {
    public enum Operación {AND, OR}
    private final Operación op;
    private final List<Billete> l1;
    private final List<Billete> l2;

    public BuscarPorCriterios(List<Billete> list1, List<Billete> list2, Operación op) {
        this.l1 = list1;
        this.l2 = list2;
        this.op = op;
    }

    @Override
    public List<Billete> buscar(List<Billete> listaBilletes) {
        if (op == Operación.AND)
            return and();
        else
            return or();
    }


    public List<Billete> and(){
        List<Billete> lista_and = new ArrayList<>();
        for (Billete b: l1) {
            if (l2.contains(b)) {
                lista_and.add(b);
            }
        }
        return lista_and;
    }

    public List<Billete> or(){
        List<Billete> lista_or = new ArrayList<>(l1);
        for (Billete b: l2) {
            if (!l1.contains(b)) {
                lista_or.add(b);
            }
        }
        return lista_or;
    }
}
