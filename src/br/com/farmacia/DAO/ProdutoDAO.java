package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {
	
	public void salvar(Produtos p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PRODUTOS ");
		sql.append("(CODIGO, DESCRICAO, QUANTIDADE, PRECO ) ");
		sql.append("VALUES(?, ?, ?, ?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, p.getFornecedores().getCodigo());
		comando.setString(2, p.getDescricao());
		comando.setInt(3, p.getQuantidade());
		comando.setDouble(4, p.getPreco());
		comando.executeUpdate();
	}
	
	public void excluir(Produtos p) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM PRODUTOS ");
		sql.append("WHERE CODIGO_PRODUTO = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, p.getCodigo());
		comando.executeUpdate();
	}
	
	
	public void editar(Produtos p) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE PRODUTOS ");
		sql.append("SET CODIGO = ?, DESCRICAO = ?, QUANTIDADE = ?, PRECO = ? ");
		sql.append("WHERE CODIGO_PRODUTO = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, p.getFornecedores().getCodigo());
		comando.setString(2, p.getDescricao());
		comando.setInt(3, p.getQuantidade());
		comando.setDouble(4, p.getPreco());
		comando.setInt(5, p.getCodigo());
		comando.executeUpdate();
		
	}	
	
	//TODO Verificar a descrição do Fornecedor (mudar nome descricao na tabela fornecedor)
	public ArrayList<Produtos>	listar()throws SQLException{ 		
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT P.CODIGO_PRODUTO, P.DESCRICAO, P.QUANTIDADE, P.PRECO, F.CODIGO, F.DESCRICAO ");
		sql.append("FROM PRODUTOS P INNER JOIN FORNECEDORES F ");
		sql.append("ON F.CODIGO = P.CODIGO ");	
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Produtos>lista = new ArrayList<Produtos>();
		
		while(resultado.next()) {				
			
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getInt("CODIGO"));		
			f.setDescricao(resultado.getString("DESCRICAO"));			
			Produtos p = new Produtos();	
			p.setCodigo(resultado.getInt("CODIGO_PRODUTO"));		
			p.setDescricao(resultado.getString("DESCRICAO"));			
			p.setQuantidade(resultado.getInt("QUANTIDADE"));
			p.setPreco(resultado.getDouble("PRECO"));			
			p.setFornecedores(f);			
			lista.add(p);			
		}
		
		return lista;
		
	}

	
	
}
