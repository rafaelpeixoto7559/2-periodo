import java.util.Scanner;

/**
 * Ex01
 */

public class Ex02 {

    public static boolean Verifica(int x, int[] v) {
        if(x >= v[4]){
            for (int i = 4; i > 0; i--) {
                if(x == v[i]){
                    return true;
                }
            }
        }else{
            for (int i = 5; i < 9; i++) {
                if(x == v[i]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int[] v = {0,1,2,3,4,5,6,7,8,9};

        x = sc.nextInt();

        Verifica(x,v);

        sc.close();
    }
}