package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Itinerario;
import com.proyecto.repository.ItinerarioRepository;

@Service
public class ItinerarioServices {

	@Autowired
	private ItinerarioRepository repo;
	
	public List<Itinerario> listarItinerarios(){
		return repo.findAll();
	}
	
	public void registarItinerario(Itinerario Itinerario) {
		 repo.save(Itinerario);
	}
	
	public void actualizarItinerario(Itinerario Itinerario) {
		repo.save(Itinerario);
	}
	
	public void eliminarItinerario(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Itinerario buscarItinerario(Integer cod) {
		return repo.findById(cod).orElse(null);
	}	
	
	public List<Itinerario> buscarItinerarioPorInicio(String inicio){
		return repo.buscarItinerarioInicio(inicio);
	}
	
	public List<Itinerario> buscarItinerarioPorFinal(String fin){
		return repo.buscarItinerarioFinal(fin);
	}
	
	public List<Itinerario> buscarItinerarioPorHora(int codHor){
		return repo.buscarItinerarioHora(codHor);
	}
	
	public List<Itinerario> buscarItinerarioPorInicioFinal(String inicio,String fin){
		return repo.buscarItinerarioInicioFinal(inicio,fin);
	}
	
	public List<Itinerario> buscarItinerarioPorInicioHora(String inicio,int codHor){
		return repo.buscarItinerarioInicioHora(inicio,codHor);
	}

	public List<Itinerario> listarItinerarioXRutaXhorario(String ini,String fin, int codHor){
		return repo.buscarItinerarioRutasHorarios(ini, fin, codHor);
	}
	
	
}
