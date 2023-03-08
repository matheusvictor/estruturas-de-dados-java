package br.com.dio.estruturas_de_dados.no;

public class Main {
    public static void main(String[] args) {

        No<String> primeiroNo = new No<>("A");
        No<String> segundoNo = new No<>("B");
        No<String> terceiroNo = new No<>("C");

        primeiroNo.setProximoNo(segundoNo); // apontando a próxima ref. de primeiroNo para segundoNo
        segundoNo.setProximoNo(terceiroNo);

        System.out.println(primeiroNo);
        System.out.println(segundoNo);
        System.out.println(terceiroNo);
        System.out.println(terceiroNo.getProximoNo()); // imprimindo o próximo Nó de terceiroNo, que neste caso é nulo

    }
}
