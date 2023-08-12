import java.lang.Math;

class Ponto {

    private double x, y;
    private int id;
    private static int nextID = 0;
    
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
        this.id = nextID;
        nextID++;
    }

    public Ponto(){
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getID() {
        return id;
    }

    public double dist(Ponto p) {
        double xf = Math.pow((this.x - p.getX()),2);
        double yf = Math.pow((this.y - p.getY()),2);
        double dist = Math.sqrt(xf+yf);
        return dist;
    }

    public double dist(double x,double y) {
        double xf = Math.pow((this.x - x),2);
        double yf = Math.pow((this.y - y),2);
        double dist = Math.sqrt(xf+yf);
        return dist;
    }

    public static double dist(double x,double y, double x2,double y2) {
        double xf = Math.pow((x - x2),2);
        double yf = Math.pow((y - y2),2);
        double dist = Math.sqrt(xf+yf);
        return dist;
    }

    public static boolean isTriangulo(Ponto p1, Ponto p2,Ponto p3) {
        if(p1.getX()!= p2.getX() && p1.getX() != p2.getX() && p2.getX() != p3.getX()){
            return true;
        }else{
            return false;
        }
    }

    public double getAreaRetangulo(Ponto p){
        double base = p.getX() - this.x; 
        double altura = p.getY() - this.y;
        double area = base * altura;
        return area;
    }

    public static int getNextID() {
        return nextID;
    }
}

class LixaoPonto {
 public static void main (String[] args){
 Ponto p1 = new Ponto(4,3);
 Ponto p2 = new Ponto(8,5);
 Ponto p3 = new Ponto(9.2,10);
 System.out.println("Distancia p1 entre e p2: " + p1.dist(p2));
 System.out.println("Distancia p1 entre e (5,2): " + p1.dist(5,2));
 System.out.println("Distancia (4,3) entre e (5,2): " + Ponto.dist(4,3,5,2));
 System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1,p2,p3));
 System.out.println("Area retangulo:" + p1.getAreaRetangulo(p2));
 System.out.println("ID de P1: " + p1.getID());
 System.out.println("ID de P2: " + p2.getID());
 System.out.println("ID de P3: " + p3.getID());
 System.out.println("Next ID: " + Ponto.getNextID());
 }
}