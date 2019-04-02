package model;

import java.util.ArrayList;

import model.vos.SaidaVO;

public abstract class SaidaDAO {
	
	protected SaidaDAO() {
		// TODO Auto-generated constructor stub
	}
	protected abstract void inserir(SaidaVO saida) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(SaidaVO saida) throws Exception;
	protected abstract ArrayList<SaidaVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
