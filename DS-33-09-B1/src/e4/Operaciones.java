package e4;

public enum Operaciones {
    SUMAR("+"){
        @Override
        public float realizarOp(float op1, float op2) {
            return op1 + op2;
        }
    },
    RESTAR("-"){
        @Override
        public float realizarOp(float op1, float op2) {
            return op1 - op2;
        }
    },
    MULTIPLICAR("*"){
        @Override
        public float realizarOp(float op1, float op2) {
            return op1 * op2;
        }
    },
    DIVIDIR("/"){
        @Override
        public float realizarOp(float op1, float op2) {
            return op1 / op2;
        }
    };

    final String valor;

    public String getValor() {
        return valor;
    }

    Operaciones(String valor) {
        this.valor = valor;
    }

    public abstract float realizarOp(float operand1, float operand2);
}
