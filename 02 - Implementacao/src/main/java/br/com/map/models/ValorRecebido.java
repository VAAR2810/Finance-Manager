package br.com.map.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author vaar|fals.
 *
 */
@Entity
public class ValorRecebido {
  @Id
  @GeneratedValue
  private long id;
  private String comentario;
  private double valor;
  @Temporal(TemporalType.DATE)
  private Date data;
  
  public ValorRecebido(){
    
  }
  
  /**
   * Construtor responsável por obter os dados direto.
   * 
   */
  public ValorRecebido(String comentario, double valor, Date data) {
    super();
    this.comentario = comentario;
    this.valor = valor;
    this.data = data;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "NovoValorRecebido [id=" + id + ", comentario=" + comentario + ", valor=" + valor
        + ", data=" + data + "]";
  }
  
  

}
