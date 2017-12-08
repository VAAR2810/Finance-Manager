package facade;

import java.util.HashMap;


import br.com.map.dao.finance.PessoaDao;
import br.com.map.models.Pessoa;
import br.com.map.util.DaoException;
import factory.Factory;

public class Facade {
  private HashMap<Long, Pessoa> pessoas;
  private PessoaDao pessoaDao;
  
  public Facade() throws DaoException{
    pessoaDao = Factory.pessoaDao();
    pessoas = pessoaDao.all();
  }
  
  
}
