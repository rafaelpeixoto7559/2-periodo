public class BubbleSort {
    static void swap (int[] array, int menor, int i) {
        int temp;
        temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;
    }

    public static void sort(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length-1-i; j++) {
                if(vetor[j] > vetor[j+1]){
                    swap(vetor, j, j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 4, 7, 1, 0, 6};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }   
    }
}
