public class VogaisRecursivo {
    public static void main(String[] args) {
        String palavra = "elefante";
        int quantidadeVogais = contarVogais(palavra.toCharArray(), 0);
        
        System.out.println("A quantidade de vogais na palavra é: " + quantidadeVogais);
    }

    public static int contarVogais(char[] palavra, int indice) {
        if (indice >= palavra.length) {
            return 0; // Base da recursão: percorreu toda a string
        }
        
        char caractere = Character.toLowerCase(palavra[indice]);
        int contador = 0;
        
        if (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u') {
            contador = 1;
        }
        
        return contador + contarVogais(palavra, indice + 1);
    }
}
