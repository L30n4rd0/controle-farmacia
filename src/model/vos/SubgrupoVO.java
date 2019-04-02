package model.vos;

public class SubgrupoVO {
	private int id;
	private String nome;
	
	public SubgrupoVO(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
