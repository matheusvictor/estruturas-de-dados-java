package br.com.dio.no;

public class Main {
    public static void main(String[] args) {

        No primeiroNo = new No("A");
        No segundoNo = new No("B");
        No terceiroNo = new No("C");

        primeiroNo.setProximoNo(segundoNo); // apontando a próxima ref. de primeiroNo para segundoNo
        segundoNo.setProximoNo(terceiroNo);

        System.out.println(primeiroNo);
        System.out.println(segundoNo);
        System.out.println(terceiroNo);
        System.out.println(terceiroNo.getProximoNo()); // imprimindo o próximo Nó de terceiroNo, que neste caso é nulo

    }
}
