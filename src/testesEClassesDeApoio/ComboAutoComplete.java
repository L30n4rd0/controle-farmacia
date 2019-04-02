package testesEClassesDeApoio;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JComboBox;


public class ComboAutoComplete extends JFrame { 

	private final String estados[] = {"PERNAMBUCO", "PARAIBA", "RIO GRANDE DO NORTE", "ACRE", "AMAP�", "BAHIA", "AMAZONAS",
			"CEAR�", "DISTRITO FEDERAL", "S�O PAULO","ESPIRITO SANTO", "GOI�S", "MARANH�O", "MATO GROSSO",
			"MINAS GERAIS", "MATO GROSSO DO SUL", "PARAN�", "PIAU�", "RIO DE JANEIRO", "SERGIPE", "TOCANTINS", "SANTA CATARINA",
			"RORAIMA", "ROND�NIA", "RIO GRANDE DO SUL", "ALAGOAS", "PAR�"};
	
	public ComboAutoComplete() {
		super("Exemplo");  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JComboBox comboBox = new JComboBox(estados);
        comboBox.setEditable(true);
        comboBox.setBounds(106, 49, 189, 20);
        getContentPane().add(comboBox);
        setSize(new Dimension(406, 199));  
        setLocationRelativeTo(null);    
        setVisible(true);
        
//        AutoCompletion combo = new AutoCompletion(comboBox);
        
        
        
	}
	
	public static void main(String[] args) {
		new ComboAutoComplete();
	}
}
