import java.util.Scanner;

public class DiagonaisMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de N (quantidade de linhas e colunas): ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Diagonal Principal:");

        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][i] + " ");
        }

        System.out.println("\nDiagonal Secundária:");

        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][n - 1 - i] + " ");
        }

        scanner.close();
    }
}
