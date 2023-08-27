using System;
using System.Collections;


//Faça uma classe Pilha contendo dois atributos do tipo Queue, os métodos inserir, remover e mostrar os elementos da sua pilha.
class Pilha {
  Queue p1, p2;
  public Pilha (){
    p1 = new Queue();
    p2 = new Queue();
  }
  public void Inserir(int valor){
    p1.Enqueue(valor);
  }
  public int Remover(){
    while(p1.Count > 1){
      p2.Enqueue(p1.Dequeue());
    }
    int resp = (int)p1.Dequeue();
    while(p2.Count > 0){
      p1.Enqueue(p2.Dequeue());
    }
    return resp;
  }
  public void Mostrar(){
    object[] array = p1.ToArray();
    for (int i = p1.Count - 1; i >= 0; i--){
      Console.WriteLine(array[i]);
    }
  }
}
class ExercicioComplementarU02S01EC03 {
  public static void Main (string[] args) {
    Pilha pilha = new Pilha();

    for(int i = 0; i < 10; i++){
      pilha.Inserir(i);
    }
    Console.WriteLine(pilha.Remover());
    pilha.Inserir(10);
    Console.WriteLine(pilha.Remover());
    pilha.Inserir(11);
    Console.WriteLine(pilha.Remover());
    pilha.Inserir(12);

    Console.WriteLine("======== Mostrar");
    pilha.Mostrar();
  }
}