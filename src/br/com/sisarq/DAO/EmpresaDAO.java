package br.com.sisarq.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import br.com.sisarq.jdbc.ConnectionFactory;
import br.com.sisarq.mvc.modelo.Empresa;

public class EmpresaDAO {
	private Connection connection;
	
	public EmpresaDAO(Connection connection)
	{
		this.connection= connection;
	}
	public EmpresaDAO() throws ServletException
	{
		connection= new ConnectionFactory().getConnection();
	}
    public void adiciona(Empresa oEmpresa)
    {
    	
    	String sqlInsert="INSERT INTO t_Empresa Values (?,?)";
    	PreparedStatement stmt =null;
    	try {
			stmt =connection.prepareStatement(sqlInsert);
			stmt.setString(1,oEmpresa.getCdEmp());
			stmt.setString(2, oEmpresa.getDsEmp());
			stmt.execute();
			stmt.close();
		} catch (SQLException  e){
			throw new RuntimeException(e);
			// TODO: handle exception
		}
    	finally {
        	try{
        		stmt.close();
        		//connection.close();
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    public Empresa consulta(Empresa oEmpresa)
    {
    	String sqlConsulta="SELECT * FROM T_Empresa WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=?  ";
    	
    	    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,oEmpresa.getCdEmp());
			
			rs=stmt.executeQuery();
			if ( rs.next() ){
				oEmpresa.setCdEmp(rs.getString("cdEmp"));
			    oEmpresa.setDsEmp(rs.getString("dsEmp"));
			    return oEmpresa;
			}
			else
			  throw new RuntimeException("Empresa Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    public Empresa consulta(String pCdEmp,String pCdEmpresa)
    {
    	Empresa oEmpresa=new Empresa();
    	String sqlConsulta="SELECT * FROM T_Empresa WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		System.out.println("dao empresa:"+pCdEmp);
		System.out.println("dao Empresa:"+pCdEmpresa);
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,pCdEmp);
			stmt.setString(2, pCdEmpresa);
			rs=stmt.executeQuery();
			if ( rs.next() ){
				oEmpresa.setCdEmp(rs.getString("cdEmp"));
			    oEmpresa.setDsEmp(rs.getString("dsEmp"));
			    return oEmpresa;
			}
			else
			  throw new RuntimeException("Empresa Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        } 
    }
    public void alterar (Empresa oEmpresa)
    {
    	String sqlAlterar="UPDATE t_Empresa set dsEmp=? ";
    	sqlAlterar=sqlAlterar +" WHERE cdEmp=?  ";
    	sqlAlterar=sqlAlterar+" cdEmpresa=?";
    	PreparedStatement stmt =null;
    	try {
    		stmt=connection.prepareStatement(sqlAlterar);
    		stmt.setString(1, oEmpresa.getDsEmp());
			stmt.setString(2,oEmpresa.getCdEmp());
			stmt.execute();
		
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
	    }
    }
    public void excluir(Empresa oEmpresa)
    { 
    	String sqlExcluir="DELETE FROM t_Empresa ";
    	sqlExcluir=sqlExcluir +" WHERE cdEmp=?  ";
    	
    	PreparedStatement stmt =null; 
    	
    	try {
    		stmt=connection.prepareStatement(sqlExcluir);
    		stmt.setString(1,oEmpresa.getCdEmp());
			stmt.execute();
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
	    }
    }
    public void excluir(String strCdEmp)
    {
    	String sqlExcluir="DELETE FROM t_Empresa ";
    	sqlExcluir=sqlExcluir +" WHERE cdEmp=? ";
    	
    	PreparedStatement stmt =null;
    	System.out.println("excluir: "+ strCdEmp);
    	System.out.println(sqlExcluir);
    	
    	try {
    		stmt=connection.prepareStatement(sqlExcluir);
    		stmt.setString(1,strCdEmp);
			stmt.execute();
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
	    }
    }
    public List<Empresa> getLista(Empresa oEmpresa)
    {
    	String sqlConsulta="SELECT * FROM T_Empresa WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		List<Empresa> lEmpresa=new ArrayList<Empresa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,oEmpresa.getCdEmp());
			rs=stmt.executeQuery();
			if (rs.next() ){
				do{
					oEmpresa.setCdEmp(rs.getString("cdEmp"));
				    oEmpresa.setDsEmp(rs.getString("dsEmp"));
				    lEmpresa.add(oEmpresa);
				}while ( rs.next()==true ) ;
				return lEmpresa;
			}
			else
				throw new RuntimeException("Não Existe Empresa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
     
    public List<Empresa> getLista(int intPara1)
    {
    	// Verficando Parametro 1: Empresa Padrao*/
    
    	PreparedStatement stmtPara=null;
    	ResultSet rsPara=null;
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	
    	String  sqlParametro ="SELECT * FROM t_parametro WHERE staPar=1 AND codPar=?";
    	String strValPara="";
    	
    	try {
    		
    		stmtPara = connection.prepareStatement(sqlParametro);
			stmtPara.setInt(1,intPara1);
			rsPara=stmtPara.executeQuery();
			if ( rsPara.next() ){
				strValPara=rsPara.getString("valPar");
			}
			
		}
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
    	finally {
        	try{
        		stmtPara.close();
        		rsPara.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    	
    	String sqlConsulta="SELECT * FROM T_Empresa ";
    	if (! strValPara.equals("") )
    	{
		  sqlConsulta=sqlConsulta +"WHERE cdEmp = ?";
    	}
    	
    	stmt = null; 
		List<Empresa> lEmpresa=new ArrayList<Empresa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
		   
		    if (! strValPara.equals("") )
		    {
		    	
		    	stmt.setString(1,strValPara);
		    }
			rs=stmt.executeQuery();
			
			if (rs.next() ){
				do{
					Empresa oEmpresa=new Empresa(rs.getString("cdEmp"),rs.getString("dsEmp"));
				    lEmpresa.add(oEmpresa);
				    
				}while ( rs.next()==true ) ;
				return lEmpresa;
			}
			else
				throw new RuntimeException("Não Existe Empresa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    //
    public List<Empresa> getLista()
    {
    	String sqlConsulta="SELECT * FROM T_Empresa ";
    	Empresa oEmpresa=null;
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		List<Empresa> lEmpresa=new ArrayList<Empresa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
			rs=stmt.executeQuery();
			if (rs.next() ){
				do{
					oEmpresa=new Empresa();
					oEmpresa.setCdEmp(rs.getString("cdEmp"));
				    oEmpresa.setDsEmp(rs.getString("dsEmp"));
				    lEmpresa.add(oEmpresa);
				}while ( rs.next()==true ) ;
				return lEmpresa;
			}
			else
				throw new RuntimeException("Não Existe Empresa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException(e);
    		}	
        	
        }
    }
    
    
    
}