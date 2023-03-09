package br.com.dio.estruturas_de_dados.lista.circular;

public class Main {

    public static void main(String[] args) {
        ListaCircular<String> listaCircular = new ListaCircular<>();

        System.out.println("Tamanho da lista: " + listaCircular.size());
        System.out.println("Lista está vazia: " + listaCircular.isEmpty());
        System.out.println(listaCircular);

        listaCircular.add("primeiro");
        System.out.println(listaCircular);

        try {
            listaCircular.remove(99);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            listaCircular.remove(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(listaCircular);

        listaCircular.add("primeiro");
        listaCircular.add("segundo");
        listaCircular.add("terceiro");
        listaCircular.add("quarto");
        System.out.println(listaCircular);

        System.out.println("Elemento de índice 0: " + listaCircular.get(0));
        System.out.println("Elemento de índice 1: " + listaCircular.get(1));
        System.out.println("Elemento de índice 2: " + listaCircular.get(2));
        System.out.println("Elemento de índice 3: " + listaCircular.get(3));
        System.out.println("Elemento de índice > 3: " + listaCircular.get(4));
        System.out.println("Elemento de índice > 4: " + listaCircular.get(5));
    }

}
