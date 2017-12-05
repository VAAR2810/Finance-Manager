package br.com.map.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author vaar|fals. Modelo apresentado pelo professor Leonardo C. Santos.
 *
 */
public class GeraTabelas {
  
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dao");
    factory.close();
  }
}
