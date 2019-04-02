package model;

import model.vos.SubgrupoVO;

public class SubgrupoBO {
	protected SubgrupoBO() {
		// TODO Auto-generated constructor stub
	}
	
	protected void inserir(SubgrupoVO subgrupo) throws Exception {
		FabricaDAOS.getFabricaDAOS().criarSubgrupoDAO().inserir(subgrupo);
		
	}
	
	protected void alterar(SubgrupoVO subgrupo) throws Exception {
		FabricaDAOS.getFabricaDAOS().criarSubgrupoDAO().alterar(subgrupo);
		
	}

}
