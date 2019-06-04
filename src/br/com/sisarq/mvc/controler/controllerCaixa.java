package br.com.sisarq.mvc.controler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sisarq.DAO.CaixaDAO;
import br.com.sisarq.DAO.EmpresaDAO;
import br.com.sisarq.mvc.modelo.Caixa;
import br.com.sisarq.mvc.modelo.Empresa;

@Controller
@RequestMapping("/caixa")
public class controllerCaixa {
	
	@RequestMapping(value="/nova", method=RequestMethod.GET)
	public ModelAndView nova(Caixa caixa,BindingResult bindingResult,HttpServletRequest request) {
	  String strMsgErro="";
	  int intParametro1=1; // Parametro Empresa Padrao
	  System.out.println("nova ");
	  //ModelAndView 	mv=new ModelAndView("adiciona-caixa-sp");
	  // Criando as variaveiss de sessao para controle do CRUD
	  HttpSession varSessao = request.getSession();
      varSessao.setAttribute("sessionCaixaCdEmp", 0);
      varSessao.setAttribute("sessionCaixaCdCaixa", 0);
      varSessao.setAttribute("sessionCaixaErro", "");
      ModelAndView 	mv = new ModelAndView("pagcaixa");
      try {
    	  Connection connection=( Connection) request.getAttribute("connection");
    	  EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
    	  CaixaDAO daoCaixa=new CaixaDAO(connection);
    	  mv.addObject("lstEmpresa",daoEmpresa.getLista());
    	  mv.addObject("gridEmpresa",daoCaixa.getListaEmpresaCaixa("01"));
      }
      catch (Exception eMsgErro )
  	{
  		strMsgErro=eMsgErro.getMessage();	
  		System.out.println(strMsgErro);
  		
  	}
  	  	    
	  
    	
	  return mv;
    }
    @RequestMapping(value ="/nova", method=RequestMethod.POST)
	public ModelAndView AdicionarCaixa(@Valid Caixa caixa,BindingResult bindingResult,RedirectAttributes attributes,HttpServletRequest request)
    { 
    	
    	String strMsgErro="";
    	ModelAndView mv=new ModelAndView("pagcaixa");
       if (bindingResult.hasErrors())
    	{  
    		for (ObjectError erro:bindingResult.getAllErrors())
    		{
    			System.out.println(erro.getCode()+" "+erro.getObjectName());
    		}
    		return nova(caixa,bindingResult, request);	
    	}
    	try {
    		 Connection connection=( Connection) request.getAttribute("connection");
    		 EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
    		 CaixaDAO daoCaixa=new CaixaDAO(connection);
       	     mv.addObject("lstEmpresa",daoEmpresa.getLista());
    	     mv.addObject("gridEmpresa",daoCaixa.getListaEmpresaCaixa(caixa.getCdEmp()));
    		 
    		CaixaDAO dao= new CaixaDAO(connection);
    		dao.adiciona(caixa);
    		
    	}
    	catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    		System.out.println(strMsgErro);
    		
    	}
    	finally  
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do CRUD
    		HttpSession varSessao = request.getSession();
 	    	if( strMsgErro.substring(0,3)=="ERRO")
 	    	{	
 	    		varSessao.setAttribute("sessionCaixaCdEmp", 0);
 	    		varSessao.setAttribute("sessionCaixaCdCaixa",0);
 	    	}
 	    	else
 	    	{
 	    		varSessao.setAttribute("sessionCaixaCdEmp", caixa.getCdEmp());
 	    		varSessao.setAttribute("sessionCaixaCdCaixa",caixa.getCdCaixa());
 	    	}
 	    	varSessao.setAttribute("sessionCaixaErro", strMsgErro);
	        
	      	System.out.println("Controle de execão....."+varSessao.getAttribute("sessionCaixaErro")+"lendo");
  	    }
      	
    	
    	//ModelAndView mv=new ModelAndView("redirect:nova");
    	//ModelAndView mv=new ModelAndView("pagcaixa");
        mv.addObject("pStrMsgErro",strMsgErro);
		return mv;	
	}
    
    @RequestMapping("consultar")
    public ModelAndView  Consultar( @RequestParam("cdEmp")  String pCdEmp,@RequestParam("cdCaixa")  String pCdCaixa, HttpServletRequest request,RedirectAttributes attrib) throws Exception
    //public ModelAndView  Consultar( @RequestParam("cdEmp")  String pCdEmp,@RequestParam("cdCaixa")  String pCdCaixa, HttpServletRequest request) throws Exception
    {
    	HttpSession varSessao = request.getSession();
    	System.out.println("Entrando Acao Consultar..");
    	String strMsgErro="";
    	int intParametro1=1; // Parametro Empresa Padrao
    	
    	ModelAndView mv = new ModelAndView ("pagcaixa");
    	List<Empresa> lista =null;
    	
  	    try {
  	    	Connection connection=( Connection) request.getAttribute("connection");
  	    	EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
  	    	CaixaDAO daoCaixa=new CaixaDAO(connection);
  	    	
  	    	//mv.addAttribute("lstEmpresa",daoEmpresa.getLista(intParametro1));
  	    	mv.addObject("lstEmpresa",daoEmpresa.getLista());
  	    	mv.addObject("gridEmpresa",daoCaixa.getListaEmpresaCaixa(pCdEmp));
 	        
  	    	mv.addObject("caixa",daoCaixa.consulta(pCdEmp,pCdCaixa));
  	    	//mv.addAttribute("caixa",daoCaixa.consulta(pCdEmp,pCdCaixa));
  	    	//lista=daoEmpresa.getLista();
  	        //System.out.println("Empresa list"+lista.size());
  	    	varSessao.setAttribute("sessionCaixaCdEmp", pCdEmp);
	      	varSessao.setAttribute("sessionCaixaCdCaixa", pCdCaixa);
  	    	
  	    }
  	    catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    		varSessao.setAttribute("sessionCaixaCdEmp", 0);
	      	varSessao.setAttribute("sessionCaixaCdCaixa", 0);
    		System.out.println("erro:"+eMsgErro.getMessage());
    		
    	}
  	    finally
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do
  	    	
  	        varSessao.setAttribute("sessionCaixaErro", strMsgErro);
	        
	      	attrib.addFlashAttribute("message", "atributo"+strMsgErro);
	      	System.out.println("Controle de execão....."+varSessao.getAttribute("sessionCaixaErro")+"lendo");
  	    }
      	
      	
        return mv; //new ModelAndView ("pagcaixa");
    }
    
    //teste
    /*
    @RequestMapping("consultar")
    public ResponseEntity  Consultar( @RequestParam("cdEmp")  String pCdEmp,@RequestParam("cdCaixa")  String pCdCaixa,Model mv, HttpServletRequest request) throws Exception
    {
    	String strMsgErro="";
    	int intParametro1=1; // Parametro Empresa Padrao
    	//ModelAndView mv = new ModelAndView ("pagcaixa");
    	String retPagina="pagcaixa";
    	List<Empresa> lista =null;
    	
  	    try {
  	    	Connection connection=( Connection) request.getAttribute("connection");
  	    	EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
  	    	mv.addAttribute("lstEmpresa",daoEmpresa.getLista(intParametro1));
  	    	//mv.addObject("lstEmpresa",daoEmpresa.getLista(intParametro1));
 	        CaixaDAO daoCaixa= new CaixaDAO(connection);
  	    	
  	    	//mv.addObject("caixa",daoCaixa.consulta(pCdEmp,pCdCaixa));
  	    	mv.addAttribute("caixa",daoCaixa.consulta(pCdEmp,pCdCaixa));

  	    	lista=daoEmpresa.getLista(intParametro1);
  	        System.out.println("Empresa list"+lista.size());
  	    }
  	    catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    		System.out.println("erro:"+eMsgErro.getMessage());
    		return new ResponseEntity(HttpStatus.ACCEPTED);
    		
    	}
  	    finally
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do CRUD
	      	HttpSession varSessao = request.getSession();
	      	varSessao.setAttribute("sessionCaixaCdEmp", pCdEmp);
	      	varSessao.setAttribute("sessionCaixaCdCaixa", pCdCaixa);
	      	varSessao.setAttribute("sessionCaixaErro", strMsgErro);
  	    }
  	   return new ResponseEntity(HttpStatus.ACCEPTED);
      	
        //return retPagina;//new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
    */
    @RequestMapping("listar")
    public ModelAndView Listar(Model model,HttpServletRequest request) throws Exception
    {
    	String strMsgErro="";
    	ModelAndView mv = new ModelAndView ("lista-caixa-scriptlet");
    	try {
    		Connection connection=( Connection) request.getAttribute("connection");
    		CaixaDAO daoCaixa= new CaixaDAO(connection);
    		mv.addObject("listaCaixa",daoCaixa.getLista());
    	}
    	catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    	}
  	    finally
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do CRUD
  	    	HttpSession varSessao = request.getSession();
  	    
	      	varSessao.setAttribute("sessionCaixaCdEmp", 0);
	      	varSessao.setAttribute("sessionCaixaCdCaixa",0);
	      	varSessao.setAttribute("sessionCaixaErro", strMsgErro);
	     
  	    }
      	
        return mv;
    }
    @RequestMapping("excluir")
    public ModelAndView ExcluirCaixa(@RequestParam("cdEmp")  String cdEmp,@RequestParam("cdCaixa")  String cdCaixa,HttpServletRequest request) throws Exception //,@RequestParam("cdCaixa") String strCdCaixa)//,HttpServletRequest request)
    //public String ExcluirCaixa(@RequestParam("cdEmp") String strCdEmp,@RequestParam("cdCaixa") String strCdCaixa)//,HttpServletRequest request)
    {
    	String strMsgErro ="";
    	ModelAndView mv = new ModelAndView ("pagcaixa");
  	    
    	System.out.println("Valor:"+cdEmp+" "+cdCaixa);
    	try
    	{
	    	Connection connection=( Connection) request.getAttribute("connection");
	    	EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
  	    	//mv.addAttribute("lstEmpresa",daoEmpresa.getLista(intParametro1));
  	    	mv.addObject("lstEmpresa",daoEmpresa.getLista());
	   	    System.out.println("abirndo dao");
	  	    CaixaDAO daoCaixa= new CaixaDAO(connection);
	   	    daoCaixa.excluir(cdEmp,cdCaixa);
	   	    System.out.println("saindo dao");
    	}
    	
    	catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    	}
  	    finally
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do CRUD
  	    	HttpSession varSessao = request.getSession();
  	    
	      	varSessao.setAttribute("sessionCaixaCdEmp", 0);
	      	varSessao.setAttribute("sessionCaixaCdCaixa",0);
	      	varSessao.setAttribute("sessionCaixaErro", strMsgErro);
	     
  	    }
	   	return mv;
    }
    @RequestMapping("alterar")
   	public ModelAndView AlterarCaixa(@Valid Caixa caixa,HttpServletRequest request) throws Exception
   	{
    	String strMsgErro="";
    	ModelAndView mv = new ModelAndView ("pagcaixa");
  	    try{
  	    	Connection connection=( Connection) request.getAttribute("connection");
  	    	EmpresaDAO daoEmpresa=new EmpresaDAO(connection);
  	    	//mv.addAttribute("lstEmpresa",daoEmpresa.getLista(intParametro1));
  	    	mv.addObject("lstEmpresa",daoEmpresa.getLista());
  	    
  	    	CaixaDAO daoCaixa= new CaixaDAO(connection);
  	    	daoCaixa.alterar(caixa);
  	    }
  	    catch (Exception eMsgErro )
    	{
    		strMsgErro=eMsgErro.getMessage();	
    	}
  	    finally
  	    {
	  	    
	  	    // Gravando as Variavies de sessao para controle do CRUD
  	    	HttpSession varSessao = request.getSession();
  	    
	      	varSessao.setAttribute("sessionCaixaCdEmp", 0);
	      	varSessao.setAttribute("sessionCaixaCdCaixa",0);
	      	varSessao.setAttribute("sessionCaixaErro", strMsgErro);
	     
  	    }
   		return mv;	
   	}
    
} 
