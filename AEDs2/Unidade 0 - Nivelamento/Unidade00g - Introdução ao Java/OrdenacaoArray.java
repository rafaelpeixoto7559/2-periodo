import java.util.Scanner;

public class OrdenacaoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        bubbleSort(array);

        System.out.println("Array ordenado:");

        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean troca;

        for (int i = 0; i < n - 1; i++) {
            troca = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    troca = true;
                }
            }
            if (!troca) {
                break;
            }
        }
    }
}
