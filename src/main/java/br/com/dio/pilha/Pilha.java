package br.com.dio.pilha;

public class Pilha {

    private No refNoEntrada;

    public Pilha() {
        this.refNoEntrada = null;
    }

    public boolean isEmpty() {
        return refNoEntrada == null;
    }

    public No top() {
        return this.refNoEntrada;
    }

    public void push(No novoNo) {
        No refNoAuxiliar = this.refNoEntrada; // guarda a referência do topo em um Nó auxiliar
        this.refNoEntrada = novoNo; // a referência de entrada passa a ser o novo Nó que foi inserido
        novoNo.setRefProximoNo(refNoAuxiliar);
    }

    public No pop() {
        if (!this.isEmpty()) {
            No noRetirado = this.refNoEntrada;
            this.refNoEntrada = this.refNoEntrada.getRefProximoNo();
            return noRetirado;
        }
        return null;
    }

}
