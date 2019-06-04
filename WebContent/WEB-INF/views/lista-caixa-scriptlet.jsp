<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
                 br.com.sisarq.DAO.*,
                br.com.sisarq.mvc.modelo.*"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%--<jsp:useBean id="dao" class="br.com.sisarq.DAO.CaixaDAO"/> --%>
    <h1>Lista de Caixas- JSTL</h1>
	<table>
		<c:forEach var="caixa" items="${listaCaixa}" >
		<tr>
		  <td>${caixa.cdEmp}</td>
		  <td>${caixa.cdCaixa}</td>
		  <td>${caixa.dsCaixa}</td>
		  <td><a href="../caixa/excluir?cdEmp=${caixa.cdEmp}&cdCaixa=${caixa.cdCaixa}">Remover</a>
        </
        </tr>	
        </c:forEach>
	</table>
</body>
	
</html>