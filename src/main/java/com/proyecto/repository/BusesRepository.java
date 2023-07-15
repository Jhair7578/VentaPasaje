package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Buses;

public interface BusesRepository  extends JpaRepository<Buses, Integer >{
			
			public List<Buses> findByNroplacaStartingWith(String np);
			
			@Query("select b from Buses b where b.marca.codigo=?1")
			public List<Buses> listarporBusesMarca(int codigoMarca);
			
			@Query("select count(b) from Buses b where b.nroplaca = ?1")
			public int existePlaca(String placa);
}
