package model;

import java.util.ArrayList;

import model.vos.FornecedorVO;

public abstract class FornecedorDAO {
	
	protected FornecedorDAO() {}
	
	protected abstract void inserir(FornecedorVO fornecedor) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(FornecedorVO fornecedor) throws Exception;
	protected abstract ArrayList<FornecedorVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
