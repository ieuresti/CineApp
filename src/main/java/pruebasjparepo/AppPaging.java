package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Obtener todas las entidades por paginacion
		//Page<Noticia> page = repo.findAll(PageRequest.of(0, 5)); // # pag, tamaño o # de registros por pag
		
		//Obtener todas las entidades por paginacion y ordenamiento
		Page<Noticia> page = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo"))); // 3er param = tipo de ordenamiento
		
		for (Noticia n : page) {
			System.out.println(n);
		}

		context.close();
	}

}
