package com.proyecto.entity;

import java.time.LocalDate;
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
@Table(name="tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_usu")
	private Integer codigo;

	@Column (name="log_usu")
	private String login;

	@Column (name="pas_usu")
	private String password;

	@Column(name="nom_usus")
	private String nombre;
	
	@Column(name="ape_usu")
	private String apellido;
	
	@Column(name="cel_usu")
	private String celular;

	@Column(name="dni_usu")
	private String dni;

	@Column(name="fec_naci")
	private LocalDate fecha;

	@Column (name="correo")
	private String correo;
	
	@Column (name="sex_usu")
	private String sexo;

	@Column (name="nro_licencia")
	private String nrolicencia;
	
	@Column (name="clase_cat")
	private String clasecategoria;
	
	@ManyToOne
	@JoinColumn(name="cod_ubi")
	private Ubigeo ubigeoUsuario;// ASOCIACIÓN
	//
	//
	@ManyToOne
	@JoinColumn(name="cod_car")
	private Cargo cargo;// ASOCIACIÓN

	@OneToMany(mappedBy="usuarioU")
	@JsonIgnore
	private List<Itinerario> listaItinerario;

	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Pasajes> listaPasajes;

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNrolicencia() {
		return nrolicencia;
	}

	public void setNrolicencia(String nrolicencia) {
		this.nrolicencia = nrolicencia;
	}

	public String getClasecategoria() {
		return clasecategoria;
	}

	public void setClasecategoria(String clasecategoria) {
		this.clasecategoria = clasecategoria;
	}

	public Ubigeo getUbigeoUsuario() {
		return ubigeoUsuario;
	}

	public void setUbigeoUsuario(Ubigeo ubigeoUsuario) {
		this.ubigeoUsuario = ubigeoUsuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Itinerario> getListaItinerario() {
		return listaItinerario;
	}

	public void setListaItinerario(List<Itinerario> listaItinerario) {
		this.listaItinerario = listaItinerario;
	}

	public List<Pasajes> getListaPasajes() {
		return listaPasajes;
	}

	public void setListaPasajes(List<Pasajes> listaPasajes) {
		this.listaPasajes = listaPasajes;
	}


	

}