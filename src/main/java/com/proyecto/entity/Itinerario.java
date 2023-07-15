package com.proyecto.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tb_itinerario")
public class Itinerario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_itinerario")
	private Integer codigoBH;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd ")
	@Column(name="dia")
	private LocalDate dia;
	
	//relacion MUCHOS A UNO
	@ManyToOne
	@JoinColumn(name="cod_bus")
	private Buses buses ;// ASOCIACIÓN
	
	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuario usuarioU ;// ASOCIACIÓN

	@ManyToOne
	@JoinColumn(name="cod_hor")
	private Horarios horario ;// ASOCIACIÓN
	
	//busesHasHorario
	@OneToMany(mappedBy = "itinerario")
	@JsonIgnore
	private List<Pasajes> pasajes;

	public Integer getCodigoBH() {
		return codigoBH;
	}

	public void setCodigoBH(Integer codigoBH) {
		this.codigoBH = codigoBH;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public Buses getBuses() {
		return buses;
	}

	public void setBuses(Buses buses) {
		this.buses = buses;
	}

	public Usuario getUsuarioU() {
		return usuarioU;
	}

	public void setUsuarioU(Usuario usuarioU) {
		this.usuarioU = usuarioU;
	}

	public Horarios getHorario() {
		return horario;
	}

	public void setHorario(Horarios horario) {
		this.horario = horario;
	}

	public List<Pasajes> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<Pasajes> pasajes) {
		this.pasajes = pasajes;
	}

	
	
	
}
