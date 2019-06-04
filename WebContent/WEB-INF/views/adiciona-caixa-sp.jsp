<!DOCTYPE html>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro de Caixa</h1>
</hr>
<sf:form modelAttribute="caixa" action="../caixa/nova" method="POST">
  <label for="cdEmp">Empresa:
    <sf:errors path="cdEmp"/>
  </label> 
  <sf:input path="cdEmp"/>
  <label for="caixa">Caixa:
   <sf:input path="cdCaixa"/>
  </label>
  <label for="descricao">Descricao:
   <sf:input path="dsCaixa"/>
   </label>
  <input type="submit" value="Salvar" name="vAcao" />
   
</sf:form>
</body>
</html>