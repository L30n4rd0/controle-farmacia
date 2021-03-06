package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.erros.ExcecaoSujeito;
import model.vos.UsuarioVO;

public class UsuarioDAOMysql extends UsuarioDAO{

	protected UsuarioDAOMysql() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void inserir(UsuarioVO usuario) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO usuario (idUsuario,nome,login,senha,nivel) VALUES (?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			ps.setInt(1, usuario.getId());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getNivel());
			ps.executeUpdate();
		
		} catch (SQLException sqle) {
			
			ExcecaoSujeito teste=new ExcecaoSujeito("Erro ao inserir os dados do Usu"+(char)225+"rio "+usuario.getNome()+" no banco de dados!", sqle);
			throw teste; 
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected void excluir(int id, String nome) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void alterar(UsuarioVO usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<UsuarioVO> listar(String coluna, String organizarPor,
			String texto) throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet result = null;
		
		ArrayList<UsuarioVO> list = new ArrayList<UsuarioVO>();
		try {
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement("SELECT * FROM usuario WHERE "+coluna+" LIKE '%"+texto+"%' ORDER BY "+organizarPor);
			result = ps.executeQuery();
			
			while( result.next() )
			{
				int id_usuario = result.getInt("idUsuario");
				String nome = result.getString("nome");
				String nomeLogin = result.getString("login");
				String senha = result.getString("senha");
				String nivel = result.getString("nivel");
				
				list.add(new UsuarioVO(id_usuario, nome, nomeLogin, senha, nivel));
			}
		} catch (SQLException sqle) {
			
			throw new ExcecaoSujeito("Erro ao consultar os Usu"+(char)225+"rios no banco de dados!", sqle);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, result);
		}
		return list;
	}

}
