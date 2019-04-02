package controller.consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControleDeletar implements ActionListener{

	protected ControleDeletar() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		deletar();
		atualizarTabela();
	}
	
	protected abstract void deletar();
	protected abstract void atualizarTabela();

}
