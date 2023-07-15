package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Buses;
import com.proyecto.entity.Usuario;
import com.proyecto.repository.BusesRepository;

@Service

public class BusesServices {
	@Autowired
	private BusesRepository repo;
	
	public List<Buses> listarBuses(){
		return repo.findAll();
	}

	
	public void registarBuses(Buses buses) {
		 repo.save(buses);
	}
	
	public void actualizarBuses(Buses buses) {
		repo.save(buses);
	}
	
	public void eliminarBuses(Integer cod) {
		repo.deleteById(cod);
	}
	

	public Buses buscarBuses(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public int existePlaca(String placa) {
		return repo.existePlaca(placa);
	}
	
	//Para el ItinerarioController
	public List<Buses> listarBusesUno(String np){
		return repo.findByNroplacaStartingWith(np);
	}
	public List<Buses> listaBM(int codigoMarca){
		return repo.listarporBusesMarca(codigoMarca);
	}
}

