package com.proyecto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_car")
	private Integer codigo;
	
	@Column(name="nom_car")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="cargo")
	private List<Usuario> listaCargos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cargo")
	private List<CargoMenu> listaCargoMenu;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Usuario> getListaCargos() {
		return listaCargos;
	}
	
	
	public void setListaCargos(List<Usuario> listaCargos) {
		this.listaCargos = listaCargos;
	}


	public List<CargoMenu> getListaCargoMenu() {
		return listaCargoMenu;
	}


	public void setListaCargoMenu(List<CargoMenu> listaCargoMenu) {
		this.listaCargoMenu = listaCargoMenu;
	}
	

}