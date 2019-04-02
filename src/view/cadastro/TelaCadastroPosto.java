package view.cadastro;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;
import java.util.Arrays;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import controller.cadastro.ControleCadastroPSF;

import model.vos.PsfVO;

public class TelaCadastroPosto extends TelaCadastro{
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome, textFieldCidade, textFieldBairro, textFieldCEP, textFieldFone;
	private MaskFormatter mascaraCep, mascaraFone;
	private JComboBox <String> comboBoxUF;
	private PsfVO editarPosto;
	
	public TelaCadastroPosto(PsfVO editarPosto) {
		
		this.editarPosto=editarPosto;
		
		if (this.editarPosto!=null) {
			this.textFieldNome.setText(this.editarPosto.getNome());
			this.textFieldCEP.setText(this.editarPosto.getCep());
			this.textFieldBairro.setText(this.editarPosto.getBairro());
			this.textFieldCidade.setText(this.editarPosto.getCidade());
			this.textFieldFone.setText(this.editarPosto.getFone());
			this.comboBoxUF.setSelectedItem(this.editarPosto.getUf());
			
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(268, 302, 100, 34);
		btnSalvar.addActionListener(new ControleCadastroPSF(this));
		
		panel.add(btnSalvar);
		
		panel.repaint();
		setVisible(true);
		
	}
	

	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}

	public JTextField getTextFieldCidade() {
		return this.textFieldCidade;
	}

	public JTextField getTextFieldBairro() {
		return this.textFieldBairro;
	}

	public JTextField getTextFieldCEP() {
		return this.textFieldCEP;
	}

	public JTextField getTextFieldFone() {
		return this.textFieldFone;
	}

	public JComboBox<String> getComboBoxUF() {
		return this.comboBoxUF;
	}

	public PsfVO getEditarPosto() {
		return this.editarPosto;
	}

	@Override
	protected void carregarView() {
		this.setTitle("Cadastro de Posto de Sa"+(char)250+"de");
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(38, 38, 49, 20);
		this.panel.add(lblNome);
		
		this.textFieldNome = new JTextField();
		this.textFieldNome.setBounds(99, 33, 262, 28);
		this.textFieldNome.setColumns(10);
		this.panel.add(this.textFieldNome);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCidade.setBounds(33, 77, 54, 20);
		this.panel.add(lblCidade);
		
		this.textFieldCidade = new JTextField();
		this.textFieldCidade.setBounds(99, 72, 196, 28);
		this.textFieldCidade.setColumns(10);
		this.panel.add(this.textFieldCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBairro.setBounds(38, 116, 49, 20);
		this.panel.add(lblBairro);
		
		this.textFieldBairro = new JTextField();
		this.textFieldBairro.setBounds(99, 111, 149, 28);
		this.textFieldBairro.setColumns(10);
		this.panel.add(this.textFieldBairro);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUf.setBounds(61, 155, 26, 20);
		this.panel.add(lblUf);
		
		Arrays.sort(getEstados());
		this.comboBoxUF = new JComboBox<String>(getEstados());
//		comboBoxUF = new JComboBox(getEstados());
		this.comboBoxUF.setBounds(99, 155, 54, 20);
		this.comboBoxUF.setSelectedItem(getEstados()[15]);
		this.panel.add(this.comboBoxUF);
		
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(46, 191, 28, 20);
		this.panel.add(lblCep);
		
		try {
			
			this.mascaraCep = new MaskFormatter("#####-###");
			this.mascaraCep.setPlaceholderCharacter('_');
			this.textFieldCEP = new JFormattedTextField(this.mascaraCep);
			this.textFieldCEP.setBounds(99, 186, 86, 28);
			this.textFieldCEP.setColumns(10);
			this.panel.add(this.textFieldCEP);
			
		} catch (ParseException e) {e.printStackTrace();}
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFone.setBounds(43, 230, 44, 20);
		this.panel.add(lblFone);
		
		try {
			
			this.mascaraFone = new MaskFormatter("(##)####-####");
			this.mascaraFone.setPlaceholderCharacter('_');
			this.textFieldFone = new JFormattedTextField(this.mascaraFone);
			this.textFieldFone.setBounds(99, 225, 112, 28);
			this.textFieldFone.setColumns(10);
			this.panel.add(this.textFieldFone);
			
		} catch (ParseException e) {e.printStackTrace();}
		
	}
}
