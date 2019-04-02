package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.telaInicial.ControleInicialMedicamento;
import controller.telaInicial.ControleInicialOdontologico;
import controller.telaInicial.ControleInicialPenso;
import controller.telaInicial.ControleMenuCadastroFornecedor;
import controller.telaInicial.ControleMenuCadastroPosto;
import controller.telaInicial.ControleMenuCadastroSubgrupo;
import controller.telaInicial.ControleMenuCadastroUsuario;
import controller.telaInicial.ControleMenuConsultaFornecedor;

import model.erros.ExcecaoSujeito;
import model.erros.ObservadorAdministrador;
import model.erros.ObservadorBanco;
import model.vos.UsuarioVO;

public class TelaInicial extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton botaoPenso, botaoMedicamentos, botaoOdontologico, botaoSair;
	private JLabel titulo;
	private Font fonteGeral;
	private JMenuBar barraMenus;
	private JMenu menuCadastro, menuConsulta;
	private JMenuItem menuItenCadasPosto, menuItenCadasFornecedor, menuItenCadasUsuario, menuItenCadasSubgrupo, menuItemConsultaUsuario, menuItemConsultaFornecedor, menuItemConsultaPosto, menuItemConsultaSubgrupo;
	private UsuarioVO usuarioLogado;

	public TelaInicial(UsuarioVO usuarioLogado) {
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		getContentPane().setBackground(new Color(153, 204, 225));
		setTitle("Tela Inicial");
		
		this.usuarioLogado=usuarioLogado;
		
		this.fonteGeral=new Font("DejaVu Sans", Font.BOLD, 14);
		
		CarregarMenu(this.usuarioLogado.getNivel());
		
		
		titulo = new JLabel("Materiais");
		titulo.setFont(new Font("comic sans", Font.BOLD, 26));
		titulo.setBounds(330, 60, 150, 80);
		add(titulo);
		
		botaoPenso = new JButton("Penso");
		botaoPenso.setBounds(100, 250, 150, 80);
		botaoPenso.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		botaoPenso.addActionListener(new ControleInicialPenso(this));
		add(botaoPenso);
		
		botaoMedicamentos = new JButton("Medicamentos");
		botaoMedicamentos.setBounds(320, 250, 150, 80);
		botaoMedicamentos.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		botaoMedicamentos.addActionListener(new ControleInicialMedicamento(this));
		add(botaoMedicamentos);
		
		botaoOdontologico = new JButton("Odontol"+(char)243+"gico");
		botaoOdontologico.setBounds(540, 250, 150, 80);
		botaoOdontologico.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		botaoOdontologico.addActionListener(new ControleInicialOdontologico(this));
		add(botaoOdontologico);
		
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}
	
	public UsuarioVO getUsuarioLogado() {
		return this.usuarioLogado;
	}

	private void CarregarMenu(String grupoUsuario){
		
		barraMenus=new JMenuBar();
		getContentPane().add(barraMenus).setBounds(0, 0, 800, 30);
		
		menuCadastro=new JMenu("Cadastro");
		menuCadastro.setFont(fonteGeral);
		barraMenus.add(menuCadastro);
		
		menuItenCadasPosto=new JMenuItem("PSF");
		menuItenCadasPosto.setFont(fonteGeral);
		menuItenCadasPosto.addActionListener(new ControleMenuCadastroPosto(this));
		this.menuCadastro.add(menuItenCadasPosto);
		
		menuItenCadasFornecedor=new JMenuItem("Fornecedor");
		menuItenCadasFornecedor.setFont(fonteGeral);
		menuItenCadasFornecedor.addActionListener(new ControleMenuCadastroFornecedor(this));
		menuCadastro.add(menuItenCadasFornecedor);
		
		menuItenCadasSubgrupo=new JMenuItem("Subgrupo");
		menuItenCadasSubgrupo.setFont(fonteGeral);
		menuItenCadasSubgrupo.addActionListener(new ControleMenuCadastroSubgrupo(this));
		menuCadastro.add(menuItenCadasSubgrupo);
		
		if (grupoUsuario.equalsIgnoreCase("Administrador")) {
			menuItenCadasUsuario=new JMenuItem("Usu"+(char)225+"rio");
			menuItenCadasUsuario.setFont(fonteGeral);
			menuItenCadasUsuario.addActionListener(new ControleMenuCadastroUsuario(this));
			menuCadastro.add(menuItenCadasUsuario);
		}
		
		menuConsulta=new JMenu("Consulta");
		menuConsulta.setFont(fonteGeral);
		barraMenus.add(menuConsulta);
		
		menuItemConsultaFornecedor=new JMenuItem("Fornecedor");
		menuItemConsultaFornecedor.setFont(fonteGeral);
		menuItemConsultaFornecedor.addActionListener(new ControleMenuConsultaFornecedor(this));
		this.menuConsulta.add(menuItemConsultaFornecedor);
		
		menuItemConsultaPosto=new JMenuItem("Posto");
		menuItemConsultaPosto.setFont(fonteGeral);
//		menuItemConsultaPosto.addActionListener(new tratadora());
		this.menuConsulta.add(menuItemConsultaPosto);
		
		menuItemConsultaUsuario=new JMenuItem("Usu"+(char)225+"rio");
		menuItemConsultaUsuario.setFont(fonteGeral);
//		menuItemConsultaUsuario.addActionListener(new tratadora());
		this.menuConsulta.add(menuItemConsultaUsuario);
		
		menuItemConsultaSubgrupo=new JMenuItem("Subgrupo");
		menuItemConsultaSubgrupo.setFont(fonteGeral);
//		menuItemConsultaSubgrupo.addActionListener(new tratadora());
		this.menuConsulta.add(menuItemConsultaSubgrupo);
		
		botaoSair=new JButton("Sair");
		botaoSair.setFont(fonteGeral);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		barraMenus.add(botaoSair);
		
	}
	
	public static void main(String[] args) {
		
		ExcecaoSujeito.adicionarObservador(new ObservadorBanco());
		ExcecaoSujeito.adicionarObservador(new ObservadorAdministrador("leo", "leo@lima"));
		
		new TelaInicial(new UsuarioVO(0, "leo", "leo", "lima", "Administrador"));
		
	}
}
