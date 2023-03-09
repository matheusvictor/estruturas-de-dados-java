package br.com.dio.estruturas_de_dados.lista.duplamente_encadeada;

public class Main {
    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<>();

        System.out.println("Lista vazia: " + listaDuplamenteEncadeada.isEmpty());
        System.out.println("Tamanho da lista: " + listaDuplamenteEncadeada.size());

        listaDuplamenteEncadeada.add("primeiro");
        listaDuplamenteEncadeada.add("segundo");
        listaDuplamenteEncadeada.add("terceiro");
        listaDuplamenteEncadeada.add("quarto");

        System.out.println("Lista vazia: " + listaDuplamenteEncadeada.isEmpty());
        System.out.println("Tamanho da lista: " + listaDuplamenteEncadeada.size());

        System.out.println("Lista completa: " + listaDuplamenteEncadeada);

        try {
            System.out.println("Segundo elemento da lista: " + listaDuplamenteEncadeada.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(listaDuplamenteEncadeada);

        try {
            System.out.println("Item removido: " + listaDuplamenteEncadeada.remove(2));
            listaDuplamenteEncadeada.add("99", 2);
            System.out.println("Novo item inserido na posição do item removido: " + listaDuplamenteEncadeada.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(listaDuplamenteEncadeada);
    }
}
