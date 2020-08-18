package net.iuresti.app.service;

import java.util.List;

import net.iuresti.app.model.Banner;

public interface IBannersService {
	
	Banner buscarPorId(int idBanner);
	
	List<Banner> buscarTodos();
	
	List<Banner> buscarActivos();
	
	void insertar(Banner banner);
	
	void eliminar(int idBanner);

}
