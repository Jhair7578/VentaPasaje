package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.PasajeHasAsiento;
import com.proyecto.repository.PasajeHasAsientorepository;

@Service
public class PasajeHasAsientoServices {

	@Autowired
	private PasajeHasAsientorepository repo;

	public List<PasajeHasAsiento> listarPHA() {
		return repo.findAll();
	}
	public List<PasajeHasAsiento> listarA(int cod) {
		return repo.listarA(cod);
	}
	
}
