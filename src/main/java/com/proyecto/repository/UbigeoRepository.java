package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Ubigeo;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Integer>{

	@Query("select distinct u.departamento from Ubigeo u order by u.departamento ")
	public List<String> listaDepartamento();
	
	@Query("select distinct u.provincia from Ubigeo u where u.departamento=?1")
	public List<String> listaProvincia(String deparmatamento);
	
	@Query("select u from Ubigeo u where u.provincia=?1")
	public List<Ubigeo> listaDistrito(String provincia);
}
