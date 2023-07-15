package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.PasajeHasAsiento;

public interface PasajeHasAsientorepository extends JpaRepository<PasajeHasAsiento, Integer>{
	
	@Query("select pa from PasajeHasAsiento pa where pa.pasajes.codigo=?1")
	public List<PasajeHasAsiento> listarA(int cod);
}
