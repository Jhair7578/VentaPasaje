package com.proyecto.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.entity.Cliente;

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
@Table(name="tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_cli")
	private Integer codigo;
	
	@Column (name="nom_cli")
	private String nombre;
	
	@Column (name="ape_cli")
	private String apellido;
	
	@Column(name="sex_cli")
	private String sexo;
	
	@Column(name="dni_cli")
	private String dni;
	
	@Column(name="fecNaci")
	private LocalDate fecha;
	
	@Column (name="cel_cli")
	private String celular;
		
	@OneToMany(mappedBy="cliente")
	@JsonIgnore
	private List<Pasajes> listaCliente;
	
	
	@ManyToOne
	@JoinColumn(name="cod_ubi")
	private Ubigeo ubigeoCliente;// ASOCIACIÓN


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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public List<Pasajes> getListaCliente() {
		return listaCliente;
	}


	public void setListaCliente(List<Pasajes> listaCliente) {
		this.listaCliente = listaCliente;
	}


	public Ubigeo getUbigeoCliente() {
		return ubigeoCliente;
	}


	public void setUbigeoCliente(Ubigeo ubigeoCliente) {
		this.ubigeoCliente = ubigeoCliente;
	}
	
}
