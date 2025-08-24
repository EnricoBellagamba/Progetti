package it.unisa.SMS;

import java.time.LocalDate;

public class SMS {

  private String mittente;
  private LocalDate data;
  private int id;
  private String testo;

  public SMS (String mittente, LocalDate data, int id, String testo){
      this.mittente = mittente;
      this.data = data;
      this.id = id;
      this.testo = testo;
  }

  public LocalDate getDate(){
      return data;
    }
    public String getMittente(){
      return mittente;
    }

    public String toString(){
      return "mittente: " + mittente +
              "\ndata: " + data +
              "\nid: " + id +
              "\ntesto: " + testo;
    }

}