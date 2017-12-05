package br.com.map.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vaar|fals.
 *
 */
public class Pessoa {
  
  private long id;
  private String nome;
  private String login;
  private String senha;
  private boolean admin;
  private List<Carteira> carteiras;
  
  public Pessoa(){
    
  }
  
  /**
   * Construtor responsável por obter os dados direto.
   * 
   */
  public Pessoa(String nome, String login, String senha, Boolean admin) {
    this.nome = nome;
    this.login = login;
    this.senha = senha;
    this.admin = admin;
    carteiras = new ArrayList<Carteira>();
  }
  
  /**
   * Construtor responsável por inserir uma carteira.
   * 
   */
  public Pessoa(Carteira carteira) {
    carteiras.add(carteira);
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  @Override
  public String toString() {
    return "Pessoa [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha
        + ", admin=" + admin + ", carteiras=" + carteiras + "]";
  }

}
