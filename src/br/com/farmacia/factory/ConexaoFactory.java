package br.com.farmacia.factory;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=sistema_farmacia";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection conexao = DriverManager.getConnection(URL, "sa", "leonardo1989");
		return conexao;

	}

	public static void main(String[] args) {

		try {
			
			@SuppressWarnings("unused")
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão obtida com Sucesso!");

		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLEState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());

		} catch (Exception e) {

			System.out.println("Não foi possível conectar ao Banco: " + e);

		}

	}

}
