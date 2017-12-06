<%-- 
    Document   : Gerar
    Created on : 31/10/2017, 19:44:54
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="web1.br.com.bean.Equipe_Aluno"%>
<%@page import="java.util.Random"%>
<%@page import="web1.br.com.bean.Tema"%>
<%@page import="web1.br.com.bean.Aluno"%>
<%@page import="web1.br.com.bean.Lista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerar</title>
        <link rel="stylesheet" type="text/css" href="style/style.css"/>
    </head>
    <body>
        <ul>
            <li><a href="index.html">Inicio</a></li>
            <li><a href="Aluno.html">Cadastrar Aluno</a></li>
            <li><a href="Tema.html">Cadastrar Tema</a></li>
            <li><a href="Gerar.jsp">Gerar</a></li>
        </ul>
        <center>
            <%  
                Random random = new Random();
                List<Tema> usados = new ArrayList<Tema>();
                for(Equipe_Aluno ea : Lista.equipes){
                    Tema tema = new Tema("a");
                    do {
                        tema = Lista.temas.get(random.nextInt(Lista.temas.size()));
                    } while(usados.contains(tema));
                    ea.setTema(tema);
                    usados.add(tema);
                }
            %>   
            <table>
                <tr>
                    <th>Aluno</th>
                    <th>Equipe</th>
                    <th>Tema</th>
                </tr>
                <%
                    for(Equipe_Aluno equipe: Lista.equipes){
                        for(Aluno a : equipe.getAluno()){
                %> 
                <tr>     
                    <td>
                        <%= a.getNome() %>
                    </td>
                    <td>
                        <%= equipe.getNumEquipe() %>
                    </td>
                    <td>
                        <%= equipe.getTema().getNome() %>
                    </td>
                </tr>
                <% }} %>
            </table>
        </center>
    </body>
</html>
