import java.util.Scanner;

public class CalculoNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[5];
        double soma = 0;
        double media;
        double menorNota = Double.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();

            soma += notas[i];

            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }

        media = soma / 5;

        System.out.println("Soma das notas: " + soma);
        System.out.println("Média das notas: " + media);
        System.out.println("Menor nota: " + menorNota);

        scanner.close();
    }
}
