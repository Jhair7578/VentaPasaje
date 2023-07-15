package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Menu;
import com.proyecto.repository.MenuRepository;

@Service
public class MenuServices {
	@Autowired
	private MenuRepository repo;
	
	private List<Menu> listarMenu(){
		return repo.findAll();
	}

}
