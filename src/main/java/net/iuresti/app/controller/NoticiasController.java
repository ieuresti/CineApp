package net.iuresti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iuresti.app.model.Noticia;
import net.iuresti.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private INoticiasService serviceNoticias;
	
	/**
	 * Método que muestra la lista de noticias
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Noticia> listaNoticias = serviceNoticias.buscarTodas();
		model.addAttribute("noticias", listaNoticias);
		return "noticias/listNoticias";
	}
	
	/**
	 * Método para mostrar el formulario para crear una noticia
	 * 
	 * @param noticia
	 * @return
	 */
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia noticia) {
		return "noticias/formNoticia";
	}
	
	/**
	 * Método para guardar el registro de la Noticia
	 * 
	 * @param noticia
	 * @param result
	 * @param model
	 * @param attributes
	 * @return
	 */
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "noticias/formNoticia";
		}
		
		serviceNoticias.guardar(noticia);
		attributes.addFlashAttribute("msg", "Los datos de la noticia fueron guardados!");
		return "redirect:/noticias/index";
	}
	
	/**
	 * Método para eliminar una noticia
	 * 
	 * @param idNoticia
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes) {
		serviceNoticias.eliminar(idNoticia);
		attributes.addFlashAttribute("msg", "La noticia fue eliminada!");
		return "redirect:/noticias/index";
	}
	
	/**
	 * Método para mostrar el formulario de Editar
	 * 
	 * @param idNoticia
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia, Model model) {
		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		model.addAttribute("noticia", noticia);
		return "noticias/formNoticia";
	}

}
