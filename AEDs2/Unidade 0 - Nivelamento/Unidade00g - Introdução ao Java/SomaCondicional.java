import java.util.Scanner;

public class SomaCondicional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro n: ");
        int n = scanner.nextInt();

        int soma = 0;
        int i = 0;

        while (2 * i + 1 < n) {
            int primeiroTermo = i;
            int segundoTermo = 2 * i + 1;
            int termoSoma = primeiroTermo + segundoTermo;

            soma += termoSoma;
            i++;
        }

        System.out.println("A soma dos termos é: " + soma);

        scanner.close();
    }
}