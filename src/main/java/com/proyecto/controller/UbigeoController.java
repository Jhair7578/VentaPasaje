package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.entity.Ubigeo;
import com.proyecto.services.UbigeoServices;

@Controller
@RequestMapping("/ubigeo")
public class UbigeoController {
	
	@Autowired
	private UbigeoServices ubigeoServicio;
	
	@RequestMapping("/listaDepartamento")
	@ResponseBody
	public List<String> verDepartamento(){
		return ubigeoServicio.listarDepartamentos();
	}
	
	@RequestMapping("/listaProvincia")
	@ResponseBody
	public List<String> verProvincia(@RequestParam("departamento") String depar){
		return ubigeoServicio.listarProvincias(depar);
	}
	
	@RequestMapping("/listaDistrito")
	@ResponseBody
	public List<Ubigeo> verDistrito(@RequestParam("provincia") String provin){								
		return ubigeoServicio.listarDistritos(provin);
	}
}
