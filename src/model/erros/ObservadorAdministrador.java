package model.erros;

import java.util.ArrayList;

import model.vos.ErroVO;

public class ObservadorAdministrador extends Observador{
	private String nome, email;

	public ObservadorAdministrador(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	@Override
	protected void processarErro(ArrayList<ErroVO> erros) {
//		System.out.println("Enviar email para o administrador, quantidade de erros: "+erro.size());
		
		for (ErroVO erro : erros) {
			System.out.println(erro.getCodigoError());
			System.out.println(erro.getInformacoes());
			System.out.println(erro.getStatus());
			System.out.println(erro.getData()+"\n\n");
			
		}
	}

	protected String getNome() {
		return this.nome;
	}

	protected String getEmail() {
		return this.email;
	}

}
