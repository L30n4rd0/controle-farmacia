package model;

import java.util.ArrayList;

import model.vos.ItemEntradaVO;

public abstract class ItemEntradaDAO {
	
	protected ItemEntradaDAO() {}
	
	protected abstract void inserir(ItemEntradaVO itemEntrada) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(ItemEntradaVO itemEntrada) throws Exception;
	protected abstract ArrayList<ItemEntradaVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
