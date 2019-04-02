package view.cadastro;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.cadastro.ControleCadastroUsuario;

import model.vos.UsuarioVO;

public class TelaCadastroUsuario extends TelaCadastro{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNome, textFieldLogin;
	private JPasswordField fieldSenha, fieldConfirmarSenha;
	private JButton btnSalvar;
	private JComboBox comboBoxNivel;
	private UsuarioVO editarUsuario;
	
	public TelaCadastroUsuario(UsuarioVO editarUsuario) {
		
		this.editarUsuario=editarUsuario;
		
		if (this.editarUsuario!=null) {
			this.textFieldNome.setText(this.editarUsuario.getNome());
			this.textFieldLogin.setText(this.editarUsuario.getLogin());
			this.fieldSenha.setText("");
			this.fieldConfirmarSenha.setText("");
			this.comboBoxNivel.removeAllItems();
			this.comboBoxNivel.addItem(editarUsuario.getNivel().toString());
			
		}
		
		this.panel.repaint();
		setVisible(true);
		
	}
	
	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}
	
	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public JPasswordField getFieldSenha() {
		return fieldSenha;
	}

	public JPasswordField getFieldConfirmarSenha() {
		return fieldConfirmarSenha;
	}

	public JComboBox getComboBoxNivel() {
		return this.comboBoxNivel;
	}

	public UsuarioVO getEditarUsuario() {
		return this.editarUsuario;
	}

	@Override
	protected void carregarView() {
		this.panel.setBounds(37, 67, 517, 336);
		setTitle("Cadastro de Usu"+(char)225+"rio");
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(162, 78, 33, 24);
		this.panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(157, 121, 38, 14);
		this.panel.add(lblSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir senha");
		lblRepetirSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepetirSenha.setBounds(112, 162, 83, 14);
		this.panel.add(lblRepetirSenha);
		
		JLabel lblNvel = new JLabel("N\u00EDvel");
		lblNvel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNvel.setBounds(165, 200, 30, 14);
		this.panel.add(lblNvel);
		
		
		this.textFieldLogin = new JTextField();
		this.textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.textFieldLogin.setColumns(10);
		this.textFieldLogin.setBounds(207, 76, 132, 29);
		this.panel.add(this.textFieldLogin);
		
		this.fieldSenha = new JPasswordField();
		this.fieldSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.fieldSenha.setColumns(10);
		this.fieldSenha.setBounds(207, 114, 132, 29);
		this.panel.add(this.fieldSenha);
		
		this.fieldConfirmarSenha = new JPasswordField();
		this.fieldConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.fieldConfirmarSenha.setColumns(10);
		this.fieldConfirmarSenha.setBounds(207, 155, 132, 29);
		this.panel.add(this.fieldConfirmarSenha);
		
		this.comboBoxNivel = new JComboBox();
		this.comboBoxNivel.addItem("Limitado");
		this.comboBoxNivel.addItem("Administrador");
		this.comboBoxNivel.setBounds(207, 196, 132, 24);
		this.panel.add(this.comboBoxNivel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNome.setBounds(158, 41, 37, 14);
		this.panel.add(lblNome);
		
		this.textFieldNome = new JTextField();
		this.textFieldNome.setBounds(207, 35, 132, 29);
		this.panel.add(this.textFieldNome);
		this.textFieldNome.setColumns(10);
		
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(250, 280, 89, 23);
		this.panel.add(this.btnSalvar);
		this.btnSalvar.addActionListener(new ControleCadastroUsuario(this));
		
	}
	
}
