import java.util.Scanner;

public class MediaNotasAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numAlunos = 5;
        double somaNotas = 0;

        for (int i = 1; i <= numAlunos; i++) {
            System.out.print("Digite a nota do aluno " + i + ": ");
            double nota = scanner.nextDouble();
            somaNotas += nota;
        }

        double media = somaNotas / numAlunos;
        System.out.println("A média das notas dos " + numAlunos + " alunos é: " + media);

        scanner.close();
    }
}
