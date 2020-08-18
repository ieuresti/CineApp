package net.iuresti.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iuresti.app.model.Horario;
import net.iuresti.app.model.Pelicula;
import net.iuresti.app.service.IHorariosService;
import net.iuresti.app.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IHorariosService serviceHorarios;

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IPeliculasService servicePeliculas;

	/**
	 * Método que muestra la lista de los horarios
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
	
	/**
	 * Método que muestra la lista de los horarios con paginacion
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Horario> listaHorarios = serviceHorarios.buscarTodos(page);
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}

	/**
	 * Método para mostrar el formulario para crear un nuevo horario
	 * 
	 * @param horario
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute Horario horario) {
		return "horarios/formHorario";
	}

	/**
	 * Método para guardar el registro del horario
	 * 
	 * @param horario
	 * @param result
	 * @param model
	 * @param attributes
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}

		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	/**
	 * Método que muestra el formulario para editar un horario
	 * 
	 * @param idHorario
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}
	
	/**
	 * Método para eliminar un registro de horarios
	 * 
	 * @param idHorario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorarios.eliminar(idHorario);
		attributes.addFlashAttribute("msg", "El horario fue eliminado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	/**
	 * Agregamos al modelo, el listado de peliculas para que este disponible
	 * para todos los métodos de este controlador
	 * 
	 * @return
	 */
	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas() {
		return servicePeliculas.buscarActivas();
	}

	/**
	 * Con este InitBinder configuramos CustomDateEditor para todas las propiedades
	 * de tipo java.util.Date
	 * 
	 * @param binder
	 */
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
