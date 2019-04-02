package model;

import java.util.ArrayList;

import model.vos.FornecedorVO;


public class FornecedorBO {
	
	protected FornecedorBO() {}
	
	protected void inserir(FornecedorVO fornecedor) throws Exception  {
		FabricaDAOS fabricaDAO=FabricaDAOS.getFabricaDAOS();
		FornecedorDAO fornecedorDAo=fabricaDAO.criarFornecedorDAO();
		fornecedorDAo.inserir(fornecedor);
		
	}
	
	protected void alterar(FornecedorVO fornecedor) throws Exception  {
		FabricaDAOS fabricaDAO=FabricaDAOS.getFabricaDAOS();
		FornecedorDAO fornecedorDAo=fabricaDAO.criarFornecedorDAO();
		fornecedorDAo.alterar(fornecedor);
		
	}
	
	protected ArrayList<FornecedorVO> listar(String coluna, String organizarPor, String texto) throws Exception {
		
		return FabricaDAOS.getFabricaDAOS().criarFornecedorDAO().listar(coluna, organizarPor, texto);
		
	}
	
	protected void excluir(int id, String nome) throws Exception {
		
		FabricaDAOS.getFabricaDAOS().criarFornecedorDAO().excluir(id, nome);
		
		
	}

}
