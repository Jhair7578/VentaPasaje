package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Detalle;
import com.proyecto.entity.Pasajes;

public interface PasajesRepository extends JpaRepository<Pasajes, Integer>{

	/*@Query(value="select pa.cod_asi, a.nro_asiento, ta.descripcion, ta.precio from tb_pasajes_has_asiento pa join tb_asiento a on pa.cod_asi = a.cod_asi "
			+ "join tb_tipo_asiento ta on ta.cod_tipo_asiento=a.cod_tipo_asiento   where  pa.cod_pas=?1",nativeQuery = true)
	public List<Detalle> listarAsientos(int cod);	*/

	/*
	@Query("select a.codigo, a.numeroAsi, a.tipoAsiento.descripcion, a.tipoAsiento.precio from Asiento a where a.listaPasajesAsiento.pasajes.codigo=?1")
	public List<Detalle> listarAsientos(int cod);*/	

}