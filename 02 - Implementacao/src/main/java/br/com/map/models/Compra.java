package br.com.map.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author vaar|fals.
 *
 */
@Entity
public class Compra {
  
  @Id
  @GeneratedValue
  private long id;
  private String descricao;
  private Date data;
  private double subvalor;
  private double valor;
  private boolean tipo;
  
  public Compra(){
    
  }
  
  /**
   * Construtor responsável por obter os dados direto.
   * 
   */ 
  public Compra(String descricao, Date data, double subvalor, double valor, boolean tipo) {
    super();
    this.descricao = descricao;
    this.data = data;
    this.subvalor = subvalor;
    this.valor = valor;
    this.tipo = tipo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public double getSubvalor() {
    return subvalor;
  }

  public void setSubvalor(double subvalor) {
    this.subvalor = subvalor;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public boolean isTipo() {
    return tipo;
  }

  public void setTipo(boolean tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "Compra [id=" + id + ", Descricao=" + descricao + ", data=" + data + ", subvalor="
        + subvalor + ", valor=" + valor + ", tipo=" + tipo + "]";
  }
  
}
