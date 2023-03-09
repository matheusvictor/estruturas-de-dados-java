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

    public void add(T conteudo) {
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);

        novoNo.setProximoNo(null); // como está sendo adicionado ao final da lista, o último Nó precisa sempre apontar para null
        novoNo.setNoAnterior(this.ultimoNo); // caso novoNo seja o primeiro Nó inserido na lista, o ultimoNo ainda será nulo nesse momento

        if (this.primeiroNo == null) this.primeiroNo = novoNo;
        if (this.ultimoNo != null) this.ultimoNo.setProximoNo(novoNo);

        this.ultimoNo = novoNo;
        this.tamanhoLista++;
    }

    public void add(T conteudo, int indice) {

        NoDuplo<T> noAuxiliar = this.getNo(indice);
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setProximoNo(noAuxiliar);

        if (novoNo.getProximoNo() != null) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getProximoNo().setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }

        if (indice == 0) this.primeiroNo = novoNo;
        else novoNo.getNoAnterior().setProximoNo(novoNo);

        this.tamanhoLista++;
    }

    public NoDuplo<T> remove(int indice) {
        NoDuplo<T> noARemover = null;

        if (this.isEmpty()) {
            throw new NullPointerException("A lista está vazia!");
        }

        if (indice == 0) { // caso seja o primeiro elemento da lista a ser removido...
            this.primeiroNo = this.primeiroNo.getProximoNo(); // o primeiroNo passa a ser o segundo elemento da lista

            if (this.primeiroNo != null) {  // verifica se o segundo Nó da lista existe
                this.primeiroNo.setNoAnterior(null); // e define seu noAnterior como nulo, afinal, o antigo primeiroNo foi removido
            }

        } else {
            noARemover = this.getNo(indice);
            noARemover
                    .getNoAnterior()
                    .setProximoNo(noARemover.getProximoNo());

            if (noARemover != this.ultimoNo) { // caso não esteja no último Nó da lista...
                noARemover
                        .getProximoNo() // significa que há um outro Nó após este...
                        .setNoAnterior(noARemover.getNoAnterior()); // e, neste caso, o Nó anterior do Nó que sucede noARemover passa a ser o anterior deste noARemover
            }
        }
        this.tamanhoLista--;
        return noARemover;
    }

    public boolean isEmpty() {
        return tamanhoLista == 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    private NoDuplo<T> getNo(int indice) {
        NoDuplo<T> noAuxiliar = this.primeiroNo; // usa o primeiroNo como ponto de entrada na lista

        for (int i = 0; (i < indice) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getProximoNo(); // se o prox. Nó após noAuxiliar atual não for nulo, significa que é possível caminhar na lista, pois ainda há Nós à frente
        }

        return noAuxiliar;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = this.primeiroNo; // a impressão se dará a partir do primeiro elemento da lista

        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No { conteúdo = " + noAuxiliar.getConteudo() + " }] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
