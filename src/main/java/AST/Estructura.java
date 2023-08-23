package AST;

public record Estructura(String assign, String val1, String val2, Type op) {

    public static int temporal = 1;

    public Estructura(String var, Estructura val1, Estructura val2, Type op) {
        this(var, val1 != null ? val1.print().getTempVar() : null, val2.print().getTempVar(), op);
    }

    public Estructura(String var, Estructura val1, Type op) {
        this(var, val1.print().getTempVar(), null, op);
    }

    private String getTempVar(boolean inc) {
        if (op == Type.EQ) {
            return assign;
        }
        if (assign == null) {
            return val1;
        }
        if (inc) {
            return "t" + temporal++;
        }
        return "t" + temporal;
    }

    public String getTempVar() {
        return getTempVar(true);
    }

    public Estructura print() {
        if (op == null) {
            return this;
        }
        System.out.print(getTempVar(false) + " =");
        if (val1 != null) {
            System.out.print(" " + val1);
        }
        if (val2 != null) {
            System.out.print(" " + op + val2);
        }
        System.out.println();
        return this;
    }

    public enum Type {
        ADD("+ "), SUB("- "), TIM("* "), DIV("/ "), EQ("=");

        private final String str;

        Type(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }
}
