package br.com.dio.estruturas_de_dados.lista.simplesmente_encadeada;

import br.com.dio.estruturas_de_dados.no.No;

public class ListaEncadeadaSimples<T> {

    private No<T> noRefEntrada;

    public ListaEncadeadaSimples() {
        this.noRefEntrada = null;
    }

    public boolean isEmpty() {
        return this.noRefEntrada == null;
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> refAuxiliar = this.noRefEntrada;

        while (true) {
            if (refAuxiliar != null) {
                tamanhoLista++;
                if (refAuxiliar.getProximoNo() != null) {
                    refAuxiliar = refAuxiliar.getProximoNo(); // se o próximo Nó a partir do Nó de referência, não for nulo, o Nó de ref. passa a ser esse próximo
                } else break; // se o próximo Nó a partir do Nó de referência for nulo, o laço é quebrado para não continuar "caminhando" para frente
            } else break;
        }
        return tamanhoLista;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        // se a lista estiver vazia, o novoNo será adicionado e será a ref. de entrada na lista
        if (this.isEmpty()) {
            this.noRefEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = this.noRefEntrada;
        for (int i = 0; i < (this.size() - 1); i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        // quando o próximo Nó de noAuxiliar for nulo, deve passar a a pontar para novoNovo e este, por sua vez, deverá a pontar para nulo
        noAuxiliar.setProximoNo(novoNo);
    }

    public T remove(int indice) {
        No<T> noARemover = this.getNo(indice);

        // caso esteja removendo o primeiro Nó da lista...
        if (indice == 0) {
            this.noRefEntrada = noARemover.getProximoNo(); // o nó de entrada passa a ser o Nó imediatamente posterior ao Nó que será removido
        } else {
            No<T> noAnterior = getNo(indice - 1);
            noAnterior.setProximoNo(noARemover.getProximoNo());
        }
        return noARemover.getConteudo();
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    private No<T> getNo(int indice) {

        validaIndice(indice);

        No<T> no = null;
        No<T> noAuxiliar = this.noRefEntrada;

        if (!this.isEmpty()) {
            for (int i = 0; i <= indice ; i++) {
                no = noAuxiliar;
                noAuxiliar = noAuxiliar.getProximoNo();
            }
        }
        return no;
    }

    private void validaIndice(int indice) throws IndexOutOfBoundsException {
        if (indice >= this.size()) {
            throw new IndexOutOfBoundsException("Essa lista não possui conteúdo no índice " + indice);
        }
    }

    @Override
    public String toString() {
        StringBuilder strRetorno = new StringBuilder();
        No<T> noAuxiliar = this.noRefEntrada;
        for(int i = 0; i < size(); i++){
            strRetorno.append("[No { conteúdo = ").append(noAuxiliar.getConteudo()).append(" }]---> ");
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno.append("null");
        return strRetorno.toString();
    }
}
