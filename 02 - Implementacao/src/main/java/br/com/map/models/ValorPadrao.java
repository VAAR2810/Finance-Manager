package br.com.map.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author vaar|fals.
 *
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class ValorPadrao extends ValorRecebido {
  
  @Temporal(TemporalType.DATE)
  private Date expira;
  @Temporal(TemporalType.DATE)
  private Date fechamento;
  
  public ValorPadrao(){
    
  }
  
  /**
   * Construtor responsável por obter os dados direto.
   * 
   */
  public ValorPadrao(Date expira, Date fechamento) {
    this.expira = expira;
    this.fechamento = fechamento;
  }
  
  public Date getExpira() {
    return expira;
  }

  public void setExpira(Date expira) {
    this.expira = expira;
  }

  public Date getFechamento() {
    return fechamento;
  }

  public void setFechamento(Date fechamento) {
    this.fechamento = fechamento;
  }

  @Override
  public String toString() {
    return "ValorPadrao [expira=" + expira + ", fechamento="
        + fechamento + "]";
  }

}
