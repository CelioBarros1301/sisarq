<!--
*Sistame Base....: Sistema de Controle de Arquivo(SISARQ)
*Pagina..........: pagCaixa.jsp
*Data Criação....: 24.06.2018
*Autor...........: Celio Barros
*Objeto..........: CRUD Tabela de Caixa
*Ultima Alteração: 29.06.2018 - Incluido Botoes de Acoes
*
*icones..........: getbootstrap.com Components Glyphicons
-->
<!DOCTYPE html>
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
        	function consultar(strCdEmp,strCdCaixa){
        		alert("empresa"+strCdEmp);
        		alert("caixa"+strCdCaixa);
        		document.pagCaixa.action="consultar?cdEmp="+strCdEmp+"&cdCaixa="+strCdCaixa;
        		document.pagCaixa.submit();	
        	}
        	function salvar(){
        		document.pagCaixa.action="nova";
        		document.pagCaixa.submit();	
        	}
        	
        
        </script>
        
    </head>
    <body>
        
        <div id="botoes" class="container">
            <div class="row">
                <!-- Definicoes dos Botoes de Acoes-->
                <div class="col-xs-12">

                    
                    <button type="button" class="btn btn-primary btn-sm" onClick="novo()">
                    	<span class="glyphicon glyphicon-log-in"></span> Novo
                    </button>
                                        
                    <a href="../caixa/consultar?cdEmp=${caixa.cdEmp}&cdCaixa=${caixa.cdCaixa};"  class="btn btn-primary btn-sm" >
                        <span class="glyphicon glyphicon-search"></span> Consultar
                    </a>

                    <a href="../caixa/excluir?cdEmp=01&cdCaixa=00001" class="btn btn-primary btn-sm">
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
                    <form  name="pagCaixa" class="form-horizontal" action="nova" method="post">
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
                        -->
                        <div class="form-group form-group-sm">
                            <lable for="cdEmp" class="col-xs-offset-1 col-xs-2 control-label">Empresa:</lable>
                            <div class="col-xs-8"  >
                                <input name="cdEmp" type="text" class="form-control size_06"  id="cdEmp" placeholder="Codigo da caixa"  maxlength="6" >
                                <span class="help-block">Informar Zero para Gerar Codigo da Caixa</span>
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                            <lable for="cdCaixa" class="col-xs-offset-1 col-xs-2 control-label">Caixa:</lable>
                            <div class="col-xs-8"  >
                                <input name="cdCaixa" type="text" class="form-control size_06"  id="cdCaixa" placeholder="Codigo da caixa"  maxlength="6" >
                                <span class="help-block">Informar Zero para Gerar Codigo da Caixa</span>
                            </div>
                        </div>
                        <div class="form-group form-group-sm">
                            <lable for="dsCaixa" class="col-xs-offset-1 col-xs-2 control-label">Descrição:</lable>
                            <div class="col-xs-8">
                                <input name="dsCaixa" type="text" class="form-control " id="dsCaixa" placeholder="Descrição da Caixa">
                            </div>
                                                                                                                 <div class="col-xs-8">
                            <input class="btn btn-primary" type="submit" value="Salvar" name="vAcao" />
                            </div>                                                               
                        </div>
                    </form>
                </div>
             </div>
        </div>
        <script src="resources/js/jquery-1.11.1.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/main.js"></script>
    </body>
</html>