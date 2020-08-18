package net.iuresti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iuresti.app.model.Perfil;
import net.iuresti.app.model.Usuario;
import net.iuresti.app.service.IPerfilesService;
import net.iuresti.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IPerfilesService servicePerfiles;
	
	/**
	 * Método que muestra la lista de usuarios
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> listaUsuarios = serviceUsuarios.buscarTodos();
		model.addAttribute("usuarios", listaUsuarios);
		return "usuarios/listUsuarios";
	}
	
	/**
	 * Método para mostrar el formulario para crear un usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuario) {
		return "usuarios/formUsuario";
	}
	
	/**
	 * Método para guardar el registro de un Usuario
	 * 
	 * @param usuario
	 * @param perfil
	 * @param result
	 * @param model
	 * @param attributes
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "usuarios/formUsuario";
		}
		
		String tmpPass = usuario.getPwd();
		String encriptado = encoder.encode(tmpPass);
		usuario.setPwd(encriptado);
		usuario.setActivo(1);
		serviceUsuarios.guardar(usuario);
		
		Perfil perfilTmp = new Perfil();
		perfilTmp.setCuenta(usuario.getCuenta());
		perfilTmp.setPerfil(perfil);
		servicePerfiles.guardar(perfilTmp);
		
		attributes.addFlashAttribute("msg", "Los datos del usuario fueron guardados!");
		return "redirect:/usuarios/index";
	}
	
	/**
	 * Método que muestra el formulario para editar un usuario
	 * 
	 * @param idUsuario
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idUsuario, Model model) {
		Usuario usuario = serviceUsuarios.buscarPorId(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuarios/formUsuario";
	}
	
	/**
	 * Método para eliminar un registro de usuarios
	 * 
	 * @param idUsuario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		serviceUsuarios.eliminar(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!");
		return "redirect:/usuarios/index";
	}
	
	/**
	 * Método de apoyo para encriptar texto plano (un password)
	 * 
	 * @return
	 */
	@GetMapping("/demo-bcrypt")
	public String pruebaBCrypt() {
		String password = "fubuki123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		return "usuarios/demo";
	}

}
