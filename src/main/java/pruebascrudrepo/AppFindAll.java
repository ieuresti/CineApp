package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Recuperar todos los registros [metodo findAll del repositorio]
		Iterable<Noticia> iterable = repo.findAll();
		for (Noticia n : iterable) {
			System.out.println(n);
		}
		
		context.close();

	}

}
