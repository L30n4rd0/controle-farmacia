package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.material.TelaMaterial;

public class ControleInicialMedicamento implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleInicialMedicamento(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaMaterial("Medicamentos", this.telaInicial.getUsuarioLogado());
		this.telaInicial.dispose();
		
	}

}
