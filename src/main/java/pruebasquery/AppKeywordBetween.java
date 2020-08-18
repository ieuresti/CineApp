package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.repository.NoticiasRepository;

public class AppKeywordBetween {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Ejemplo Keyword Between

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		List<Noticia> lista = null;
		try {
			lista = repo.findByFechaBetween(format.parse("2017-09-03"), format.parse("2017-09-06"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (Noticia n : lista) {
			System.out.println(n);
		}

		context.close();
	}

}
