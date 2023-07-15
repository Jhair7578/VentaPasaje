package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.proyecto.entity.Menu;
import com.proyecto.entity.Usuario;
import com.proyecto.services.UsuarioServices;


@SessionAttributes({"datosUsuario","menu","cargo","CODIGO_USUARIO"})
@Controller
@RequestMapping("/ingresar")
public class IngresarController {

	@Autowired 
	private UsuarioServices usuarioServicio;
	
	@RequestMapping("/login")
	public String login(){		
		return "login1";
	}
	
	@RequestMapping("/principal")
	public String principal(){		
		return "principal";
	}
	
	@RequestMapping("/index")
	public String index(Authentication auth,Model model){

		String nomUsuario = auth.getName();
		Usuario bean=usuarioServicio.loginUsuario(nomUsuario);
		List<Menu> lista = usuarioServicio.MenuUsuario(bean.getCargo().getCodigo());
		model.addAttribute("datosUsuario",bean.getApellido()+" "+bean.getNombre());
		model.addAttribute("menu",lista);
		model.addAttribute("cargo",bean.getCargo().getNombre());
		model.addAttribute("CODIGO_USUARIO",bean.getCodigo());
		return "index";
	}
}
  