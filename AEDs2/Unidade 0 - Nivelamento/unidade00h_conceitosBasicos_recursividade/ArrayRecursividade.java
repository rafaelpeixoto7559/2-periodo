public class ArrayRecursividade {
    public static void main(String[] args) {
        int[] array = { 4, 9, 2, 7, 5 };
        int tamanho = array.length;
        int maior = encontrarMaiorElemento(array, tamanho);
        System.out.println("O maior elemento no array é: " + maior);
    }

    public static int encontrarMaiorElemento(int[] array, int n) {
        if (n == 1) {
            return array[0];
        }
        int maxAnterior = encontrarMaiorElemento(array, n - 1);
        return Math.max(maxAnterior, array[n - 1]);
    }
}
