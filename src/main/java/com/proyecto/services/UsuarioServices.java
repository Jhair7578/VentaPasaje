package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Menu;
import com.proyecto.entity.Usuario;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	@Autowired
	private UsuarioRepository repo;
	
	public void registarUsuario(Usuario usuario) {
		 repo.save(usuario);
	}
	
	public void actualizarUsuario(Usuario usuario) {
		repo.save(usuario);
	}
	
	public void eliminarUsuario(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Usuario> listarUsuario(){
		return repo.findAll();
	}

	public Usuario buscarUsuario(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public int existeDni(String dni) {
		return repo.existeDNI(dni);
	}	
	
	//----LOGIN----
	public Usuario loginUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	
	public List<Menu> MenuUsuario(int codigoCargo){
		return repo.traerMenuUsuario(codigoCargo);
	}

	//para ItinerarioController
	public List<Usuario> listarUsuarioUno(String n){
		return repo.listarUporNombre(n);
	}
	public List<Usuario> listaCodigoBrevete1(int codigoBrevete){
		return repo.listarporCodigoBrevete(codigoBrevete);
	}
	public List<Usuario> listaChoferesSeis(){
		return repo.listarChoferes();
	}

}
