package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.consulta.TelaConsultaFornecedor;

public class ControleMenuConsultaFornecedor implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleMenuConsultaFornecedor(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaConsultaFornecedor(this.telaInicial);
		this.telaInicial.dispose();
		
	}

}
