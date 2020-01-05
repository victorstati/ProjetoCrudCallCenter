<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fornecedores</title>
<style>
        body{
            font-family: sans-serif;
        }

        table{
            border-collapse: collapse;
            width: 80%;
            margin: auto;
            background: beige;
        }

        td{
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }

        th{
            background: #bfc361;
            border: 2px solid chocolate;
            padding: 15px;
        }
        
        h2{
        	text-align: center;
        }
    </style>
</head>
<body>
	
	<form method="POST" action="fornecedorServlet">
		 <input type="hidden" name="acao" value="CREATE"/>
		 <input type="hidden" name="codigo" value="${fornecedor.codigo}"/>
	     Codigo <input type="text" disabled name="codigo" value="${fornecedor.codigo}"/> <br>
	     Nome Fantasia <input type="text" name="nome" value="${fornecedor.nome}"/> <br>
	     Razao Social <input type="text"  name="razaoSocial" value="${fornecedor.razaoSocial}"/> <br>
	     Cnpj <input type="text"  name="cnpj" value="${fornecedor.cnpj}"/> <br>
	     Email <input type="text"  name="email" value="${fornecedor.email}"/> <br>
		 <input type="submit" value="Enviar" />
	</form>

	<font color="red">
		<h2>${mensagem}</h2>
	</font>
	<h4>Fornecedores Cadastrados</h4>
	
	<table border=1>
		<tr>
			<th>Código</th>
			<th>Nome Fantasia</th>
			<th>Razao Social</th>
			<th>CNPJ</th>
			<th>Email</th>
			<th>Editar</th>
			<th>Excluir</th>	
		</tr>
		<c:forEach var="f" items="${fornecedores}">
			<tr>
				<td>${f.codigo}</td>
				<td>${f.nome}</td>
				<td>${f.razaoSocial}</td>
				<td>${f.cnpj}</td>
				<td>${f.email}</td>
				<td><a href="fornecedorServlet?acao=RETRIEVE&codigo=${f.codigo}">Editar</a></td>
				<td><a href="fornecedorServlet?acao=DELETE&codigo=${f.codigo}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>