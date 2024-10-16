package br.com.farmacia.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {	
	
	//@Test
	public void salvar() throws SQLException {
		
	Produtos p1 = new Produtos();
	
	Fornecedores f = new Fornecedores();
	f.setCodigo(10);	
	
	
	p1.setFornecedores(f);
	p1.setDescricao("Produto 2020");
	p1.setQuantidade(30);
	p1.setPreco(40.90);	

	ProdutoDAO pdao = new ProdutoDAO();
	pdao.salvar(p1);
	System.out.println("Salvo com Sucesso!");

	}	
	
	//@Test
	public void excluir() throws SQLException {
		
		Produtos p1 = new Produtos();
		p1.setCodigo(6);
		
		ProdutoDAO pdao = new ProdutoDAO();	
		pdao.excluir(p1);			
		System.out.println("Excluído com Sucesso!");	
	}
	
	//@Test
	public void editar() throws SQLException {
		
		Produtos p1 = new Produtos();
		Fornecedores f = new Fornecedores();
		f.setCodigo(3);	
		
		p1.setCodigo(4);
		p1.setFornecedores(f);		
		p1.setDescricao("Quarto Produto");
		p1.setQuantidade(100);
		p1.setPreco(1000.00);	
		
		
		ProdutoDAO pdao = new ProdutoDAO();	
		pdao.editar(p1);	
		System.out.println("Alterado com Sucesso!");
	}
	
	@Test
	public void listar() throws SQLException {
		
		ProdutoDAO pdao = new ProdutoDAO();			
		ArrayList<Produtos>lista = pdao.listar();
		
		for(Produtos p: lista) {
			   System.out.println("Código do Produto: "+p.getCodigo());
			   System.out.println("Descrição do Produto: "+p.getDescricao());
			   System.out.println("Quantidade de Produtos: "+p.getQuantidade());
			   System.out.println("Valor do Produto: "+p.getPreco());
			   System.out.println("Código do Fornecedor: "+p.getFornecedores().getCodigo());
			   System.out.println("Descrição do Fornecedor: "+p.getFornecedores().getDescricao());
			   System.out.println("");
			   
		   }	
			
	}	
	


}
