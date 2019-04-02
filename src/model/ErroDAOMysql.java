package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vos.ErroVO;

public class ErroDAOMysql extends ErroDAO{

	protected ErroDAOMysql() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void inserir(ArrayList<ErroVO> erros) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;
		
		try{
			String stringSQL="INSERT INTO erro (idErro,codigo,data,informacoes,status) VALUES (?,?,?,?,?)";
			
			conn = AdmBancoSql.getConnection();
			ps = conn.prepareStatement(stringSQL);
			
			for (ErroVO erro : erros) {
				ps.setInt(1, erro.getId());
				ps.setInt(2, erro.getCodigoError());
				ps.setDate(3, erro.getData());
				ps.setString(4, erro.getInformacoes());
				ps.setString(5, erro.getStatus());
				ps.executeUpdate();
				
			}
		
		} catch (SQLException excecao) {
			
			String mensagemUsuario="Erro ao inserir as informa"+(char)231+""+(char)245+"es do erro no banco de dados!\nMais detalhes ser"+(char)227+"o salvos na pasta erros!",
					informacoesErro=mensagemUsuario;
			
			int codigoErro=excecao.getErrorCode();
			
			informacoesErro+="\nLocalizedMessage: "+excecao.getLocalizedMessage()+
					"\nSQLExceptionMessage:"+excecao.getMessage()+
					"\nSQLState: "+excecao.getSQLState()+
					"\nCause: "+excecao.getCause()+
					"\nClass: "+excecao.getClass()+
					"\nNextException: "+excecao.getNextException()+
					"\nStackTrace: "+excecao.getStackTrace()+
					"\nSuppressed: "+excecao.getSuppressed();
			
			erros.add(new ErroVO(0, codigoErro, new Date(System.currentTimeMillis()), informacoesErro));
			
			ErroDAOArquivo erroDAOArquivo=new ErroDAOArquivo();
			
			try {
				erroDAOArquivo.inserir(erros);
				
			} catch (Exception e) {
				mensagemUsuario+="\n"+e.getMessage();//getMessage retorna a mensagem de erro da insercao no arquivo
				
			}
			
			throw new Exception(mensagemUsuario);
			
		} finally {
			AdmBancoSql.closeConnection(conn, ps, null);
		}
		
	}

	@Override
	protected void excluir(int id) throws Exception {
		
	}

	@Override
	protected void alterar(ErroVO erro) throws Exception {
		
	}

	@Override
	protected ArrayList<ErroVO> listar(String coluna, String organizarPor,
			String texto) throws Exception {
		return null;
	}

}
