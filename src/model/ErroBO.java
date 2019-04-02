package model;

import java.util.ArrayList;

import model.vos.ErroVO;

public class ErroBO {
	
	protected ErroBO() {}
	
	protected void inserir(ArrayList<ErroVO> erros) throws Exception  {
		
		FabricaDAOS.getFabricaDAOS().criarErroDAO().inserir(erros);
		
	}

}
