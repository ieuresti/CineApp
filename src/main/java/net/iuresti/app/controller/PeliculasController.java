package net.iuresti.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iuresti.app.model.Pelicula;
import net.iuresti.app.service.IDetallesService;
import net.iuresti.app.service.IPeliculasService;
import net.iuresti.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IPeliculasService servicePeliculas;

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IDetallesService serviceDetalles;

	/**
	 * Método que muestra la lista de peliculas
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	/**
	 * Método que muestra la lista de peliculas con paginacion
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	/**
	 * Método para mostrar el formulario para crear una pelicula
	 * 
	 * @param pelicula
	 * @param model
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		// model.addAttribute("generos", servicePeliculas.buscarGeneros());
		return "peliculas/formPelicula";
	}

	/**
	 * Método para guardar los datos de la pelicula (CON ARCHIVO DE IMAGEN)
	 * 
	 * @param pelicula
	 * @param result
	 * @param attributes
	 * @param multiPart
	 * @param request
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}

		// Comparar si el archivo no viene vacio
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			if (nombreImagen!=null) { // La imagen si se subio
				pelicula.setImagen(nombreImagen); // Asignamos el nombre de la imagen
			}
		}

		// Primero insertamos el detalle
		serviceDetalles.insertar(pelicula.getDetalle());
		// Como el Detalle ya tiene id, ya podemos guardar la pelicula
		servicePeliculas.insertar(pelicula);
		attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
		// return "redirect:/peliculas/index";
		return "redirect:/peliculas/indexPaginate";
	}

	/**
	 * Método editar que recibe el id de la pelicula que viene incrustado en la url
	 * de la petición, posteriormente usando nuestra clase de servicio se busca por
	 * id esa pelicula y al encontrarla la agregamos al modelo para posteriormente
	 * renderizar la vista formPelicula
	 * 
	 * @param idPelicula
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		// model.addAttribute("generos", servicePeliculas.buscarGeneros());
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		model.addAttribute("pelicula", pelicula);

		return "peliculas/formPelicula";
	}

	/**
	 * Método para eliminar una pelicula
	 * 
	 * @param idPelicula
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
		// Buscamos primero la pelicula
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula); // Asi obtenemos una instancia de la entidad que vamos a eliminar

		// Eliminamos la pelicula. Tambien al borrar la pelicula, se borraran los Horarios (ON CASCADE DELETE)
		servicePeliculas.eliminar(idPelicula);
		// Eliminamos el registro del detalle
		serviceDetalles.eliminar(pelicula.getDetalle().getId());

		attributes.addFlashAttribute("msg", "La pelicula fue eliminada!");
		//return "redirect:/peliculas/index";
		return "redirect:/peliculas/indexPaginate";
	}

	/**
	 * Agregamos al Model la lista de generos, de esta forma nos evitamos agregarlos en los métodos
	 * crear y editar
	 * 
	 * @return
	 */
	@ModelAttribute("generos")
	public List<String> getGeneros() {
		return servicePeliculas.buscarGeneros();
	}

	/**
	 * Con este InitBinder configuramos CustomDateEditor para todas las propiedades
	 * de tipo java.util.Date
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
