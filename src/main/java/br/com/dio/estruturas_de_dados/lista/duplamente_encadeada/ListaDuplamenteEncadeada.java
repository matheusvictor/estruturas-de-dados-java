package br.com.dio.estruturas_de_dados.lista.duplamente_encadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    private NoDuplo<T> getNo(int indice) {
        NoDuplo<T> noAuxiliar = this.primeiroNo;

        for (int i = 0; (i < indice) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

}
