package model;

public class FabricaDAOSMysql extends FabricaDAOS{
	protected FabricaDAOSMysql() {}

	@Override
	protected EntradaDAO criarEntradaDAO() {
		return new EntradaDAOMysql();
	}

	@Override
	protected FornecedorDAO criarFornecedorDAO() {
		return new FornecedorDAOMysql();
	}

	@Override
	protected MaterialDAO criarMaterialDAO() {
		return new MaterialDAOMysql();
	}

	@Override
	protected PsfDAO criarPsfDAO() {
		return new PsfDAOMysql();
	}

	@Override
	protected SubgrupoDAO criarSubgrupoDAO() {
		return new SubgrupoDAOMysql();
	}

	@Override
	protected UsuarioDAO criarUsuarioDAO() {
		return new UsuarioDAOMysql();
	}

	@Override
	protected SaidaDAO criarSaidaDAO() {
		return new SaidaDAOMysql();
	}

	@Override
	protected ItemEntradaDAO criarItemEntradaDAO() {
		return new ItemEntradaDAOMysql();
	}

	@Override
	protected ErroDAO criarErroDAO() {
		return new ErroDAOMysql();
	}

}
