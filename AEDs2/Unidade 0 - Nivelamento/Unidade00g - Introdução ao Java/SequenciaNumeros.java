import java.util.Scanner;

public class SequenciaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro N: ");
        int N = scanner.nextInt();

        System.out.println("Os primeiros " + N + " números da sequência são:");
        
        int numeroAtual = 1;
        int incremento = 4;

        for (int i = 0; i < N; i++) {
            System.out.println(numeroAtual);
            numeroAtual += incremento;
            incremento++;
        }

        scanner.close();
    }
}
