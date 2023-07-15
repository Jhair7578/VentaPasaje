package com.proyecto.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PasajeHasAsientoPK implements Serializable{

	@Column(name ="cod_pas")
	private int codPasaje;
	@Column(name ="cod_asi")
	private int codAsiento;
	
	public int getCodPasaje() {
		return codPasaje;
	}
	public void setCodPasaje(int codPasaje) {
		this.codPasaje = codPasaje;
	}
	public int getCodAsiento() {
		return codAsiento;
	}
	public void setCodAsiento(int codAsiento) {
		this.codAsiento = codAsiento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codAsiento, codPasaje);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasajeHasAsientoPK other = (PasajeHasAsientoPK) obj;
		return codAsiento == other.codAsiento && codPasaje == other.codPasaje;
	}
	
	
}
