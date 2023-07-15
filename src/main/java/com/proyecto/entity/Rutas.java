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
@Table(name="tb_rutas")
public class Rutas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ruta")
	private Integer codigo;
	
	@Column(name="ruta_Inicio")
	private String rutaInicio;
	
	@Column(name="ruta_Final")
	private String rutaFinal;
	
	
	@OneToMany(mappedBy="rutas")
	@JsonIgnore
	private List<Buses> listaBuses;

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getRutaInicio() {
		return rutaInicio;
	}


	public void setRutaInicio(String rutaInicio) {
		this.rutaInicio = rutaInicio;
	}


	public String getRutaFinal() {
		return rutaFinal;
	}


	public void setRutaFinal(String rutaFinal) {
		this.rutaFinal = rutaFinal;
	}


	public List<Buses> getListaBuses() {
		return listaBuses;
	}


	public void setListaBuses(List<Buses> listaBuses) {
		this.listaBuses = listaBuses;
	}
	
}
