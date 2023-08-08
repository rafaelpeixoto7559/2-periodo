import java.util.Scanner;

public class ElementosArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();

        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            array[i] = scanner.nextInt();
        }

        int maior = array[0];
        int menor = array[0];

        for (int i = 1; i < tamanho; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
            if (array[i] < menor) {
                menor = array[i];
            }
        }

        System.out.println("O maior elemento do array é: " + maior);
        System.out.println("O menor elemento do array é: " + menor);

        scanner.close();
    }
}
