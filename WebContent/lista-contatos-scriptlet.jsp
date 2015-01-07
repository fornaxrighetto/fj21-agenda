<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,
    		br.com.caelum.agenda.dao.*,
    		br.com.caelum.agenda.modelo.*" %>
    <%@page import="java.util.Calendar" %>
    <%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
	<table>
		<%ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();%>
		
		<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
		
		<% 
		for(Contato contato : contatos){
			%>
			
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=sdf.format(contato.getDataNascimento().getInstance().getTime())%></td>
			</tr>
			<%
		}
		%>
	</table>
</body>
</html>