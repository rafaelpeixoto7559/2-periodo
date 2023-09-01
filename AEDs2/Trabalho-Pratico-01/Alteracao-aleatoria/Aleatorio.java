import java.util.Random;

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
