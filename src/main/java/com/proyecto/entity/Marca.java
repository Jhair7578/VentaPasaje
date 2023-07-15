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
@Table(name="tb_marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mar")
	private Integer codigo;
	
	@Column (name="nom_mar")
	private String nombre;
	
	@OneToMany(mappedBy="marca")
	@JsonIgnore
	private List<Buses> listaBusesMarca;

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

	public List<Buses> getListaBusesMarca() {
		return listaBusesMarca;
	}

	public void setListaBusesMarca(List<Buses> listaBusesMarca) {
		this.listaBusesMarca = listaBusesMarca;
	}
	
}