package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.Carrinho;
import dados.Estoque;
import entidades.Item;

@WebServlet("/adicionar")
public class AdicionarAoCarrinhoControlador extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		try {

			int id = Integer.valueOf(request.getParameter("id_produto"));
			float qtd = Float.valueOf(request.getParameter("quantidade"));

			Item it = new Item(Estoque.listar().get(id), qtd);
			
			new Carrinho().adicionar(it);
	
		} catch (NumberFormatException e) {
			
		}		
		getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request,response);
	}

}
