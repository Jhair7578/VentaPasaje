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
@Table(name="tb_asiento")
public class Asiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_asi")
	private Integer codigo;
	@Column (name="nro_asiento")
	private int numeroAsi;
	@Column (name="estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_asiento")
	private TipoAsiento tipoAsiento;
	
	@ManyToOne
	@JoinColumn(name="cod_bus")
	private Buses buses;
	
	@OneToMany(mappedBy = "asiento")
	@JsonIgnore
	private List<PasajeHasAsiento> listaPasajesAsiento;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getNumeroAsi() {
		return numeroAsi;
	}

	public void setNumeroAsi(int numeroAsi) {
		this.numeroAsi = numeroAsi;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoAsiento getTipoAsiento() {
		return tipoAsiento;
	}

	public void setTipoAsiento(TipoAsiento tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}

	public Buses getBuses() {
		return buses;
	}

	public void setBuses(Buses buses) {
		this.buses = buses;
	}

	public List<PasajeHasAsiento> getListaPasajesAsiento() {
		return listaPasajesAsiento;
	}

	public void setListaPasajesAsiento(List<PasajeHasAsiento> listaPasajesAsiento) {
		this.listaPasajesAsiento = listaPasajesAsiento;
	}	
}
