package com.proyecto.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CargoMenuPK implements Serializable{

	//para la llave primaria compuesta
	@Column(name ="cod_car")
	private int codCargo;
	@Column(name ="cod_men")
	private int codMenu;
	
	
	
	public int getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}
	public int getCodMenu() {
		return codMenu;
	}
	public void setCodMenu(int codMenu) {
		this.codMenu = codMenu;
	}
	//hashCode --> Genera una clave en funcion a los atributos de la clase actual
	//equals --> Valida la clave generada
	@Override
	public int hashCode() {
		return Objects.hash(codCargo, codMenu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoMenuPK other = (CargoMenuPK) obj;
		return codCargo == other.codCargo && codMenu == other.codMenu;
	}
	
}
