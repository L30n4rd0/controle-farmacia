package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.erros.ExcecaoSujeito;
import model.vos.SubgrupoVO;

public class SubgrupoDAOMysql extends SubgrupoDAO{
	protected SubgrupoDAOMysql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void inserir(SubgrupoVO subgrupo) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO subgrupo (idSubgrupo,nome) VALUES (?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, subgrupo.getId());
			ps.setString(2, subgrupo.getNome());
			ps.executeUpdate();
		
		} catch (SQLException sqle) {
			throw new ExcecaoSujeito("Erro ao inserir os dados do Subgrupo "+subgrupo.getNome()+" no banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected void excluir(int id, String nome) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void alterar(SubgrupoVO subgrupo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<SubgrupoVO> listar(String coluna, String organizarPor,
			String texto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
