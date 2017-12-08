package br.com.map.facade;

import java.util.HashMap;


import br.com.map.dao.finance.CarteiraDao;
import br.com.map.dao.finance.CompraDao;
import br.com.map.dao.finance.PessoaDao;
import br.com.map.dao.finance.ValorPadraoDao;
import br.com.map.dao.finance.ValorRecebidoDao;
import br.com.map.factory.Factory;
import br.com.map.models.Carteira;
import br.com.map.models.Compra;
import br.com.map.models.Pessoa;
import br.com.map.models.ValorPadrao;
import br.com.map.models.ValorRecebido;
import br.com.map.util.DaoException;

public class Facade {
  private PessoaDao pessoaDao;
  private CarteiraDao carteiraDao;
  private CompraDao comrpaDao;
  private ValorPadraoDao valorPadraoDao;
  private ValorRecebidoDao valorRecebidoDao;
  
  
  
  public Facade() {
    super();
    this.pessoaDao = Factory.pessoaDao();
    this.carteiraDao = Factory.carteiraDao();
    this.comrpaDao = Factory.compraDao();
    this.valorPadraoDao = Factory.valorPadraoDao();
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
  
  public void findPessoa(Pessoa pessoa) throws DaoException {
    pessoaDao.remove(pessoa);
  }
  
  public void listAllPessoa() throws DaoException{
    pessoaDao.listAll();
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
  
  public void findCompra(Compra compra) throws DaoException {
    comrpaDao.remove(compra);
  }
  
  public void listAllCompra() throws DaoException{
    comrpaDao.listAll();
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
  
  public void findCarteira(Carteira compra) throws DaoException {
    carteiraDao.remove(compra);
  }
  
  public void listAllCarteira() throws DaoException{
    carteiraDao.listAll();
  }
  
  
  //ValorPadrao
  public void saveValorPadrao(ValorPadrao valorPadrao) throws DaoException{
    valorPadraoDao.save(valorPadrao);
  }
  
  public void updateValorPadrao(ValorPadrao valorPadrao) throws DaoException{
    valorPadraoDao.update(valorPadrao);
  }
  
  public void removeValorPadrao(ValorPadrao valorPadrao) throws DaoException{
    valorPadraoDao.remove(valorPadrao);
  }
  
  public void findValorPadrao(ValorPadrao valorPadrao) throws DaoException {
    valorPadraoDao.remove(valorPadrao);
  }
  
  public void listAllValorPadrao() throws DaoException{
    valorPadraoDao.listAll();
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
  
  public void findValorRecebido(ValorRecebido valorRecebido) throws DaoException {
    valorRecebidoDao.remove(valorRecebido);
  }
  
  public void listAllValorRecebido() throws DaoException{
    valorRecebidoDao.listAll();
  }
}
