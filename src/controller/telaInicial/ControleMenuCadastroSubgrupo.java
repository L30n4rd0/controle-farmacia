package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.cadastro.TelaCadastroSubgrupo;

public class ControleMenuCadastroSubgrupo implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleMenuCadastroSubgrupo(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastroSubgrupo(null);
		
	}

}
