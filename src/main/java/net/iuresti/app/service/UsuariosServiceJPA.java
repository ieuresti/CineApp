package net.iuresti.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.iuresti.app.model.Usuario;
import net.iuresti.app.repository.UsuariosRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext
@Service
public class UsuariosServiceJPA implements IUsuariosService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private UsuariosRepository usuariosRepo;

	@Override
	public Usuario buscarPorId(int idUsuario) {
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuariosRepo.findAll();
	}
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public void eliminar(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

}
