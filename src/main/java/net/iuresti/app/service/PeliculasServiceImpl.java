package net.iuresti.app.service;

/**
 * Esta clase ya no se utiliza, solo esta como referencia de inicios del proyecto
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;

import net.iuresti.app.model.Pelicula;

//@Service
public class PeliculasServiceImpl implements IPeliculasService {
	
	private List<Pelicula> lista = null;
	
	public PeliculasServiceImpl() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			// imagen = "cinema.png";
			// estatus = "Activa";

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setImagen("estreno6.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setImagen("estreno7.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La isla Calavera");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Aventura y Accion");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula4.setImagen("estreno4.png");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");

			// Agregamos los objetos a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// Recorriendo la lista de peliculas
		for (Pelicula p : lista) {
			if (p.getId() == idPelicula) {
				// Retornar el obj que haya coincidido con el idPelicula que esta como parametro
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);	
	}

	/**
	 * Metodo que regresa una lista de los Generos de las peliculas
	 */
	@Override
	public List<String> buscarGeneros() {
		// Nota: Esta lista podria ser obtenida en una BD
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		// TODO Auto-generated method stub
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarActivas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
