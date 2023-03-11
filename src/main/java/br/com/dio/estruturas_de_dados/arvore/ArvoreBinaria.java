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

    public void remove(T conteudo) throws NullPointerException {
        try {
            BinNo<T> noAtual = this.noRaiz;
            BinNo<T> noPai = null;
            BinNo<T> noFilho = null;
            BinNo<T> noTemp = null;

            while (noAtual != null && !noAtual.getConteudo().equals(conteudo)) {
                noPai = noAtual;
                if (conteudo.compareTo(noAtual.getConteudo()) < 0) { // conteúdo passado como parâmetro é menor do que o conteúdo armazenado em noAtua
                    noAtual = noAtual.getNoEquerdo(); // assim, devemos continuar buscando o conteúdo no lado esquerdo da Árvore
                } else {
                    noAtual = noAtual.getNoDireito();
                }
            }

            // caso a Raiz seja nula ou, ao percorrer a Árvore, chegamos a uma Folha
            if (noAtual == null) {
                throw new NullPointerException("Conteúdo não encontrado!");
            }

            if (noPai == null) { // remoção da Raiz. Por ser Raiz, este Nó não tem um Pai
                if (noAtual.getNoDireito() == null) {
                    this.noRaiz = noAtual.getNoEquerdo();
                } else if (noAtual.getNoEquerdo() == null) {
                    this.noRaiz = noAtual.getNoDireito();
                } else {
                    for (noTemp = noAtual, noFilho = noAtual.getNoEquerdo();
                         noTemp.getNoDireito() != null;
                         noTemp = noFilho, noFilho = noFilho.getNoEquerdo()
                    ) {
                        if (noFilho != noAtual.getNoEquerdo()) {
                            noTemp.setNoDireito(noFilho.getNoEquerdo());
                            noFilho.setNoEquerdo(this.noRaiz.getNoEquerdo());
                        }
                    }
                    noFilho.setNoDireito(this.noRaiz.getNoDireito());
                    this.noRaiz = noFilho;
                }

            } else if (noAtual.getNoDireito() == null) {
                if (noPai.getNoEquerdo() == noAtual) {
                    noPai.setNoEquerdo(noAtual.getNoEquerdo());
                } else {
                    noPai.setNoDireito(noAtual.getNoEquerdo());
                }
            } else if (noAtual.getNoEquerdo() == null) {
                if (noPai.getNoEquerdo() == noAtual) {
                    noPai.setNoEquerdo(noAtual.getNoDireito());
                } else {
                    noPai.setNoDireito(noAtual.getNoDireito());
                }
            } else {
                for (
                        noTemp = noAtual, noFilho = noAtual.getNoEquerdo();
                        noFilho.getNoDireito() != null;
                        noTemp = noFilho, noFilho = noFilho.getNoDireito()
                ) {
                    if (noFilho != noAtual.getNoEquerdo()) {
                        noTemp.setNoDireito(noFilho.getNoEquerdo());
                        noFilho.setNoEquerdo(noAtual.getNoEquerdo());
                    }
                    noFilho.setNoDireito(noAtual.getNoDireito());
                    if (noPai.getNoEquerdo() == noAtual) {
                        noPai.setNoEquerdo(noFilho);
                    } else {
                        noPai.setNoDireito(noFilho);
                    }
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Conteúdo não encontrado!");
        }
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
