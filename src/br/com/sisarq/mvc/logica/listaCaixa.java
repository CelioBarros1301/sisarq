package br.com.sisarq.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisarq.DAO.CaixaDAO;
import br.com.sisarq.mvc.modelo.Caixa;

public class listaCaixa implements Logica{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		Connection connection=( Connection) request.getAttribute("connection");
	    CaixaDAO dao= new CaixaDAO(connection);
	    List<Caixa> lCaixa=dao.getLista();
    	request.setAttribute("listaCaixa", lCaixa);
        return "lista-caixa-scriptlet.jsp";

	}
}
