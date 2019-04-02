package model.erros;

import java.util.ArrayList;

import model.FabricaDAOS;
import model.Fachada;
import model.vos.ErroVO;

public class ObservadorBanco extends Observador{

	public ObservadorBanco() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void processarErro(ArrayList<ErroVO> erros) throws Exception{
		
		Fachada fachada=new Fachada();
		fachada.inserirErro(erros);
			
	}
}
