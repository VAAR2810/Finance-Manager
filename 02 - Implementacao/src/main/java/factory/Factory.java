package factory;

import java.util.Date;


import br.com.map.dao.finance.PessoaDao;
import br.com.map.models.Carteira;
import br.com.map.models.Compra;
import br.com.map.models.Pessoa;
import br.com.map.models.ValorPadrao;
import br.com.map.models.ValorRecebido;
import facade.Facade;

public class Factory {
  
  public static final Facade facade(){
    return new Facade();
  }
  
  public static final Pessoa pessoa(String nome, String login, String senha, Boolean admin){
    return new Pessoa(nome, login, senha, admin);
  }
  
  public static final Compra compra(String descricao, Date data, double subvalor, double valor, boolean tipo){
    return new Compra(descricao, data, subvalor, valor, tipo);
  }
  
  public static final ValorPadrao valorPadrao(Date expira, Date fechamento){
    return new ValorPadrao(expira, fechamento);
  }
  
  public static final ValorRecebido valorRecebido(String comentario, double valor, Date data){
    return new ValorRecebido(comentario, valor, data);
  }
  
  public static final Carteira carteira(double fundosTotais, Date dataInicio, Date dataFechamento){
    return new Carteira(fundosTotais, dataInicio, dataFechamento);
  }
  
  public static final PessoaDao pessoaDao(){
    return new PessoaDao();
  }
  
}
