package br.com.dio.pilha;

public class Main {
    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        No<Integer> primeiroNo = new No<>(1);
        No<Integer> segundoNo = new No<>(2);
        No<Integer> terceiroNo = new No<>(3);
        No<Integer> quartoNo = new No<>(4);

        System.out.println("Pilha vazia: " + pilha.isEmpty());
        pilha.push(primeiroNo); // inserindo o primeiro Nó na pilha
        System.out.println("Pilha vazia: " + pilha.isEmpty());
        pilha.push(segundoNo);
        pilha.push(terceiroNo);
        pilha.push(quartoNo);

        System.out.println(pilha); // impressão da pilha
        System.out.println("Topo da pilha: " + pilha.top());
        System.out.println("Nó removido: " + pilha.pop()); // removendo o Nó do topo da pilha e exibindo qual foi o Nó removido
        System.out.println("Topo da pilha: " + pilha.top()); // impressão do novo topo, após a remoção do anterior.

        pilha.push(new No<>(99));
        System.out.println("Topo da pilha: " + pilha.top()); // impressão do novo topo, após a adição de um novo Nó

    }
}
