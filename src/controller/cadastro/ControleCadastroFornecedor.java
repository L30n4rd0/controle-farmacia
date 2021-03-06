package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import model.Fachada;
import model.vos.FornecedorVO;
import model.vos.UsuarioVO;

import view.cadastro.TelaCadastroFornecedor;
import view.cadastro.TelaCadastroUsuario;

public class ControleCadastroFornecedor implements ActionListener{
	private TelaCadastroFornecedor telaCadastroFornecedor;
	
	public ControleCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
		this.telaCadastroFornecedor=telaCadastroFornecedor;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			verificarDados(this.telaCadastroFornecedor.getTextFieldNome().getText(),
					this.telaCadastroFornecedor.getTextFieldCidade().getText(),
					this.telaCadastroFornecedor.getTextFieldCnpj().getText(),
					this.telaCadastroFornecedor.getTextFieldInscricao().getText());
			
			int id=0;
			
			if (this.telaCadastroFornecedor.getEditarFornecedor()!=null) {
				id=this.telaCadastroFornecedor.getEditarFornecedor().getId();
				
			}
			
			FornecedorVO fornecedor=new FornecedorVO(id,
					this.telaCadastroFornecedor.getTextFieldNome().getText(),
					this.telaCadastroFornecedor.getTextFieldCidade().getText(),
					this.telaCadastroFornecedor.getComboBoxUF().getSelectedItem().toString(),
					this.telaCadastroFornecedor.getTextFieldCnpj().getText(),
					this.telaCadastroFornecedor.getTextFieldInscricao().getText(),
					new Date(System.currentTimeMillis()));
			
			Fachada fachada=new Fachada();
			
			String mensagemUsuario="Fornecedor cadastrado com sucesso!";
			
			if (id==0) {
				fachada.inserirFornecedor(fornecedor);
				
			}else {
				fachada.alterarFornecedor(fornecedor);
				mensagemUsuario="Fornecedor editado com sucesso!";
			}
			
			JOptionPane.showMessageDialog(this.telaCadastroFornecedor, mensagemUsuario, "Informa"+(char)231+""+(char)227+"o", JOptionPane.INFORMATION_MESSAGE);
			
			this.telaCadastroFornecedor.dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.telaCadastroFornecedor, e.getMessage(), "Aten"+(char)231+""+(char)227+"o", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void verificarDados(String nome, String cidade, String cnpj, String inscricao) throws Exception {
		String erro="";
		
		//validar nome do fornecedor
		if (nome.equals(""))
			erro+="Erro!!\nPor favor digite um nome v"+(char)225+"lido para o fornecedor.";
		else if (nome.length()>45) 
			erro+="Erro!!\nVoc"+(char)234+" excedeu limite de caracteres para o nome do fornecedor.";
		
		//validar cidade
		if (cidade.equals("")){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nPor favor digite um nome v"+(char)225+"lido para a cidade.";
			
		}else if (cidade.length()>45){ 
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para a cidade do fornecedor.";
		}
		
		//validar cnpj
		if (cnpj.contains("_")) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite um cnpj v"+(char)225+"lido.";
		}
		
		//validar inscricao
		if (inscricao.equals("")){
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite uma inscri"+(char)231+""+(char)227+"o v"+(char)225+"lida.";
			
		}else if (inscricao.length()>45){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para a inscri"+(char)231+""+(char)227+"o do fornecedor.";
		}
		
		if (!erro.equals("")) {
			throw new Exception(erro);
			
		}
	}
	
}
