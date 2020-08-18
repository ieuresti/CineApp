package net.iuresti.app.service;

import net.iuresti.app.model.Detalle;

public interface IDetallesService {
	
	void insertar(Detalle detalle);
	
	void eliminar(int idDetalle);

}
