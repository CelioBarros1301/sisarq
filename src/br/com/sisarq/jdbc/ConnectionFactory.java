package br.com.sisarq.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ConnectionFactory {
	 
		 
		public Connection getConnection() throws ServletException 
		{
			//String strConexaoITG04\SQLEXPRESSITG04\SQLEXPRESS
	    
			
			String strConexao="jdbc:sqlserver://ITG04\\SQLEXPRESS:1433;databaseName=SISARQ;user=sa;password=secrel";
			//String strConexao="jdbc:sqlserver:1433;databaseName=SISARQ;user=sa;password=secrel";
			
			String serverName="localhost";
			String myDatabase="sisarq";
			String url="jdbc:mysql://"+serverName+"/"+myDatabase;
			String userName="root";
			String password="secrel";
			
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection ocon=DriverManager.getConnection(strConexao);
				//Class.forName("com.mysql.jdbc.Driver");
				//Connection ocon=DriverManager.getConnection(url,userName,password);
				
				return  ocon; //DriverManager.getConnection(url,userName,password);
			}
			catch ( SQLException e)
			{
			System.out.println("Conexao..");	  
			//e.printStackTrace();
			
			throw new ServletException(e);
			}
			catch ( ClassNotFoundException e)
			{
				 
				e.printStackTrace();
				throw new ServletException(e);
			}
		
		}
		
	}
