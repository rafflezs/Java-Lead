<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dados.Estoque" %>
<%@ page import="dados.Carrinho" %>
<%@ page import="entidades.Produto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Produtos | Mercado Online</title>
	</head>
	<body>
	
		<h1>Mercado Online</h1>
		<h2>Produtos</h2>
	
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
	
		<table>
			<tr>
				<td>Valor Unitário</td>
				<td>Produto</td>
				<td>Quantidade</td>
			</tr>
			<%
			List<Produto> produtos = Estoque.listar();
			for (Produto p : produtos) {
			%>
			<tr>
				<td>R$ <%=p.getPreco() %></td>
				<td><%=p.getDescricao() %></td>
				<td>
					<form action="adicionar" method="post">
					<input type="text" name="quantidade" />
						<input type="hidden" value="<%=produtos.indexOf(p) %>" name="id_produto" />
						<input type="submit" value="Adicionar" />
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</body>
</html>