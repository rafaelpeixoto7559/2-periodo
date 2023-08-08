public class Ex04 {
    public static void Sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int aux = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    public static void MaiorMenor(int[] array) {
        System.out.println("O maior numero e " + array[array.length - 1] + " e o menor numero e " + array[0]);
    }

    public static void main(String[] args) {
        int[] arr = { 30, 28, 58, 29, 22, 54, 34, 56 };
        Sort(arr);
        MaiorMenor(arr);
    }
}
