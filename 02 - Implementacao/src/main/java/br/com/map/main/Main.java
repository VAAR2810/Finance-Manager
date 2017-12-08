package br.com.map.main;


import java.util.Scanner;


import br.com.map.menu.MenuCarteira;
import br.com.map.menu.MenuCompra;
import br.com.map.menu.MenuPessoa;
import br.com.map.menu.MenuValorRecebido;
import br.com.map.util.DaoException;


/**
 * 
 * @author vaar|fals.
 *
 */
public class Main {

  public static void main(String[] args) throws DaoException {
    Scanner sc = new Scanner(System.in);
    int op = 1;
    while (op != 0) {

      System.out.println("MENU Inicial");
      System.out.println("1 - opçoes de Pessoa");
      System.out.println("2 - opçoes Carteira");
      System.out.println("3 - opçoes valor recebido");
      System.out.println("4 - opçoes compra");
      System.out.println("0 - SAIR");

      System.out.println("faça sua escolha.");
      op = sc.nextInt();

      switch (op) {
      case 1:
        MenuPessoa m = new MenuPessoa();
        m.menuPessoa();
        break;
      case 2:
        MenuCarteira mca = new MenuCarteira();
        mca.menuCarteira();
        break;
      case 3:
        MenuValorRecebido mvr = new MenuValorRecebido();
        mvr.menuValorRecebido();
        break;
      case 4:
        MenuCompra mc = new MenuCompra();
        mc.menuCompra();
        break;

      case 0:
        System.out.println("Valeu!");
        break;

      default:
        System.out.println("OPs, Opção ainda não disponivel");
        break;
      }

    }
  }

}
