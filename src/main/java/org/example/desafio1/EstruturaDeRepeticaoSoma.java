package org.example.desafio1;

public class EstruturaDeRepeticaoSoma {
    public static void main(String[] args) {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K += 1;
            SOMA += K;
            System.out.println(SOMA);
            // valor final de SOMA: 91
        }

    }
}
