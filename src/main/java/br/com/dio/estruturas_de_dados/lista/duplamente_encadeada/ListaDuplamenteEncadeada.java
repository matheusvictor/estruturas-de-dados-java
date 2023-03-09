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

        if (indice == 0) this.primeiroNo = novoNo;
        else novoNo.getNoAnterior().setProximoNo(novoNo);

        if (novoNo.getProximoNo() != null) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getProximoNo().setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
        this.tamanhoLista++;
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

}
