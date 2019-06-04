package br.com.sisarq.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisarq.DAO.CaixaDAO;
import br.com.sisarq.mvc.modelo.Caixa;
@WebServlet("/manterCaixa")
public class ManterCaixaServlet  extends HttpServlet{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config )throws ServletException{
		super.init(config);
		log("iniciando a servlet");
	}
    public void destroy(){
    	super.destroy();
    	log("Destruindo a servlet");
    }
	public ManterCaixaServlet() {
	       super();
	       // TODO Auto-generated constructor stub
	   }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao=request.getParameter("vAcao");
		String strMsg="";
		Caixa oCaixa=null;	
	    try{
			if (acao.equals("Salvar")){ 
		    	String cdEmpresa=request.getParameter("cdEmp");
		    	String cdCaixa =request.getParameter("cdCaixa");
		    	String dsCaixa=request.getParameter("dsCaixa");
		       	oCaixa=new Caixa(cdEmpresa,cdCaixa,dsCaixa);
		    	CaixaDAO dao= new CaixaDAO();
		    	dao.adiciona(oCaixa);
		    }
		    if (acao.equals("Consultar")){ 
		    	String cdEmpresa=request.getParameter("cdEmp");
		    	String cdCaixa =request.getParameter("cdCaixa");
		       	oCaixa=new Caixa(cdEmpresa,cdCaixa,"");
			    CaixaDAO dao= new CaixaDAO();
		    	dao.consulta(oCaixa);
		    	System.out.println(oCaixa.getDsCaixa());
		    }
		    if (acao.equals("Alterar")){ 
		    	String cdEmpresa=request.getParameter("cdEmp");
		    	String cdCaixa =request.getParameter("cdCaixa");
		    	String dsCaixa =request.getParameter("dsCaixa");
		       	oCaixa=new Caixa(cdEmpresa,cdCaixa,dsCaixa);
			    CaixaDAO dao= new CaixaDAO();
		    	dao.alterar(oCaixa);
		    }
		    if (acao.equals("Excluir")){ 
		    	String cdEmpresa=request.getParameter("cdEmp");
		    	String cdCaixa =request.getParameter("cdCaixa");
		       	oCaixa=new Caixa(cdEmpresa,cdCaixa,"");
			    CaixaDAO dao= new CaixaDAO();
		    	dao.excluir(oCaixa);
		    }
		    request.setAttribute("oCaixa", oCaixa);
		    System.out.println("Gerando mensagem..");
		    strMsg="Processo Executado com Sucesso !!!!";
		}
	    catch (RuntimeException e)
	    {
	       System.out.println("Entrando no erro..");	
	       strMsg=e.getMessage();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    finally {
			request.setAttribute("msg", strMsg);
		    request.getRequestDispatcher("adiciona-caixa.jsp?msg="+strMsg).forward(request, response);
	    }
	    
    }
	 

}
