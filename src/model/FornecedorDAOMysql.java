package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.erros.ExcecaoSujeito;
import model.vos.FornecedorVO;

public class FornecedorDAOMysql extends FornecedorDAO{
	
	protected FornecedorDAOMysql() {}

	@Override
	protected void inserir(FornecedorVO fornecedor) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO fornecedor (idFornecedor,nome,cidade,uf,cnpj,inscricao,dataCadastro) VALUES (?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, fornecedor.getId());
			ps.setString(2, fornecedor.getNome());
			ps.setString(3, fornecedor.getCidade());
			ps.setString(4, fornecedor.getUf());
			ps.setString(5, fornecedor.getCnpj());
			ps.setString(6, fornecedor.getInscricao());
			ps.setDate(7, fornecedor.getDataCadastro());
			ps.executeUpdate();
		
		} catch (SQLException sqle) {
			throw new ExcecaoSujeito("Erro ao inserir os dados do Fornecedor "+fornecedor.getNome()+" no banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected void excluir(int id, String nome) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("DELETE FROM fornecedor WHERE idFornecedor = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			
			throw new ExcecaoSujeito("Erro ao excluir o Fornecedor "+nome+" do banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
	}

	@Override
	protected void alterar(FornecedorVO fornecedor) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String SQL = "UPDATE fornecedor SET nome=?,cidade=?,uf=?,cnpj=?,inscricao=? WHERE idFornecedor=?";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCidade());
			ps.setString(3, fornecedor.getUf());
			ps.setString(4, fornecedor.getCnpj());
			ps.setString(5, fornecedor.getInscricao());
			ps.setInt(6, fornecedor.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new ExcecaoSujeito("Erro ao alterar os dados do fornecedor: "+fornecedor.getNome()+" no banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected ArrayList<FornecedorVO> listar(String coluna, String organizarPor, String texto) throws Exception{
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		
		ArrayList<FornecedorVO> list = new ArrayList<FornecedorVO>();
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM fornecedor WHERE "+coluna+" LIKE '%"+texto+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			
			while( result.next() )
			{
				int idFornecedor = result.getInt("idFornecedor");
				String nome = result.getString("nome");
				String cidade = result.getString("cidade");
				String uf = result.getString("uf");
				String cnpj = result.getString("cnpj");
				String inscricao = result.getString("inscricao");
				Date dataCadastro = result.getDate("dataCadastro");
				
				list.add(new FornecedorVO(idFornecedor, nome, cidade, uf, cnpj, inscricao, dataCadastro));
			}
			
		} catch (SQLException sqle) {
			throw new ExcecaoSujeito("Ocorreu um erro durante a consulta no banco dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		
		return list;
	}

}
