package Estruturas_Sequenciais;
import java.util.Locale;
import java.util.Scanner;

/* 
 Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago
 */
public class Exercicio05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int cod1, cod2, num1, num2;
        float valor1, valor2, preco;

        System.out.println("Codigo da primeira peca: ");
        cod1 = sc.nextInt();
        System.out.println("Quantidade da primeira peca: ");
        num1 = sc.nextInt();
        System.out.println("Valor da primeira peca: ");
        valor1 = sc.nextFloat();

        System.out.println("Codigo da segunda peca: ");
        cod2 = sc.nextInt();
        System.out.println("Quantidade da segunda peca: ");
        num2 = sc.nextInt();
        System.out.println("Valor da segunda peca: ");
        valor2 = sc.nextFloat();

        preco = valor1*num1+valor2*num2;
        System.out.printf("VALOR A PAGAR: R$ %.2f",preco);
        sc.close();
    }
}
