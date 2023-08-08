import java.util.Scanner;

public class MaiorQueMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números inteiros a serem lidos: ");
        int n = scanner.nextInt();

        int[] numeros = new int[n];
        int soma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
        }

        double media = (double) soma / n;

        System.out.println("A média dos números é: " + media);
        System.out.println("Números maiores que a média:");

        for (int i = 0; i < n; i++) {
            if (numeros[i] > media) {
                System.out.println(numeros[i]);
            }
        }

        scanner.close();
    }
}
