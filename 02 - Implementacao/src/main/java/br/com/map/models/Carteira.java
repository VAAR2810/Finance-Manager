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
public class Carteira {
  
  @Id
  @GeneratedValue
  private long id;
  private double fundosTotais;
  private double fundoAtual;
  private Date dataInicio;
  private Date dataFechamento;
  private double gatos;
  
  public Carteira(){
    
  }

  /**
   * Construtor responsável por obter os dados direto.
   * 
   */
  public Carteira(double fundosTotais, double fundoAtual, Date dataInicio, Date dataFechamento,
      double gatos) {
    super();
    this.fundosTotais = fundosTotais;
    this.fundoAtual = fundoAtual;
    this.dataInicio = dataInicio;
    this.dataFechamento = dataFechamento;
    this.gatos = gatos;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getFundosTotais() {
    return fundosTotais;
  }

  public void setFundosTotais(double fundosTotais) {
    this.fundosTotais = fundosTotais;
  }

  public double getFundoAtual() {
    return fundoAtual;
  }

  public void setFundoAtual(double fundoAtual) {
    this.fundoAtual = fundoAtual;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFechamento() {
    return dataFechamento;
  }

  public void setDataFechamento(Date dataFechamento) {
    this.dataFechamento = dataFechamento;
  }

  public double getGatos() {
    return gatos;
  }

  public void setGatos(double gatos) {
    this.gatos = gatos;
  }

  @Override
  public String toString() {
    return "Carteira [id=" + id + ", fundosTotais=" + fundosTotais + ", fundoAtual=" + fundoAtual
        + ", dataInicio=" + dataInicio + ", dataFechamento=" + dataFechamento + ", gatos=" + gatos
        + "]";
  }
  
}
