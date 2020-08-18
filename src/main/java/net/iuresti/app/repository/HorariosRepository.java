package net.iuresti.app.repository;

// Este repositorio administra todas las operaciones de BD para objetos de tipo Horario

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.iuresti.app.model.Horario;

/**
 * Marcamos esta clase como un Bean de tipo Repository en nuestro Root
 * ApplicationContext. Nota: La anotacion @Repository es opcional ya que al
 * extender la interfaz JpaRepository Spring crea una instancia en nuestro Root
 * ApplicationContext.
 */
@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

	// Horarios por idPelicula (Pelicula.id = Pelicula_Id and fecha=?)
	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);

	// Este método es usado cuando filtramos POR FECHA en la página principal del
	// proyecto final. En este caso buscamos en la tabla de horarios AGRUPANDO por
	// idPelicula, pero solo películas ACTIVAS
	@Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc")
	public List<Horario> findByFecha(@Param("fecha") Date fecha); // Anotación @Param, otra forma de indicar placeholders para los parámetros de la consulta(Named Parameter)

}
