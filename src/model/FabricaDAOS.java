package model;

import java.io.File;
import java.util.ArrayList;

public abstract class FabricaDAOS {
	protected FabricaDAOS() {
		// TODO Auto-generated constructor stub
	}
	
	protected static FabricaDAOS instancia=null;
	
	protected static synchronized FabricaDAOS getFabricaDAOS() throws Exception {
		if (instancia==null) {
			
			if (bancoTipoMysql())
				instancia=new FabricaDAOSMysql();
			else
				instancia=new FabricaDAOSOracle();
			
		}
		
		return instancia;
	}
	
	private static boolean bancoTipoMysql() throws Exception {
		boolean retorno=true;
		
		if (!new File("config.txt").exists()) {
			ArrayList<String>conteudoArq=new ArrayList<String>();
			
			conteudoArq.add("Arquivo de configuracao");
			conteudoArq.add("tipoBanco:mysql");
			
			AdmArquivos.salvarArquivo(conteudoArq, "config.txt");
		}
		
		ArrayList<String>conteudoArq=AdmArquivos.lerArquivo("config.txt");
		
		for (String string : conteudoArq) {
			if (string.contains("tipoBanco")) {
				if (string.substring(10, string.length()).equals("oracle")) {
					retorno=false;
					
				}
				break;
			}
		}
		
		return retorno;
	}
	
	protected abstract EntradaDAO criarEntradaDAO();
	protected abstract FornecedorDAO criarFornecedorDAO();
	protected abstract MaterialDAO criarMaterialDAO();
	protected abstract PsfDAO criarPsfDAO();
	protected abstract SubgrupoDAO criarSubgrupoDAO();
	protected abstract UsuarioDAO criarUsuarioDAO();
	protected abstract SaidaDAO criarSaidaDAO();
	protected abstract ItemEntradaDAO criarItemEntradaDAO();
	protected abstract ErroDAO criarErroDAO();
	
}
