package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Cliente;
import com.proyecto.repository.ClienteRespository;

@Service
public class ClienteServices {
	@Autowired
	private ClienteRespository repo;
	
	public List<Cliente> listarCliente(){
		return repo.findAll();
	}

	public void registrarCliente(Cliente cliente) {
		repo.save(cliente);
	}
	
	public void actualizarCliente(Cliente cliente) {
		repo.save(cliente);
	}
	
	public void eliminarCliente(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Cliente buscarCliente(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public int existeDni(String dni) {
		return repo.existeDNI(dni);
	}	
	
	public List<Cliente> buscarClienteNombre(String nombre){
		return repo.listarClientesNombre(nombre);
	}
	public List<Cliente> buscarClienteDNI(int dni){
		return repo.listarClientesDni(dni);
	}	
	public List<Cliente> consultaClientes(String nom,int dni){
		return repo.listarClienteNombreDni(nom, dni);
	}
}
