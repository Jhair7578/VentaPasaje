package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Itinerario;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Integer>{
	
	@Query("select i from Itinerario i where i.buses.rutas.rutaInicio like ?1")
	public List<Itinerario> buscarItinerarioInicio(String inicio);
	
	@Query("select i from Itinerario i where i.buses.rutas.rutaFinal = ?1")
	public List<Itinerario> buscarItinerarioFinal(String fin);
	
	@Query("select i from Itinerario i where i.horario.codigo = ?1")
	public List<Itinerario> buscarItinerarioHora(int codHor);
	
	@Query("select i from Itinerario i where i.buses.rutas.rutaInicio like ?1 and i.buses.rutas.rutaFinal = ?2")
	public List<Itinerario> buscarItinerarioInicioFinal(String inicio,String fin);
	
	@Query("select i from Itinerario i where i.buses.rutas.rutaInicio like ?1 and i.horario.codigo = ?2")
	public List<Itinerario> buscarItinerarioInicioHora(String inicio,int codHora);
	
	@Query("select i from Itinerario i where i.buses.rutas.rutaInicio like ?1 and i.buses.rutas.rutaFinal like ?2 and i.horario.codigo like ?3")
	public List<Itinerario> buscarItinerarioRutasHorarios(String inicio,String fin, int codHora);
	
}
