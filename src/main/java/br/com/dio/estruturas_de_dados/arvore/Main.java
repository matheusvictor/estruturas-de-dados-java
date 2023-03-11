package br.com.dio.estruturas_de_dados.arvore;

import br.com.dio.estruturas_de_dados.arvore.model.ObjArvoreImpl;

public class Main {
    public static void main(String[] args) {

        ArvoreBinaria<ObjArvoreImpl> arvoreBinaria = new ArvoreBinaria<>();

        System.out.println(arvoreBinaria);

        System.out.println("Inserindo Nós na Árvore...");
        arvoreBinaria.insert(new ObjArvoreImpl(13));
        arvoreBinaria.insert(new ObjArvoreImpl(10));
        arvoreBinaria.insert(new ObjArvoreImpl(25));
        arvoreBinaria.insert(new ObjArvoreImpl(2));
        arvoreBinaria.insert(new ObjArvoreImpl(12));
        arvoreBinaria.insert(new ObjArvoreImpl(20));
        arvoreBinaria.insert(new ObjArvoreImpl(31));
        arvoreBinaria.insert(new ObjArvoreImpl(29));

        System.out.println("Exibição da Árvore InOrder");
        arvoreBinaria.inOrder();
        System.out.println();
        System.out.println("Exibição da Árvore PreOrder");
        arvoreBinaria.preOrder();
        System.out.println();
        System.out.println("Exibição da Árvore PosOrder");
        arvoreBinaria.posOrder();
    }
}
