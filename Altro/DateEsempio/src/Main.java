import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Persona p1 = new Persona("Mario", OffsetDateTime.now());
        // System.out.println(p1);
        // Persona p2 = new Persona(null, OffsetDateTime.now());

        //DateTimeFormatter formatterIta = DateTimeFormatter.ofPattern("dd/MM/yy");
        Scanner scn = new Scanner(System.in);
        List<Persona> persone = new ArrayList<>();

        Boolean scelta = true;
        while (scelta) {
            System.out.println("Inserisci nome: ");
            String inputNome = scn.nextLine();
            System.out.println("Inserisci data di nascita: ");
            String inputData = scn.nextLine();
            Persona p1 = new Persona(inputNome, OffsetDateTime.parse(inputData + "T00:00:00Z"));
            persone.add(p1);
            //System.out.println(p1);
            System.out.println("Vuoi continuare ad inserire? y/n");
            String sceltaUtente = scn.nextLine();
            if(sceltaUtente.equals("n")){
                scelta = false;
            }
        }
        System.out.println(persone);
        scn.close();
    }
}