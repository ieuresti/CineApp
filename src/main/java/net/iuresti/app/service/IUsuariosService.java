package net.iuresti.app.service;

import java.util.List;

import net.iuresti.app.model.Usuario;

public interface IUsuariosService {
	
	Usuario buscarPorId(int idUsuario);
	
	List<Usuario> buscarTodos();
	
	void guardar(Usuario usuario);
	
	void eliminar(int idUsuario);

}
