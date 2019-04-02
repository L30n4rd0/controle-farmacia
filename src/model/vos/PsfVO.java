package model.vos;

import java.sql.Date;

public class PsfVO {
	private int id;
	private String nome, cidade, bairro, uf, cep, fone;
	private Date dataCadastro;
	
	public PsfVO(int id, String nome, String cidade, String bairro, String uf,
			String cep, String fone, Date dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
		this.fone = fone;
		this.dataCadastro = dataCadastro;
	}
	
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCidade() {
		return this.cidade;
	}
	public String getBairro() {
		return this.bairro;
	}
	public String getUf() {
		return this.uf;
	}
	public String getCep() {
		return this.cep;
	}
	public String getFone() {
		return this.fone;
	}
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

}
