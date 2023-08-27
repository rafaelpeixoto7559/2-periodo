using System;
using System.Collections;
    
//Faça uma classe Pilha contendo um atributo do tipo ArrayList, os métodos inserir, remover e mostrar os elementos da sua pilha.
class Pilha {
  ArrayList arrayList;
  public Pilha (){
    arrayList = new ArrayList();
  }
  public void Inserir(int valor){
    arrayList.Add(valor);
  }
  public int Remover(){
    int resp = (int)arrayList[arrayList.Count-1];
    arrayList.RemoveAt(arrayList.Count-1);
    return resp;
  }
  public void Mostrar(){
    for (int i = arrayList.Count - 1; i >= 0; i--){
      Console.WriteLine(arrayList[i]);
    }
  }
}
class ExercicioComplementarU02S01EC02 {
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