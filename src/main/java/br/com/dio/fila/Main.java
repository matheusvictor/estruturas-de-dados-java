package br.com.dio.fila;

public class Main {
    public static void main(String[] args) {

        Fila fila = new Fila();

        System.out.println("Fila vazia: " + fila.isEmpty());
        fila.enqueue("primeiroNo");
        fila.enqueue("segundoNo");
        fila.enqueue("terceiroNo");
        fila.enqueue("quartoNo");
        System.out.println("Fila vazia: " + fila.isEmpty());
        System.out.println(fila);
        System.out.println("Primeiro da fila: " + fila.first()); // "consultando" o primeiro elemento da fila
        System.out.println(fila);
        System.out.println("Primeiro da fila (removido): " + fila.dequeue());  // removendo o primeiro elemento da fila
        System.out.println(fila); // fila atualizada após a remoção do primeiro elemento na linha anterior
        fila.enqueue("último"); // inserindo novo elemento no final da fila
        System.out.println(fila);

    }
}
