package view.cadastro;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public abstract class TelaCadastro extends JDialog{
	
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	private final String estados[] = {"PE", "PB", "RN", "AC", "AP", "BA", "AM", "CE", "DF", "SP",
			"ES", "GO", "MA", "MT", "MG", "MS", "PA", "PI", "RJ", "SE", "TO", "SC", "RO", "RR", "RS", "AL", "PR"};
	
	public TelaCadastro() {
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setBounds(10, 69, 574, 392);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		add(panel);
		
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setModal(true);
		
		carregarView();
		
	}

	public String[] getEstados() {
		return this.estados;
	}
	
	protected abstract void carregarView();
	
}
