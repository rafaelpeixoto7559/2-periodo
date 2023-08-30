/*
 * O Imperador Júlio César foi um dos principais nomes do Império Romano. Entre suas contribuições, temos um algoritmo de criptografia chamado Ciframento de César. Segundo os historiadores, César utilizava esse algoritmo para criptografar as mensagens que enviava aos seus generais durante as batalhas. A ideia básica é um simples deslocamento de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3, todas as ocorrências do caractere 'a' são substituídas pelo caractere 'd', as do 'b' por 'e', e assim sucessivamente.


Crie um método iterativo que recebe uma string como parâmetro e retorna outra contendo a entrada de forma cifrada. Neste exercício, suponha a chave de ciframento três. Na saída padrão, para cada linha de entrada, escreva uma linha com a mensagem criptografada.
 */

import java.util.Scanner;

public class cifra {
   
    public static String ciframento(String x){
        int len = x.length();
        String cesar = "";
        for(int i = 0; i < len; i++){
            
            cesar += x.charAt(i) <= 255 ? (char)(x.charAt(i)+3) : (char)x.charAt(i) ;
        }

        return cesar;
    }

    public static void main(String[] args) {
        String cesar = "";
        int res = 1;
        Scanner sc = new Scanner(System.in);
        do {
            String x = sc.nextLine();
            if(x.equalsIgnoreCase("FIM")){
                res = 0;
            }else{
                cesar = ciframento(x);
                System.out.printf("%s\n",cesar);;
            }
        } while (res == 1);
        sc.close();
    }

}   

