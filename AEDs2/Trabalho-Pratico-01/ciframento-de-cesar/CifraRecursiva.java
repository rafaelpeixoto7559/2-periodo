import java.util.Scanner;

public class CifraRecursiva {
   
    public static String ciframento(String x, int i, String cifrado){
        int len = x.length();
        
        if(i>=len){
            return cifrado;
        }else if(x.charAt(i) == 65533){
            char buffer = x.charAt(i);
            cifrado += buffer;
            cifrado = ciframento(x, i+1, cifrado);
            return cifrado;
        }
        char buffer = x.charAt(i);
        buffer+=3;
        cifrado += buffer;
        return ciframento(x, i+1, cifrado);
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
                cesar = ciframento(x, 0, "");
                System.out.printf("%s\n",cesar);;
            }
        } while (res == 1);
        sc.close();
    }

}   
