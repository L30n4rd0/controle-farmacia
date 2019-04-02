package view.cadastro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.cadastro.ControleCadastroSubgrupo;

import model.vos.SubgrupoVO;

public class TelaCadastroSubgrupo extends TelaCadastro{
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNome;
	private SubgrupoVO editarSubgrupo;
	
	public TelaCadastroSubgrupo(SubgrupoVO editarSubgrupo) {
		
		
		this.editarSubgrupo=editarSubgrupo;
		
		if (this.editarSubgrupo!=null) {
			textFieldNome.setText(editarSubgrupo.getNome());
			
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(100, 175, 117, 39);
		btnSalvar.addActionListener(new ControleCadastroSubgrupo(this));
		panel.add(btnSalvar);
		
		setSize(350, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JTextField getTextFieldNome() {
		return this.textFieldNome;
	}

	public SubgrupoVO getEditarSubgrupo() {
		return this.editarSubgrupo;
	}


	@Override
	protected void carregarView() {
		setTitle("Cadastro de Subgrupo");
		panel.setBounds(20, 20, 310, 260);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(6, 50, 70, 25);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(60, 48, 244, 25);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
	}
}
