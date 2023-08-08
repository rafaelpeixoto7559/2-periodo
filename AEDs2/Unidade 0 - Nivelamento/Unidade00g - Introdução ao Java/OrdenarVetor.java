import java.util.Arrays;
import java.util.Scanner;

public class OrdenarVetor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de elementos do vetor: ");
        int n = scanner.nextInt();
        
        int[] vetor = new int[n];

        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < n; i++) {
            vetor[i] = scanner.nextInt();
        }

        Arrays.sort(vetor);

        System.out.println("Elementos ordenados:");

        for (int num : vetor) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
