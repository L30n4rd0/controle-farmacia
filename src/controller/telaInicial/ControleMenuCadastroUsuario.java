package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.cadastro.TelaCadastroUsuario;

public class ControleMenuCadastroUsuario implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleMenuCadastroUsuario(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastroUsuario(null);
		
	}

}
