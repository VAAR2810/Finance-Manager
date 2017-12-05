package br.com.map.models;

import java.util.Date;

/**
 * 
 * @author vaar|fals.
 *
 */
public class ValorPadrao extends ValorRecebido {
  private long id;
  private Date expira;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
    return "ValorPadrao [id=" + id + ", expira=" + expira + ", fechamento="
        + fechamento + "]";
  }

}
