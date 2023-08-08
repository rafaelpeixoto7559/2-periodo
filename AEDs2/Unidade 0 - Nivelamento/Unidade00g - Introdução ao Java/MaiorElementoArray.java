import java.util.Scanner;

public class MaiorElementoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int maior = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }

        System.out.println("O maior elemento do array é: " + maior);

        scanner.close();
    }
}