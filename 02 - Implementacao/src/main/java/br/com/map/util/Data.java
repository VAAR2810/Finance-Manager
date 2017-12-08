package br.com.map.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

  public static Date stringToDate(String s){
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Date date = null;
    try {
      date = (Date)format.parse(s);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao converter data");
    }
    
    return date;
  }
  
}
