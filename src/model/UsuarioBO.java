package model;

import java.util.ArrayList;

import model.vos.UsuarioVO;


public class UsuarioBO {
	
	protected UsuarioBO() {
		// TODO Auto-generated constructor stub
	}
	protected void inserir(UsuarioVO usuario) throws Exception {
		
		UsuarioDAO usuarioDAO=FabricaDAOS.getFabricaDAOS().criarUsuarioDAO();
		
		ArrayList<UsuarioVO> usuarios=usuarioDAO.listar("idUsuario", "idUsuario", "");
		
		for (UsuarioVO usuarioVO : usuarios) {
			if (usuario.getLogin().equals(usuarioVO.getLogin()))
				throw new Exception("Login inv"+(char)225+"lido, j"+(char)225+" existe um usu"+(char)225+"rio utilizando este login!");
		}
		
		usuarioDAO.inserir(usuario);
	}
	
	protected void alterarUsuario(UsuarioVO usuario) throws Exception {
		FabricaDAOS fabricaDAOS=FabricaDAOS.getFabricaDAOS();
		
		UsuarioDAO usuarioDAO=fabricaDAOS.criarUsuarioDAO();
		
		usuarioDAO.alterar(usuario);
		
	}

}
