public class MergeSortRecursivo {
    public static void main(String[] args) {
        int[] array = { 12, 29, 7, 53, 9, 25, 17 };
        mergeSort(array, 0, array.length - 1);
        
        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            
            merge(array, inicio, meio, fim);
        }
    }
    
    public static void merge(int[] array, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;
        
        int[] arrayEsquerda = new int[tamanhoEsquerda];
        int[] arrayDireita = new int[tamanhoDireita];
        
        for (int i = 0; i < tamanhoEsquerda; i++) {
            arrayEsquerda[i] = array[inicio + i];
        }
        
        for (int j = 0; j < tamanhoDireita; j++) {
            arrayDireita[j] = array[meio + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = inicio;
        
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (arrayEsquerda[i] <= arrayDireita[j]) {
                array[k] = arrayEsquerda[i];
                i++;
            } else {
                array[k] = arrayDireita[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanhoEsquerda) {
            array[k] = arrayEsquerda[i];
            i++;
            k++;
        }
        
        while (j < tamanhoDireita) {
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }
}
