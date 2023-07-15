package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Rutas;
import com.proyecto.repository.RutasRepository;

@Service
public class RutasServices {
	@Autowired
	private RutasRepository repo;
	
	public List<String> listarRutaInicial(){
		return repo.listaRutaInicial();
	}

	public List<Rutas> listarRutaFinal(String inicio){
		return repo.listaRutaFinal(inicio);
	}
}
