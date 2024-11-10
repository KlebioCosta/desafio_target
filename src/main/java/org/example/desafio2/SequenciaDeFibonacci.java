package org.example.desafio2;

import java.util.Scanner;

public class SequenciaDeFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" -=-= Verificador de números Fibonacci =-=-");
        System.out.print("Infome um número para verificação: ");
        int numero = sc.nextInt();

        if(verificadorFibonacci(numero)) {
            System.out.printf("O número %d pertence a sequência de Fibonaci. ", numero);
        } else {
            System.out.printf("O %d \"NÃO\" pertence a sequência de Fibonacci.", numero);
        }

        sc.close();
    }
    public static boolean verificadorFibonacci(int numero) {
        int x = 0, y = 1;

        if(numero == 0){
            return true;
        }

        while (y < numero) {
            int marcador = y;
            y = x + y;
            x = marcador;
        }

        return y == numero;

    }

}
