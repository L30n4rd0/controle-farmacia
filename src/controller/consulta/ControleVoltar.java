package controller.consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInicial;
import view.consulta.TelaConsulta;

public class ControleVoltar implements ActionListener{

	TelaConsulta telaConsulta;
	
	public ControleVoltar(TelaConsulta tela) {
		this.telaConsulta=tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaInicial(this.telaConsulta.getTelaInicial().getUsuarioLogado());
		this.telaConsulta.dispose();
	}
	

}
