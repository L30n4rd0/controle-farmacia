package model.vos;

import java.sql.Date;

public class FornecedorVO {
	private int id;
	private String nome, cidade, uf, cnpj, inscricao;
	private Date dataCadastro;
	
	public FornecedorVO(int id, String nome, String cidade, String uf, String cnpj, String inscricao, Date dataCadastro) {
		this.id=id;
		this.nome=nome;
		this.cidade=cidade;
		this.uf=uf;
		this.dataCadastro=dataCadastro;
		this.cnpj=cnpj;
		this.inscricao=inscricao;
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

	public String getUf() {
		return this.uf;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getInscricao() {
		return this.inscricao;
	}

}
