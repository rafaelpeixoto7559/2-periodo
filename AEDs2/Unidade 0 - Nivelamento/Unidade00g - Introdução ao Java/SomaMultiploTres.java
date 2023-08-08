import java.util.Scanner;

public class SomaMultiploTres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números inteiros a serem lidos: ");
        int n = scanner.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        int somaMultiplosDeTres = 0;

        for (int num : numeros) {
            if (num % 3 == 0) {
                somaMultiplosDeTres += num;
            }
        }

        System.out.println("Soma dos números múltiplos de três: " + somaMultiplosDeTres);

        scanner.close();
    }
}
