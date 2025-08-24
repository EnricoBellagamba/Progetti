package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {

    private List<SMS> messaggi = new ArrayList<>();

    public void aggiungiMessaggio(SMS sms){
        messaggi.add(sms);
    }

    public List<SMS> getListByDate(){
        messaggi.sort(Comparator.comparing(SMS::getDate));
        return messaggi;
    }

    public List<SMS> getListBySender(){
        messaggi.sort(Comparator.comparing(SMS::getMittente));
        return messaggi;
    }

}
