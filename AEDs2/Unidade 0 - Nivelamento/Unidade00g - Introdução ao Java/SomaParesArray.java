import java.util.Scanner;

public class SomaParesArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        if (n % 2 == 0) {
            System.out.println("Soma dos elementos consecutivos:");

            for (int i = 0; i < n; i += 2) {
                if (i + 1 < n) {
                    int soma = array[i] + array[i + 1];
                    System.out.println("Elemento " + (i + 1) + " + Elemento " + (i + 2) + " = " + soma);
                }
            }
        } else {
            System.out.println("O número de elementos não é par.");
        }

        scanner.close();
    }
}
