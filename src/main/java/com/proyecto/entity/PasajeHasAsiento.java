package com.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pasajes_has_asiento")
public class PasajeHasAsiento {

	@EmbeddedId
	private PasajeHasAsientoPK pk;
	
	@ManyToOne
	@JoinColumn(name="cod_pas",insertable = false,updatable = false,referencedColumnName = "cod_pas")
	private Pasajes pasajes;
	
	@ManyToOne
	@JoinColumn(name="cod_asi",insertable = false,updatable = false,referencedColumnName = "cod_asi")
	private Asiento asiento;

	@Column(name = "precio")
	private double precio;
	
	public PasajeHasAsientoPK getPk() {
		return pk;
	}

	public void setPk(PasajeHasAsientoPK pk) {
		this.pk = pk;
	}

	public Pasajes getPasajes() {
		return pasajes;
	}

	public void setPasajes(Pasajes pasajes) {
		this.pasajes = pasajes;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
