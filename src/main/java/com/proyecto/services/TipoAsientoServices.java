package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.TipoAsiento;
import com.proyecto.repository.TipoAsientoRepository;

@Service
public class TipoAsientoServices {

	@Autowired
	private TipoAsientoRepository repo;
	
	public List<TipoAsiento> listarTipoAsiento(){
		return repo.findAll();
	}
}
