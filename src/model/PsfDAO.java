package model;

import java.util.ArrayList;

import model.vos.PsfVO;

public abstract class PsfDAO {
	
	protected PsfDAO() {
		// TODO Auto-generated constructor stub
	}
	protected abstract void inserir(PsfVO psf) throws Exception;
	protected abstract void excluir(int id, String nome) throws Exception;
	protected abstract void alterar(PsfVO psf) throws Exception;
	protected abstract ArrayList<PsfVO> listar(String coluna, String organizarPor, String texto) throws Exception;

}
