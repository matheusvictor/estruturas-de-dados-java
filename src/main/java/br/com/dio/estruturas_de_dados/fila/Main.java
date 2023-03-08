package br.com.dio.estruturas_de_dados.fila;

public class Main {
    public static void main(String[] args) {

        Fila<String> fila = new Fila();

        System.out.println("Fila vazia: " + fila.isEmpty());
        fila.enqueue("primeiro");
        fila.enqueue("segundo");
        fila.enqueue("terceiro");
        fila.enqueue("quarto");
        // fila.enqueue(1); // linha apresenta erro de compilação, pois a fila instanciada aceita apenas objetos do tipo String
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
