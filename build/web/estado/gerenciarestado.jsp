<%-- 
    Document   : gerenciarestado
    Created on : 21/09/2021, 08:48:11
    Author     : Heitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Taglig - Uma biblioteca que permite que seja utilizado linguagem de programacao (logica de programacao)-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/CSS/estilo.css" rel="stylesheet" type="text/css"/> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Estado</title>
    </head>
    <body>
        <h1>Cadastrar Estado</h1>
        
        <form action="${pageContext.request.contextPath}/SalvarEstado">
            <label for="idEstado"> ID Estado</label>
            <input type="number" name="idEstado" value="${oEstado.idEstado}"
            <br/>
            <br/>
            <br/>
            <label for="nomeEstado"> Nome Estado</label>
            <input type="text" name="nomeEstado" value="${oEstado.nomeEstado}"
            <br/>
            <br/>
            <br/>
            <label for="siglaEstado"> Sigla Estado</label>
            <input type="text" name="siglaEstado" value="${oEstado.siglaEstado}"
            <br/>
            <br/>
            <br/>
            
            <input type="submit" value="Salvar"/>
         
        </form>
            <h3>${mensagem}</h3>
        <h1>Lista Estados</h1>
        <table class="minimalistBlack">
            <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Sigla</th>
            <th colspan="1">Excluir</th>
            <th colspan="2">Editar</th>
            </thead>
            <tbody>
                <c:forEach var="estado" items="${listadeestados}">
                    <tr>
                        <td>${estado.idEstado}</td>
                        <td>${estado.nomeEstado}</td>
                        <td>${estado.siglaEstado}</td>
                        <td><a href="ExcluirEstado?idestadoexcluir=${estado.idEstado}">Excluir</a></td>
                        <td><a href="CarregarEstado?idestadocarregar=${estado.idEstado}">Editar</a></td>
                    </tr>
                </c:forEach>    
            </tbody>
        </table>
        
    </body>
</html>
