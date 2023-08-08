import java.util.Scanner;

public class MostrarMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas (L): ");
        int l = scanner.nextInt();

        System.out.print("Digite o número de colunas (C): ");
        int c = scanner.nextInt();

        int[][] matriz = new int[l][c];

        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matriz em formato de grid:");

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }

        scanner.close();
    }
}
