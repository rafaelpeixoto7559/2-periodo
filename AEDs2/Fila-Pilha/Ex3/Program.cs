using System;
using System.Collections;


//Faça uma classe Fila contendo dois atributos do tipo Stack, os métodos inserir, remover e mostrar os elementos da sua fila.
class Fila {
  Stack p1, p2;
  public Fila (){
    p1 = new Stack();
    p2 = new Stack();
  }
  public void Inserir(int valor){
    p1.Push(valor);
  }
  public int Remover(){
    while(p1.Count > 1){
      p2.Push(p1.Pop());
    }
    int resp = (int)p1.Pop();
    while(p2.Count > 0){
      p1.Push(p2.Pop());
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
    Fila fila = new Fila();

    for(int i = 0; i < 10; i++){
      fila.Inserir(i);
    }
    Console.WriteLine(fila.Remover());
    fila.Inserir(10);
    Console.WriteLine(fila.Remover());
    fila.Inserir(11);
    Console.WriteLine(fila.Remover());
    fila.Inserir(12);

    Console.WriteLine("======== Mostrar");
    fila.Mostrar();
  }
}