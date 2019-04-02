package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import model.Fachada;
import model.vos.PsfVO;

import view.cadastro.TelaCadastroPosto;

public class ControleCadastroPSF implements ActionListener{
	private TelaCadastroPosto telaCadastroPSF;
	
	public ControleCadastroPSF(TelaCadastroPosto telaCadastroPSF) {
		this.telaCadastroPSF=telaCadastroPSF;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			
			verificarDados(this.telaCadastroPSF.getTextFieldNome().getText(),
					this.telaCadastroPSF.getTextFieldCidade().getText(),
					this.telaCadastroPSF.getTextFieldBairro().getText(),
					this.telaCadastroPSF.getTextFieldCEP().getText(),
					this.telaCadastroPSF.getTextFieldFone().getText());
			
			int id=0;
			
			if (this.telaCadastroPSF.getEditarPosto()!=null) {
				id=this.telaCadastroPSF.getEditarPosto().getId();
				
			}
			
			PsfVO psf=new PsfVO(id,
					this.telaCadastroPSF.getTextFieldNome().getText(),
					this.telaCadastroPSF.getTextFieldCidade().getText(),
					this.telaCadastroPSF.getTextFieldBairro().getText(),
					this.telaCadastroPSF.getComboBoxUF().getSelectedItem().toString(),
					this.telaCadastroPSF.getTextFieldCEP().getText(),
					this.telaCadastroPSF.getTextFieldFone().getText(),
					new Date(System.currentTimeMillis()));
			
			Fachada fachada=new Fachada();
			
			String mensagemUsuario="Posto de Sa"+(char)250+"de cadastrado com sucesso!";
			
			if (id==0) {
				fachada.inserirPSF(psf);
				
			}else {
				fachada.alterarPSF(psf);
				mensagemUsuario="Posto de Sa"+(char)250+"de editado com sucesso!";
			}
			
			JOptionPane.showMessageDialog(this.telaCadastroPSF, mensagemUsuario, "Informa"+(char)231+""+(char)227+"o", JOptionPane.INFORMATION_MESSAGE);
			
			this.telaCadastroPSF.dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.telaCadastroPSF, e.getMessage(), "Aten"+(char)231+""+(char)227+"o", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void verificarDados(String nome, String cidade, String bairro, String cep, String fone) throws Exception {
		String erro="";
		
		//validar nome do posto
		if (nome.equals(""))
			erro+="Erro!!\nPor favor digite um nome v"+(char)225+"lido para o posto de sa"+(char)250+"de.";
		
		else if (nome.length()>45)
			erro+="Erro!!\nVoc"+(char)234+" excedeu limite de caracteres para o nome do posto de sa"+(char)250+"de.";
		
		//validar cidade do posto
		if (cidade.equals("")){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nPor favor digite um nome v"+(char)225+"lido para a cidade.";
			
		}else if (cidade.length()>45){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para o nome da cidade.";
		}
		
		//validar bairro do posto
		if (bairro.equals("")) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite um nome v"+(char)225+"lido para bairro.";
			
		}else if (bairro.length()>45){
			if (erro.equals("")) erro="Erro!!";
		
			erro+="\nVoc"+(char)234+" excedeu limite de caracteres para o nome da bairro.";
		}
		
		//validar cep do posto
		if (cep.contains("_")) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite um CEP v"+(char)225+"lido.";
			
		}
		
		//validar fone do posto
		if (fone.contains("_")) {
			if (erro.equals("")) erro="Erro!!";
			
			erro+="\nPor favor digite um telefone v"+(char)225+"lido.";
			
		}
		
		if (!erro.equals("")) {
			throw new Exception(erro);
			
		}
	}
}
