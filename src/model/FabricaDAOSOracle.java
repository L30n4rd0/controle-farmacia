package model;

public class FabricaDAOSOracle extends FabricaDAOS{
	
	protected FabricaDAOSOracle() {}

	@Override
	protected EntradaDAO criarEntradaDAO() {
		return new EntradaDAOOracle();
	}

	@Override
	protected FornecedorDAO criarFornecedorDAO() {
		return new FornecedorDAOOracle();
	}

	@Override
	protected MaterialDAO criarMaterialDAO() {
		return new MaterialDAOOracle();
	}

	@Override
	protected PsfDAO criarPsfDAO() {
		return new PsfDAOOracle();
	}

	@Override
	protected SubgrupoDAO criarSubgrupoDAO() {
		return new SubgrupoDAOOracle();
	}

	@Override
	protected UsuarioDAO criarUsuarioDAO() {
		return new UsuarioDAOOracle();
	}

	@Override
	protected SaidaDAO criarSaidaDAO() {
		return new SaidaDAOOracle();
	}

	@Override
	protected ItemEntradaDAO criarItemEntradaDAO() {
		return new ItemEntradaDAOOracle();
	}

	@Override
	protected ErroDAO criarErroDAO() {
 		return null;
	}

}
