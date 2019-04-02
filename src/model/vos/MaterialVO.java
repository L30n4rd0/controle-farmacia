package model.vos;

import java.sql.Date;


public class MaterialVO {
	private int id;
	private double precoUnitario;
	private String descricao, apresentacao;
	private Date dataCadastro;
	private SubgrupoVO subgrupo;
	public MaterialVO(int id, double precoUnitario, String descricao, String apresentacao, Date dataCadastro, SubgrupoVO subgrupo) {
		this.id = id;
		this.precoUnitario = precoUnitario;
		this.descricao = descricao;
		this.apresentacao = apresentacao;
		this.dataCadastro = dataCadastro;
		this.subgrupo = subgrupo;
	}
	protected int getId() {
		return id;
	}
	protected double getPrecoUnitario() {
		return precoUnitario;
	}
	protected String getDescricao() {
		return descricao;
	}
	protected String getApresentacao() {
		return apresentacao;
	}
	protected Date getDataCadastro() {
		return dataCadastro;
	}
	protected SubgrupoVO getSubgrupo() {
		return subgrupo;
	}
	
	
	

}
