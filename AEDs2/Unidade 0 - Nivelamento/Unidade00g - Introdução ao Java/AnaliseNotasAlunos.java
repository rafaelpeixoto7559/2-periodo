import java.util.Scanner;

public class AnaliseNotasAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota máxima da prova: ");
        int notaMaxima = scanner.nextInt();

        double totalNotas = 0;
        int quantidadeAlunos = 20;
        int abaixoMedia = 0;
        int conceitoA = 0;

        for (int i = 1; i <= quantidadeAlunos; i++) {
            System.out.print("Digite a nota do aluno " + i + ": ");
            int notaAluno = scanner.nextInt();
            totalNotas += notaAluno;

            if (notaAluno < 0 || notaAluno > notaMaxima) {
                System.out.println("Nota inválida. A nota deve estar entre 0 e " + notaMaxima + ".");
                i--;  // Decrementa o contador para repetir a entrada da nota inválida
                continue;
            }

            if (notaAluno < 0.6 * notaMaxima) {
                abaixoMedia++;
            }

            if (notaAluno > 0.9 * notaMaxima) {
                conceitoA++;
            }
        }

        double mediaTurma = totalNotas / quantidadeAlunos;
        int alunosConceitoA = conceitoA;

        System.out.println("Média da turma: " + mediaTurma);
        System.out.println("Número de alunos abaixo da média da universidade: " + abaixoMedia);
        System.out.println("Quantidade de alunos com conceito A: " + alunosConceitoA);

        scanner.close();
    }
}