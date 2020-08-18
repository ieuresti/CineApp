package net.iuresti.app.repository;

//Este repositorio administra todas las operaciones de BD para objetos de tipo Usuario

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.iuresti.app.model.Usuario;

/**
 * Marcamos esta clase como un Bean de tipo Repository en nuestro Root
 * ApplicationContext. Nota: La anotacion @Repository es opcional ya que al
 * extender la interfaz JpaRepository Spring crea una instancia en nuestro Root
 * ApplicationContext.
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
