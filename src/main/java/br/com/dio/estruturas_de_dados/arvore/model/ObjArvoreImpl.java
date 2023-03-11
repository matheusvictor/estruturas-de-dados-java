package br.com.dio.estruturas_de_dados.arvore.model;

import java.util.Objects;

public class ObjArvoreImpl extends ObjArvore<ObjArvoreImpl> {

    Integer valor;

    public ObjArvoreImpl(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) return true;
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass())
            return false; // se são Clases diferentes...
        ObjArvoreImpl meuObjeto = (ObjArvoreImpl) outroObjeto; // casting do outroObjeto para o tipo ObjArvoreImpl
        return Objects.equals(this.valor, meuObjeto.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.valor);
    }

    @Override
    public int compareTo(ObjArvoreImpl outroObjeto) {
        int valorDeComparacao = 0;
        if (this.valor > outroObjeto.valor) {
            valorDeComparacao = 1;
        } else if (this.valor < outroObjeto.valor) {
            valorDeComparacao = -1;
        }
        return valorDeComparacao;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }
}
