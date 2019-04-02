package model;

import java.util.ArrayList;

import model.vos.ErroVO;

public abstract class ErroDAO {
	
	protected ErroDAO() {
		// TODO Auto-generated constructor stub
	}
	
	protected abstract void inserir(ArrayList<ErroVO> erros) throws Exception;
	protected abstract void excluir(int id) throws Exception;
	protected abstract void alterar(ErroVO erro) throws Exception;
	protected abstract ArrayList<ErroVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
