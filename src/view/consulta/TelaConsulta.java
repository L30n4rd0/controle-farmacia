package view.consulta;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.consulta.ControleVoltar;

import view.TelaInicial;

import java.awt.Font;

public abstract class TelaConsulta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldPesquisa;
	private JTable tabela;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPesquisa, comboBoxOrganiza;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JButton btnVoltar;
	private TelaInicial telaInicial;
	
	public TelaConsulta(TelaInicial telaInicial) {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		getContentPane().setBackground(new Color(153, 204, 225));
		
		this.telaInicial=telaInicial;
		
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		carregarComponentes();
		
		atualizarComboBox();
		
	}
	
	private void carregarComponentes() {
		JLabel lblPesquisarPor = new JLabel("Pesquisar por");
		lblPesquisarPor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		lblPesquisarPor.setBounds(10, 11, 110, 17);
		getContentPane().add(lblPesquisarPor);
		
		comboBoxPesquisa = new JComboBox();
		comboBoxPesquisa.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		comboBoxPesquisa.setBounds(132, 7, 167, 25);
		getContentPane().add(comboBoxPesquisa);
		
		textFieldPesquisa = new JTextField("");
		textFieldPesquisa.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		textFieldPesquisa.setBounds(311, 7, 481, 25);
		getContentPane().add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnEditar.setBounds(311, 32, 70, 27);
		getContentPane().add(btnEditar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnDeletar.setBounds(393, 32, 81, 27);
		getContentPane().add(btnDeletar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnVoltar.setBounds(486, 32, 81, 27);
		btnVoltar.addActionListener(new ControleVoltar(this));
		getContentPane().add(btnVoltar);
		
		JLabel lblOrganizarPor = new JLabel("Organizar por");
		lblOrganizarPor.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		lblOrganizarPor.setBounds(11, 36, 109, 17);
		getContentPane().add(lblOrganizarPor);
		
		comboBoxOrganiza = new JComboBox();
		comboBoxOrganiza.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		comboBoxOrganiza.setBounds(131, 32, 168, 25);
		getContentPane().add(comboBoxOrganiza);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(6, 60, 786, 505);
		
		getContentPane().add(scrollPane);
		
	}

	public JTable getTabela() {
		return this.tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTextField getTextFieldPesquisa() {
		return this.textFieldPesquisa;
	}

	public JComboBox getComboBoxPesquisa() {
		return this.comboBoxPesquisa;
	}

	public JButton getBtnEditar() {
		return this.btnEditar;
	}

	public JButton getBtnDeletar() {
		return this.btnDeletar;
	}

	public JButton getBtnVoltar() {
		return this.btnVoltar;
	}

	public JComboBox getComboBoxOrganiza() {
		return this.comboBoxOrganiza;
	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public TelaInicial getTelaInicial() {
		return this.telaInicial;
	}
	
	protected abstract void atualizarComboBox();

}
