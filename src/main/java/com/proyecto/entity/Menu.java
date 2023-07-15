package com.proyecto.entity;

import java.io.Serializable;
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
@Table(name="tb_menu")
public class Menu implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_men")
	private Integer codigo;

	@Column (name="nom_men")
	private String nombre;

	@Column(name="url_men")
	private String url;

	@OneToMany(mappedBy = "menu")
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CargoMenu> getListaCargoMenu() {
		return listaCargoMenu;
	}

	public void setListaCargoMenu(List<CargoMenu> listaCargoMenu) {
		this.listaCargoMenu = listaCargoMenu;
	}


	
}