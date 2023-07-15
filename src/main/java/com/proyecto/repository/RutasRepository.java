package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Rutas;

public interface RutasRepository extends JpaRepository<Rutas , Integer>{

	@Query("select distinct r.rutaInicio from Rutas r order by r.rutaInicio")
	public List<String> listaRutaInicial();
	
	@Query("select r from Rutas r where r.rutaInicio=?1")
	public List<Rutas> listaRutaFinal(String rutaInicio);
}
