package org.example;

public class Main {

    public static void stampaTabellina(int numero){
        System.out.println("Tabellina del " + numero + ":");
        for (int i = 1; i <= 10; i++){
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void main(String[] args) {
        int numero = 7;
        stampaTabellina(numero);
    }
}