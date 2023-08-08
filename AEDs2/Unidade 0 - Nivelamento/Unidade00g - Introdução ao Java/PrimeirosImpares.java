import java.util.Scanner;

public class PrimeirosImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro N: ");
        int N = scanner.nextInt();

        System.out.println("Os primeiros " + N + " números inteiros ímpares são:");
        
        int contador = 0;
        int numero = 1;

        while (contador < N) {
            if (numero % 2 != 0) {
                System.out.println(numero);
                contador++;
            }
            numero++;
        }

        scanner.close();
    }
}
