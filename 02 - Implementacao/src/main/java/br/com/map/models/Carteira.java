package br.com.map.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 
 * @author vaar|fals.
 *
 */
@Entity
public class Carteira {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  
  @Column(name = "fundos_totais")
  private double fundosTotais;
  
  @Column(name = "fundo_atual")
  private double fundoAtual;
  
  @Temporal(TemporalType.DATE)
  @Column(name = "data_inicio")
  private Date dataInicio;
  
  @Temporal(TemporalType.DATE)
  @Column(name = "data_fechamento")
  private Date dataFechamento;
  
  @Column(name = "novos_valores_recebidos")
  @ManyToMany
  private List<ValorRecebido> recebido;
  
  @Column(name = "novos_valores_padroes")
  @ManyToMany
  private List<ValorPadrao> recebidoPadrao;
  
  @Column(name = "nova_compra")
  @OneToMany
  private List<Compra> compras;
  
  @Transient
  private double gatos;
  
  public Carteira(){
    
  }

  /**
   * Construtor responsável por obter os dados direto.
   * 
   */
  
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

  public List<ValorRecebido> getRecebido() {
    return recebido;
  }

  public void setRecebido(List<ValorRecebido> recebido) {
    this.recebido = recebido;
  }

  public List<ValorPadrao> getRecebidoPadrao() {
    return recebidoPadrao;
  }

  public void setRecebidoPadrao(List<ValorPadrao> recebidoPadrao) {
    this.recebidoPadrao = recebidoPadrao;
  }

  public List<Compra> getCompras() {
    return compras;
  }

  public void setCompras(List<Compra> compras) {
    this.compras = compras;
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
        + ", dataInicio=" + dataInicio + ", dataFechamento=" + dataFechamento + ", recebido="
        + recebido + ", recebidoPadrao=" + recebidoPadrao + ", compras=" + compras + ", gatos="
        + gatos + "]";
  }
  
}
