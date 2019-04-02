package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.erros.ExcecaoSujeito;

public class AdmBancoSql {
	
	protected AdmBancoSql() {
		// TODO Auto-generated constructor stub
	}
	
	protected static Connection getConnection() throws Exception{
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdfarmacia","root", "");
			
		} catch (SQLException excecao) {
			con = null;
			throw new ExcecaoSujeito("N"+(char)227+"o foi possivel conectar com o banco", excecao);
		}
		return con;
	}
	
	protected static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception{
		try {
			if (rs != null) rs.close( );
			if (stmt != null)stmt.close( );
			if (conn != null)conn.close( );
		} catch (SQLException excecao) {
			throw new ExcecaoSujeito("Erro ao fechar Banco de dados", excecao);
			
		}
	}
}
