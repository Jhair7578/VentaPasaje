package com.proyecto.entity;

public class Detalle {

	private int codigo;
	private int numAsiento;
	private String tipoAsiento;
	private Double precio;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumAsiento() {
		return numAsiento;
	}
	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}
	
	public String getTipoAsiento() {
		return tipoAsiento;
	}
	public void setTipoAsiento(String tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
		
}
