package br.com.map.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 * @author vaar|fals. Modelo apresentado pelo professor Leonardo C. Santos.
 *
 */
public final class PersistenceUtil {

  private static final String PERSISTENCE_UNIT_NAME = "mapFM";
  private static EntityManagerFactory entityManagerFactory = null;
  private static EntityManager entityManager = null;

  private PersistenceUtil() {
  }

  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // SINGLETON
  /** Abre a conexão com o Entity Manager.
   * 
   * @return conexão aberta.
   */
  public static EntityManager getEntityManager() {
    try {
      if (entityManager == null || !entityManager.isOpen()) {
        entityManager = entityManagerFactory.createEntityManager();
      }
      return entityManager;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  /** Fecha a conexão com o Entity Manager.
   * 
   */
  public static void closeEntityManager() {
    try {
      if (entityManager != null) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
          transaction.commit();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
  }

  public static void closeEntityManagerFactory() {
    closeEntityManager();
    entityManagerFactory.close();
  }
}