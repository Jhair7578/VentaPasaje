package com.proyecto.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Cargo;
import com.proyecto.entity.Ubigeo;
import com.proyecto.entity.Usuario;
import com.proyecto.services.CargoServices;
import com.proyecto.services.UbigeoServices;
import com.proyecto.services.UsuarioServices;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServicio;
	
	@Autowired
	private CargoServices cargoServicio;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/lista")
	private String lista(Model model) {
		model.addAttribute("cargo",cargoServicio.listarCargo());
		model.addAttribute("usuarios", usuarioServicio.listarUsuario());
		return "empleados";
	}
	
	
	//Cuando salga un error de hibernate con insert con nombre en los valores que no existan Alter a la table y colocar ese valor
	@RequestMapping("grabar")
	private String grabar(@RequestParam("codigo") Integer codUsuario,
						  @RequestParam("nombre") String nom,
						  @RequestParam("apellido") String ape,
						  @RequestParam("cargo") Integer car,
						  @RequestParam("dni") String dni,
						  @RequestParam("fechaNac") String fech,
						  @RequestParam("celular") String cel,
						  @RequestParam("correo") String correo,
						  @RequestParam("sexo") String sexo,
						  @RequestParam(value = "licencia", required = false) String nroLice,
		                  @RequestParam(value = "categoria", required = false) String catCat,		                      
						  @RequestParam("distrito") String codUbigeo,//Uso el name 'distrito' ya que es el que almacena el codigo
						  @RequestParam("usuario") String usu,
						  @RequestParam("contraseña") String con,
						  RedirectAttributes redirect) {
		try {
			Usuario u = new Usuario();
			LocalDate fechaNacimiento = LocalDate.parse(fech);
		    LocalDate fechaActual = LocalDate.now();
		    Period edad = Period.between(fechaNacimiento, fechaActual);
		    if (edad.getYears() < 18) {
	            redirect.addFlashAttribute("MENSAJE", "Debes tener al menos 18 años");
	            return "redirect:/usuario/lista";
	        }

	        if (usuarioServicio.existeDni(dni) == 1) {
	            redirect.addFlashAttribute("MENSAJE", "El DNI ya está registrado");
	            return "redirect:/usuario/lista";
	        } 
				u.setNombre(nom);
				u.setApellido(ape);
				u.setDni(dni);
				u.setFecha(LocalDate.parse(fech));
				u.setCelular(cel);
				u.setCorreo(correo);
				u.setSexo(sexo);
				u.setNrolicencia(nroLice);
				u.setClasecategoria(catCat);			
				
				u.setLogin(usu);
				u.setPassword(encoder.encode(con));
				
				Cargo c = new Cargo();
				Ubigeo ubi = new Ubigeo();
				
				c.setCodigo(car);
				ubi.setCodigo(codUbigeo);
				
				u.setCargo(c);
				u.setUbigeoUsuario(ubi);
			
			if(codUsuario == 0) {
				usuarioServicio.registarUsuario(u);
				redirect.addFlashAttribute("MENSAJE","Usuario Registrado");
			}else {
				u.setCodigo(codUsuario);
				usuarioServicio.actualizarUsuario(u);
				redirect.addFlashAttribute("MENSAJE","Usuario Actualizado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
		}
		return "redirect:/usuario/lista";
	}
		
	@RequestMapping("buscar")
	@ResponseBody
	private Usuario buscarUsuario(@RequestParam("codigo")  Integer cod) {
		return usuarioServicio.buscarUsuario(cod);
	}
	
	@RequestMapping("eliminar")
	private String eliminar(@RequestParam("codigoEliminar") Integer codEli,
										  RedirectAttributes redirect) {
		usuarioServicio.eliminarUsuario(codEli);
		redirect.addAttribute("MENSAJE","Usuario Eliminado");
		return "redirect:/usuario/lista";
	}
}
