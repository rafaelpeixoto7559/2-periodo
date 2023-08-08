import java.util.Scanner;

public class Intercaladosn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de elementos do primeiro vetor (N): ");
        int n = scanner.nextInt();
        
        int[] vetor1 = new int[n];

        System.out.println("Digite os elementos do primeiro vetor:");
        for (int i = 0; i < n; i++) {
            vetor1[i] = scanner.nextInt();
        }

        System.out.print("Digite a quantidade de elementos do segundo vetor (M): ");
        int m = scanner.nextInt();
        
        int[] vetor2 = new int[m];

        System.out.println("Digite os elementos do segundo vetor:");
        for (int i = 0; i < m; i++) {
            vetor2[i] = scanner.nextInt();
        }

        System.out.println("Elementos intercalados:");

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            System.out.print(vetor1[i] + " ");
            System.out.print(vetor2[j] + " ");
            i++;
            j++;
        }

        while (i < n) {
            System.out.print(vetor1[i] + " ");
            i++;
        }

        while (j < m) {
            System.out.print(vetor2[j] + " ");
            j++;
        }

        scanner.close();
    }
}
