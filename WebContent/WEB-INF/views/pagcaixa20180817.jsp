<!--
*Sistame Base....: Sistema de Controle de Arquivo(SISARQ)
*Pagina..........: pagCaixa.jsp
*Data CriaÃ§Ã£o....: 24.06.2018
*Autor...........: Celio Barros
*Objeto..........: CRUD Tabela de Caixa
*Ultima AlteraÃ§Ã£o: 29.06.2018 - Incluido Botoes de Acoes
*                    22.07.2018 - Processamento dos Botoes -Salvar,Consultar e Exluir
*icones..........: getbootstrap.com Components Glyphicons
-->
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
    <head>
        <title>Sistema de Controle de Arquivo</title>
        <% %>
        <!-- define a viewport -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0" >
        
        <meta charset="UTF-8">

        <!-- adicionar CSS Bootstrap -->
        <link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
        
        <!-- css personalizado -->
        <link type="text/css" href="${pageContext.request.contextPath}/resources/css/csspadrao.css" rel="stylesheet" media="screen">
        <link type="text/css" href="${pageContext.request.contextPath}/resources/css/csssisarq.css" rel="stylesheet" media="screen">
         
        <script LANGUAGE="JavaScript1.1">
        
	        function configurar(){
	       	 <!-- Recuperando Variaveis de Sessão-->
	   		 var idEmpresa = "<%=request.getSession().getAttribute("sessionCaixaCdEmp")%>";
	   		 var idCaixa   = "<%=request.getSession().getAttribute("sessionCaixaCdCaixa")%>";
	   		 var strMsgErroCaixa   = "Mensagem Pagina:"+"<%=request.getSession().getAttribute("sessionCaixaErro")%>";
	   		 document.getElementById("msgAlerta").innerHTML = strMsgErroCaixa; 
             alert(strMsgErroCaixa);	   		    		
	       	 if ( idEmpresa !=0  ) 
	       	 	{ 
	       		    var btnExcluir=document.getElementById('excluir');
	       			btnExcluir.classList.remove('disabled'); 
	       			
	       		}
	       
	        }
            
        	function consultar(){
        		
        			
       			var strCdEmp= document.getElementById('cdEmp').value;
       			var strCdCaixa=document.getElementById('cdCaixa').value;
       			var strLink=document.getElementById('consultar').href='../caixa/consultar?cdEmp='+strCdEmp+'&cdCaixa='+strCdCaixa;
       		    var btnExcluir=document.getElementById('excluir');
       		    btnExcluir.classList.remove('disabled')
       		    var strMsgErroCaixa   = "Mensagem Consulta:"+"<%=request.getSession().getAttribute("sessionCaixaErro")%>";
   	   		    document.getElementById("msgAlerta").innerHTML = strMsgErroCaixa; 
                alert(strMsgErroCaixa);
   	   		    		
       		   
       		    
        	}
        	function salvar(){
        		
        		<!-- Recuperando Variaveis de Sessão-->
    	   		var idEmpresa = "<%=request.getSession().getAttribute("sessionCaixaCdEmp")%>";
    	   		var idCaixa   = "<%=request.getSession().getAttribute("sessionCaixaCdCaixa")%>";

        		alert("empresa id"+ idEmpresa);
        		if ( idEmpresa !=0)   
        		{
        			document.pagCaixa.action="alterar";
        			alert("alterar");
        		}
        		else
        		{
        			document.pagCaixa.action="nova";
        			alert("Incluir");
        		}
        		document.pagCaixa.submit();	
        	}
        	     	
        	
         
        </script>
    </head>
    <body  onload="configurar">
          
        <div id="botoes" class="container">
            <div class="row">
                <!-- Definicoes dos Botoes de Acoes-->
                <div class="col-xs-12">

                    
                    <a href="../caixa/nova" class="btn btn-primary btn-sm">
                    	<span class="glyphicon glyphicon-log-in"></span> Novo
                    </a>
                    
                    <a href="#"   id="consultar" class="btn btn-primary btn-sm" onClick="consultar()" >
                        <span class="glyphicon glyphicon-search"></span> Consultar
                    </a>
                    
                    <a href="../caixa/excluir?cdEmp=${caixa.cdEmp}&cdCaixa=${caixa.cdCaixa}" id="excluir" class="btn   btn-primary btn-sm disabled"  >
                            <span class="glyphicon glyphicon-trash"></span> Excluir
                    </a>
                    
                    <button type="button" class="btn btn-primary btn-sm" onClick="salvar()">
                        <span class="glyphicon glyphicon-floppy-disk"></span> Salvar
                    </button>

                    <button type="button" class="btn btn-primary btn-sm" onClick="processar()">
                        <span class="glyphicon glyphicon-refresh"></span> Processar
                    </button>

                    <button type="button" class="btn btn-primary btn-sm" onClick="imprimir()">
                        <span class="glyphicon glyphicon-print"></span> Imprimir
                    </button>

                    <button type="button" class="btn btn-primary btn-sm" onClick="sair()">
                        <span class="glyphicon glyphicon-search"></span> Sair
                    </button>
                    
                </div>
                <!-- Fim dos Botoes de Acoes-->
            </div>
        </div>
        <!--- Formulario da Pagina-->
        <div  class="container">
            <div class="row">
                <div class="col-xs-12">
                    <fieldset>
         			<legend>Dados Caixa</legend>
         			<div class="row">
	                	<div class="col-xs-12">
	                    <!--  Dados Salvos com Sucesso!
	                          Preencha todos os campos do formulário Obrigatorios!
	                          Preencha todos os campos do Corretamente !
	                          Dados Excluido com Sucesso!
	                          Erro na Aplicacao:<MENSAGEM DE ERRO> Entrar em contato com o Suporte Celular:(85) 987234013!! Encaminhar a mesagem para Email so Suporte Celio1301@gmail.com.br
	                     
		                    <div class="alert alert-success">Formulário enviado com sucesso!</div>
		                    <div class="alert alert-warning">Cuidado ao preencher o formulário!</div>
		                    <div class="alert alert-info">Preencha todos os campos do formulário!</div>
		                    <div class="alert alert-danger">Você não preencheu os campos corretamente!</div>
		                    
		                    
		                    <div class="alert alert-danger alert-dismissible">
		                        
		                        <button type="button" class="close" data-dismiss="alert">
		                            <span aria-hidden="true">&times;</span>
		                        </button>
		                        <p id="msgAlertax"></p>
		                    </div>
	                    -->
	                	</div>
            		</div>
         			
         			
         			
         			
         			
         			
         			
         			
                    
                    <form  name="pagCaixa" class="form-horizontal" action="nova" method="post">
                         
                        <div class="form-group form-group-sm">
                        	<div class="alert alert-danger alert-dismissible">
		                        
		                        <button type="button" class="close" data-dismiss="alert">
		                            <span aria-hidden="true">&times;</span>
		                        </button>
		                        <p>${message}</p>
		                        <p id="msgAlerta"></p>
		                    </div>
                        
                        </div>
                        
                        <!-- 
                        <div class="form-group form-group-sm">
                            <lable for="cdEmpresa" class="col-xs-offset-1 col-xs-2 control-label">Empresa:</lable>
                            <div class="col-xs-8">
                                <select class="form-control">
                                    <option>Empresa 01</option>
                                    <option>Empresa 02</option>
                                </select>
                            </div>
                        </div>
                          <input name="cdEmp" type="text" class="form-control size_06"  id="cdEmp" value="${caixa.cdEmp}"placeholder="Codigo da Empresa"  maxlength="2" autofocus autocomplete="on">
                                <span class="help-block">Informar Zero para Gerar Codigo da Caixa</span>
                        -->
                        
                           <div class="form-group form-group-sm">
                            <lable for="cdEmp" class="col-xs-offset-1 col-xs-2 control-label">Empresa:</lable>
                            <div class="col-xs-8"  >
	                            <select name="cdEmp" id="cdEmp">
		    						<c:forEach items="${lstEmpresa}" var="emp">
			        					<option value="${emp.cdEmp}">${emp.dsEmp}</option>
		    						</c:forEach>
								</select>
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <lable for="cdCaixa" class="col-xs-offset-1 col-xs-2 control-label">Caixa:</lable>
                            <div class="col-xs-8"  >
                                <input name="cdCaixa" type="text" class="form-control size_06"  id="cdCaixa" value="${caixa.cdCaixa}"placeholder="Codigo da caixa"  maxlength="5" required  onkeypress='return SomenteNumero(event)' onblur='ZerosEsquerda(document.pagCaixa.cdCaixa,5)'>
                                <span class="help-block">Informar Zero para Gerar Codigo da Caixa</span>
                            </div>
                        </div>
                        <div class="form-group form-group-sm">
                            <lable for="dsCaixa" class="col-xs-offset-1 col-xs-2 control-label">Descrição:</lable>
                            <div class="col-xs-8">
                                <input name="dsCaixa" type="text" class="form-control " id="dsCaixa" value="${caixa.dsCaixa}" placeholder="Descrição da Caixa"  maxlength="40" required onkeypress='return LetraNumero(event)' >
                            </div>
                                                                                                                 <div class="col-xs-8">
                        </div>
                        
                    </form>
                    </fieldset>
                </div>
             </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/sistema.js"></script>
        
    </body>
</html>