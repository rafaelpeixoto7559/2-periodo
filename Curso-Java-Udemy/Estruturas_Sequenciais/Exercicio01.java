package Estruturas_Sequenciais;
/* 
 Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma
mensagem explicativa, conforme exemplos.
*/

import java.util.Scanner;

public class Exercicio01{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n1, n2, soma;

        System.out.println("Digite o primeiro numero: ");
        n1 = sc.nextInt();
        System.out.println("Digite o segundo numero: ");
        n2 = sc.nextInt();
        
        soma = n1+n2;

        System.out.printf("SOMA: %d", soma);
        sc.close();
    }
}