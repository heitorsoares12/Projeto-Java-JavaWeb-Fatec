<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/CSS/estilo.css" rel="stylesheet" type="text/css"/> 


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Cidade</title>
    </head>
    <body>
        <h1>Cadastrar Cidade</h1>
        
        <form action="SalvarCidade" method="POST">
            <label for="idcidade">ID Cidade</label>
            <input type="number" name="idcidade" value="${oCidade.idCidade}">
            <br /><br />
            <label for="nomecidade">Nome cidade</label>
            <input type="text" name="nomecidade" value="${oCidade.nomeCidade}">
            <br /><br />
            Estado
            <select class="form-select" aria-label="Default select example"name="idestado">
                <c:forEach items="${listadeestados}" var="estado">
                <option value="${estado.idEstado}"
                        ${estado.idEstado==oCidade.estado.idEstado?'selected':''}>
                        ${estado.siglaEstado} - ${estado.nomeEstado}
                
                </option>
                </c:forEach>
            </select>
                <br /><br />
               
                <input type="submit" value="Salvar">
        </form>
                ${mensagem}
                
           <h1>Lista de Cidade</h1>
                
           <table class="minimalistBlack">
           <thead>
           <th>ID Cidade</th>
           <th>Nome Cidade</th>
           <th>Sigla Estado</th>
           <th>Nome Estado</th>
           <th colspan="1">Excluir</th>
           <th colspan="2">Editar</th>
           </thead>
    <tbody>
        <c:forEach var="cidade" items="${listadecidades}">
            <tr>
                <td>${cidade.idCidade}</td>
                <td>${cidade.nomeCidade}</td>
                <td>${cidade.estado.siglaEstado}</td>
                <td>${cidade.estado.nomeEstado}</td>
                <td><a href="ExcluirCidade?idcidadeexcluir=${cidade.idCidade}">Excluir</a></td>
                <td><a href="CarregarCidade?idcidadecarregar=${cidade.idCidade}">Editar</a></td>
                        
                </tr>
            </c:forEach>
    </tbody>
    </table>
 </body>

</html>