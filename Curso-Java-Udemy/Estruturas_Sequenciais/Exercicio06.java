package Estruturas_Sequenciais;
import java.util.Locale;
import java.util.Scanner;

/*
 Fazer um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. Em seguida, calcule e
mostre:
a) a área do triângulo retângulo que tem A por base e C por altura.
b) a área do círculo de raio C. (pi = 3.14159)
c) a área do trapézio que tem A e B por bases e C por altura.
d) a área do quadrado que tem lado B.
e) a área do retângulo que tem lados A e B.
 */
public class Exercicio06 {
    public static void main(String[] args){
        double a,b,c,fim;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o primeiro numero: ");
        a = sc.nextDouble();
        System.out.println("Digite o segundo numero: ");
        b = sc.nextDouble();
        System.out.println("Digite o terceiro numero: ");
        c = sc.nextDouble();

        fim = (a*c)/2;
        System.out.printf("TRIANGULO: %.3f\n",fim);

        fim = 3.14159*(c*c);;
        System.out.printf("CIRCULO: %.3f\n",fim);

        fim = ((a+b)*c)/2;
        System.out.printf("TRAPEZIO: %.3f\n",fim);

        fim = b*2;
        System.out.printf("QUADRADO: %.3f\n",fim);

        fim = a*b;
        System.out.printf("RETANGULO: %.3f\n",fim);

        sc.close();
    }
}
