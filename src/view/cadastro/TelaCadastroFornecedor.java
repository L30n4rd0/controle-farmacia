package view.cadastro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Arrays;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import view.AutoCompletion;

import controller.cadastro.ControleCadastroFornecedor;

import model.vos.FornecedorVO;

public class TelaCadastroFornecedor extends TelaCadastro{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNome, textFieldCnpj, textFieldInscricao, textFieldCidade;
	private JLabel lblInscricao, lblCidade, lblUf;
	private JComboBox comboBoxUF;
	private MaskFormatter maskCnpj;
	private FornecedorVO editarFornecedor;
	
	public TelaCadastroFornecedor(FornecedorVO editarFornecedor)  {
		
		this.editarFornecedor=editarFornecedor;
		
		if (this.editarFornecedor!=null) {
			this.textFieldNome.setText(editarFornecedor.getNome());
			this.textFieldCidade.setText(editarFornecedor.getCidade());
			this.textFieldCnpj.setText(editarFornecedor.getCnpj());
			this.textFieldInscricao.setText(editarFornecedor.getInscricao());
			this.comboBoxUF.setSelectedItem(editarFornecedor.getUf());
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(268, 302, 100, 34);
		this.panel.add(btnSalvar);
		
		btnSalvar.addActionListener(new ControleCadastroFornecedor(this));
		
		this.panel.repaint();
		setVisible(true);
	}
	
	public FornecedorVO getEditarFornecedor() {
		return this.editarFornecedor;
	}

	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}

	public JTextField getTextFieldCnpj() {
		return this.textFieldCnpj;
	}

	public JTextField getTextFieldInscricao() {
		return this.textFieldInscricao;
	}

	public JTextField getTextFieldCidade() {
		return this.textFieldCidade;
	}

	public JComboBox getComboBoxUF() {
		return this.comboBoxUF;
	}

	@Override
	protected void carregarView() {
		setTitle("Cadastro de Fornecedor");
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNome.setBounds(36, 43, 46, 20);
		this.panel.add(lblNome);
		
		this.textFieldNome = new JTextField();
		this.textFieldNome.setBounds(96, 37, 272, 28);
		this.panel.add(this.textFieldNome);
		this.textFieldNome.setColumns(10);
		
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCnpj.setBounds(36, 84, 46, 20);
		this.panel.add(lblCnpj);
		
		try {
			this.maskCnpj = new MaskFormatter("##.###.###/####-##");
			this.maskCnpj.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Erro ao criar MaskFormatter CNPJ!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		this.textFieldCnpj = new JFormattedTextField(maskCnpj);
		this.textFieldCnpj.setBounds(96, 77, 166, 28);
		this.panel.add(this.textFieldCnpj);
		this.textFieldCnpj.setColumns(10);
		
		this.lblInscricao = new JLabel("Inscri"+(char)231+""+(char)227+"o");
		this.lblInscricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
		this.lblInscricao.setBounds(16, 123, 66, 20);
		this.panel.add(this.lblInscricao);
		
		this.textFieldInscricao = new JTextField();
		this.textFieldInscricao.setBounds(96, 117, 166, 28);
		this.panel.add(this.textFieldInscricao);
		this.textFieldInscricao.setColumns(10);
		
		this.lblCidade = new JLabel("Cidade");
		this.lblCidade.setFont(new Font("SansSerif", Font.PLAIN, 14));
		this.lblCidade.setBounds(27, 167, 55, 20);
		this.panel.add(this.lblCidade);
		
		this.textFieldCidade = new JTextField();
		this.textFieldCidade.setBounds(96, 161, 203, 28);
		this.panel.add(this.textFieldCidade);
		this.textFieldCidade.setColumns(10);
		
		this.lblUf = new JLabel("UF");
		this.lblUf.setFont(new Font("SansSerif", Font.PLAIN, 14));
		this.lblUf.setBounds(54, 203, 28, 20);
		this.panel.add(this.lblUf);
		
		Arrays.sort(getEstados());
		this.comboBoxUF = new JComboBox(getEstados());
		this.comboBoxUF.setEditable(true);
		this.comboBoxUF.setBounds(96, 201, 55, 20);
		this.comboBoxUF.setSelectedItem(getEstados()[15]);
		this.panel.add(this.comboBoxUF);
		new AutoCompletion(this.comboBoxUF);
	}
}
