package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Metodo para verificar si una unidad existe en la BD (metodo existsById)
		int idNoticia = 1;
		System.out.println(repo.existsById(idNoticia));
		
		context.close();

	}

}
