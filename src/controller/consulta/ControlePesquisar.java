package controller.consulta;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class ControlePesquisar extends KeyAdapter{
	
	protected ControlePesquisar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		atualizarTabela();
	}

	protected abstract void atualizarTabela();

}
