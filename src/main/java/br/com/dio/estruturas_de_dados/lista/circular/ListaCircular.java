package br.com.dio.estruturas_de_dados.lista.circular;

import br.com.dio.estruturas_de_dados.no.No;

public class ListaCircular<T> {

    private No<T> noCauda;
    private No<T> noCabeca;
    private int tamanhoLista;

    public ListaCircular() {
        this.noCabeca = null;
        this.noCauda = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    private No<T> getNo(int indice) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("A lista está vazia!");
        } else if (indice > this.tamanhoLista) {
            throw new IndexOutOfBoundsException("Índice não existe nesta lista!");
        } else {
            if (indice == 0) {
                return this.noCauda;
            }

            No<T> noAuxiliar = this.noCauda;
            for (int i = 0; i < indice; i++) {
                noAuxiliar = noAuxiliar.getProximoNo();
            }
            return noAuxiliar;
        }
    }


}
