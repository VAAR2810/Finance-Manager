package br.com.map.dao;

import br.com.map.util.DaoException;
import br.com.map.util.PersistenceUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 * 
 * @author vaar|fals. Modelo apresentado pelo professor Leonardo C. Santos.
 *
 */
public abstract class DaoGenericAbs<T> implements IDaoGeneric<T> {

  EntityManager manager;
  private final Class<T> classe;

  /** Construtor da classe. 
   * 
   */
  public DaoGenericAbs() {
    manager = PersistenceUtil.getEntityManager();
    this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  /**
   * Método generico responsável por pesistir uma entidade no banco de dados.
   *
   * @param t
   *            - entidade correspondente a ser persistido
   */
  public void save(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.persist(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }

  }

  /**
   * Método generico responsável por atualizar uma entidade no banco de dados.
   *
   * @param t
   *            - entidade correspondente a ser atualizada.
   *            
   */
  public void update(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.merge(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }

  }

  /**
   * Método genérico responsável por deletar uma entidade presente no banco de
   * dados.
   *
   * @param t
   *            entidade a ser deletada do banco de dados
   */
  public void remove(T t) throws DaoException {
    try {
      manager.getTransaction().begin();
      manager.remove(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }
  }

  /**
   * Método generico responsável por buscar uma determinada entidade por sua
   * identificação no banco de dados.
   *
   * @param id
   *            - identificação única da entidade
   * @return - entidade encontrada
   */
  public T find(Long id) throws DaoException {
    try {
      return (T) manager.find(classe, id);
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }
  }
  
  /**
   * Método generico responsável por buscar e retornar todas as entidades no
   * banco de dados correspondente ao @T (tipo da entidade).
   *
   * @return lista com todos as entidades persistidas de acordo com seu tipo
   */
  public List<T> listAll() throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.addOrder(Order.asc("id")); // orderBy id;
      return (List<T>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }
  }

  /**
   * Método responsável por retornar o criteria;
   *
   * @return criteria.
   */
  public Criteria getCriteria() {
    Session session = ((Session) manager.getDelegate());
    Criteria criteria = session.createCriteria(classe);
    return criteria;
  }

}
