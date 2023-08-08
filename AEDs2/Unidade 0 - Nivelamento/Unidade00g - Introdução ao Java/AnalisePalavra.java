import java.util.Scanner;

public class AnalisePalavra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        int totalCaracteres = palavra.length();
        int letras = 0;
        int naoLetras = 0;
        int vogais = 0;
        int consoantes = 0;

        for (int i = 0; i < totalCaracteres; i++) {
            char caractere = palavra.charAt(i);

            if (Character.isLetter(caractere)) {
                letras++;

                char letraMin = Character.toLowerCase(caractere);
                if (letraMin == 'a' || letraMin == 'e' || letraMin == 'i' || letraMin == 'o' || letraMin == 'u') {
                    vogais++;
                } else {
                    consoantes++;
                }
            } else {
                naoLetras++;
            }
        }

        System.out.println("Número total de caracteres: " + totalCaracteres);
        System.out.println("Número de letras: " + letras);
        System.out.println("Número de não letras: " + naoLetras);
        System.out.println("Número de vogais: " + vogais);
        System.out.println("Número de consoantes: " + consoantes);

        scanner.close();
    }
}
