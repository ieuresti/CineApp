package net.iuresti.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.iuresti.app.model.Horario;

public interface IHorariosService {
	
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
	
	List<Horario> buscarTodos();
	
	Page<Horario> buscarTodos(Pageable page);
	
	Horario buscarPorId(int idHorario);
	
	void insertar(Horario horario);
	
	void eliminar(int idHorario);

}
