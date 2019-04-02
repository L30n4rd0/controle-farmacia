package controller.consulta;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Fachada;
import model.vos.FornecedorVO;

import view.consulta.TelaConsultaFornecedor;


public class ControlePesquisarFornecedor extends ControlePesquisar{
	
	private TelaConsultaFornecedor telaConsultaFornecedor;
	private ArrayList<FornecedorVO> fornecedores;
	
	public ControlePesquisarFornecedor(TelaConsultaFornecedor tela) {
		this.telaConsultaFornecedor=tela;
		atualizarTabela();
		
	}
	
	@Override
	protected void atualizarTabela() {
		
		Fachada fachada=new Fachada();
		
		String pesquisarColuna=this.telaConsultaFornecedor.getComboBoxPesquisa().getSelectedItem().toString(),
				organizarPor=this.telaConsultaFornecedor.getComboBoxOrganiza().getSelectedItem().toString(),
				texto=this.telaConsultaFornecedor.getTextFieldPesquisa().getText();
		
		if (pesquisarColuna.equals("Nome"))
			pesquisarColuna="nome";
			
		else if (pesquisarColuna.equals("ID"))
			pesquisarColuna="idFornecedor";
		
		else if (pesquisarColuna.equals("Cidade"))
			pesquisarColuna="cidade";
		
		else if (pesquisarColuna.equals("UF"))
			pesquisarColuna="uf";
		
		else if (pesquisarColuna.equals("CNPJ"))
			pesquisarColuna="cnpj";
		
		
		else if (pesquisarColuna.equals("Inscri"+(char)231+""+(char)227+"o"))
			pesquisarColuna="inscricao";
		
		else if (pesquisarColuna.equals("Data de Cadastro"))
			pesquisarColuna="dataCadastro";
//		********************************************
		if (organizarPor.equals("Nome"))
			organizarPor="nome";
			
		else if (organizarPor.equals("ID"))
			organizarPor="idFornecedor";
		
		else if (organizarPor.equals("Cidade"))
			organizarPor="cidade";
		
		else if (organizarPor.equals("UF"))
			organizarPor="uf";
		
		else if (organizarPor.equals("CNPJ"))
			organizarPor="cnpj";
		
		
		else if (organizarPor.equals("Inscri"+(char)231+""+(char)227+"o"))
			organizarPor="inscricao";
		
		else if (organizarPor.equals("Data de Cadastro"))
			organizarPor="dataCadastro";
		
		
		
		try {
			this.fornecedores=fachada.listarFornecedores(pesquisarColuna, organizarPor, texto);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.telaConsultaFornecedor, e.getMessage(), "Informa"+(char)231+""+(char)227+"o", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		String[] colunas=new String[7];
		DefaultTableModel modelo=null;
		
		colunas[0] = "ID";
		colunas[1] = "Nome";
		colunas[2] = "Cidade";
		colunas[3] = "UF";
		colunas[4] = "CNPJ";
		colunas[5] = "Inscri"+(char)231+""+(char)227+"o";
		colunas[6] = "Data Cadastro";
		
		modelo = new DefaultTableModel(new Object[][]{}, colunas);
		
		for (int i = 0; i < this.fornecedores.size(); i++) {
			FornecedorVO fornecedor = this.fornecedores.get(i);
			
			String linha[]= {""+fornecedor.getId(),
							""+fornecedor.getNome(),
							""+fornecedor.getCidade(),
							""+fornecedor.getUf(),
							""+fornecedor.getCnpj(),
							""+fornecedor.getInscricao(),
							""+fornecedor.getDataCadastro()};
			
			modelo.addRow(linha);
		}
		
		this.telaConsultaFornecedor.setTabela(new JTable(modelo));
		
		this.telaConsultaFornecedor.getTabela().setFillsViewportHeight(true);
		this.telaConsultaFornecedor.getTabela().setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
//		this.telaConsultaFornecedor.getTabela().getTableHeader().setReorderingAllowed(true);
		this.telaConsultaFornecedor.getTabela().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.telaConsultaFornecedor.getTabela().getTableHeader().setReorderingAllowed(false);//NAO PERMITE A REORDENACAO DAS COLUNAS
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(0).setPreferredWidth(50);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(1).setPreferredWidth(230);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(2).setPreferredWidth(190);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(3).setPreferredWidth(30);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(4).setPreferredWidth(170);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(5).setPreferredWidth(120);
		this.telaConsultaFornecedor.getTabela().getColumnModel().getColumn(6).setPreferredWidth(110);
		
		
		
		try {
			this.telaConsultaFornecedor.remove(this.telaConsultaFornecedor.getScrollPane());
			
		} catch (Exception e) {}
		
		this.telaConsultaFornecedor.getScrollPane().setViewportView(this.telaConsultaFornecedor.getTabela());
		this.telaConsultaFornecedor.getScrollPane().repaint();
		this.telaConsultaFornecedor.add(this.telaConsultaFornecedor.getScrollPane());
		
	}

}
