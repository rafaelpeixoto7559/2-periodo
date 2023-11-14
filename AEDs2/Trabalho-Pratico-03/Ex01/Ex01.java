import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Crie uma Lista de registros baseada na de inteiros vista na sala de aula. Sua lista deve conter todos os atributos e métodos existentes na lista de inteiros, contudo, adaptados para a classe Jogador. Lembre-se que, na verdade, temos uma lista de ponteiros (ou referências) e cada um deles aponta para um registo. Neste exercício, faremos inserções, remoções e mostraremos os elementos de nossa lista.


Os métodos de inserir e remover devem operar conforme descrito a seguir, respeitando parâmetros e retornos. primeiro, o void inserirInicio(Jogador jogador) insere um registro na primeira posição da Lista e remaneja os demais. Segundo, o void inserir(Jogador jogador, int posição) insere um registro na posição p da Lista, onde p < n e n é o número de registros cadastrados. Em seguida, esse método remaneja os demais registros. O void inserirFim(Jogador jogador) insere um registro na última posição da Lista. O Jogador removerInicio() remove e retorna o primeiro registro cadastrado na Lista e remaneja os demais. O Jogador remover(int posição) remove e retorna o registro cadastrado na p-ésima posição da Lista e remaneja os demais. O Jogador removerFim() remove e retorna o último registro cadastrado na lista.


Entrada
A entrada padrão é composta por duas partes. A primeira é igual a entrada da primeira questão. As demais linhas correspondem a segunda parte. A primeira linha da segunda parte tem um número inteiro n indicando a quantidade de registros a serem inseridos/removidos. Nas próximas n linhas, tem-se n comandos de inserção/remoção a serem processados neste exercício. Cada uma dessas linhas tem uma palavra de comando: II inserir no início, I* inserir em qualquer posição, IF inserir no fim, RI remover no início, R* remover em qualquer posição e RF remover no fim. No caso dos comandos de inserir, temos também o nome do arquivo que contém o registro a ser inserido. No caso dos comandos de “em qualquer posição”, temos também esse nome. No Inserir, a posição fica imediatamente após a palavra de comando.


Saída
A saída padrão tem uma linha para cada registro removido sendo que essa informação será constituída pela palavra “(R)” e o atributo nome. No final, a saída mostra os atributos relativos a cada registro cadastrado na lista após as operações de inserção e remoção.
 */

class Jogador {

  private int id;
  private String nome;
  private int altura;
  private int peso;
  private String universidade;
  private int anoNascimento;
  private String cidadeNascimento;
  private String estadoNascimento;

  public Jogador() {
    this.id = -1;
    this.nome = "";
    this.altura = -1;
    this.peso = -1;
    this.universidade = "";
    this.anoNascimento = -1;
    this.cidadeNascimento = "";
    this.estadoNascimento = "";
  }

  public Jogador(
      int id,
      String nome,
      int altura,
      int peso,
      String universidade,
      int anoNascimento,
      String cidadeNascimento,
      String estadoNascimento) {
    this.id = id;
    this.nome = nome;
    this.altura = altura;
    this.peso = peso;
    this.universidade = universidade;
    this.anoNascimento = anoNascimento;
    this.cidadeNascimento = cidadeNascimento;
    this.estadoNascimento = estadoNascimento;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getAltura() {
    return altura;
  }

  public int getPeso() {
    return peso;
  }

  public String getUniversidade() {
    return universidade;
  }

  public int getAnoNascimento() {
    return anoNascimento;
  }

  public String getCidadeNascimento() {
    return cidadeNascimento;
  }

  public String getEstadoNascimento() {
    return estadoNascimento;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId(String id) {
    int convertedId = id.equals("nao informado") ? -1 : Integer.parseInt(id);
    setId(convertedId);
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public void setAltura(String altura) {
    int convertedAltura = altura.equals("nao informado") ? 0 : Integer.parseInt(altura);
    setAltura(convertedAltura);
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public void setPeso(String peso) {
    int convertedPeso = peso.equals("nao informado") ? 0 : Integer.parseInt(peso);
    setPeso(convertedPeso);
  }

  public void setUniversidade(String universidade) {
    this.universidade = universidade;
  }

  public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public void setAnoNascimento(String anoNascimento) {
    int convertedAnoNascimento = anoNascimento.equals("nao informado") ? 0 : Integer.parseInt(anoNascimento);
    setAnoNascimento(convertedAnoNascimento);
  }

  public void setCidadeNascimento(String cidadeNascimento) {
    this.cidadeNascimento = cidadeNascimento;
  }

  public void setEstadoNascimento(String estadoNascimento) {
    this.estadoNascimento = estadoNascimento;
  }

  public Jogador clone() throws CloneNotSupportedException {
    Jogador clone = new Jogador();
    clone.nome = this.nome;
    clone.altura = this.altura;
    clone.peso = this.peso;
    clone.universidade = this.universidade;
    clone.anoNascimento = this.anoNascimento;
    clone.cidadeNascimento = this.cidadeNascimento;
    clone.estadoNascimento = this.estadoNascimento;
    return clone;

  }

  public void ler(String data) { // le e separa cada atributo bonitinho
    String newData = "";
    if (data != null) {
      int aux = data.length();
      for (int j = 0; j < aux; j++) {
        char letter = data.charAt(j);
        char letter2 = (j + 1 == data.length()) ? ' ' : data.charAt(j + 1);
        if (letter == ',' && letter2 == ',') { // se for duas virgulas substitui
          newData += ",nao informado";
        } else {
          if (j == data.length() - 1 && letter == ',') { // se for a ultima virgula tambem substitui
            newData += ",nao informado";
          } else {
            newData += letter;
          }
        }
      }
      String[] infos = newData.split(","); // divide a string e separa as variaveis
      this.setId(infos[0]);
      this.setNome(infos[1]);
      this.setAltura(infos[2]);
      this.setPeso(infos[3]);
      this.setUniversidade(infos[4]);
      this.setAnoNascimento(infos[5]);
      this.setCidadeNascimento(infos[6]);
      this.setEstadoNascimento(infos[7]);

    }
  }

  public void imprimir() {
    System.out.println(
        " ## " +
            nome +
            " ## " +
            altura +
            " ## " +
            peso +
            " ## " +
            anoNascimento +
            " ## " +
            universidade +
            " ## " +
            cidadeNascimento +
            " ## " +
            estadoNascimento +
            " ## ");
  }

}

class Ex01 {

  static int cont = 0;

  static void inserirInicio(int x, Jogador[] arrayCompleto, Jogador[] array) throws Exception{

    if(cont == array.length) throw new Exception("Array cheio");
    for(int i = cont; i > 0; i--){
      array[i] = array[i-1];
    }
    array[0] = arrayCompleto[x];
    cont++;

  }

  static void inserirFinal(Jogador[] array, Jogador[] arrayCompleto, int x) throws Exception{

    if(cont == array.length) throw new Exception("Array cheio");
    array[cont] = arrayCompleto[x];
    cont++;

  }

  static void inserirPos(Jogador[] array, Jogador[] arrayCompleto, int x, int pos) throws Exception{

    if(cont == array.length || pos < 0 || pos > cont) throw new Exception("Array cheio ou posicao invalida");
    for(int i = cont; i > pos; i--){
      array[i] = array[i-1];
    }
    array[pos] = arrayCompleto[x];
    cont++;

  }

  static String removerInicio(Jogador[] array) throws Exception{

    if(cont == 0) throw new Exception("Array vazio");
    String removido = array[0].getNome();
    for(int i = 0; i < cont; i++){
      array[i] = array[i+1];
    }
    cont--;
    return removido;

  }

  static String removerFinal(Jogador[] array) throws Exception{

    if(cont == 0) throw new Exception("Array vazio");
    String removido = array[cont-1].getNome();
    cont--;
    return removido;

  }

  static String removerPos(Jogador[] array, int pos) throws Exception{

    if(cont == 0 || pos < 0 || pos >= cont) throw new Exception("Array vazio ou posicao invalida");
    String removido = array[pos].getNome();
    for(int i = pos; i < cont; i++){
      array[i] = array[i+1];
    }
    cont--;
    return removido;

  }


  public static String[] lerArq(String path) {
    File file = new File(path); // le o arquivo
    String[] arrData = new String[3922]; // array com linha por linha do arquivo
    int i = 0; 
    try {
      Scanner scanner = new Scanner(file); 
      scanner.nextLine(); 
      while (scanner.hasNext()) {
        arrData[i] = scanner.nextLine(); // le linha por linha e salva no array
        i++;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: " + e.getMessage());
    }
    return arrData;
  }

  public static void main(String[] args) throws Exception {
    String[] arrData = lerArq("/tmp/players.csv"); // le o arquivoe cada posiçao é uma linha
    Jogador[] jogadorData = new Jogador[arrData.length]; // array com todos os jogadores
    Jogador[] arrayPesquisa = new Jogador[150];

    for (int i = 0; i < arrData.length; i++) {
      String data = arrData[i];
      Jogador jogador = new Jogador();
      jogador.ler(data);
      jogadorData[i] = jogador;
    }

    Scanner teclado = new Scanner(System.in);

    while (!teclado.hasNext("FIM")) {
      int aux = teclado.nextInt();
      arrayPesquisa[cont] = jogadorData[aux];
      cont++;
    }

    teclado.nextLine();
    teclado.nextLine();

    int aux = teclado.nextInt();

    for (int i = 0; i < aux; i++) {
      String action = teclado.next();
      if (action.equals("II")) {
        int id = teclado.nextInt();
        inserirInicio(id, jogadorData, arrayPesquisa);
      } else if (action.equals("IF")) {
        int id = teclado.nextInt();
        inserirFinal(arrayPesquisa, jogadorData, id);
      } else if (action.equals("I*")) {
        int pos = teclado.nextInt();
        int id = teclado.nextInt();
        inserirPos(arrayPesquisa, jogadorData, id, pos);
      } else if (action.equals("RI")) {
        System.out.println("(R) " + removerInicio(arrayPesquisa));
      } else if (action.equals("RF")) {
        System.out.println("(R) " + removerFinal(arrayPesquisa));
      } else if (action.equals("R*")) {
        int pos = teclado.nextInt();
        System.out.println("(R) " + removerPos(arrayPesquisa, pos));
      }
    }

    for (int i = 0; i < cont; i++) {
      System.out.print("[" + i + "]");
      arrayPesquisa[i].imprimir();
    }

    teclado.close();

  }

}