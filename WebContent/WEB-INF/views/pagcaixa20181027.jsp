<!--
*Sistame Base....: Sistema de Controle de Arquivo(SISARQ)
*Pagina..........: pagCaixa.jsp
*Data CriaÃ§Ã£o....: 24.06.2018
*Autor...........: Celio Barros
*Objeto..........: CRUD Tabela de Caixa
*Ultima AlteraÃ§Ã£o: 29.06.2018 - Incluido Botoes de Acoes
*                    22.07.2018 - Processamento dos Botoes -Salvar,Consultar e Exluir
*                    23.08.2018 - Mensagem de Informação e Erro retornado para a PAGINA
*                               - Desabilitar INPUT de Codigo da CAIXA quando da Consulta
*                               - Desabiliar OPTINON da Empresa quando da consulta
*                    12.09.2018 - Configuração do JSTL DisplayTag
*icones..........: getbootstrap.com Components Glyphicons
*Observacoes.....:
*
* Variaves de Session:sessionCaixaCdEmp,*sessionCaixaCdCaixa
* Objetivo: Para controle de incluisão /alteraçao/exclusao de Dados da Caixa
*           Quando sessionCaixaCdEmp=0  estamos realizando uma Inclusão
*           Quando sessionCaixaCdEmp!=0 estamos realizando o controle de alteração/exclusão
*           Algumas TAG utilizando o valor sessionCaixaCdEmp para habilitar algums atributos das TAGS
-->
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
        <link type="text/css" href="${pageContext.request.contextPath}/resources/css/cssdisplayScrool.css" rel="stylesheet" media="screen"> 
         
        <script LANGUAGE="JavaScript1.1">
	        
			function configurar(){
	        	
	        	
	        	
	       	 	<!-- Recuperando Variaveis de Sessão-->
	       	 	alert("carregando"+document.url);
	       	 
	   		 	var idEmpresa = "<%=request.getSession().getAttribute("sessionCaixaCdEmp")%>";
	   		 	var idCaixa   = "<%=request.getSession().getAttribute("sessionCaixaCdCaixa")%>";
	   		 	   		    		
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
    <body  onload="configurar" onload="addRowHandlers('row', 'rowMouseOver', 'SelectedFact.jsp', 'id', 0)">
          
        
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
         			
                    <form  name="pagCaixa" class="form-horizontal" action="nova" method="post">
                        
                        <!--  Testa Variavel de Sessão de Mensagem de Erro/Informação
                              Mostra Alert de Erro ou Informação
                         -->
                         
                        <c:if test="${not empty sessionScope['sessionCaixaErro']}">
	                        <div class="form-group form-group-sm">
	                        	
	                        	<!-- Ler Variavel de Sessao com Mensagem de Erro/Informação -->
	                        	<c:set var = "msgErroInfo" scope = "session" value = '${sessionScope["sessionCaixaErro"]}'/>
	                        	<c:set var = "msgErroInfo" scope = "session" value = "${fn:substring(msgErroInfo, 0,4)}"/>
	                        	
	                        	<!--Testa Tipo de Mensagem Para Mostra Alert-Success ou Alert-Danger   -->
	                        	<c:if test="${msgErroInfo!='ERRO'}">
	                        		<div class="alert alert-success alert-dismissible">
			                    </c:if>
			                     
			                    <c:if test="${msgErroInfo!='INFO'}">
	                        		<div class="alert alert-danger alert-dismissible">
			                    </c:if>
			                        
		                        <button type="button" class="close" data-dismiss="alert">
		                            <span aria-hidden="true">&times;</span>
		                        </button>
		                        <p id="message">${sessionScope['sessionCaixaErro']}  </p> 
			                    </div>
	                        
	                        </div>
                        </c:if>
                                                
                        
						
						<div class="form-group form-group-sm">
	                        <lable for="cdEmp" class=" col-xs-3 control-label">Empresa:</lable>
	                        <div class="col-xs-8"  >
		                        <!-- Ler Variavel de Sessao com Mensagem de Erro/Informação -->
		                       	<c:set var = "strCodigoEmpresa" scope = "session" value = '${sessionScope["sessionCaixaCdEmp"]}'/>
		                        <select name="cdEmp" id="cdEmp" class="form-control">
			    					<c:forEach items="${lstEmpresa}" var="emp">
				    					<c:if test="${emp.cdEmp == sessionScope['sessionCaixaCdEmp']}">
				    						<option value="${emp.cdEmp}" selected>${emp.dsEmp}</option>
				    					</c:if>
				    					<c:if test="${sessionScope['sessionCaixaCdEmp'] =='0'}">
				    						<option value="${emp.cdEmp}" >${emp.dsEmp}</option>
				                       	</c:if>
			                       	</c:forEach>
								</select>
	                        </div>
                        </div>  
                        <div class="form-group form-group-sm">
                            <lable for="cdCaixa" class=" col-xs-3 control-label">Caixa:</lable>
                            <div class="col-xs-8"  >
                                <!-- Bloquear Codigo da Caixa apos uma CONSULTA  -->
		    			        <input name="cdCaixa" type="text" class="form-control size_06 "  id="cdCaixa" value="${caixa.cdCaixa}"  ${sessionScope["sessionCaixaCdEmp"] !=0 ? 'readonly="readonly"' : ''}  placeholder="Codigo da caixa"  maxlength="5" required  onkeypress='return SomenteNumero(event)' onblur='ZerosEsquerda(document.pagCaixa.cdCaixa,5)'>
                                <span class="help-block">Informar Zero para Gerar Codigo da Caixa</span>
                            </div>
                        </div>
                        <c:set var="dsCaixaHasBindError">
							<form:errors path="caixa.dsCaixa"/>
						</c:set>
                        
                        <div class="form-group form-group-sm  ${not empty dsCaixaHasBindError? "has-error":""} ${not empty dsCaixaHasBindError? "has-feedback":""}">
                            <lable for="dsCaixa" class=" col-xs-3 control-label">Descrição:</lable>
                            <div class="col-xs-8">
                                <input name="dsCaixa" type="text" class="form-control " id="dsCaixa" value="${caixa.dsCaixa}" placeholder="Descrição da Caixa"  maxlength="40" required onkeypress='return LetraNumero(event)' >
                                <c:if test="${not empty dsCaixaHasBindError}">
                                	<span class="glyphicon glyphicon-remove form-control-feedback"></span>
                                	<form:errors path="caixa.dsCaixa" cssStyle="color:red"/>
                                </c:if>
                            </div>
                                                                                                                 
                        </div> 
                          
                    </form> 
                    </fieldset>
                </div>
            	<div class="row">
                	<div class="col-xs-8 displayTableFrame">
                		<display:table name="${gridEmpresa}"  id="row" export="true"  defaultsort="1" defaultorder="ascending" pagesize="5" class="dataTable">
				    		<display:setProperty name="basic.empty.showtable" value="true" />
				    		<display:column property="cdEmp"    title="Codigo Empresa"/>
				    		<display:column property="dsEmp"    title="Nome Empresa"/>
				    		<display:column property="cdCaixa"  title="Codigo Caixa"/>
				    		<display:column property="dsCaixa"  title="Descricao Caixa"/>
				    	</display:table>
            		</div>
            	</div>
            	        </div>
        
        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/sistema.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/RowHandlers.js"></script>
        
        
    </body>
</html>