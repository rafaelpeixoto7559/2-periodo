using System;
using System.Collections;

class Lista {
   private int[] array;
   private int n;

   public Lista () {
      array = new int[6];
      n = 0;
   }

   public Lista (int tamanho){
      array = new int[tamanho];
      n = 0;
   }

   public void InserirInicio(int x) {

      if(n >= array.Length){
         Console.WriteLine("Erro ao inserir!");
         Environment.Exit(0);
      } 

      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }

      array[0] = x;
      n++;
   }
      public void InserirFim(int x){

      //validar insercao
      if(n >= array.Length){
         Console.WriteLine("Erro ao inserir!");
         Environment.Exit(0);         
      }

      array[n] = x;
      n++;
   }

   public void Inserir(int x, int pos){

      if(n >= array.Length || pos < 0 || pos > n){
         Console.WriteLine("Erro ao inserir!");
         Environment.Exit(0);         
      }

      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }

      array[pos] = x;
      n++;
   }

   public int RemoverInicio(){

      if (n == 0) {
         Console.WriteLine("Erro ao remover!");
         Environment.Exit(0);         
      }

      int resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

   public int RemoverFim(){

      if (n == 0) {
         Console.WriteLine("Erro ao remover!");
         Environment.Exit(0);         
      }

      return array[--n];
   }

   public int Remover(int pos){

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         Console.WriteLine("Erro ao remover!");
         Environment.Exit(0);         
      }

      int resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

   public void Mostrar(){
      Console.Write("[ ");
      for(int i = 0; i < n; i++){
         Console.Write(array[i] + " ");
      }
      Console.WriteLine("]");
   }

   public bool Pesquisar(int x) {
      bool retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }
}

class ExercicioResolvido01ListaSequencial {
 	public static void Main (string[] args) {
      Console.WriteLine("==== LISTA SEQUENCIAL ====");
      Lista lista = new Lista();
      int x1, x2, x3;

      lista.InserirInicio(1);
      lista.InserirInicio(0);
      lista.InserirFim(2);
      lista.InserirFim(3);
      lista.Inserir(4, 3);
      lista.Inserir(5, 2);

      Console.Write("Apos insercoes: ");
      lista.Mostrar();

      x1 = lista.RemoverInicio();
      x2 = lista.RemoverFim();
      x3 = lista.Remover(2);

      Console.Write("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
      lista.Mostrar();
   }
}