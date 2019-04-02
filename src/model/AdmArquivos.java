package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdmArquivos {
	
	protected AdmArquivos() {
		// TODO Auto-generated constructor stub
	}
	
	protected static ArrayList<String> lerArquivo(String endereco) throws Exception{
		ArrayList<String> conteudoArquivo = new ArrayList <String>();
		
		try {
			BufferedReader ler = new BufferedReader(new FileReader(endereco));
				
			while(ler.ready()){
				conteudoArquivo.add(ler.readLine());
				
			}
			ler.close();
				
		}catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Erro na leitura do arquivo!");
		}			
		
		return conteudoArquivo;
	}
	
	protected static void salvarArquivo(ArrayList<String> conteudoArquivo, String endereco) throws Exception{
		
//		try {
			BufferedWriter gravar=new BufferedWriter(new FileWriter(endereco));
			
			for (int i = 0; i < conteudoArquivo.size(); i++) {
				gravar.write(conteudoArquivo.get(i));
				gravar.newLine();
				
			}
			
			gravar.flush();
			gravar.close();
			
//		} catch (IOException e) {
//			e.printStackTrace();
////			throw new Exception("Erro ao salvar no arquivo!");
//		}
	}
}
