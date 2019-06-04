package br.com.sisarq.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisarq.DAO.CaixaDAO;
import br.com.sisarq.mvc.modelo.Caixa;

public class consultaCaixa implements Logica{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		String cdEmpresa=request.getParameter("cdEmp");
    	String cdCaixa =request.getParameter("cdCaixa");
       	Caixa oCaixa=new Caixa(cdEmpresa,cdCaixa,"");
        Connection connection=( Connection) request.getAttribute("connection");
	    CaixaDAO dao= new CaixaDAO(connection);
        oCaixa=dao.consulta(oCaixa);
    	request.setAttribute("caixa", oCaixa);
        return "adiciona-caixa.jsp";

	}
}
