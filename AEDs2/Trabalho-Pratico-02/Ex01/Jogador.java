import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Sua classe terá os atributos privados id(int), nome(String), altura(int), peso(int), universidade (String), anoNascimento (int), cidadeNascimento(String), estadoNascimento(String). Sua classe também terá pelo menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.


O método imprimir mostra os atributos do registro (ver cada linha da saída padrão) e o ler lê os atributos de um registro. Atenção para o arquivo de entrada, pois em alguns registros faltam valores e esse foi substituído pelo valor “nao informado”.


A entrada padrão é composta por várias linhas e cada uma contém uma string indicando o id do jogador a ser lido. A última linha da entrada contém a palavra FIM. A saída padrão também contém várias linhas, uma para cada registro contido em uma linha da entrada padrão.
 */

public class Jogador {
    // Atributos privados da classe Jogador
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    // Construtor vazio
    public Jogador() {
        this.id = 0;
        this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.universidade = "";
        this.anoNascimento = 0;
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }

    // Construtor que recebe os parametros
    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    // Gets e Sets
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public int getAltura() {
        return this.altura;
    }
    public int getPeso() {
        return this.peso;
    }
    public String getUniversidade() {
        return this.universidade;
    }
    public int getAnoNascimento() {
        return this.anoNascimento;
    }
    public String getCidadeNascimento() {
        return this.cidadeNascimento;
    }
    public String getEstadoNascimento() {
        return this.estadoNascimento;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }
    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    // Metodo clone
    public Jogador clone() {
        Jogador clone = new Jogador();
        clone.id = this.id;
        clone.nome = this.nome;
        clone.altura = this.altura;
        clone.peso = this.peso;
        clone.universidade = this.universidade;
        clone.anoNascimento = this.anoNascimento;
        clone.cidadeNascimento = this.cidadeNascimento;
        return clone;
    }

    // Metodo para imprimir os atributos da classe

    public void imprimir() {
        System.out.println("[" + this.id + " ## " + this.nome + " ## " + this.altura + " ## " + this.peso + " ## " + this.anoNascimento + " ## " + this.universidade + " ## " + this.cidadeNascimento + " ## " + this.estadoNascimento + "]");
    }

    // Metodo para ler os atributos da classe
    public void ler(String s) {
        String[] array = s.split(",",-1);
        this.id = Integer.parseInt(array[0]);
        this.nome = array[1];
        if(array[2].equals("")) {
            this.altura = 0;
        }else{
            this.altura = Integer.parseInt(array[2]);
        }
        if(array[3].equals("")) {
            this.peso = 0;
        }else{
            this.peso = Integer.parseInt(array[3]);
        }
        if(array[4].equals("")) {
            this.universidade = "nao informado";
        }else{
            this.universidade = array[4];
        }
        if(array[5].equals("")) {
            this.anoNascimento = 0;
        }else{
            this.anoNascimento = Integer.parseInt(array[5]);
        }
        if(array[6].equals("")) {
            this.cidadeNascimento = "nao informado";
        }else{
            this.cidadeNascimento = array[6];
        }
        if(array[7].equals("")) {
            this.estadoNascimento = "nao informado";
        }else{
            this.estadoNascimento = array[7];
        }
    }
    
    public static String[] lerArq(String path) {
        File file = new File("/tmp/"+path);
        String[] arrData = new String[3922];
        int i = 0;
        try {
          Scanner scanner = new Scanner(file);
          scanner.nextLine();
          while (scanner.hasNext()) {
            arrData[i] = scanner.nextLine();
            i++;
          }
          scanner.close();
        } catch (FileNotFoundException e) {
          System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
        return arrData;
      }
    
      public static void main(String[] args) {
        String[] arrData = lerArq("players.csv");
        Jogador[] jogadorData = new Jogador[arrData.length];
    
        for(int i = 0; i < arrData.length; i++) {
          String data = arrData[i];
          Jogador jogador = new Jogador();
          jogador.ler(data);
          jogadorData[i] = jogador;
        }

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();
        while(!entrada.equals("FIM")) {
            int id = Integer.parseInt(entrada);
            jogadorData[id].imprimir();
            entrada = sc.nextLine();
        }
    }
}
