import java.util.Scanner;

public class ContagemDivisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número inteiro N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int countPares = 0;
        int countDivisiveisPorTres = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                countPares++;
            }
            if (num % 3 == 0) {
                countDivisiveisPorTres++;
            }
        }

        System.out.println("Número de elementos pares: " + countPares);
        System.out.println("Número de elementos divisíveis por três: " + countDivisiveisPorTres);

        scanner.close();
    }
}
