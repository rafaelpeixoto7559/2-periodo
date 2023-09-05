import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * Faça um programa que leia um número inteiro n indicando o número de valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Após a leitura dos valores, devemos fechar o arquivo. 
 * Em seguida, reabri-lo e fazer a leitura de trás para frente usando os métodos getFilePointer e seek da classe RandomAccessFile e mostre todos os valores lidos na tela. 
 * Nessa questão, você não pode usar, arrays, strings ou qualquer estrutura de dados. 
 * A entrada padrão é composta por um número inteiro n e mais n números reais. A saída padrão corresponde a n números reais mostrados um por linha de saída.
 */
public class Arquivo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        try{
            RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
            for(int i = 0; i < n; i++){
                raf.writeDouble(sc.nextDouble());
            }
            raf.close();
            raf = new RandomAccessFile("raf.txt", "r");
            for(int i = 0; i < n; i++){
                raf.seek((n-1-i)*8);
                double num = raf.readDouble();
                int numi = (int) num; 
                if(num - numi == 0){
                    System.out.println(numi);
                }else{
                   System.out.println(num);
                }
            }
            raf.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        sc.close();
    }
}
