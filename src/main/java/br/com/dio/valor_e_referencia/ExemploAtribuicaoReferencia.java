package br.com.dio.valor_e_referencia;

public class ExemploAtribuicaoReferencia {

    public static void main(String[] args) {

        int primeiroNumero = 1;

        // atribuindo uma cópia do valor da variável primeiroNumero para a variável segundoNumero
        int segundoNumero = primeiroNumero;

        System.out.println("Primeiro número: " + primeiroNumero);
        System.out.println("Segundo número: " + segundoNumero);
        primeiroNumero++; // modificando o valor armazenado na variável primeiroNumero

        System.out.println("Primeiro número: " + primeiroNumero); // apenas o valor da variável primeiroNumero foi alterado
        System.out.println("Segundo número: " + segundoNumero); // segundoNumero permanece com o mesmo valor copiado que foi lhe atriuído durante a inicialização

        MeuObjeto objetoA = new MeuObjeto(10);
        MeuObjeto objetoB = objetoA; // atribuindo a cópia do valor da referência de objetoA para objetoB

        // ambos objetos possuem o mesmo valor, pois apontam para a mesma referência
        System.out.println("ID objetoA: " + objetoA);
        System.out.println("ID objetoB: " + objetoB);

        objetoA.setIdentificador(30); // alterando o ID do objetoA

        System.out.println("ID objetoA: " + objetoA);
        System.out.println("ID objetoB: " + objetoB); // objetoB também é alterado, pois aponta para a mesma referência de objetoA

    }

}
