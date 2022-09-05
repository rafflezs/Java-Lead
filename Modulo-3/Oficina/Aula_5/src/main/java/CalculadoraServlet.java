import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calcular")
public class CalculadoraServlet extends HttpServlet{

	private String idadePorExtenso(int dia, int mes, int ano) {
		LocalDateTime now = LocalDateTime.now();  

		int diaAtual = now.getDayOfMonth();
		int mesAtual = now.getMonthValue();
		int anoAtual = now.getYear();
		
		int anos = anoAtual - ano; 
		int meses = mesAtual - mes; 
		int dias = diaAtual - dia;
		
		if (meses < 0) {
			anos -=1;
			meses += 12;
		}
		if (dias < 0) {
			meses -= 1;
			dias += 30;
		}
		
		return anos + "anos, " + meses + " meses, " + dias + " dias.";
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		
		try {

			int dia = Integer.valueOf(request.getParameter("dia"));
			int mes = Integer.valueOf(request.getParameter("mes"));
			int ano = Integer.valueOf(request.getParameter("ano"));
			out.println("<html><body>");
			out.println("<h1>Olá, "+nome+"!<br/>Você tem " + idadePorExtenso(dia,mes,ano));
			out.println("</body></html>");
	
		} catch (ArithmeticException e) {
			out.println("<html><body><h1>Erro na conversão de algum dos valores.</h1></body></html>");
			
		}		
	}
	
}
