package view.consulta;

import controller.consulta.ControleDeletarFornecedor;
import controller.consulta.ControleEditarFornecedor;
import controller.consulta.ControleOrganizarFornecedor;
import controller.consulta.ControlePesquisarFornecedor;

import view.TelaInicial;

public class TelaConsultaFornecedor extends TelaConsulta{
	private static final long serialVersionUID = 1L;
	
	public TelaConsultaFornecedor(TelaInicial telaInicial) {
		super(telaInicial);
		
		setTitle("Consultar Fornecedor");
		
		getTextFieldPesquisa().addKeyListener(new ControlePesquisarFornecedor(this));
		getComboBoxOrganiza().addActionListener(new ControleOrganizarFornecedor(this));
		getBtnDeletar().addActionListener(new ControleDeletarFornecedor(this));
		getBtnEditar().addActionListener(new ControleEditarFornecedor(this));
		
//		atualizaTabela(getComboBoxPesquisa().getSelectedItem().toString(), getComboBoxOrganiza().getSelectedItem().toString(), getTextFieldPesquisa().getText());
		
		setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void atualizarComboBox() {
		
		getComboBoxPesquisa().addItem("Nome");
		getComboBoxPesquisa().addItem("ID");
		getComboBoxPesquisa().addItem("Cidade");
		getComboBoxPesquisa().addItem("UF");
		getComboBoxPesquisa().addItem("CNPJ");
		getComboBoxPesquisa().addItem("Inscri"+(char)231+""+(char)227+"o");
		getComboBoxPesquisa().addItem("Data de Cadastro");
		
		getComboBoxOrganiza().addItem("ID");
		getComboBoxOrganiza().addItem("Nome");
		getComboBoxOrganiza().addItem("Cidade");
		getComboBoxOrganiza().addItem("UF");
		getComboBoxOrganiza().addItem("CNPJ");
		getComboBoxOrganiza().addItem("Inscri"+(char)231+""+(char)227+"o");
		getComboBoxOrganiza().addItem("Data de Cadastro");
		
	}

	
}
