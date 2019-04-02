package testesEClassesDeApoio;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class table extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	
	public table() {
		super("Exemplo Tabela");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,200);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		String columnNames[] = {"Nome", "Cor dos Olhos", "Sexo"};
		
		Object[][] data = {
				{"Bill", "Castanhos", "Masculino"},
				{"Maria", "Azuis", "Feminino"},
				{"Jose", "Verdes", "Masculino"},
				{"Joao", "Pretos", "Masculino"},
				{"Ricardo", "Mel", "Masculino"},
				{"Diego", "Verdes", "Masculino"},
				{"Leonardo", "Castanhos", "Masculino"},
				{"Rene", "Castanhos", "Masculino"},
				{"Luana", "Castanhos", "Feminino"},
				{"Susana", "Azuis", "Feminino"},
				{"Maria", "Pretos", "Feminino"},
				{"Edu", "Pretos", "Masculino"},
				
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);
		System.out.println(table.getRowSelectionAllowed());
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new table();
	}
}
