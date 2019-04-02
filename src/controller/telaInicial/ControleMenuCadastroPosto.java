package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.cadastro.TelaCadastroPosto;

public class ControleMenuCadastroPosto implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleMenuCadastroPosto(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastroPosto(null);
		
	}

}
