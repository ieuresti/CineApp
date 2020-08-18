package net.iuresti.app.service;

import net.iuresti.app.model.Perfil;

public interface IPerfilesService {
	
	void guardar(Perfil perfil);
	
	void eliminar(int idPerfil);

}
