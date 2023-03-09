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

    public void remove(int indice) {
        if (indice >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("Índice não existe nesta lista!");
        }

        No<T> noARemover = this.noCauda;
        if (indice == 0) {
            this.noCauda = this.noCauda.getProximoNo();
            this.noCabeca.setProximoNo(this.noCauda);
        } else if (indice == 1) {
            this.noCauda.setProximoNo(this.noCauda.getProximoNo().getProximoNo());
        } else {
            for (int i = 0; i < (indice - 1); i++) {
                noARemover = noARemover.getProximoNo(); // percorrendo a lista até chegar ao Nó a ser removido
            }
            noARemover.setProximoNo(noARemover.getProximoNo().getProximoNo());
        }
        this.tamanhoLista--;
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
