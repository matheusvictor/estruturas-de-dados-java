package br.com.dio.estruturas_de_dados.fila;

public class No<T> {

    private T conteudo;
    private No<T> refProximoNo;

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.refProximoNo = null;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setRefProximoNo(No<T> refProximoNo) {
        this.refProximoNo = refProximoNo;
    }

    public No<T> getRefProximoNo() {
        return refProximoNo;
    }

    @Override
    public String toString() {
        return "No { conteudo= " + conteudo + " }";
    }
}
