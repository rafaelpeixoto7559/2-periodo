import java.lang.Math;

class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Retangulo() {
        this.base = 0;
        this.altura = 0;
    }

    // Métodos para cálculos
    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return 2 * (base + altura);
    }

    public double getDiagonal() {
        return Math.sqrt(base * base + altura * altura);
    }
}

public class Lixao {
    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(2,2);
        Retangulo r2 = new Retangulo(4,4);

        System.out.println("Retângulo 1:");
        System.out.println("Área: " + r1.getArea());
        System.out.println("Perímetro: " + r1.getPerimetro());
        System.out.println("Diagonal: " + r1.getDiagonal());

        System.out.println("\nRetângulo 2:");
        System.out.println("Área: " + r2.getArea());
        System.out.println("Perímetro: " + r2.getPerimetro());
        System.out.println("Diagonal: " + r2.getDiagonal());
    }
}