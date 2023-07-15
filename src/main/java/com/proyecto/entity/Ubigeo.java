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
@Table(name = "tb_ubigeo")
public class Ubigeo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_ubi")
	private String codigo;
	
	@Column(name="departamento")
	private String departamento;
	
	@Column (name="provincia")
	private String provincia;
	
	@Column (name="distrito")
	private String distrito;
	
	
	@OneToMany(mappedBy="ubigeoCliente")
	@JsonIgnore
	private List<Cliente> listaUbigeoCliente;
	
	
	@OneToMany(mappedBy="ubigeoUsuario")
	@JsonIgnore
	private List<Usuario> listaUbigeosUsuario;
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDepartamento() {
		return departamento;
	}
	
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	public String getProvincia() {
		return provincia;
	}
	
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	public String getDistrito() {
		return distrito;
	}
	
	
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public List<Cliente> getListaUbigeoCliente() {
		return listaUbigeoCliente;
	}


	public void setListaUbigeoCliente(List<Cliente> listaUbigeoCliente) {
		this.listaUbigeoCliente = listaUbigeoCliente;
	}


	public List<Usuario> getListaUbigeosUsuario() {
		return listaUbigeosUsuario;
	}


	public void setListaUbigeosUsuario(List<Usuario> listaUbigeosUsuario) {
		this.listaUbigeosUsuario = listaUbigeosUsuario;
	}
	
	
}