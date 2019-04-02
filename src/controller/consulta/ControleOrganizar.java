package controller.consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControleOrganizar implements ActionListener{

	protected ControleOrganizar() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		organizar();
		
	}
	
	protected abstract void organizar();
	protected abstract void atualizarTabela();

}
