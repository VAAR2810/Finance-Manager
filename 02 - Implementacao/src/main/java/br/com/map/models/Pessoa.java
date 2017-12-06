package br.com.map.models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * 
 * @author vaar|fals.
 *
 */
@Entity
public class Pessoa {
  
  @Id
  @GeneratedValue
  private long id;
  private String nome;
  private String login;
  private String senha;
  private boolean admin;
  
  @ManyToMany
  private List<Carteira> carteiras;
  
  @OneToMany
  private List<Compra> compras;
  
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
    //carteiras = new ArrayList<Carteira>();
  }
  
  /**
   * Construtor responsável por inserir uma carteira.
   * 
   */
  public Pessoa(Carteira carteira) {
    //carteiras.add(carteira);
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
        + ", admin=" + admin + "";
  }

}
