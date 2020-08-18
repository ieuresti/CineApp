package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.model.Detalle;
import net.iuresti.app.repository.DetallesRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);
		
		List<Detalle> lista = repo.findAll();
		
		for (Detalle d : lista) {
			System.out.println(d);
		}
		
		context.close();

	}

}
