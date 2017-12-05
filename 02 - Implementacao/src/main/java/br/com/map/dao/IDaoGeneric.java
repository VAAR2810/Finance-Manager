package br.com.map.dao;

import br.com.map.util.DaoException;

import java.util.List;
import org.hibernate.Criteria;

/**
 * 
 * @author vaar|fals. Modelo apresentado pelo professor Leonardo C. Santos.
 *
 */
public interface IDaoGeneric<T> {

  void save(T t) throws DaoException;


  void update(T t) throws DaoException;


  void remove(T t) throws DaoException;


  T find(Long id) throws DaoException;


  List<T> listAll() throws DaoException;


  Criteria getCriteria();

}
