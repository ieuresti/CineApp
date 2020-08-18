package net.iuresti.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.iuresti.app.model.Perfil;
import net.iuresti.app.repository.PerfilesRepository;

//Registramos esta clase como un Bean en nuestro Root ApplicationContext
@Service
public class PerfilesServiceJPA implements IPerfilesService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private PerfilesRepository perfilesRepo;
	
	@Override
	public void guardar(Perfil perfil) {
		perfilesRepo.save(perfil);
	}

	@Override
	public void eliminar(int idPerfil) {
		perfilesRepo.deleteById(idPerfil);
	}

}
