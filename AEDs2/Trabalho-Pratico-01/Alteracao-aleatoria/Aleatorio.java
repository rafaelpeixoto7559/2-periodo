import java.util.Random;

/*
 * Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII >= 'a' e <= 'z'), substitui todas as ocorrências da primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, para cada linha de entrada, execute o método desenvolvido nesta questão e mostre a string retornada como uma linha de saída. Abaixo, observamos um exemplo de entrada supondo que para a primeira linha as letras sorteados foram o 'a' e o 'q'. Para a segunda linha, foram o 'e' e o 'k'.


EXEMPLO DE ENTRADA:                 EXEMPLO DE SAÍDA:

    
o rato roeu a roupa do rei de roma       o rqto roeu q roupq do rei de romq
    
e qwe qwe qwe ewq ewq ewq            k qwk qwk qwk kwq kwq kwq
 */

public class Aleatorio {
    
    public static String aleatorio(String pal, char n1, char n2){
        String ale = ""; 
        
        for (int i=0; i<pal.length(); i++) {
            if(pal.charAt(i) == n1){
                ale += n2;
            }else{
                ale += pal.charAt(i);
            }
        }

        return ale;
    }

    public static void main(String[] args) {
        int res = 1;
        Random gerador = new Random();
        gerador.setSeed(4);

        do{
            String pal = MyIO.readLine();
            char n1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char n2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            if(pal.compareTo("FIM") == 0){
                res = 0;
            }else{
                MyIO.println(aleatorio(pal, n1, n2));
            }
        }while(res == 1);
    }

}
