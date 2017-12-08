package br.com.map.menu;

import java.util.Date;
import java.util.Scanner;


import br.com.map.facade.Facade;
import br.com.map.factory.Factory;
import br.com.map.models.Compra;
import br.com.map.util.DaoException;
import br.com.map.util.Data;

public class MenuCompra {
  private Facade facade = new Facade();
  private Scanner sc = new Scanner(System.in);

  public void menuCompra() {
    System.out.println("Menu de Compra");
    System.out.println("01 - Inserir Compra");
    System.out.println("02 - Atualizar compra");
    System.out.println("03 - Remover compra");
    System.out.println("04 - Listar compra");

    int op = sc.nextInt();
    sc.nextLine();
    
    switch (op) {
    case 01:
      try {
        facade.saveCompra(inserirCompra());;
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao inserir a Compra");
      }
      break;
    case 02:
      try {
        facade.updateCompra(atualizarCompra());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao atualizar a Compra");
      }
      break;
    case 03:
      try {
        facade.removeCompra(removerCompra());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao deletar a Compra");
      }
      break;
    case 04:
      try {
        for (Compra c : facade.listAllCompra()) {
          System.out.println(c);
        }
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao listar as Compra");
      }
      break;

    default:

      System.out.println("OPs, Opção errada.");

      break;
    }
  }

  private Compra removerCompra() {
    Long id;
    Compra compra = null;

    try {
      for (Compra c : facade.listAllCompra()) {
        System.out.println(c);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Compras");
    }

    System.out.println("Qual deseja Remover ? OBS: pegue o ID");
    id = sc.nextLong();

    try {
      compra = facade.findCompra(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Compra");
    }
    return compra;
  }

  private Compra atualizarCompra() {
    Long id;
    String descricao;
    Date data;
    double valor = 0;
    
    Compra compra = null;
    String date;
    
    try {
      for (Compra c : facade.listAllCompra()) {
        System.out.println(c);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Compras");
    }
    
    System.out.println("Qual deseja editar ? OBS: pegue o ID");
    id = sc.nextLong();
    sc.nextLine();
    
    try {
      compra = facade.findCompra(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Compra");
    }

    System.out.println("Editar Compra");
    System.out.println("01 - Informe uma descricao");
    descricao = sc.nextLine();

    System.out.println("02 - Informe o valor");
    valor = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    data = Data.stringToDate(date);
    
    compra.setData(data);
    compra.setDescricao(descricao);
    compra.setValor(valor);
    compra.setSubvalor(valor);
    compra.setTipo(true);
    
    return compra;
    
  }

  private Compra inserirCompra() {
    String descricao;
    Date data;
    double valor = 0;
    
    String date;

    System.out.println("Inserir Compra");
    System.out.println("01 - Informe uma descricao");
    descricao = sc.nextLine();

    System.out.println("02 - Informe o valor");
    valor = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    data = Data.stringToDate(date);

    return Factory.compra(descricao, data, valor, valor, true);
  }
  
}
