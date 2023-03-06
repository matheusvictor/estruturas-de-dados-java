package br.com.dio.fila;

public class Main {
    public static void main(String[] args) {

        Fila fila = new Fila();

        No<Object> primeiroNo = new No<>(1);
        No<Object> segundoNo = new No<>(2);
        No<Object> terceiroNo = new No<>(3);
        No<Object> quartoNo = new No<>(4);

        System.out.println("Fila vazia: " + fila.isEmpty());
        fila.enqueue(primeiroNo);
        fila.enqueue(segundoNo);
        fila.enqueue(terceiroNo);
        fila.enqueue(quartoNo);
        System.out.println("Fila vazia: " + fila.isEmpty());
        System.out.println(fila);
        System.out.println("Primeiro da fila: " + fila.first()); // "consultando" o primeiro elemento da fila
        System.out.println(fila);
        System.out.println("Primeiro da fila (removido): " + fila.dequeue());  // removendo o primeiro elemento da fila
        System.out.println(fila); // fila atualizada após a remoção do primeiro elemento na linha anterior
        fila.enqueue(new No<>("último")); // inserindo novo elemento no final da fila
        System.out.println(fila);

    }
}
