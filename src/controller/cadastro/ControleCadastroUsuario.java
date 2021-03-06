package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Fachada;
import model.vos.UsuarioVO;

import view.cadastro.TelaCadastroUsuario;

public class ControleCadastroUsuario implements ActionListener{
	private TelaCadastroUsuario telaCadastroUsuario;
	
	public ControleCadastroUsuario(TelaCadastroUsuario telaCadastroUsuario) {
		this.telaCadastroUsuario=telaCadastroUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			verificarDados(this.telaCadastroUsuario.getTextFieldNome().getText(),
					this.telaCadastroUsuario.getTextFieldLogin().getText(),
					this.telaCadastroUsuario.getFieldSenha().getText(),
					this.telaCadastroUsuario.getFieldConfirmarSenha().getText());
			
			int id=0;
			
			if (this.telaCadastroUsuario.getEditarUsuario()!=null) {
				id=this.telaCadastroUsuario.getEditarUsuario().getId();
				
			}
			
			UsuarioVO usuario=new UsuarioVO(id,
					this.telaCadastroUsuario.getTextFieldNome().getText(),
					this.telaCadastroUsuario.getTextFieldLogin().getText(),
					this.telaCadastroUsuario.getFieldSenha().getText(),
					this.telaCadastroUsuario.getComboBoxNivel().getSelectedItem().toString());
			
			Fachada fachada=new Fachada();
			
			String mensagemUsuario="Usu"+(char)225+"rio cadastrado com sucesso!";
			
			if (id==0) {
				fachada.inserirUsuario(usuario);
				
			}else {
				fachada.alterarUsuario(usuario);
				mensagemUsuario="Usu"+(char)225+"rio editado com sucesso!";
			}
			
			JOptionPane.showMessageDialog(this.telaCadastroUsuario, mensagemUsuario, "Informa"+(char)231+""+(char)227+"o", JOptionPane.INFORMATION_MESSAGE);
			
			this.telaCadastroUsuario.dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.telaCadastroUsuario, e.getMessage(), "Aten"+(char)231+""+(char)227+"o", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void verificarDados(String nome, String login, String senha, String confirmarSenha) throws Exception {
		String erro="";
		
		//validar nome do usuario
		if (nome.equals(""))
			erro+="Erro!!\nPor favor digite um nome v"+(char)225+"lido para o usu"+(char)225+"rio.";
		
		else if (nome.length()>45) 
			erro+="Erro!!\nVoc"+(char)234+" excedeu limite de caracteres para o nome do usu"+(char)225+"rio.";
		
		//validar login do usuario 
		if (login.equals("")){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nPor favor digite um nome v"+(char)225+"lido para o login.";
			
		}else if (login.length()>45) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para o login.";
		}
		
		//validar senha do usuario
		if (senha.equals("")) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite uma senha v"+(char)225+"lida.";
			
		}else if (senha.length()>45) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para a senha.";
			
		}else if (!senha.equals(confirmarSenha)) {
			if (erro.equals("")) erro="Erro!!";
			erro+="\nAs senhas n"+(char)227+"o conferem";
			
		}
		
		
		if (!erro.equals("")) {
			throw new Exception(erro);
			
		}
	}
}
