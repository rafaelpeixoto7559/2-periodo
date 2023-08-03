package AEDs2.Palindromo;

import java.util.Scanner;

/*
    Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.


    Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NAO indicando se a linha é um palíndromo.


    Destaca-se que uma linha de entrada pode ter caracteres não letras


    A entrada termina com a leitura de FIM
 */

public class palindromo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int res = 1;

        do{
            String x = sc.nextLine();
            if(x.compareTo("FIM")==0){
                res = 0;
            }else{
                int tam = x.length(), vale = 1;

                for(int i = 0; i < tam; i++){
                    if(x.charAt(i) != x.charAt(tam-i-1)){
                        vale = 0;
                    }
                }

                if(vale == 1){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }
            }

        }while(res == 1);

        sc.close();
    }
}