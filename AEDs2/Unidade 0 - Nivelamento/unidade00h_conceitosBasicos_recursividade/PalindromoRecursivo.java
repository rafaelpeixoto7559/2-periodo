public class PalindromoRecursivo {
    public static void main(String[] args) {
        String palavra = "radar";
        boolean ehPalindromo = verificarPalindromo(palavra.toCharArray(), 0, palavra.length() - 1);
        
        if (ehPalindromo) {
            System.out.println("A palavra é um palíndromo.");
        } else {
            System.out.println("A palavra não é um palíndromo.");
        }
    }

    public static boolean verificarPalindromo(char[] palavra, int inicio, int fim) {
        if (inicio >= fim) {
            return true;
        }
        
        if (palavra[inicio] != palavra[fim]) {
            return false;
        }
        
        return verificarPalindromo(palavra, inicio + 1, fim - 1);
    }
}
