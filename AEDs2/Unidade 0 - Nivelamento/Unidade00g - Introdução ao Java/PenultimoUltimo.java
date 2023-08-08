import java.util.Scanner;

public class PenultimoUltimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números inteiros a serem lidos: ");
        int n = scanner.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Soma dos elementos consecutivos:");

        for (int i = 0; i < n / 2; i++) {
            int soma = numeros[i] + numeros[n - i - 1];
            System.out.println("Elemento " + (i + 1) + " + Elemento " + (n - i) + " = " + soma);
        }

        // Caso o número de elementos seja ímpar, tratamos o elemento do meio separadamente
        if (n % 2 != 0) {
            System.out.println("Elemento do meio: " + numeros[n / 2]);
        }

        scanner.close();
    }
}
