package Estruturas_Sequenciais;

import java.util.Scanner;

/*
 Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).
 */
public class Exercicio03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dif,a,b,c,d;

        System.out.println("Digite o primeiro numero: ");
        a = sc.nextInt();
        System.out.println("Digite o segundo numero: ");
        b = sc.nextInt();
        System.out.println("Digite o terceiro numero: ");
        c = sc.nextInt();
        System.out.println("Digite o quarto numero: ");
        d = sc.nextInt();

        dif = a*b-c*d;

        System.out.printf("DIFERENCA: %d",dif);
        sc.close();
    }
}
