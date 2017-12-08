package br.com.map.menu;

import java.util.Date;
import java.util.Scanner;


import br.com.map.facade.Facade;
import br.com.map.factory.Factory;
import br.com.map.models.Carteira;
import br.com.map.util.DaoException;
import br.com.map.util.Data;

public class MenuCarteira {
  private Facade facade = new Facade();
  private Scanner sc = new Scanner(System.in);

  public void menuCarteira() {
    System.out.println("Menu da Carteira");
    System.out.println("01 - Inserir Carteira");
    System.out.println("02 - Atualizar Carteira");
    System.out.println("03 - Remover Carteira");
    System.out.println("04 - Listar Carteira");

    int op = sc.nextInt();
    sc.nextLine();
    
    switch (op) {
    case 01:
      try {
        facade.saveCarteira(inserirCarteira());;
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao inserir a Carteira");
      }
      break;
    case 02:
      try {
        facade.updateCarteira(atualizarCarteira());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao atualizar a Carteira");
      }
      break;
    case 03:
      try {
        facade.removeCarteira(removerCarteira());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao deletar a Carteira");
      }
      break;
    case 04:
      try {
        for (Carteira c : facade.listAllCarteira()) {
          System.out.println(c);
        }
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao listar as Carteira");
      }
      break;

    default:

      System.out.println("OPs, Opção errada.");

      break;
    }
  }

  private Carteira atualizarCarteira() {
    Long id;
    Date dataInicio;
    Date dataFechamento;
    double fundosTotais = 0;
    
    Carteira carteira = null;
    String date;
    
    try {
      for (Carteira c : facade.listAllCarteira()) {
        System.out.println(c);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Carteira");
    }
    
    System.out.println("Qual deseja editar ? OBS: pegue o ID");
    id = sc.nextLong();
    sc.nextLine();
    
    try {
      carteira = facade.findCarteira(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Carteira");
    }

    System.out.println("Editar Carteira");
    System.out.println("01 - Informe o fundo Total");
    fundosTotais = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    dataInicio = Data.stringToDate(date);
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    dataFechamento = Data.stringToDate(date);
    
    carteira.setFundosTotais(fundosTotais);
    carteira.setDataInicio(dataInicio);
    carteira.setDataFechamento(dataFechamento);
    
    
    return carteira;
  }

  private Carteira removerCarteira() {
    Long id;
    Carteira carteira = null;

    try {
      for (Carteira c : facade.listAllCarteira()) {
        System.out.println(c);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Carteira");
    }

    System.out.println("Qual deseja Remover ? OBS: pegue o ID");
    id = sc.nextLong();

    try {
      carteira = facade.findCarteira(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Carteira");
    }
    return carteira;
  }

  private Carteira inserirCarteira() {
    Date dataInicio;
    Date dataFechamento;
    double fundosTotais = 0;
    
    String date;

    System.out.println("Inserir Carteira");
    System.out.println("01 - Informe o fundo Total");
    fundosTotais = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    dataInicio = Data.stringToDate(date);
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    dataFechamento = Data.stringToDate(date);
    
    
    return Factory.carteira(fundosTotais, dataInicio, dataFechamento);
  }

}
