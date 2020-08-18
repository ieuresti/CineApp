package net.iuresti.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	/**
	 * Método que muestra la pagina principal despues de haber iniciado sesión en la aplicación
	 * 
	 * @param authentication
	 * @return
	 */
	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication authentication) {
		System.out.println("Username: " + authentication.getName());
		
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("Rol: " + rol.getAuthority());
		}
		
		return "admin";
	}

	/**
	 * Método para cerrar nuestra sesión y volver al login
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/formLogin";
	}

}
