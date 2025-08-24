package it.unisa.SMS;

import java.time.LocalDate;
import java.util.List;

public class SMSMain {
    public static void main(String[] args) {
        SMSOrganizer o = new SMSOrganizer();

        SMS sms1 = new SMS("ABC", LocalDate.now().minusDays(5), 1, "ABnbf D");
        SMS sms2 = new SMS("GD", LocalDate.now(), 2, "asdfasefC D");
        SMS sms3 = new SMS("FJASDF", LocalDate.now().minusDays(2), 3, "ABC D");

        o.aggiungiMessaggio(sms1);
        o.aggiungiMessaggio(sms2);
        o.aggiungiMessaggio(sms3);
        //
         List<SMS> lista1 = o.getListByDate();

//        System.out.println(lista1);

        for (SMS s : lista1){
            System.out.println(s);
        }


        // List<SMS> lista2 = o.getListBySender();
    }
}
