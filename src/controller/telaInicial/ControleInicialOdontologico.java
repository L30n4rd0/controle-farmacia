package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.material.TelaMaterial;

public class ControleInicialOdontologico implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleInicialOdontologico(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaMaterial("Odontol"+(char)243+"gico", this.telaInicial.getUsuarioLogado());
		this.telaInicial.dispose();
		
	}

}
