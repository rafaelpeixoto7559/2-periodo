package Estruturas_Sequenciais;
import java.util.Locale;
/*
 * Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
casas decimais conforme exemplos.
Fórmula da área: area = π . raio2
Considere o valor de π = 3.14159
 */
import java.util.Scanner;
public class Exercicio02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double area, raio;

        System.out.println("Informe o raio: ");
        raio = sc.nextDouble();

        area = 3.14159*(raio*raio);

        System.out.printf("A: %.4f",area);
        sc.close();
    }
}
