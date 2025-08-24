class Media {

    public static double mediaPesata(Integer[] valori, Integer[] pesi){
        if (valori == null || pesi == null){
            throw new IllegalArgumentException("Gli array non possono essere null");
        }
        if (valori.length != pesi.length){
                throw new IllegalArgumentException("Gli array devono avere la stessa lunghezza");
        }
        int sommaPesata = 0, sommaPesi = 0;

        for (int i = 0; i < valori.length; i++){
            if (valori[i] == null || pesi[i] == null){
                throw new IllegalArgumentException("I valori della stringa sono null");
            }
            sommaPesata += valori[i] * pesi[i];
            sommaPesi += pesi[i];
        }
        if (sommaPesi == 0){
            throw new ArithmeticException("La somma dei pesi è uguale a 0");
        }
        return (double) sommaPesata / sommaPesi;
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            Integer[] valori = {60, 70, 80};
            Integer[] pesi = {2, 3, 4};
            double risultato1 = Media.mediaPesata(valori, pesi);
            String output = String.format("Risultato: %.1f", risultato1);
            System.out.println(output);
        } catch (IllegalArgumentException | ArithmeticException e){
            System.out.println("Errore" + e.getMessage());
        }
    }
}

/*
Esercizio — Calcolo della media pesata
Obiettivo:
Scrivi una funzione mediaPesata(Integer[] valori, Integer[] pesi) che:
Accetta due array della stessa lunghezza:
uno con i valori, uno con i pesi corrispondenti.
Controlla che:
nessuno dei due array sia null,
nessun elemento al loro interno sia null,
gli array abbiano stessa lunghezza,
la somma dei pesi sia diversa da zero.
Calcola e restituisce la media pesata:
media pesata
=
∑
(
𝑣
𝑎
𝑙
𝑜
𝑟
𝑒
𝑖
×
𝑝
𝑒
𝑠
𝑜
𝑖
)
∑
𝑝
𝑒
𝑠
𝑜
𝑖
media pesata=
∑peso
i
​

∑(valore
i
​
 ×peso
i
​
 )
​
In main, crea due chiamate alla funzione, gestite con blocchi try-catch:
una valida,
una con un errore di null o di array di lunghezza diversa.
 */