package br.com.sisarq.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisarq.DAO.CaixaDAO;
import br.com.sisarq.mvc.modelo.Caixa;

public class adicionaCaixa implements Logica{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	   	String cdEmpresa=request.getParameter("cdEmp");
	   	String cdCaixa =request.getParameter("cdCaixa");
	   	String dsCaixa=request.getParameter("dsCaixa");
	    Caixa oCaixa=new Caixa(cdEmpresa,cdCaixa,dsCaixa);
	    Connection connection=( Connection) request.getAttribute("connection");
	    CaixaDAO dao= new CaixaDAO(connection);
	    dao.adiciona(oCaixa);
		request.setAttribute("caixa", oCaixa);
	    return "adiciona-caixa.jsp";
	}

}