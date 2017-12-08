package br.com.map.menu;

import java.util.Date;
import java.util.Scanner;


import br.com.map.facade.Facade;
import br.com.map.factory.Factory;
import br.com.map.models.ValorRecebido;
import br.com.map.util.DaoException;
import br.com.map.util.Data;

public class MenuValorRecebido {
  private Facade facade = new Facade();
  private Scanner sc = new Scanner(System.in);
  
  public void menuValorRecebido() {
    System.out.println("Menu de Valor Recebido");
    System.out.println("01 - Inserir Valor Recebido");
    System.out.println("02 - Atualizar Valor Recebido");
    System.out.println("03 - Remover Valor Recebido");
    System.out.println("04 - Listar Valor Recebido");

    int op = sc.nextInt();
    sc.nextLine();
    
    switch (op) {
    case 01:
      try {
        facade.saveValorRecebido(inserirValorRecebido());;
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao inserir o Valor Recebido");
      }
      break;
    case 02:
      try {
        facade.updateValorRecebido(atualizarValorRecebido());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao atualizar o Valor Recebido");
      }
      break;
    case 03:
      try {
        facade.removeValorRecebido(removerValorRecebido());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao deletar o Valor Recebido");
      }
      break;
    case 04:
      try {
        for (ValorRecebido vr : facade.listAllValorRecebido()) {
          System.out.println(vr);
        }
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao listar os Valor Recebido");
      }
      break;

    default:

      System.out.println("OPs, Opção errada.");

      break;
    }
  }
  private ValorRecebido atualizarValorRecebido() {
    Long id;
    String comentario;
    Date data;
    double valor = 0;
    
    ValorRecebido valorRecebido = null;
    String date;
    
    try {
      for (ValorRecebido vr : facade.listAllValorRecebido()) {
        System.out.println(vr);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Valor Recebido");
    }
    
    System.out.println("Qual deseja editar ? OBS: pegue o ID");
    id = sc.nextLong();
    sc.nextLine();
    
    try {
      valorRecebido = facade.findValorRecebido(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Valor Recebido");
    }

    System.out.println("Editar ValorRecebido");
    System.out.println("01 - Informe uma descricao");
    comentario = sc.nextLine();

    System.out.println("02 - Informe o valor");
    valor = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    data = Data.stringToDate(date);
    
    valorRecebido.setData(data);
    valorRecebido.setComentario(comentario);
    valorRecebido.setValor(valor);
    
    return valorRecebido;
  }
  private ValorRecebido removerValorRecebido() {
    Long id;
    ValorRecebido valorRecebido = null;

    try {
      for (ValorRecebido c : facade.listAllValorRecebido()) {
        System.out.println(c);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir Valor Recebido");
    }

    System.out.println("Qual deseja Remover ? OBS: pegue o ID");
    id = sc.nextLong();

    try {
      valorRecebido = facade.findValorRecebido(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Valor Recebido");
    }
    return valorRecebido;
  }
  private ValorRecebido inserirValorRecebido() {
    String comentario;
    Date data;
    double valor = 0;
    
    String date;

    System.out.println("Inserir Valor Recebido");
    System.out.println("01 - Informe um comentario");
    comentario = sc.nextLine();

    System.out.println("02 - Informe o valor");
    valor = sc.nextDouble();
    sc.nextLine();
    
    System.out.println("03 - Informe a Data - dia/mes/ano");
    date = sc.nextLine();
    data = Data.stringToDate(date);

    return Factory.valorRecebido(comentario, valor, data);
  }
}
