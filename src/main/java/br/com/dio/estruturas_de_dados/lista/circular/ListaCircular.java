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

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()) {
            this.noCabeca = novoNo;
            this.noCauda = this.noCabeca;
            this.noCabeca.setProximoNo(this.noCauda);
        } else {
            novoNo.setProximoNo(this.noCauda);
            this.noCabeca.setProximoNo(novoNo);
            this.noCauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void add(T conteudo, int indice) {
        // TODO: Implementar sobrecarga para inserir um novo Nó em um dado índice
    }

    public void remove(int indice) {
        if (indice >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("Esta lista não possui o índice " + indice + "!");
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

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.noCauda;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No { conteúdo = " + noAuxiliar.getConteudo() + " } --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += this.isEmpty() ? "A lista está vazia!" : this.noCauda;
        return strRetorno;
    }
}
