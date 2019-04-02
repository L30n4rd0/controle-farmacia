package model;

import java.util.ArrayList;

import model.vos.UsuarioVO;

public abstract class UsuarioDAO {
	
	protected UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	protected abstract void inserir(UsuarioVO usuario) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(UsuarioVO usuario) throws Exception;
	protected abstract ArrayList<UsuarioVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
