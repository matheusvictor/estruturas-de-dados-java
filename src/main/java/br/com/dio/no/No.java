package br.com.dio.no;

public class No {

    private String conteudo;
    private No proximoNo;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.proximoNo = null;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    @Override
    public String toString() {
        return "No { conteudo= " + conteudo + " }";
    }
}
