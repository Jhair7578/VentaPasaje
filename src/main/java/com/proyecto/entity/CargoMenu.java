package com.proyecto.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cargo_menu")
public class CargoMenu {

	//atributo de la clase CargoMenuPK
	@EmbeddedId
	private CargoMenuPK id;
	
	@ManyToOne
	@JoinColumn(name="cod_car",insertable = false,updatable = false,referencedColumnName = "cod_car")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="cod_men",insertable = false,updatable = false,referencedColumnName = "cod_men")
	private Menu menu;

	public CargoMenuPK getId() {
		return id;
	}

	public void setId(CargoMenuPK id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	
}
