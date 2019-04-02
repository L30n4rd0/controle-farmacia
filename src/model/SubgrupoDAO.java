package model;

import java.util.ArrayList;

import model.vos.SubgrupoVO;

public abstract class SubgrupoDAO {
	
	protected SubgrupoDAO() {
		// TODO Auto-generated constructor stub
	}
	protected abstract void inserir(SubgrupoVO subgrupo) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(SubgrupoVO subgrupo) throws Exception;
	protected abstract ArrayList<SubgrupoVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
