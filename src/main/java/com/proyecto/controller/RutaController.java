package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.entity.Rutas;
import com.proyecto.services.RutasServices;

@Controller
@RequestMapping("/ruta")
public class RutaController {

	@Autowired
	private RutasServices rutaServicio;
	
	@RequestMapping("/listaInicio")
	@ResponseBody
	public List<String> verInicio(){
		return rutaServicio.listarRutaInicial();
	}
	
	@RequestMapping("/listaFinal")
	@ResponseBody
	public List<Rutas> verFinal(@RequestParam("inicio") String inicio){
		return rutaServicio.listarRutaFinal(inicio);
	}
}
