package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.repository.NoticiasRepository;

// Aplicacion para persistir (Crear) en la tabla Noticias un objeto de tipo Noticia
public class AppCreate {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Se confirma 4ta temporada de SNK");
		noticia.setDetalle("El nuevo estudio sera MAPPA y se estrenara en Oct de este año");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		
		context.close();

	}

}
