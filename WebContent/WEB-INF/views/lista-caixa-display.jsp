
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
               br.com.sisarq.DAO.*,
               br.com.sisarq.mvc.modelo.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table>

<% 
    CaixaDAO dao=new CaixaDAO();
    List <Caixa> caixas =dao.getLista();
    for (Caixa caixa: caixas){
 %>
    <tr>
	  <td><%=caixa.getCdEmp()%></td>
	</tr>	
 <%}%>
 </table>
  inicio
 <display:table name="caixas">
    <display:column property="cdEmp" title="Empresa"/>
    <display:column property="cdCaixa"  title="Caixa"/>
    <display:column property="dsCaixa" title="Descricao"/>
   </display:table>
   
  FIM

</body>
</html>