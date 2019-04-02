package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Fachada;
import model.vos.SubgrupoVO;

import view.cadastro.TelaCadastroSubgrupo;

public class ControleCadastroSubgrupo implements ActionListener{
	private TelaCadastroSubgrupo telaCadastroSubgrupo;
	
	public ControleCadastroSubgrupo(TelaCadastroSubgrupo telaCadastroSubgrupo) {
		this.telaCadastroSubgrupo=telaCadastroSubgrupo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			verificarDados(this.telaCadastroSubgrupo.getTextFieldNome().getText());
			
			int id=0;
			
			if (this.telaCadastroSubgrupo.getEditarSubgrupo()!=null) {
				id=this.telaCadastroSubgrupo.getEditarSubgrupo().getId();
				
			}
			
			SubgrupoVO subgrupo=new SubgrupoVO(id,this.telaCadastroSubgrupo.getTextFieldNome().getText());
			
			Fachada fachada=new Fachada();
			
			String mensagemUsuario="Subgrupo cadastrado com sucesso!";
			
			if (id==0) {
				fachada.inserirSubgrupo(subgrupo);
				
			}else {
				fachada.alterarSubgrupo(subgrupo);
				mensagemUsuario="Subgrupo editado com sucesso!";
			}
			
			JOptionPane.showMessageDialog(this.telaCadastroSubgrupo, mensagemUsuario, "Informa"+(char)231+""+(char)227+"o", JOptionPane.INFORMATION_MESSAGE);
			
			this.telaCadastroSubgrupo.dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.telaCadastroSubgrupo, e.getMessage(), "Aten"+(char)231+""+(char)227+"o", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void verificarDados(String nome) throws Exception {
		String erro="";
		
		//validar nome do subgrupo
		if (nome.equals(""))
			erro+="Erro!!\nPor favor digite um nome v"+(char)225+"lido para o usu"+(char)225+"rio.";
		
		else if (nome.length()>45) 
			erro+="Erro!!\nVoc"+(char)234+" excedeu limite de caracteres para o nome do usu"+(char)225+"rio.";
		
		if (!erro.equals("")) {
			throw new Exception(erro);
			
		}
	}
}
