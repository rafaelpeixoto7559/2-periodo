public class VogalConsoante {
    public static void main(String[] args) {
        String texto = "Exemplo de Texto";
        int nvnc = countnvnc(texto, 0);
        
        System.out.println("A quantidade de caracteres não vogais e não consoantes maiúsculas é: " + nvnc);
    }

    public static int countnvnc(String texto, int indice) {
        if (indice >= texto.length()) {
            return 0; // Base da recursão: percorreu toda a string
        }
        
        char caractere = texto.charAt(indice);
        int contador = 0;
        
        if (!Character.isUpperCase(caractere) && !isVogal(caractere) && !isConsoante(caractere)) {
            contador = 1;
        }
        
        return contador + countnvnc(texto, indice + 1);
    }
    
    public static boolean isVogal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public static boolean isConsoante(char c) {
        c = Character.toLowerCase(c);
        return Character.isLetter(c) && !isVogal(c);
    }
}
