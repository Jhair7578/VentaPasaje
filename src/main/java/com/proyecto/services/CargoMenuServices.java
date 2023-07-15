package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.CargoMenu;
import com.proyecto.repository.CargoMenuRepository;

@Service 
public class CargoMenuServices {
	@Autowired
	private CargoMenuRepository repo;
	
	private List<CargoMenu> listarCargoMenu(){
		return repo.findAll();
	}

}
