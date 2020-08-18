package net.iuresti.app.service;

import java.util.List;

import net.iuresti.app.model.Noticia;

public interface INoticiasService {
	
	Noticia buscarPorId(int idNoticia);
	
	List<Noticia> buscarUltimas();
	
	List<Noticia> buscarTodas();
	
	void guardar(Noticia noticia);
	
	void eliminar(int idNoticia);

}
