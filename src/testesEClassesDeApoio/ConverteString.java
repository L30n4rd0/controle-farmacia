package testesEClassesDeApoio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ConverteString extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField areaEntrada, areaSaida;
	private JLabel labelEntrada, labelSaida;
	
	public ConverteString() {
		super("Converte String");
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.labelEntrada=new JLabel("Entre com uma String abaixo para converter");
		add(labelEntrada).setBounds(10, 10, 400, 30);
		
		this.areaEntrada=new JTextField();
		this.areaEntrada.setEditable(true);
		
		this.areaEntrada.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {conversor();}
			public void keyPressed(KeyEvent e) {}
		});
		add(areaEntrada).setBounds(10, 40, 480, 30);
		
		this.labelSaida=new JLabel("Resultado da conver"+(char)231+""+(char)227+"o");
		add(labelSaida).setBounds(10, 80, 220, 30);
		
		this.areaSaida=new JTextField();
		add(areaSaida).setBounds(10, 110, 480, 30);
		
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void conversor() {
		String entrada=areaEntrada.getText(), saida="";
		
		for (int i = 0; i < entrada.length(); i++) {
			
			if((int)entrada.charAt(i)>126){
				if (i==0) {
					if (entrada.length()==1) saida+="(char)"+(int)entrada.charAt(i);
					
					else saida+="(char)"+(int)entrada.charAt(i)+"+"+(char)34+(char)34+"+";
					
				}
				else if (i==entrada.length()-1) saida+="(char)"+(int)entrada.charAt(i);
				
				else saida+="(char)"+(int)entrada.charAt(i)+"+"+(char)34+(char)34+"+";
				
			}else {
				
				if (i==0) {
					if (entrada.length()==1) saida+=(char)34+""+entrada.charAt(i)+""+(char)34;
					
					else saida+=(char)34+""+entrada.charAt(i)+""+(char)34+"+";
					
				}
				
				else if (saida.substring(saida.length()-2, saida.length()).equals((char)34+"+")) {
					
					if (i==entrada.length()-1) {
						saida=saida.substring(0, saida.length()-2)+entrada.charAt(i)+(char)34;
					
					}else {
						saida=saida.substring(0, saida.length()-2)+entrada.charAt(i)+(char)34+"+";
					}
					
				}
				else if (!saida.substring(saida.length()-3, saida.length()).equals((char)34+"+")) {
					
					if (i==entrada.length()-1) {
						saida+=(char)34+""+entrada.charAt(i)+""+(char)34;
					
					}else {
						saida+=(char)34+""+entrada.charAt(i)+""+(char)34+"+";
						
					}
				}
			}
		}
		
		this.areaSaida.setText(saida);
	}
	
	
	
	public static void main(String[] args) {
		new ConverteString();
		
	}
}

