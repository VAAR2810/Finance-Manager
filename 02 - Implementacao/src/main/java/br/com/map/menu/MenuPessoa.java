package br.com.map.menu;


import java.util.Scanner;


import br.com.map.facade.Facade;
import br.com.map.factory.Factory;
import br.com.map.models.Pessoa;
import br.com.map.util.DaoException;


public class MenuPessoa {
  private Facade facade = new Facade();
  private Scanner sc = new Scanner(System.in);


  public void menuPessoa() {
    System.out.println("Menu Pessoa");
    System.out.println("01 - Inserir pessoa");
    System.out.println("02 - Atualizar pessoa");
    System.out.println("03 - Remover pessoa");
    System.out.println("04 - Listar pessoas");

    int op = sc.nextInt();
    sc.nextLine();
    
    switch (op) {
    case 01:
      try {
        facade.savePessoa(inserirPessoa());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao inserir a Pessoa");
      }
      break;
    case 02:
      try {
        facade.updatePessoa(atualizarPessoa());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao atualizar a Pessoa");
      }
      break;
    case 03:
      try {
        facade.removePessoa(removerPessoa());
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao deletar a Pessoa");
      }
      break;
    case 04:
      try {
        for (Pessoa p : facade.listAllPessoa()) {
          System.out.println(p);
        }
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Erro ao listar as pessoas");
      }
      break;

    default:

      System.out.println("OPs, Opção errada.");

      break;
    }
  }


  private Pessoa removerPessoa() {
    Long id;
    Pessoa pessoa = null;

    try {
      for (Pessoa p : facade.listAllPessoa()) {
        System.out.println(p);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir pessoas");
    }

    System.out.println("Qual deseja Remover ? OBS: pegue o ID");
    id = sc.nextLong();

    try {
      pessoa = facade.findPessoa(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Usuario");
    }
    return pessoa;
  }


  private Pessoa inserirPessoa() {
    String nome;
    String login;
    String senha;
    Boolean admin = false;
    String op;

    System.out.println("Inserir Pessoa");
    System.out.println("01 - Informe o nome");
    nome = sc.nextLine();

    System.out.println("02 - Informe o Login");
    login = sc.nextLine();

    System.out.println("03 - Informe a Senha");
    senha = sc.nextLine();

    System.out.println("04 - Essa pessoa é Adm?");
    System.out.println("1 - Sim, 2 Não");
    op = sc.nextLine();

    if (op.equalsIgnoreCase("1")) {
      admin = true;
    } else if (op.equalsIgnoreCase("2")) {
      admin = false;
    } else {
      System.out.println("OPs, Opção errada.");
    }

    return Factory.pessoa(nome, login, senha, admin);

  }


  private Pessoa atualizarPessoa() {
    Long id;
    String nome;
    String login;
    String senha;
    Boolean admin = false;
    String op;
    Pessoa pessoa = null;

    try {
      for (Pessoa p : facade.listAllPessoa()) {
        System.out.println(p);
      }
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro Ao exibir pessoas");
    }

    System.out.println("Qual deseja editar ? OBS: pegue o ID");
    id = sc.nextLong();

    try {
      pessoa = facade.findPessoa(id);
    } catch (DaoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("Erro ao buscar Usuario");
    }

    System.out.println("Inserir Pessoa");
    System.out.println("01 - Informe o nome");
    nome = sc.nextLine();

    System.out.println("02 - Informe o Login");
    login = sc.nextLine();

    System.out.println("03 - Informe a Senha");
    senha = sc.nextLine();

    System.out.println("04 - Essa pessoa é Adm?");
    System.out.println("1 - Sim, 2 Não");
    op = sc.nextLine();

    if (op.equalsIgnoreCase("1")) {
      admin = true;
    } else if (op.equalsIgnoreCase("2")) {
      admin = false;
    } else {
      System.out.println("OPs, Opção errada.");
    }

    pessoa.setAdmin(admin);
    pessoa.setLogin(login);
    pessoa.setNome(nome);
    pessoa.setSenha(senha);

    return pessoa;
  }

}
