package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import model.vos.ErroVO;

public class ErroDAOArquivo extends ErroDAO{
	
	protected ErroDAOArquivo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void inserir(ArrayList<ErroVO> erros) throws Exception {
//		=new File(new File(System.getProperty("java.class.path")).getParent()+File.separator+"audiosPalavras");
		
		try {
			File file=new File("erros");
			
			if (!file.isDirectory())
				file.mkdir();
			
			ArrayList<String>conteudoArq=new ArrayList<String>();
			
			for (ErroVO erro : erros) {
				
				conteudoArq.add("Codigo do erro: "+erro.getCodigoError());
				
				conteudoArq.add("Data de ocorr"+(char)234+"ncia: "+erro.getData());
				
				conteudoArq.add("Outras informa"+(char)231+""+(char)245+"es: \n"+erro.getInformacoes()+"\n\n");
				
			}
			
			AdmArquivos.salvarArquivo(conteudoArq, "erros"+File.separator+"erro-"+new Date(System.currentTimeMillis())+".txt");
			
		} catch (Exception excecao) {
			
			String informacoesErro="\nLocalizedMessage: "+excecao.getLocalizedMessage()+
					"\nSQLExceptionMessage:"+excecao.getMessage()+
					"\nCause: "+excecao.getCause()+
					"\nClass: "+excecao.getClass()+
					"\nStackTrace: "+excecao.getStackTrace()+
					"\nSuppressed: "+excecao.getSuppressed();
			
			erros.add(new ErroVO(0, 0, new java.sql.Date(System.currentTimeMillis()), informacoesErro));
			
			throw new Exception("Erro ao salvar o arquivo com detalhes na pasta erros!\nEntre em contato com o administrador do sistema!");
		}
		
	}

	@Override
	protected void excluir(int id) throws Exception {
		
	}

	@Override
	protected void alterar(ErroVO erro) throws Exception {
		
	}

	@Override
	protected ArrayList<ErroVO> listar(String coluna, String organizarPor,
			String texto) throws Exception {
		return null;
	}
	


}
