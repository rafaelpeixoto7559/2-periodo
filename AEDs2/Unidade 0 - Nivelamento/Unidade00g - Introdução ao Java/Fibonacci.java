import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro n: ");
        int n = scanner.nextInt();

        int fibN = calcularFibonacci(n);

        System.out.println("O " + n + "-ésimo termo da sequência de Fibonacci é: " + fibN);

        scanner.close();
    }

    public static int calcularFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibPrev = 0;
            int fibCurr = 1;
            for (int i = 2; i <= n; i++) {
                int nextFib = fibPrev + fibCurr;
                fibPrev = fibCurr;
                fibCurr = nextFib;
            }
            return fibCurr;
        }
    }
}
