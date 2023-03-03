package br.com.dio.no;

public class No<T> {

    private T conteudo;
    private No<T> proximoNo;

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proximoNo = null;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setProximoNo(No<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    public No<T> getProximoNo() {
        return proximoNo;
    }

    @Override
    public String toString() {
        return "No { conteudo= " + conteudo + " }";
    }
}
