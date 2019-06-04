package br.com.sisarq.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


import br.com.sisarq.jdbc.ConnectionFactory;
@WebFilter("/*")
public class filtroCaixa implements Filter{
  public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
     try{
	 Connection connection = new ConnectionFactory().getConnection();
     connection.getAutoCommit() ;
     request.setAttribute("connection", connection);
     chain.doFilter(request, response);
     
     connection.close();
     } catch (SQLException e) {
			throw new ServletException(e);
		}
     
  }
  public void destroy()
  {}
  public void init(FilterConfig arg0)
  {
	  
  }

}
