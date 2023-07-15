package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.entity.Asiento;


public interface AsientoRepository extends JpaRepository<Asiento, Integer> {

	//INSERT INTO `bd_dawi`.`tb_asiento` (`nro_asiento`, `estado`, `cod_tipo_asiento`, `cod_bus`) VALUES ('1', 'libre', '1', '1');

	/*@Query("insert into Asiento ()")
	public List<Asiento> registrarAsientos();*/
	@Query("select a from Asiento a where a.buses.nroplaca = ?1")
	public List<Asiento> listarAsientosPorPlaca(String placa);

	//DELETE FROM tb_asiento WHERE (cod_bus = '1');
	@Query("delete from Asiento a where  a.buses.codigo = ?1")
	public void eliminarAsientos(Integer codBus);
	
	

}
