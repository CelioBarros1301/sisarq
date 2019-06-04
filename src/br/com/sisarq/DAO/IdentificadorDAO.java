package br.com.sisarq.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import br.com.sisarq.jdbc.ConnectionFactory;
import br.com.sisarq.mvc.modelo.Identificador;

public class IdentificadorDAO {
private Connection connection;
	
	public IdentificadorDAO(Connection connection)
	{
		this.connection= connection;
	}
	public IdentificadorDAO() throws ServletException
	{
		connection= new ConnectionFactory().getConnection();
	}
    public void adiciona(Identificador oIdentificador)
    {
    	
    	String sqlInsert="INSERT INTO t_Identificador Values (?,?;?)";
    	PreparedStatement stmt =null;
    	try {
			stmt =connection.prepareStatement(sqlInsert);
			stmt.setString(1,oIdentificador.getCdEmp());
			stmt.setString(2, oIdentificador.getDsCampo());
			stmt.setString(3, oIdentificador.getDsCampo());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException  e){
			throw new RuntimeException(e);
			// TODO: handle exception
		}
    	finally {
        	try{
        		stmt.close();
        		connection.close();
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    public Identificador consulta(Identificador oIdentificador)
    {
    	String sqlConsulta="SELECT * FROM T_Identificador WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=?  ";
    	sqlConsulta=sqlConsulta+"dsCampo=?  ";
    	
    	
    	    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,oIdentificador.getCdEmp());
			stmt.setString(2,oIdentificador.getDsCampo());
			
			
			rs=stmt.executeQuery();
			if ( rs.next() ){
				oIdentificador.setCdEmp(rs.getString("cdEmp"));
			    oIdentificador.setDsCampo(rs.getString("dsCampo"));
			    oIdentificador.setIdCampo(rs.getInt("idCampo"));
			    return oIdentificador;
			}
			else
			  throw new RuntimeException("Identificador Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    public Identificador consulta(String pCdEmp,String pDsCampo)
    {
    	Identificador oIdentificador=new Identificador();
    	String sqlConsulta="SELECT * FROM T_Identificador WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? ";
    	sqlConsulta=sqlConsulta+"dsCampo=?  ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,pCdEmp);
			stmt.setString(2, pDsCampo);
			rs=stmt.executeQuery();
			if ( rs.next() ){
				oIdentificador.setCdEmp(rs.getString("cdEmp"));
			    oIdentificador.setDsCampo(rs.getString("dsCampo"));
			    oIdentificador.setIdCampo(rs.getInt("idCampo"));
			    
			    return oIdentificador;
			}
			else
			  throw new RuntimeException("Identificador Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    public void alterar (Identificador oIdentificador)
    {
    	String sqlAlterar="UPDATE t_Identificador set idCampo=? ";
    	sqlAlterar=sqlAlterar +" WHERE cdEmp=?  ";
    	sqlAlterar=sqlAlterar+" dsCampo=?";
    	PreparedStatement stmt =null;
    	try {
    		stmt=connection.prepareStatement(sqlAlterar);
    		stmt.setInt(1, oIdentificador.getIdCampo());
    		stmt.setString(2, oIdentificador.getCdEmp());
			stmt.setString(3,oIdentificador.getDsCampo());
			stmt.execute();
		
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
		}
	    finally {
        	try{
        		stmt.close();
         		connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
	    }
    }
    
}