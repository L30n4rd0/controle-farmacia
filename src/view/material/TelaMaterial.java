package view.material;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.vos.UsuarioVO;

import java.awt.Color;
import java.awt.Font;

public class TelaMaterial extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String grupoMaterial;
	private UsuarioVO userLogado;
	private JDesktopPane panel = null;
	private JButton btnCadastrar, btnConsultar, btnRegistrarEntrada, btnRegistrarSaida, btnVoltar;
	
	public TelaMaterial(String grupoMaterial, UsuarioVO userLogado) {
		super("Controle "+grupoMaterial);
		
		UIManager.put("DesktopPaneUI","javax.swing.plaf.basic.BasicDesktopPaneUI");
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		getContentPane().setBackground(new Color(153, 204, 225));
		
		this.grupoMaterial = grupoMaterial;
		this.userLogado=userLogado;
		
		panel = new JDesktopPane();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 39, 782, 526); // RECENTE
		panel.setLayout(null);
		getContentPane().add(panel);
		
		btnCadastrar = new JButton("Cadastrar "+grupoMaterial);
		btnCadastrar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnCadastrar.setBounds(10, 0, 198, 27);
		getContentPane().add(btnCadastrar);
		
		btnConsultar = new JButton("Consultar "+grupoMaterial);
		btnConsultar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnConsultar.setBounds(215, 0, 196, 27);
		getContentPane().add(btnConsultar);
		
		btnRegistrarEntrada = new JButton("Registrar Entrada");
		btnRegistrarEntrada.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnRegistrarEntrada.setBounds(418, 0, 154, 27);
		getContentPane().add(btnRegistrarEntrada);
		
		btnRegistrarSaida = new JButton("Registrar Sa"+(char)237+"da");
		btnRegistrarSaida.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnRegistrarSaida.setBounds(579, 0, 138, 27);
		getContentPane().add(btnRegistrarSaida);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnVoltar.setBounds(724, 0, 71, 27);
		getContentPane().add(btnVoltar);
	
		btnRegistrarEntrada.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Registrar entrada de "+getGrupoMaterial());
				
				getContentPane().remove(panel);
//				setPanel(new PanelEntradaSaida(getGrupoMaterial(), getUsuarioLogado(), "Entrada"));
				panel.setLocation(10, 39);
				getContentPane().add(panel);
				getContentPane().repaint();
				
			}
		});

		
		btnRegistrarSaida.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				setTitle("Registrar Sa"+(char)237+"da de "+getGrupoMaterial());
				
				getContentPane().remove(panel);
//				setPanel(new PanelEntradaSaida(getGrupoMaterial(), getUsuarioLogado(), "Sa"+(char)237+"da"));
				panel.setLocation(10, 39);
				getContentPane().add(panel);
				getContentPane().repaint();
				
			}
		});

		
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Cadastrar "+getGrupoMaterial());
				
				getContentPane().remove(panel);
//				setPanel(new PanelCadastroMaterial(getGrupoMaterial(), getUsuarioLogado()));
				panel.setLocation(10, 39);
				getContentPane().add(panel);
				getContentPane().repaint();
				
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setTitle("Consultar "+getGrupoMaterial());
				
				getContentPane().remove(panel);
//				setPanel(new PanelConsultaMaterial(getGrupoMaterial(), getUsuarioLogado()));
				panel.setLocation(10, 39);
				getContentPane().add(panel);
				getContentPane().repaint();
			
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new TelaInicial(getUsuarioLogado());
				dispose();
				
			}
		});
		
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public String getGrupoMaterial() {
		return grupoMaterial;
	}
	
	public UsuarioVO getUsuarioLogado() {
		return userLogado;
	}
	public void setPanel(JDesktopPane panel) {
		this.panel = panel;
	}
}
