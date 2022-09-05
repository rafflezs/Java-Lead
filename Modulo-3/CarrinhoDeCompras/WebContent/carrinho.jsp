<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Item"%>
<%@ page import="dados.Carrinho"%>
<%@ page import="entidades.Produto"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Carrinho | Mercado Online</title>
	</head>
	<body>
	
		<h1>Mercado Online</h1>
		<h2>Carrinho</h2>
	
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
	
		<table>
			<tr>
				<td>Quantidade</td>
				<td>Valor Unitário</td>
				<td>Produto</td>
				<td>Valor por Produto</td>
				<td></td>
			</tr>
			<%
			List <Item> carrinho = Carrinho.listar();
			for (Item i : carrinho) {
			%>
			<tr>
				<td><%=i.getQuantidade() %></td>
				<td>R$ <%=i.getProduto().getPreco() %></td>
				<td><%=i.getProduto().getDescricao() %></td>
				<td>R$ <%=i.getProduto().getPreco() * i.getQuantidade() %></td>
				<td>
					<form action="remover" method="post">
						<input type="hidden" value="<%=carrinho.indexOf(i) %>" name="id_item" />
						<input type="submit" value="Remover" />
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		

	</body>
</html>