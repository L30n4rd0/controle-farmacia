package model;

import java.util.ArrayList;

import model.vos.FornecedorVO;

public class FornecedorDAOOracle extends FornecedorDAO{
	
	protected FornecedorDAOOracle() {}

	@Override
	protected void inserir(FornecedorVO fornecedor) throws Exception{
	}

	@Override
	protected void excluir(int id, String nome) throws Exception{
	}

	@Override
	protected void alterar(FornecedorVO fornecedor) throws Exception{
	}

	@Override
	protected ArrayList<FornecedorVO> listar(String coluna, String organizarPor, String texto) throws Exception{
		return null;
	}

}
