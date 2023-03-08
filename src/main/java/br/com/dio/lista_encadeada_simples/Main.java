package br.com.dio.lista_encadeada_simples;

public class Main {

    public static void main(String[] args) {

        ListaEncadeadaSimples<String> listaEncadeadaSimples = new ListaEncadeadaSimples<>();

        System.out.println("Lista vazia: " + listaEncadeadaSimples.isEmpty());
        System.out.println("Tamanho da lista: " + listaEncadeadaSimples.size());

        listaEncadeadaSimples.add("primeiro");
        listaEncadeadaSimples.add("segundo");
        listaEncadeadaSimples.add("terceiro");
        listaEncadeadaSimples.add("quarto");

        System.out.println("Lista vazia: " + listaEncadeadaSimples.isEmpty());
        System.out.println("Tamanho da lista: " + listaEncadeadaSimples.size());

        System.out.println("Lista completa: " + listaEncadeadaSimples);

        try {
            System.out.println("Segundo elemento da lista: " + listaEncadeadaSimples.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(listaEncadeadaSimples);

        try {
            System.out.println("Item removido: " + listaEncadeadaSimples.remove(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(listaEncadeadaSimples);

    }

}
