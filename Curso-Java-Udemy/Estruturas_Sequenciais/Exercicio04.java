package Estruturas_Sequenciais;
import java.util.Locale;
/*
 Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
decimais.
 */
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        float valor, salario;
        int num, horas;

        System.out.println("Informe o numero do funcionario: ");
        num = sc.nextInt();
        System.out.println("Informe as horas trabalhadas: ");
        horas = sc.nextInt();
        System.out.println("Informe o valor recebido por hora: ");
        valor = sc.nextFloat();

        salario = valor*horas;

        System.out.printf("Number = %d\n",num);
        System.out.printf("Salary = U$ %.2f",salario);

        sc.close();
    }
}
