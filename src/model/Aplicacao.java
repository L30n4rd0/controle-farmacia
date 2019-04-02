package model;

import javax.swing.JOptionPane;

import model.erros.ExcecaoSujeito;
import model.erros.ObservadorAdministrador;
import model.erros.ObservadorBanco;
import model.vos.FornecedorVO;
import model.vos.SubgrupoVO;

public class Aplicacao {
	public static void main(String[] args) {
		
		try {
			
			ExcecaoSujeito.adicionarObservador(new ObservadorBanco());
			ExcecaoSujeito.adicionarObservador(new ObservadorAdministrador("Leonardo", "leonardo@souza.com"));
			
//			FornecedorVO fornecedor=new FornecedorVO(0, "Leonardo", "serra talhada", "pe", "dfsdfdsf345435", "3432435345", null);
			SubgrupoVO sub=new SubgrupoVO(0, "Tratamento de Tracoma");
			
			FabricaDAOS.getFabricaDAOS().criarSubgrupoDAO().inserir(sub);
			
			
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
