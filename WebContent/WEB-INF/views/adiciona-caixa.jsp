<!DOCTYPE html>
<html>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro de Caixa Padrao 1</h1>
</hr>
<form action=../caixa/adicionar  method="post">
  Empresa  :<input type="text" name="cdEmp"  /></br>
  <sf:errors path="caixa.cdEmp" cssStyle="color:red"/>
  Caixa    :<input type="text" name="cdCaixa" /></br>
  Descricao:<input type="text" name="dsCaixa" /></br>
  </br>
  </br>
  <input type="submit" value="Salvar" name="vAcao" />
  <input type="submit" value="Consultar" name="vAcao" />
  <input type="submit" value="Excluir" name="vAcao" />
  <input type="submit" value="Alterar" name="vAcao" />
  
   
</form>
</body>
</html>