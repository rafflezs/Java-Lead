package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.Carrinho;

@WebServlet("/remover")
public class RemoverDoCarrinhoControlador extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		// Receber dado do indice do item e remove-lo do Carrinho

		// request.setAttribute("aluno", aluno);
		getServletContext().getRequestDispatcher("/carrinho.jsp").forward(request,response);
	}

}
