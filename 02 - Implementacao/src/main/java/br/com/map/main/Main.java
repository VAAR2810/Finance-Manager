package br.com.map.main;

import javax.persistence.EntityManager;


import br.com.map.util.DaoException;
import br.com.map.util.PersistenceUtil;

/**
 * 
 * @author vaar|fals.
 *
 */
public class Main {
  
  public static void main(String[] args) throws DaoException {
    EntityManager factory = PersistenceUtil.getEntityManager();
    factory.close();
    
  }

}
