package com.proyecto.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Asiento;

public interface AsientoRepositorySecundario extends JpaRepository<Asiento, Integer> {

	/*
	@Query("select a from Asiento a where a.listaPasajesAsiento.pasajes = ?1")
	public List<Asiento> buscarAsientosxPasaje(Pasajes pasaje);	
	*/
	
	@Query(value="select a.* from tb_asiento a join tb_pasajes_has_asiento pa on a.cod_asi = pa.cod_asi join tb_pasajes p on p.cod_pas=pa.cod_pas where p.cod_pas=?1",nativeQuery = true)
	public ArrayList<Asiento> buscarAsientoPasaje(Integer codPas);	
}
