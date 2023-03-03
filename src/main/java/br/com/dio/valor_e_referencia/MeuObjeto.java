package br.com.dio.valor_e_referencia;

public class MeuObjeto {

    private int identificador;

    public MeuObjeto(int id) {
        this.identificador = id;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "ID do objeto: " + identificador;
    }
}
