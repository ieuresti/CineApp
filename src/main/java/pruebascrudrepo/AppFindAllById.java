package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Recuperar varios registros por Id [metodo findAllById del repositorio]
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(3);
		ids.add(5);
		ids.add(8);
		
		Iterable<Noticia> iterable = repo.findAllById(ids);
		
		for (Noticia n : iterable) {
			System.out.println(n);
		}
		
		context.close();

	}

}
