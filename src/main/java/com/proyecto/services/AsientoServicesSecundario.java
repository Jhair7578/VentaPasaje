package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.entity.Asiento;
import com.proyecto.entity.Pasajes;
import com.proyecto.repository.AsientoRepositorySecundario;

@Service
public class AsientoServicesSecundario {

	 private final ObjectMapper objectMapper;

	    public AsientoServicesSecundario(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }

	
	@Autowired
	private AsientoRepositorySecundario repo;
	
	public ArrayList<Asiento> listarAsientosXPasaje(int pasaje){
		return repo.buscarAsientoPasaje(pasaje);
	}
}
