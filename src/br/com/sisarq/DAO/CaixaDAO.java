package br.com.sisarq.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import br.com.sisarq.jdbc.ConnectionFactory;
import br.com.sisarq.mvc.modelo.Caixa;
import br.com.sisarq.mvc.modelo.CaixaEmpresa;

public class CaixaDAO {
	private Connection connection;
	
	public CaixaDAO(Connection connection)
	{
		this.connection= connection;
	}
	public CaixaDAO() throws ServletException
	{
		connection= new ConnectionFactory().getConnection();
	}
    public void adiciona(Caixa oCaixa) throws Exception
    {
    	
    	String sqlInsert="INSERT INTO t_caixa Values (?,?,?)";
    	PreparedStatement stmt =null;
    	try {
			stmt =connection.prepareStatement(sqlInsert);
			stmt.setString(1,oCaixa.getCdEmp());
			stmt.setString(2, oCaixa.getCdCaixa());
			stmt.setString(3, oCaixa.getDsCaixa());
			
			stmt.execute();
			stmt.close();
			throw new RuntimeException("INFO:Caixa:"+oCaixa.getCdCaixa()+"-"+oCaixa.getDsCaixa()+" Salva Com sucesso!");
			
		} catch (SQLException  e){
			
			if (e.getErrorCode()==1062 ){
				throw new RuntimeException("INFO:Caixa:"+oCaixa.getCdCaixa()+"-"+oCaixa.getDsCaixa()+" Ja cadastrada!");
			}
			else
			{
				throw new RuntimeException("ERRO:"+e);
			}
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
    public Caixa consulta(Caixa oCaixa) throws Exception
    {
    	String sqlConsulta="SELECT * FROM T_CAIXA WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? AND ";
    	sqlConsulta=sqlConsulta+"cdCaixa=? ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,oCaixa.getCdEmp());
			stmt.setString(2, oCaixa.getCdCaixa());
			rs=stmt.executeQuery();
			if ( rs.next() ){
				oCaixa.setCdEmp(rs.getString("cdEmp"));
			    oCaixa.setCdCaixa(rs.getString("cdCaixa"));
			    oCaixa.setDsCaixa(rs.getString("dsCaixa"));
			    return oCaixa;
			}
			else
			  throw new RuntimeException("INFO:Caixa:" +oCaixa.getCdCaixa()+"  Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO:"+e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
        }
    }
    public Caixa consulta(String pCdEmp,String pCdCaixa) //throws Exception
    {
    	Caixa oCaixa=new Caixa();
    	String sqlConsulta="SELECT * FROM T_CAIXA WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? AND ";
    	sqlConsulta=sqlConsulta+"cdCaixa=? ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		System.out.println("dao empresa:"+pCdEmp);
		System.out.println("dao Caixa:"+pCdCaixa);
		
    	try {
			stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,pCdEmp);
			stmt.setString(2, pCdCaixa);
			rs=stmt.executeQuery();
			
			if ( rs.next() ){
				oCaixa.setCdEmp(rs.getString("cdEmp"));
			    oCaixa.setCdCaixa(rs.getString("cdCaixa"));
			    oCaixa.setDsCaixa(rs.getString("dsCaixa"));
			    return oCaixa;
			}
			else
			  throw new RuntimeException("INFO:Caixa:" +pCdCaixa+"  Não Cadastrada!!");	
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO:"+e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
        }
    }
    public void alterar (Caixa oCaixa) throws Exception
    {
    	String sqlAlterar="UPDATE t_caixa set dsCaixa=? ";
    	sqlAlterar=sqlAlterar +" WHERE cdEmp=? AND ";
    	sqlAlterar=sqlAlterar+" cdCaixa=?";
    	PreparedStatement stmt =null;
    	try {
    		stmt=connection.prepareStatement(sqlAlterar);
    		stmt.setString(1, oCaixa.getDsCaixa());
			stmt.setString(2, oCaixa.getCdEmp());
			stmt.setString(3, oCaixa.getCdCaixa());
			stmt.execute();
			throw new RuntimeException("INFO:Caixa:"+oCaixa.getCdCaixa()+"-"+oCaixa.getDsCaixa()+" Alterado Com sucesso!");
					
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("ERRO:"+e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
	    }
    }
    public void excluir(Caixa oCaixa) throws Exception
    { 
    	String sqlExcluir="DELETE FROM t_caixa ";
    	sqlExcluir=sqlExcluir +" WHERE cdEmp=? AND ";
    	sqlExcluir=sqlExcluir+" cdCaixa=?";
    	PreparedStatement stmt =null; 
    	
    	try {
    		stmt=connection.prepareStatement(sqlExcluir);
    		stmt.setString(1,oCaixa.getCdEmp());
			stmt.setString(2, oCaixa.getCdCaixa());
			stmt.execute();
			throw new RuntimeException("INFO:Caixa:"+oCaixa.getCdCaixa()+"-"+oCaixa.getDsCaixa()+" Excluido Com sucesso!");
			
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("ERRO:"+e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
	    }
    }
    public void excluir(String strCdEmp,String strCdCaixa) throws Exception
    {
    	String sqlExcluir="DELETE FROM t_caixa ";
    	sqlExcluir=sqlExcluir +" WHERE cdEmp=? AND ";
    	sqlExcluir=sqlExcluir+" cdCaixa=?";
    	PreparedStatement stmt =null;
    	
    	try {
    		stmt=connection.prepareStatement(sqlExcluir);
    		stmt.setString(1,strCdEmp);
			stmt.setString(2,strCdCaixa);
			stmt.execute();
			throw new RuntimeException("INFO:Caixa:"+strCdCaixa+" Excluido Com sucesso!");
			
    	}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("ERRO:"+e);
		}
	    finally {
        	try{
        		stmt.close();
         		//connection.close();
                
        	}
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
	    }
    }
    public List<Caixa> getLista(Caixa oCaixa) throws Exception
    {
    	String sqlConsulta="SELECT * FROM T_CAIXA WHERE ";
    	sqlConsulta=sqlConsulta+"cdEmp=? ";
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		List<Caixa> lCaixa=new ArrayList<Caixa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
			stmt.setString(1,oCaixa.getCdEmp());
			rs=stmt.executeQuery();
			if (rs.next() ){
				do{
					oCaixa.setCdEmp(rs.getString("cdEmp"));
				    oCaixa.setCdCaixa(rs.getString("cdCaixa"));
				    oCaixa.setDsCaixa(rs.getString("dsCaixa"));
				    lCaixa.add(oCaixa);
				}while ( rs.next()==true ) ;
				return lCaixa;
			}
			else
				throw new RuntimeException("INFO:Não Existe Caixa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO:"+e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
        }
    }  
     
    public List<Caixa> getLista() throws Exception
    {
    	String sqlConsulta="SELECT * FROM T_CAIXA ";
    
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		List<Caixa> lCaixa=new ArrayList<Caixa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
			rs=stmt.executeQuery();
			if (rs.next() ){
				do{
					Caixa oCaixa=new Caixa(rs.getString("cdEmp"),rs.getString("cdCaixa"),rs.getString("dsCaixa"));
				    lCaixa.add(oCaixa);
				}while ( rs.next()==true ) ;
				return lCaixa;
			}
			else
				throw new RuntimeException("INFO: Não Existe Caixa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO:"+e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
        }
    }
    
    public List<CaixaEmpresa> getListaEmpresaCaixa(String strCodEmpresa) throws Exception
    {
    	/*String sqlConsulta="SELECT  t_empresa.cdEmp as [Codigo Empresa],";
        sqlConsulta=sqlConsulta + "t_empresa.dsEmp as [Nome Empresa]  ,";
        sqlConsulta=sqlConsulta +"t_caixa.cdCaixa as [Codigo Caixa]  ,";
        sqlConsulta=sqlConsulta +"t_caixa.dsCaixa as [Descrição Caixa] ";
        sqlConsulta=sqlConsulta +"FROM t_empresa ";
        sqlConsulta=sqlConsulta +"INNER JOIN t_caixa on ";
        sqlConsulta=sqlConsulta +"t_empresa.cdEmp=t_caixa.cdEmp ";
        //sqlConsulta=sqlConsulta +"WHERE t_empresa.cdEmp=? ";*/
        
        String sqlConsulta="SELECT  t_empresa.cdEmp ,";
        sqlConsulta=sqlConsulta + "t_empresa.dsEmp   ,";
        sqlConsulta=sqlConsulta +"t_caixa.cdCaixa  ,";
        sqlConsulta=sqlConsulta +"t_caixa.dsCaixa ";
        sqlConsulta=sqlConsulta +"FROM t_empresa ";
        sqlConsulta=sqlConsulta +"INNER JOIN t_caixa on ";
        sqlConsulta=sqlConsulta +"t_empresa.cdEmp=t_caixa.cdEmp ";
        //sqlConsulta=sqlConsulta +"WHERE t_empresa.cdEmp=? ";
    	System.out.println(sqlConsulta+" "+strCodEmpresa);
    	
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	stmt = null;
		List<CaixaEmpresa> lCaixaEmpresa=new ArrayList<CaixaEmpresa>();
		try {
		    stmt = connection.prepareStatement(sqlConsulta);
			//stmt.setString(1,strCodEmpresa);
			rs=stmt.executeQuery();
			if (rs.next() ){
				do{
					CaixaEmpresa oCaixaEmpresa=new CaixaEmpresa();

					//oCaixaEmpresa.setCdEmp(rs.getString(0));
					oCaixaEmpresa.setCdEmp(rs.getString("cdEmp"));
					oCaixaEmpresa.setDsEmp(rs.getString("dsEmp"));
					oCaixaEmpresa.setCdCaixa(rs.getString("cdCaixa"));
					oCaixaEmpresa.setDsCaixa(rs.getString("dsCaixa"));
				
				    lCaixaEmpresa.add(oCaixaEmpresa);
				}while ( rs.next()==true ) ;
				return lCaixaEmpresa;
			}
			else
				throw new RuntimeException("INFO:Não Existe Caixa Cadastrados");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO:"+e);
		}
        finally {
        	try{
        		stmt.close();
        		rs.close();
         		//connection.close();
            }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			throw new RuntimeException("ERRO:"+e);
    		}	
        	
        }
    }  
    
    
}