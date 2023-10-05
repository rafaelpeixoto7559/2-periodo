/*
 * Ordenação Parcial por Seleção (k = 10)
Nesta questão, abordaremos a ordenação parcial por seleção com um valor de k igual a 10. O objetivo é encontrar os 10 menores elementos do vetor com base em algum atributo específico, considerando o atributo nome como a chave de pesquisa.

Entrada
A entrada consiste em uma lista de registros, onde cada registro possui um atributo nome. A lista pode conter um grande número de registros, mas nosso objetivo é encontrar e listar os 10 menores registros com base no atributo nome.

Saída
A saída será uma lista dos 10 registros com os menores valores do atributo nome, em ordem crescente.

Algoritmo de Ordenação Parcial por Seleção (k = 10)
O algoritmo de ordenação parcial por seleção com k igual a 10 funciona da seguinte maneira:

Inicialmente, selecione os primeiros 10 registros do vetor como os 10 menores registros até o momento.

Em seguida, percorra o restante dos registros do vetor e, para cada registro, verifique se ele é menor do que o maior registro entre os 10 menores atuais. Se for menor, substitua o maior registro pelo novo registro.

Continue percorrendo o vetor e atualizando os 10 menores registros até que todos tenham sido processados.

No final, a lista conterá os 10 menores registros com base no atributo nome.

Observações
Este algoritmo é eficiente quando precisamos encontrar um subconjunto dos menores elementos em uma grande lista. É uma forma de ordenação parcial que não requer que todos os elementos sejam ordenados, economizando tempo e recursos quando apenas uma parte dos resultados é necessária.


Lembre-se de fornecer a entrada adequada e adaptar o algoritmo para o seu contexto específico, considerando a ordenação parcial com k igual a 10.
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

    // Metodo para ler o arquivo e preencher o vetor de jogadores
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

    // Metodo para trocar dois jogadores de posicao
    public static void swap(int menor, int k, Jogador[] entradaJogador) {
        Jogador temp = entradaJogador[menor];
        entradaJogador[menor] = entradaJogador[k];
        entradaJogador[k] = temp;
    }

    public static void main(String[] args) {

        String[] arrData = lerArq("players.csv");
        Jogador[] jogadorData = new Jogador[arrData.length];

        for (int i = 0; i < arrData.length; i++) {
            String data = arrData[i];
            Jogador jogador = new Jogador();
            jogador.ler(data);
            jogadorData[i] = jogador;
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
        }

        // ordena o vetor de entrada por selecao parcial
        Jogador[] menor = new Jogador[10];
        for(int j = 0; j < 10; j++){
            menor[j] = entradaJogador[j];
        }
        for (int j = 10; j < i; j++){
            int maior = 0;
            for(int k = 0; k < 10; k++){
                if(menor[k].getNome().compareTo(menor[maior].getNome()) > 0){
                    maior = k;
                }
            }
            if(entradaJogador[j].getNome().compareTo(menor[maior].getNome()) < 0){
                menor[maior] = entradaJogador[j];
            }
        }

        for(int j = 0; j < 10; j++){
            for(int k = 0; k < 10; k++){
                if(menor[j].getNome().compareTo(menor[k].getNome()) < 0){
                    swap(j, k, menor);
                }
            }
        }

        // imprime o vetor ordenado
        for (int j = 0; j < 10; j++) {
            menor[j].imprimir();
        }
    }
}
