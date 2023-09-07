import java.util.Scanner;

/*
    Crie um método recursivo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.


    Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NAO indicando se a linha é um palíndromo.


    Destaca-se que uma linha de entrada pode ter caracteres não letras


    A entrada termina com a leitura de FIM
 */

public class PalindromoRecursivo {

    public static boolean verifica(String x){
        if(x.length() == 1 || x.length() == 0){
            return true;
        }else{
            if(x.charAt(0) == x.charAt(x.length()-1)){
                return verifica(x.substring(1, x.length()-1));
            }else{
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int res = 1;
        do {
            String x = sc.nextLine();
            boolean vale;

            if (x.compareTo("FIM") == 0) {
                res = 0;
            }else {
                vale = verifica(x);
                if (vale == true) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        } while (res == 1);
        sc.close();
    }
}
