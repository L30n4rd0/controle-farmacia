package model.vos;

import java.sql.Date;

public class ErroVO {
	private int id, codigoErro;
	private Date data;
	private String informacoes, status;
	
	public ErroVO(int id, int codigoErro, Date data, String informacoes) {
		this.id = id;
		this.codigoErro = codigoErro;
		this.data = data;
		this.informacoes = informacoes;
		this.status="Aguardando solu"+(char)231+""+(char)227+"o";
	}

	public int getId() {
		return this.id;
	}

	public int getCodigoError() {
		return this.codigoErro;
	}

	public Date getData() {
		return this.data;
	}

	public String getInformacoes() {
		return this.informacoes;
	}

	public String getStatus() {
		return status;
	}

}
