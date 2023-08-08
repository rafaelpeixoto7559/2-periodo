/**
 * Ex03
 */

public class Ex03 {

    public static void Verifica(int[] v) {
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        for (int i : v) {
            if(v[i] >= maior){
                maior = v[i];
            }
            if(v[i] <= menor){
                menor = v[i];
            }
        }
        System.out.printf("maior:%d menor:%d",maior,menor);
    }
    public static void main(String[] args) {

        int[] v = {0,1,2,3,4,5,6,7,8,9};

        Verifica(v);
    }
}

