package net.iuresti.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.iuresti.app.model.Pelicula;

public interface IPeliculasService {
	
	List<Pelicula> buscarTodas();
	
	Page<Pelicula> buscarTodas(Pageable page); // Paginación
	
	List<String> buscarGeneros();
	
	Pelicula buscarPorId(int idPelicula);
	
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario
	List<Pelicula> buscarActivas();
	
	List<Pelicula> buscarPorFecha(Date fecha);
	
	void insertar(Pelicula pelicula);
	
	void eliminar(int idPelicula);

}
