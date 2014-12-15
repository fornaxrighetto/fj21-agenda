package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

//@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		//busca o writer
		PrintWriter out = response.getWriter();
		
		//buscando os parametros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		//Fazendo a conversao da data
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch (ParseException | java.text.ParseException e){
			out.println("Erro de conversão da data");
			return;
		}
		
		//Monta um objeto contato
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		//salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//imprime o nome do contato que foi adicionado
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Contato " + contato.getNome() + " Adicionado com sucesso");
//		out.println("</body>");
//		out.println("</html>");
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}

//	private Object getTime(String string) {
		// TODO Auto-generated method stub
//		return null;
		
		
		
		
//	}
}
