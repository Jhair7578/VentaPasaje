package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Cliente;

public interface ClienteRespository extends JpaRepository<Cliente, Integer>{
	
	@Query("select c from Cliente c where c.nombre like ?1%")
	public List<Cliente> listarClientesNombre(String nombre);
	
	@Query("select c from Cliente c where c.dni like ?1%")
	public List<Cliente> listarClientesDni(int dni);
	
	@Query("select c from Cliente c where c.nombre like ?1% and c.dni like ?2%")
	public List<Cliente> listarClienteNombreDni(String nom,int dni);
		
	@Query("select count(c) from Cliente c where c.dni = ?1")
	public int existeDNI(String dni);
}
