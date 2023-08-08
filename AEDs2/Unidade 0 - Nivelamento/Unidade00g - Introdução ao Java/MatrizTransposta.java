import java.util.Scanner;

public class MatrizTransposta {
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

        int[][] matrizTransposta = new int[c][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matrizTransposta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz Transposta:");

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(matrizTransposta[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
