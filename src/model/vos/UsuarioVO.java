package model.vos;

public class UsuarioVO {
	private String nome, login, senha, nivel;
	private int id;
	
	public UsuarioVO(int id, String nome, String login, String senha, String nivel) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.nivel = nivel;
	}

	public String getNome() {
		return this.nome;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

	public String getNivel() {
		return this.nivel;
	}

	public int getId() {
		return this.id;
	}

}
