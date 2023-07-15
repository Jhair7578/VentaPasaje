package com.proyecto.entity;

import java.util.Date;
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
@Table(name="tb_pasajes")
public class Pasajes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_pas")
	private Integer codigo;
	
	@Column(name="monto")
	private Double monto;
	
	@Column(name="dia")
	private Date dia;
	
	//relacion MUCHOS A UNO
	@ManyToOne
	@JoinColumn(name="cod_cli")
	private Cliente cliente;// ASOCIACIÓN

	@ManyToOne
	@JoinColumn(name="cod_itinerario")
	private Itinerario itinerario;

	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuario usuario;

	
	@OneToMany(mappedBy = "pasajes")
	@JsonIgnore
	private List<PasajeHasAsiento> listaPasajesAsiento;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Itinerario getItinerario() {
		return itinerario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public List<PasajeHasAsiento> getListaPasajesAsiento() {
		return listaPasajesAsiento;
	}

	public void setListaPasajesAsiento(List<PasajeHasAsiento> listaPasajesAsiento) {
		this.listaPasajesAsiento = listaPasajesAsiento;
	}


	
}