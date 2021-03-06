package model.vos;

import java.sql.Date;
import java.util.ArrayList;


public class EntradaVO {
	private int id, nota;
	private Date dataNota, dataRecebimento;
	private double total;
	private String observacoes;
	private FornecedorVO fornecedor;
	private UsuarioVO usuario;
	private ArrayList<ItemEntradaVO> itens;
	
	public EntradaVO(int id, int nota, Date dataNota, Date dataRecebimento, double total, String observacoes, FornecedorVO fornecedor, UsuarioVO usuario, ArrayList<ItemEntradaVO> itens) {
		this.id = id;
		this.nota = nota;
		this.dataNota = dataNota;
		this.dataRecebimento = dataRecebimento;
		this.total = total;
		this.observacoes = observacoes;
		this.fornecedor = fornecedor;
		this.usuario = usuario;
		this.itens = itens;
	}
	
	protected int getId() {
		return this.id;
	}
	protected int getNota() {
		return this.nota;
	}
	protected Date getDataNota() {
		return this.dataNota;
	}
	protected Date getDataRecebimento() {
		return this.dataRecebimento;
	}
	protected double getTotal() {
		return this.total;
	}
	protected String getObservacoes() {
		return this.observacoes;
	}
	protected FornecedorVO getFornecedor() {
		return this.fornecedor;
	}
	protected UsuarioVO getUsuario() {
		return this.usuario;
	}
	protected ArrayList<ItemEntradaVO> getItens() {
		return this.itens;
	}

}
