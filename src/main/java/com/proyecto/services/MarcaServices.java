package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Marca;
import com.proyecto.repository.MarcaRepository;

@Service
public class MarcaServices {
	@Autowired
	private MarcaRepository repo;
	
	public List<Marca> listaMarcas(){
		return repo.findAll();
	}
 
}
