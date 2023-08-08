import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro lado do triângulo: ");
        double lado1 = scanner.nextDouble();

        System.out.println("Digite o segundo lado do triângulo: ");
        double lado2 = scanner.nextDouble();

        System.out.println("Digite o terceiro lado do triângulo: ");
        double lado3 = scanner.nextDouble();

        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("O triângulo é Equilátero.");
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            System.out.println("O triângulo é Isósceles.");
        } else {
            System.out.println("O triângulo é Escaleno.");
        }

        scanner.close();
    }
}