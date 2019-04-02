package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.erros.ExcecaoSujeito;
import model.vos.PsfVO;

public class PsfDAOMysql extends PsfDAO{
	
	protected PsfDAOMysql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void inserir(PsfVO psf) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL = "INSERT INTO psf (idPSF,nome,cidade,bairro,uf,CEP,fone,dataCadastro) VALUES (?,?,?,?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, psf.getId());
			ps.setString(2, psf.getNome());
			ps.setString(3, psf.getCidade());
			ps.setString(4, psf.getBairro());
			ps.setString(5, psf.getUf());
			ps.setString(6, psf.getCep());
			ps.setString(7, psf.getFone());
			ps.setDate(8, psf.getDataCadastro());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new ExcecaoSujeito("Erro ao inserir os dados do Posto "+psf.getNome()+" no banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected void excluir(int id, String nome) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void alterar(PsfVO psf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<PsfVO> listar(String coluna, String organizarPor,
			String texto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
