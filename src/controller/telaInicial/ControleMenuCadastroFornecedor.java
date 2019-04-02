package controller.telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.cadastro.TelaCadastroFornecedor;
import view.cadastro.TelaCadastroUsuario;

public class ControleMenuCadastroFornecedor implements ActionListener{
	private TelaInicial telaInicial;
	
	public ControleMenuCadastroFornecedor(TelaInicial telaInicial) {
		this.telaInicial=telaInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaCadastroFornecedor(null);
		
	}

}
