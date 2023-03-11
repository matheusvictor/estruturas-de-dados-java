package br.com.dio.estruturas_de_dados.arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void insert(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        this.noRaiz = this.insertNo(this.noRaiz, novoNo);
    }

    private BinNo<T> insertNo(BinNo<T> noAtual, BinNo<T> novoNo) {
        if (noAtual == null) { // Árvore vazia, então novoNo deve ser a Raiz
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0) { // testa se o conteúdo do novoNo é menor que conteúdo do noAtual
            noAtual.setNoEquerdo(this.insertNo(noAtual.getNoEquerdo(), novoNo));
        } else {
            noAtual.setNoDireito(
                    this.insertNo(noAtual.getNoDireito(), novoNo)
            );
        }
        return noAtual;
    }

    public void inOrder() {
        this.inOrder(this.noRaiz);
    }

    private void inOrder(BinNo<T> noAtual) {
        if (noAtual != null) {
            this.inOrder(noAtual.getNoEquerdo());
            System.out.println(noAtual.getConteudo() + ", ");
            this.inOrder(noAtual.getNoDireito());
        }
    }

    public void posOrder() {
        this.posOrder(this.noRaiz);
    }

    private void posOrder(BinNo<T> noAtual) {
        if (noAtual != null) {
            this.posOrder(noAtual.getNoEquerdo());
            this.posOrder(noAtual.getNoDireito());
            System.out.println(noAtual.getConteudo() + ", ");
        }
    }

    public void preOrder() {
        this.preOrder(this.noRaiz);
    }

    private void preOrder(BinNo<T> noAtual) {
        if (noAtual != null) {
            System.out.println(noAtual.getConteudo() + ", ");
            this.preOrder(noAtual.getNoEquerdo());
            this.preOrder(noAtual.getNoDireito());
        }
    }

}
