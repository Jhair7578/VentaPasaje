package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Detalle;
import com.proyecto.entity.PasajeHasAsiento;
import com.proyecto.entity.PasajeHasAsientoPK;
import com.proyecto.entity.Pasajes;
import com.proyecto.repository.PasajeHasAsientorepository;
import com.proyecto.repository.PasajesRepository;

import jakarta.transaction.Transactional;

@Service
public class PasajesServices {
	@Autowired
	private PasajesRepository repoPasaje;

	@Autowired
	private PasajeHasAsientorepository repoPasAsi;
	
	public List<Pasajes> listarPasajes(){
		return repoPasaje.findAll();
	}

	public Pasajes listarPasajesPorID(Integer cod){
		return repoPasaje.findById(cod).orElse(null);
	}
	
	@Transactional
	public void registrar(Pasajes bean) {
		try {
			repoPasaje.save(bean);
			
			for(PasajeHasAsiento pha:bean.getListaPasajesAsiento()) {
				PasajeHasAsientoPK pk = new PasajeHasAsientoPK();
				
				pk.setCodAsiento(pha.getAsiento().getCodigo());
				pk.setCodPasaje(bean.getCodigo());
				
				pha.setPk(pk);
				
				repoPasAsi.save(pha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
/*
	public List<Detalle> listarAsientosP(int cod){
		return repoPasaje.listarAsientos(cod);
	}
	*/
}
