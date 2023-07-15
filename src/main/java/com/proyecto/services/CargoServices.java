package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Cargo;
import com.proyecto.repository.CargoRepository;

@Service
public class CargoServices {
	@Autowired
	private CargoRepository repo;
	
	public List<Cargo> listarCargo(){
		return repo.findAll();
	}
	

}
