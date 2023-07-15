package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Horarios;
import com.proyecto.repository.HorariosRepository;

@Service 
public class HorariosServices {
	@Autowired
	private HorariosRepository repo;
	
	public List<Horarios> listarHorarios(){
		return repo.findAll();
	}

}
