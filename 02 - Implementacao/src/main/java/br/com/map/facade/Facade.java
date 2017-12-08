package br.com.map.facade;

import java.util.List;


import br.com.map.dao.finance.CarteiraDao;
import br.com.map.dao.finance.CompraDao;
import br.com.map.dao.finance.PessoaDao;
import br.com.map.dao.finance.ValorRecebidoDao;
import br.com.map.factory.Factory;
import br.com.map.models.Carteira;
import br.com.map.models.Compra;
import br.com.map.models.Pessoa;
import br.com.map.models.ValorRecebido;
import br.com.map.util.DaoException;

public class Facade {
  private PessoaDao pessoaDao;
  private CarteiraDao carteiraDao;
  private CompraDao comrpaDao;
  private ValorRecebidoDao valorRecebidoDao;
  
  
  
  public Facade() {
    super();
    this.pessoaDao = Factory.pessoaDao();
    this.carteiraDao = Factory.carteiraDao();
    this.comrpaDao = Factory.compraDao();
    this.valorRecebidoDao = Factory.valorRecebidoDao();
  }
  
  //Pessoa

  public void savePessoa(Pessoa pessoa) throws DaoException{
    pessoaDao.save(pessoa);
  }
  
  public void updatePessoa(Pessoa pessoa) throws DaoException{
    pessoaDao.update(pessoa);
  }
  
  public void removePessoa(Pessoa pessoa) throws DaoException{
    pessoaDao.remove(pessoa);
  }
  
  public Pessoa findPessoa(Long id) throws DaoException {
    return pessoaDao.find(id);
  }
  
  public List<Pessoa> listAllPessoa() throws DaoException{
    return pessoaDao.listAll();
  }
  
  //Compra
  public void saveCompra(Compra compra) throws DaoException{
    comrpaDao.save(compra);
  }
  
  public void updateCompra(Compra compra) throws DaoException{
    comrpaDao.update(compra);
  }
  
  public void removeCompra(Compra compra) throws DaoException{
    comrpaDao.remove(compra);
  }
  
  public Compra findCompra(Long id) throws DaoException {
    return comrpaDao.find(id);
  }
  
  public List<Compra> listAllCompra() throws DaoException{
    return comrpaDao.listAll();
  }
  
  //Carteira
  public void saveCarteira(Carteira compra) throws DaoException{
    carteiraDao.save(compra);
  }
  
  public void updateCarteira(Carteira compra) throws DaoException{
    carteiraDao.update(compra);
  }
  
  public void removeCarteira(Carteira compra) throws DaoException{
    carteiraDao.remove(compra);
  }
  
  public Carteira findCarteira(Long id) throws DaoException {
    return carteiraDao.find(id);
  }
  
  public List<Carteira> listAllCarteira() throws DaoException{
    return carteiraDao.listAll();
  }
  
//ValorPadrao
  public void saveValorRecebido(ValorRecebido valorRecebido) throws DaoException{
    valorRecebidoDao.save(valorRecebido);
  }
  
  public void updateValorRecebido(ValorRecebido valorRecebido) throws DaoException{
    valorRecebidoDao.update(valorRecebido);
  }
  
  public void removeValorRecebido(ValorRecebido valorRecebido) throws DaoException{
    valorRecebidoDao.remove(valorRecebido);
  }
  
  public ValorRecebido findValorRecebido(Long id) throws DaoException {
    return valorRecebidoDao.find(id);
  }
  
  public List<ValorRecebido> listAllValorRecebido() throws DaoException{
    return valorRecebidoDao.listAll();
  }
}
