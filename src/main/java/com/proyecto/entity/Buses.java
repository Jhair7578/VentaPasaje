package com.proyecto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_buses")
public class Buses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_bus")
	private Integer codigo;
	
	@Column(name="nro_placa")
	private String nroplaca;
	@Column(name="año_fab")
	private int aniofab;
	@Column(name="est_bus")
	private String estadobus;
	@Column(name="col_bus")
	private String colbus;
	
	@OneToMany(mappedBy="buses")
	@JsonIgnore
	private List<Itinerario> listaItinerario;
		
	@OneToMany(mappedBy = "buses")
	@JsonIgnore
	private List<Asiento> listaAsientos;
	
	@ManyToOne
	@JoinColumn(name="cod_mar")
	private Marca marca;// ASOCIACIÓN
	
	@ManyToOne
	@JoinColumn(name="cod_ruta")
	private Rutas rutas;// ASOCIACIÓN

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNroplaca() {
		return nroplaca;
	}

	public void setNroplaca(String nroplaca) {
		this.nroplaca = nroplaca;
	}

	public int getAniofab() {
		return aniofab;
	}

	public void setAniofab(int aniofab) {
		this.aniofab = aniofab;
	}

	public String getEstadobus() {
		return estadobus;
	}

	public void setEstadobus(String estadobus) {
		this.estadobus = estadobus;
	}

	public String getColbus() {
		return colbus;
	}

	public void setColbus(String colbus) {
		this.colbus = colbus;
	}

	public List<Itinerario> getListaItinerario() {
		return listaItinerario;
	}

	public void setListaItinerario(List<Itinerario> listaItinerario) {
		this.listaItinerario = listaItinerario;
	}

	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Rutas getRutas() {
		return rutas;
	}

	public void setRutas(Rutas rutas) {
		this.rutas = rutas;
	}


}
