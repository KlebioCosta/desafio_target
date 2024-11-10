package org.example.desafio5;

public class InversaoDeString {
    public static void main(String[] args) {

        String mensagem = "Socorram-me subi no ônibus em Marrocos";

        String resultadoInvertido = inversortring(mensagem);
        System.out.printf("Frase: %s", resultadoInvertido);


    }

    public static String inversortring(String frase) {
        String invertida = "";

        for (int i = frase.length() - 1; i >= 0; i--) {
            invertida += frase.charAt(i);
        }
        return  invertida;
    }

};
