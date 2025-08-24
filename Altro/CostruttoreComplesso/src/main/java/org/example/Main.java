// costruttore getter setter con override

package org.example;

import java.util.Scanner;


class Studente {
    String nome;
    String cognome;
    int identificativo;

    // Costruttore di default (senza parametri)
    public Studente() {
        nome = "default";
        cognome = "default";
        identificativo = 7327;
    }

    // Costruttore (con parametri)
    public Studente(String nome, String cognome, int identificativo) {
        this.nome = nome;
        this.cognome = cognome;
        this.identificativo = identificativo;
    }

    // Costruttore che prende input dall'utente
    public Studente(Scanner scanner){
        System.out.print("Inserisci nome: ");
        this.nome = scanner.nextLine();
        System.out.print("Inserisca cognome: ");
        this.cognome = scanner.nextLine();
        System.out.print("Inserisca identificativo: ");
        while (!scanner.hasNextInt()){ // controllo sull'input (se è intero o no)
            System.out.print("ERRORE: Devi inserire un # int per l'ID ");
            scanner.next(); //consuma l'input errato
        }
        this.identificativo = scanner.nextInt();
        scanner.nextLine();

    }


    @Override
    public String toString() {
        return "Studente: " + nome + " " + cognome + " | ID: " + identificativo;
    }
}

public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Studente studente1 = new Studente(); // Usa il costruttore di default
        Studente studente2 = new Studente("Ares", "Bortolussi", 123456);
        Studente studente3 = new Studente(scanner); //chiedo all'utente

        System.out.println("\nlista studenti: ");
        System.out.println(studente1);
        System.out.println(studente2);
        System.out.println(studente3);


        scanner.close();

    }
}