package e4;

import java.util.*;

public class Calculator {
    private ArrayList<Float> l_num;
    private ArrayList<String> l_op;

    public Calculator () {
        l_num = new ArrayList<>();
        l_op = new ArrayList<>();
    }

    public void cleanOperations () {
            l_num.clear();
            l_op.clear();
    }

    public void addOperation ( String operation , float ... values ) {
        if(Objects.equals(operation, "+")||Objects.equals(operation, "-")||Objects.equals(operation, "*")||Objects.equals(operation, "/")) {
            if (values.length == 2 && l_num.isEmpty() && l_op.isEmpty()) {
                l_num.add(values[0]);
                l_op.add(operation);
                l_num.add(values[1]);
            } else {
                l_op.add(operation);
                l_num.add(values[0]);
            }
        } else throw new IllegalArgumentException("La operación no existe");
    }

    public float executeOperations () {
        float resultado = 0;
        if(!l_num.isEmpty() && !l_op.isEmpty()){
            for (int i = 1; i < l_num.size(); i++){
                if (i==1) {
                    switch (l_op.get(0)) {
                        case "+":
                            resultado = Operaciones.SUMAR.realizarOp(l_num.get(0), l_num.get(i));
                            break;
                        case "-":
                            resultado = Operaciones.RESTAR.realizarOp(l_num.get(0), l_num.get(i));
                            break;
                        case "*":
                            resultado = Operaciones.MULTIPLICAR.realizarOp(l_num.get(0), l_num.get(i));
                            break;
                        case "/":
                            if(l_num.get(1) == 0) {
                                cleanOperations();
                                throw new ArithmeticException("División entre cero");
                            }else{
                                resultado = Operaciones.DIVIDIR.realizarOp(l_num.get(0), l_num.get(i));
                                break;
                            }
                    }
                }else{
                    switch (l_op.get(i - 1)){
                        case "+":
                            resultado = Operaciones.SUMAR.realizarOp(resultado, l_num.get(i));
                            break;
                        case "-":
                            resultado = Operaciones.RESTAR.realizarOp(resultado, l_num.get(i));
                            break;
                        case "*":
                            resultado = Operaciones.MULTIPLICAR.realizarOp(resultado, l_num.get(i));
                            break;
                        case "/":
                            if(l_num.get(i) == 0) {
                                cleanOperations();
                                throw new ArithmeticException("División entre cero");
                            }else{
                                resultado = Operaciones.DIVIDIR.realizarOp(resultado, l_num.get(i));
                                break;
                            }
                    }
                }
            }
        }
        cleanOperations();
        return resultado;
    }

    @Override
    public String toString () {
        StringBuilder state = new StringBuilder();
        if(l_num.isEmpty()){
            state.append("[STATE:]");
        }
        for (int i = 1; i < l_num.size(); i++){
            if (i==1)
                state.append("[STATE:[").append(l_op.get(0)).append("]").append(l_num.get(0).toString()).append("_").append(l_num.get(1).toString());

            else{
                if (i==l_num.size()-1)
                    state.append("[").append(l_op.get(i-1)).append("]").append(l_num.get(i).toString()).append("]");
                else
                    state.append("[").append(l_op.get(i-1)).append("]").append(l_num.get(i).toString());
            }
        }
        return state.toString();
    }
}
