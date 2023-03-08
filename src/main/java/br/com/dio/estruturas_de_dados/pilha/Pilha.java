package br.com.dio.estruturas_de_dados.pilha;

public class Pilha {

    private No<Integer> refNoEntrada;

    public Pilha() {
        this.refNoEntrada = null;
    }

    public boolean isEmpty() {
        return refNoEntrada == null;
    }

    public No<Integer> top() {
        return this.refNoEntrada;
    }

    public void push(No<Integer> novoNo) {
        No<Integer> refNoAuxiliar = this.refNoEntrada; // guarda a referência do topo em um Nó auxiliar
        this.refNoEntrada = novoNo; // a referência de entrada passa a ser o novo Nó que foi inserido

        // a referência de próximo do novo Nó passa a ser o Nó anterior, cuja ref. está guardada na variável auxiliar refNoAuxiliar:
        novoNo.setRefProximoNo(refNoAuxiliar);
    }

    public No<Integer> pop() {
        if (!this.isEmpty()) { // a remoção só irá ocorrer caso haja presença de algum Nó na pilha
            No<Integer> noRetirado = this.refNoEntrada; // guarda a referência do Nó que será removido

            // o Nó de entrada passa a ser o Nó que está imediatamente abaixo do Nó que será removido
            this.refNoEntrada = this.refNoEntrada.getRefProximoNo();
            return noRetirado; // retorna a referência do Nó removido
        }
        return null; // caso a pilha esteja vazia, deverá retornar um ponteiro nulo
    }

    @Override
    public String toString() {

        boolean refEntradaNaoNula = true;
        No<Integer> noAuxiliar = this.refNoEntrada;
        StringBuilder retorno = new StringBuilder("------------------------\n");

        while (refEntradaNaoNula) {
            if (noAuxiliar != null) {
                retorno.append("[No {dado = ").append(noAuxiliar.getConteudo()).append("}]\n");
                noAuxiliar = noAuxiliar.getRefProximoNo(); // o Nó atual passa a ser o próximo Nó logo abaixo
            } else {
                refEntradaNaoNula = false;
            }
        }
        return retorno.append("------------------------\n").toString();
    }
}
