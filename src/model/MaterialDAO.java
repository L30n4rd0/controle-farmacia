package model;

import java.util.ArrayList;

import model.vos.MaterialVO;

public abstract class MaterialDAO {
	
	protected MaterialDAO() {
		// TODO Auto-generated constructor stub
	}
	
	protected abstract void inserir(MaterialVO material) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(MaterialVO material) throws Exception;
	protected abstract ArrayList<MaterialVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
