package net.iuresti.app.repository;

// Este repositorio administra todas las operaciones de BD para objetos de tipo Noticia

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.iuresti.app.model.Noticia;

/**
 * Marcamos esta clase como un Bean de tipo Repository en nuestro Root
 * ApplicationContext. Nota: La anotacion @Repository es opcional ya que al
 * extender la interfaz JpaRepository Spring crea una instancia en nuestro Root
 * ApplicationContext.
 */
@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

	// select * from Noticias
	List<Noticia> findBy();

	// select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);

	// select * from Noticias where fecha = ?
	List<Noticia> findByFecha(Date fecha);

	// select * from Noticias where estatus = ? and fecha = ?
	List<Noticia> findByEstatusAndFecha(String status, Date fecha);

	// select * from Noticias where estatus = ? or fecha = ?
	List<Noticia> findByEstatusOrFecha(String status, Date fecha);

	// select * from Noticias where fecha between = ? and fecha = ?
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);

	// where id between ? and ?
	List<Noticia> findByIdBetween(int n1, int n2);

	// select * from Noticias where estatus = ? order by id desc limit 3
	public List<Noticia> findTop3ByEstatusOrderByIdDesc(String estatus);
}
