package br.com.map.dao.finance;

import java.util.HashMap;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Order;


import br.com.map.dao.DaoGenericAbs;
import br.com.map.models.Pessoa;
import br.com.map.util.DaoException;

/**
 * 
 * @author vaar|fals. Modelo apresentado pelo professor Leonardo C. Santos.
 *
 */
public class PessoaDao extends DaoGenericAbs<Pessoa> {
  
  public HashMap<Long, Pessoa> all() throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.addOrder(Order.asc("id")); // orderBy id;
      HashMap<Long, Pessoa> hashMap = new HashMap<Long, Pessoa>();
      for (Pessoa pessoa : (List<Pessoa>) criteria.list()) {
        hashMap.put(pessoa.getId(), pessoa);
      }
      return hashMap;
    } catch (Exception e) {
      this.manager.getTransaction().rollback();
      throw new DaoException("deu mer#@");
    }
  }
}
