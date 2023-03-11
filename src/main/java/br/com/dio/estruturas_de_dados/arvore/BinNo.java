package br.com.dio.estruturas_de_dados.arvore;

public class BinNo<T extends Comparable<T>> {

    private T conteudo;
    private BinNo<T> noEquerdo;
    private BinNo<T> noDireito;

    public BinNo(T conteudo) {
        this.noEquerdo = null;
        this.noDireito = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public BinNo<T> getNoEquerdo() {
        return noEquerdo;
    }

    public void setNoEquerdo(BinNo<T> noEquerdo) {
        this.noEquerdo = noEquerdo;
    }

    public BinNo<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(BinNo<T> noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public String toString() {
        return "BinNo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
