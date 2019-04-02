package controller.consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControleEditar implements ActionListener{

	protected ControleEditar() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		editar();
		atualizarTabela();
		
	}
	
	protected abstract void editar();
	protected abstract void atualizarTabela();

}
