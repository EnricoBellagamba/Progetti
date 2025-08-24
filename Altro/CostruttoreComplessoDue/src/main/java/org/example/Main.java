// costruttore getter setter con scanner e controllo immissione dati

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
        return """
                Nome: %s
                Cognome: %s
                Identificativo: %d
                """.formatted(nome, cognome, identificativo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione degli studenti
        Studente studente1 = new Studente(); // Costruttore di default
        Studente studente2 = new Studente("Ares", "Bortolussi", 123456);
        Studente studente3 = new Studente(scanner); // Input da utente

        // Array di studenti
        Studente[] studenti = {studente1, studente2, studente3};

        // Stampa l'elenco dei nomi
        System.out.println("\nLista studenti disponibili:");
        for (Studente s : studenti) {
            System.out.println("- " + s.nome);
        }

        // Chiedi all'utente quale studente visualizzare
        Studente studenteScelto = null;
        while (studenteScelto == null) {
            System.out.print("\nInserisci il nome dello studente per visualizzare i dettagli: ");
            String nomeCercato = scanner.nextLine();

            for (Studente s : studenti) {
                if (s.nome.equalsIgnoreCase(nomeCercato)) {
                    studenteScelto = s;
                    break; // Esce dal ciclo appena trova il nome
                }
            }

            if (studenteScelto == null) {
                System.out.println("ERRORE: Nome non trovato. Riprova.");
            }
        }

        // Mostra i dettagli dello studente scelto
        System.out.println("\nDettagli dello studente:");
        System.out.println(studenteScelto);

        scanner.close();
    }
}