public class Insertion{

    public static void sort(int[] vetor){
        for (int i = 1; i < vetor.length; i++) {
            int j = i;
            while(j > 0 && vetor[j-1] > vetor[j]){
                int temp = vetor[j];
                vetor[j] = vetor[j-1];
                vetor[j-1] = temp;
                j--;
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