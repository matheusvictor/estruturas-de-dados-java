package br.com.dio.fila;

public class Fila {

    private No<Object> refNoEntrada; // a entrada da fila se dá no final desta!

    public Fila() {
        this.refNoEntrada = null;
    }

    public void enqueue(Object obj) {
        No<Object> novoNo = new No<>(obj);
        // Ao inserir um novo Nó, a ref. de próximo deste deve ser o antigo último Nó da fila
        novoNo.setRefProximoNo(this.refNoEntrada);
        this.refNoEntrada = novoNo; // o novo Nó inserido passa a ser a ref. de entrada da fila, afinal ele passa a ser o último!
    }

    public Object dequeue() {
        if (!this.isEmpty()) {

            boolean naoEhPrimeiroNo = true;
            No<Object> primeiroNo = this.refNoEntrada;
            No<Object> noAnterior = this.refNoEntrada;

            while (naoEhPrimeiroNo) {
                if (primeiroNo.getRefProximoNo() != null) {
                    noAnterior = primeiroNo;
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    noAnterior.setRefProximoNo(null);
                    naoEhPrimeiroNo = false;
                }
            }
            return primeiroNo.getConteudo();
        }
        return null;
    }

    public Object first() {
        if (!this.isEmpty()) {
            boolean naoEhPrimeiroNo = true;
            No<Object> primeiroNo = this.refNoEntrada;

            while (naoEhPrimeiroNo) {
                if (primeiroNo.getRefProximoNo() != null) {
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    naoEhPrimeiroNo = false;
                }
            }
            return primeiroNo.getConteudo();
        }
        return null;
    }

    public boolean isEmpty() {
        return refNoEntrada == null;
    }

    @Override
    public String toString() {

        boolean refEntradaNaoNula = true;
        No<Object> noAuxiliar = this.refNoEntrada;
        StringBuilder retorno = new StringBuilder();

        while (refEntradaNaoNula) {
            retorno.append("[No {objeto = ").append(noAuxiliar.getConteudo()).append("}] ==> ");
            if (noAuxiliar.getRefProximoNo() != null) {
                noAuxiliar = noAuxiliar.getRefProximoNo();
            } else {
                retorno.append("null");
                refEntradaNaoNula = false;
            }
        }
        return retorno.toString();
    }
}
