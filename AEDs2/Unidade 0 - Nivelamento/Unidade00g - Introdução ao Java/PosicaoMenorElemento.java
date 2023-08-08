import java.util.Scanner;

public class PosicaoMenorElemento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int posicaoMenor = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] < array[posicaoMenor]) {
                posicaoMenor = i;
            }
        }

        System.out.println("A posição do menor elemento do array é: " + posicaoMenor);

        scanner.close();
    }
}
