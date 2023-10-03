/*
 * Inserção e Pesquisa Sequencial em Vetor
Este documento descreve um algoritmo para a inserção de registros no final de um vetor e a subsequente realização de pesquisas sequenciais com base na chave primária, que é o atributo nome.

Entrada
A entrada padrão consiste em duas partes:

A primeira parte é igual à entrada da primeira questão.

A segunda parte é composta por várias linhas, cada uma contendo um elemento que deve ser pesquisado no vetor. A última linha da segunda parte contém a palavra FIM.

Saída
A saída padrão será composta por várias linhas, cada uma contendo as palavras SIM ou NAO para indicar se cada um dos elementos pesquisados foi encontrado no vetor.

Registro de Log
Além disso, um arquivo de log será criado na pasta corrente com o nome matrícula_sequencial.txt. Este arquivo conterá uma única linha com as seguintes informações, separadas por uma tabulação ('\t'):

Sua matrícula
Tempo de execução do algoritmo
Número de comparações realizadas durante a execução
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
            String cidadeNascimento, String estadoNascimento) {
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
        System.out.println("[" + this.id + " ## " + this.nome + " ## " + this.altura + " ## " + this.peso + " ## "
                + this.anoNascimento + " ## " + this.universidade + " ## " + this.cidadeNascimento + " ## "
                + this.estadoNascimento + "]");
    }

    // Metodo para ler os atributos da classe
    public void ler(String s) {
        String[] array = s.split(",", -1);
        this.id = Integer.parseInt(array[0]);
        this.nome = array[1];
        if (array[2].equals("")) {
            this.altura = 0;
        } else {
            this.altura = Integer.parseInt(array[2]);
        }
        if (array[3].equals("")) {
            this.peso = 0;
        } else {
            this.peso = Integer.parseInt(array[3]);
        }
        if (array[4].equals("")) {
            this.universidade = "nao informado";
        } else {
            this.universidade = array[4];
        }
        if (array[5].equals("")) {
            this.anoNascimento = 0;
        } else {
            this.anoNascimento = Integer.parseInt(array[5]);
        }
        if (array[6].equals("")) {
            this.cidadeNascimento = "nao informado";
        } else {
            this.cidadeNascimento = array[6];
        }
        if (array[7].equals("")) {
            this.estadoNascimento = "nao informado";
        } else {
            this.estadoNascimento = array[7];
        }
    }

    public static String[] lerArq(String path) {
        File file = new File("/tmp/" + path);
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

        long startTime = System.nanoTime();
        int comparacoes = 0;

        String[] arrData = lerArq("players.csv");
        Jogador[] jogadorData = new Jogador[arrData.length];

        for (int i = 0; i < arrData.length; i++) {
            String data = arrData[i];
            Jogador jogador = new Jogador();
            jogador.ler(data);
            jogadorData[i] = jogador;
            comparacoes++;
        }

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();
        Jogador[] entradaJogador = new Jogador[1000];
        int i = 0;

        // preenche o vetor de entrada com os jogadores
        while (!entrada.equals("FIM")) {
            int id = Integer.parseInt(entrada);
            entradaJogador[i] = jogadorData[id];
            i++;
            entrada = sc.nextLine();
            comparacoes++;
        }

        // procura jogadores por nome
        entrada = sc.nextLine();
        while (!entrada.equals("FIM")) {
            boolean encontrou = false;
            for (int j = 0; j < i; j++) {
                if (entradaJogador[j].getNome().equals(entrada)) {
                    System.out.println("SIM");
                    encontrou = true;
                    j = i;
                }
                comparacoes++;
            }
            if (!encontrou) {
                System.out.println("NAO");
            }
            entrada = sc.nextLine();
            comparacoes++;
        }

        try {
            File arq = new File("matríricula_sequencial.txt");
            if (arq.createNewFile()) {
                FileWriter fw = new FileWriter(arq);
                fw.write("Matricula: 1453574\t");
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                fw.write("Tempo de execução: " + totalTime + "\t");
                fw.write("Comparações: " + comparacoes);
            } else {
                System.out.println("Arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Erro na criação do arquivo.");
            e.printStackTrace();
        }

        sc.close();
    }
}
