package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Asiento;
import com.proyecto.repository.AsientoRepository;

@Service
public class AsientoServices {

	@Autowired
	private AsientoRepository repo;
	
	
	public void registrarAsientos(Asiento a) {
		repo.save(a);		
	}
	public void actualizarAsientos(Asiento a) {
		repo.save(a);		
	}
	public void eliminarAsientoxBus(Integer codBus) {
		repo.deleteById(codBus);		
	}
	
	public Asiento buscarAsientosID(int codAsi){
		return repo.findById(codAsi).orElse(null);
	}
	
	public List<Asiento> listarAsientosXPlaca(String placa){
		return repo.listarAsientosPorPlaca(placa);
	}
}
