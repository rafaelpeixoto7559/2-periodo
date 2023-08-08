import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniaoIntersecao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do primeiro array: ");
        int tamanho1 = scanner.nextInt();
        
        int[] array1 = new int[tamanho1];

        System.out.println("Digite os elementos do primeiro array:");
        for (int i = 0; i < tamanho1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Digite o tamanho do segundo array: ");
        int tamanho2 = scanner.nextInt();
        
        int[] array2 = new int[tamanho2];

        System.out.println("Digite os elementos do segundo array:");
        for (int i = 0; i < tamanho2; i++) {
            array2[i] = scanner.nextInt();
        }

        Set<Integer> conjuntoUniao = new HashSet<>();
        Set<Integer> conjuntoIntersecao = new HashSet<>();

        for (int num : array1) {
            conjuntoUniao.add(num);
        }

        for (int num : array2) {
            if (conjuntoUniao.contains(num)) {
                conjuntoIntersecao.add(num);
            }
            conjuntoUniao.add(num);
        }

        System.out.println("União dos arrays:");
        for (int num : conjuntoUniao) {
            System.out.print(num + " ");
        }

        System.out.println("\nInterseção dos arrays:");
        for (int num : conjuntoIntersecao) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
