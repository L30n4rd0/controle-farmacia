package model;

import java.util.ArrayList;

import model.vos.ErroVO;
import model.vos.FornecedorVO;
import model.vos.PsfVO;
import model.vos.SubgrupoVO;
import model.vos.UsuarioVO;

public class Fachada {
	
	private EntradaBO entradaBO=null;
	private ErroBO erroBO=null;
	private FornecedorBO fornecedorBO=null;
	private ItemEntradaBO itemEntradaBO=null;
	private MaterialBO materialBO=null;
	private PsfBO psfBO=null;
	private SaidaBO saidaBO=null;
	private SubgrupoBO subgrupoBO=null;
	private UsuarioBO usuarioBO=null;
	
	
	public void inserirUsuario(UsuarioVO usuario) throws Exception {
		getUsuarioBO().inserir(usuario);
		
	}
	
	public void alterarUsuario(UsuarioVO usuario) throws Exception {
		getUsuarioBO().alterarUsuario(usuario);
		
	}
	
	
	
	public void inserirFornecedor(FornecedorVO fornecedor) throws Exception {
		getFornecedorBO().inserir(fornecedor);
		
	}
	
	public void alterarFornecedor(FornecedorVO fornecedor)throws Exception {
		getFornecedorBO().inserir(fornecedor);
		
	}
	
	public ArrayList<FornecedorVO> listarFornecedores(String coluna, String organizarPor, String texto) throws Exception {
		
		return getFornecedorBO().listar(coluna, organizarPor, texto);
		
	}
	
	public void excluirFornecedor(int id, String nome) throws Exception {
		
		getFornecedorBO().excluir(id, nome);
		
		
	}
	
	
	public void inserirPSF(PsfVO psf) throws Exception {
		getPsfBO().inserir(psf);
		
	}
	
	public void alterarPSF(PsfVO psf) throws Exception {
		getPsfBO().alterar(psf);
		
	}
	
	
	
	public void inserirErro(ArrayList<ErroVO> erros) throws Exception {
		getErroBO().inserir(erros);
		
	}
	
	
	public void inserirSubgrupo(SubgrupoVO subgrupo) throws Exception {
		getSubgrupoBO().inserir(subgrupo);
		
	}
	
	public void alterarSubgrupo(SubgrupoVO subgrupo) throws Exception {
		getSubgrupoBO().alterar(subgrupo);
		
	}
	

	private EntradaBO getEntradaBO() {
		if (this.entradaBO==null) {
			this.entradaBO=new EntradaBO();
			
		}
		
		return this.entradaBO;
	}

	private ErroBO getErroBO() {
		if (this.erroBO==null) {
			this.erroBO=new ErroBO();
			
		}
		
		return this.erroBO;
	}

	private FornecedorBO getFornecedorBO() {
		if (this.fornecedorBO==null) {
			this.fornecedorBO=new FornecedorBO();
			
		}
		
		return this.fornecedorBO;
	}

	private ItemEntradaBO getItemEntradaBO() {
		if (this.itemEntradaBO==null) {
			this.itemEntradaBO=new ItemEntradaBO();
			
		}
		
		return this.itemEntradaBO;
	}

	private MaterialBO getMaterialBO() {
		if (this.materialBO==null) {
			this.materialBO=new MaterialBO();
			
		}
		
		return this.materialBO;
	}

	private PsfBO getPsfBO() {
		if (this.psfBO==null) {
			this.psfBO=new PsfBO();
			
		}
		
		return this.psfBO;
	}

	private SaidaBO getSaidaBO() {
		if (this.saidaBO==null) {
			this.saidaBO=new SaidaBO();
			
		}
		
		return this.saidaBO;
	}

	private SubgrupoBO getSubgrupoBO() {
		if (this.subgrupoBO==null) {
			this.subgrupoBO=new SubgrupoBO();
			
		}
		
		return this.subgrupoBO;
	}

	private UsuarioBO getUsuarioBO() {
		if (this.usuarioBO==null) {
			this.usuarioBO=new UsuarioBO();
			
		}
		
		return this.usuarioBO;
	}
}
