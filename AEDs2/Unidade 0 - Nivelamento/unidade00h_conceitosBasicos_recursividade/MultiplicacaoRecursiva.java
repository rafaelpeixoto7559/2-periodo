public class MultiplicacaoRecursiva {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int resultado = multiplicacaoRecursiva(a, b);
        System.out.println(a + " * " + b + " = " + resultado);
    }

    public static int multiplicacaoRecursiva(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b > 0) {
            return a + multiplicacaoRecursiva(a, b - 1);
        } else {
            return -multiplicacaoRecursiva(a, -b);
        }
    }
}
