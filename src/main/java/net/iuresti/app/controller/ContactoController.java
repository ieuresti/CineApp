package net.iuresti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iuresti.app.model.Contacto;
import net.iuresti.app.service.IPeliculasService;

@Controller
public class ContactoController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	IPeliculasService servicePeliculas;

	/**
	 * Método para mostrar el formulario de contacto
	 * Nota: Al agregar ModelAttribute antes de una clase de modelo al momento de
	 * realizar una peticion al metodo mostrarFormulario SpringMVC automaticamente
	 * creara una instancia de la clase Contacto utilizando el constructor por
	 * defecto y la va a agregar al modelo
	 * 
	 * @param contacto
	 * @return
	 */
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto) {
		return "formContacto";
	}

	/**
	 * Método para guardar los datos del formulario de contacto
	 * 
	 * @param contacto
	 * @param attributes
	 * @return
	 */
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto, RedirectAttributes attributes) {
		// El objeto de modelo contacto podria ser almacenado en la BD ...
		System.out.println("Guardando datos del usuario: " + contacto);
		attributes.addFlashAttribute("msg", "Gracias por enviarnos tu opinion!");
		return "redirect:/contacto";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePeliculas.buscarGeneros();
	}

}
