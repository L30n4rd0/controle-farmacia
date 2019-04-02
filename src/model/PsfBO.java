package model;

import model.vos.PsfVO;


public class PsfBO {
	
	protected PsfBO() {
		// TODO Auto-generated constructor stub
	}
	
	protected void inserir(PsfVO psf) throws Exception {
		PsfDAO psfDAO=FabricaDAOS.getFabricaDAOS().criarPsfDAO();
		psfDAO.inserir(psf);
		
	}
	
	protected void alterar(PsfVO psf) throws Exception {
		
	}

}
