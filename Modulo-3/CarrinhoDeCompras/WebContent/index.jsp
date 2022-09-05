<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dados.Carrinho"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mercado Online</title>
	</head>
	<body>
	
		<h1>Mercado Online</h1>
		<h2>Página inicial</h2>
	
		<ul>
			<li><a href="./">Home</a></li>
			<li><a href="./produtos.jsp">Produtos</a></li>
			<li><a href="./carrinho.jsp">Carrinho</a></li>
		</ul>
	
		<%
		if(Carrinho.listar().isEmpty()){
		%>
		
		<h3>Seu carrinho está vazio!</h3>
		
		<%
		} else {
		%>
		
		<h3>Total do carrinho: R$ <%=Carrinho.getValor()%></h3>
		
		<%
		}
		%>
	</body>
</html>