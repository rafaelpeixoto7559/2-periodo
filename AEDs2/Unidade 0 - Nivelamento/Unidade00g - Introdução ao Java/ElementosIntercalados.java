import java.util.Scanner;

public class ElementosIntercalados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho dos arrays: ");
        int tamanho = scanner.nextInt();

        int[] array1 = new int[tamanho];
        int[] array2 = new int[tamanho];

        System.out.println("Digite os elementos do primeiro array:");
        for (int i = 0; i < tamanho; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.println("Digite os elementos do segundo array:");
        for (int i = 0; i < tamanho; i++) {
            array2[i] = scanner.nextInt();
        }

        System.out.println("Elementos intercalados dos arrays:");

        for (int i = 0; i < tamanho; i++) {
            System.out.print(array1[i] + " " + array2[i] + " ");
        }

        scanner.close();
    }
}
