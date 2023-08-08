import java.util.Scanner;

public class PrimeiraOcorrenciaA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        int posicaoPrimeiraOcorrencia = -1;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == 'A' || palavra.charAt(i) == 'a') {
                posicaoPrimeiraOcorrencia = i;
                break;
            }
        }

        if (posicaoPrimeiraOcorrencia != -1) {
            System.out.println("Primeira ocorrência da letra A na posição: " + (posicaoPrimeiraOcorrencia + 1));
        } else {
            System.out.println("A letra A não foi encontrada na palavra.");
        }

        scanner.close();
    }
}
