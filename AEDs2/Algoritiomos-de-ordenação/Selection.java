public class Selection{

    static void swap (int[] array, int menor, int i) {
        int temp;
        temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;
    }

    public static void sort(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            int menor = i;
            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            swap(vetor, menor, i);
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 4, 7, 1, 0, 6};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }   
    }
}