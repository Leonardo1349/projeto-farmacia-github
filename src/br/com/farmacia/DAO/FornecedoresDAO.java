package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO FORNECEDORES ");
		sql.append("(DESCRICAO) ");
		sql.append("VALUES(?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}
	
	public void excluir(Fornecedores f)throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM FORNECEDORES ");
		sql.append("WHERE CODIGO = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, f.getCodigo());
		comando.executeUpdate();
	}
	
	
	public void editar(Fornecedores f)throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE FORNECEDORES ");
		sql.append("SET DESCRICAO = ? ");
		sql.append("WHERE CODIGO = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setInt(2, f.getCodigo());
		comando.executeUpdate();
	}
	
	public Fornecedores buscaPorCodigo(Fornecedores f)throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODIGO, DESCRICAO ");
		sql.append("FROM FORNECEDORES ");
		sql.append("WHERE CODIGO = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, f.getCodigo());	
		
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		
		if(resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getInt("CODIGO"));
			retorno.setDescricao(resultado.getString("DESCRICAO"));
		}
		
	
		return retorno;
	}
	
 public ArrayList<Fornecedores> buscaPorDescricao(Fornecedores f)throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODIGO, DESCRICAO ");
		sql.append("FROM FORNECEDORES ");
		sql.append("WHERE DESCRICAO LIKE ? ");
		sql.append("ORDER BY DESCRICAO ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");	
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()) {
			Fornecedores fornecedores = new Fornecedores();
			fornecedores.setCodigo(resultado.getInt("CODIGO"));
			fornecedores.setDescricao(resultado.getString("DESCRICAO"));
			lista.add(fornecedores);
		}
		
	
		return lista;
	}
	
	
public ArrayList<Fornecedores>	listar()throws SQLException{ 
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT* FROM FORNECEDORES ");
	sql.append("ORDER BY CODIGO ASC");
	
	Connection conexao = ConexaoFactory.conectar();
	
	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
	ResultSet resultado = comando.executeQuery();
	
	ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
	
	while(resultado.next()) {
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(resultado.getInt("CODIGO"));
		f.setDescricao(resultado.getString("DESCRICAO"));		
		lista.add(f);
		
	}
	
	
	return lista;
	
}

	public static void main(String[] args) {		
		
//----------------------------SALVAR-----------------------------------------------
		
		/*Fornecedores f1 = new Fornecedores();
		f1.setDescricao("DECIMO REGISTRO INSERIDO");

		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("NONIMO REGISTRO INSERIDO");

		FornecedoresDAO fdao = new FornecedoresDAO();

		try {

			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Salvo com Sucesso!");
			
			
			

		} catch (SQLException e) {
			System.out.println("Erro ao Salvar!");
			e.printStackTrace();
		} 
		*/
		
//----------------------------EXCLUIR-----------------------------------------------
		/*
		
		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(2);
		
		FornecedoresDAO fdao = new FornecedoresDAO();	
		
		try {

			fdao.excluir(f1);			
			System.out.println("Excluído com Sucesso!");			

		} catch (SQLException e) {
			System.out.println("Erro ao Excluír!");
			e.printStackTrace();
		}
		*/

//----------------------------EDITAR-----------------------------------------------
		/*Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1);
		f1.setDescricao("Descrição Alterada com Sucesso");
		
		FornecedoresDAO fdao = new FornecedoresDAO();	
		
		try {

			fdao.editar(f1);	
			System.out.println("Alterado com Sucesso!");			

		} catch (SQLException e) {
			System.out.println("Erro ao Alterar!");
			e.printStackTrace();
		}	*/
		
//----------------------------PESQUISAR POR CODIGO-----------------------------------------------
		/*
					Fornecedores f1 = new Fornecedores();
						f1.setCodigo(3);
						
						FornecedoresDAO fdao = new FornecedoresDAO();	
						
						try {

							Fornecedores resultado = fdao.buscaPorCodigo(f1);		
							System.out.println("Retorno da Pesquisa: " +resultado );			

						} catch (SQLException e) {
							System.out.println("Erro ao Pesquisar!");
							e.printStackTrace();
						}		
				
			*/				
		
//----------------------------PESQUISAR POR DESCRIÇÂO-----------------------------------------------
				
							/*Fornecedores f1 = new Fornecedores();
								f1.setDescricao("Sucesso");
								
								FornecedoresDAO fdao = new FornecedoresDAO();	
								
								try {
									
									ArrayList<Fornecedores> lista = fdao.buscaPorDescricao(f1);	
									
									 for(Fornecedores f: lista) {
								    	   System.out.println("Resultado da Busca: "+f);
								    	   
								   }
										
								} catch (SQLException e) {
									System.out.println("Erro ao Pesquisar!");
									e.printStackTrace();
								}		
						*/
						
//----------------------------LISTAR-----------------------------------------------		
		
/*		FornecedoresDAO fdao = new FornecedoresDAO();	
		
		try {
       ArrayList<Fornecedores>lista = fdao.listar();
       
       for(Fornecedores f: lista) {
    	   System.out.println("Resultado da Busca: "+f);
    	   
       }
					

		} catch (SQLException e) {
			System.out.println("Erro ao Listar Resultado!");
			e.printStackTrace();
		}	*/	
	}

}
