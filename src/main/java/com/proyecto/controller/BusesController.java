package com.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Asiento;
import com.proyecto.entity.Buses;
import com.proyecto.entity.Marca;
import com.proyecto.entity.Rutas;
import com.proyecto.entity.TipoAsiento;
import com.proyecto.services.AsientoServices;
import com.proyecto.services.BusesServices;
import com.proyecto.services.MarcaServices;

@Controller
@RequestMapping("/bus")
public class BusesController {

	@Autowired
	private BusesServices busesServicio;
	
	@Autowired
	private AsientoServices asientoServicio;
	

	
	@Autowired
	private MarcaServices marcaServicio;
	
	@RequestMapping("/lista")
	private String lista(Model model) {
		model.addAttribute("marca",marcaServicio.listaMarcas());
		model.addAttribute("buse", busesServicio.listarBuses());
		return "buses";
	}
	
	
	//Cuando salga un error de hibernate con insert con nombre en los valores que no existan Alter a la table y colocar ese valor
	@RequestMapping("grabar")
	private String grabar(@RequestParam("codigo") Integer codBus,
						  @RequestParam("placa") String pla,
						  @RequestParam("añoFab") int año,
						  @RequestParam("estado") String est,
						  @RequestParam("color") String col,
						  @RequestParam("marca") Integer codMar,
						  @RequestParam("final") Integer codRuta,
						  RedirectAttributes redirect) {
		try {
			Buses b = new Buses();
			
			if(busesServicio.existePlaca(pla)==1) {
				redirect.addFlashAttribute("MENSAJE","Placa ya está registrada");
				return "redirect:/bus/lista";
			}
			
			b.setNroplaca(pla);
			b.setAniofab(año);
			b.setEstadobus(est);
			b.setColbus(col);
			
			Marca m = new Marca();
			Rutas r = new Rutas();
			
			m.setCodigo(codMar);
			r.setCodigo(codRuta);			
			
			b.setMarca(m);
			b.setRutas(r);
			if(codBus == 0) {
				busesServicio.registarBuses(b);
				for(int i=1; i<=12;i++) {
					Asiento a = new Asiento();
					a.setNumeroAsi(i);
					a.setEstado("Libre");
					
					TipoAsiento ta= new TipoAsiento();
					ta.setCodigo(1);
					a.setTipoAsiento(ta);
					a.setBuses(b);
					
					asientoServicio.registrarAsientos(a);
				}
				for(int i=13; i<=28;i++) {
					Asiento a = new Asiento();
					a.setNumeroAsi(i);
					a.setEstado("Libre");
					
					TipoAsiento ta= new TipoAsiento();
					ta.setCodigo(2);
					a.setTipoAsiento(ta);
					a.setBuses(b);
					
					asientoServicio.registrarAsientos(a);
				}
				for(int i=29; i<=44;i++) {
					Asiento a = new Asiento();
					a.setNumeroAsi(i);
					a.setEstado("Libre");
					
					TipoAsiento ta= new TipoAsiento();
					ta.setCodigo(3);
					a.setTipoAsiento(ta);
					a.setBuses(b);
					
					asientoServicio.registrarAsientos(a);
				}
				redirect.addFlashAttribute("MENSAJE","Bus Registrado");
			}else {
				b.setCodigo(codBus);
				busesServicio.actualizarBuses(b);
				redirect.addFlashAttribute("MENSAJE","Bus Actualizado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
		}
		return "redirect:/bus/lista";
	}
		
	@RequestMapping("buscar")
	@ResponseBody
	private Buses buscarUsuario(@RequestParam("codigo")  Integer cod) {
		return busesServicio.buscarBuses(cod);
	}
	
	@RequestMapping("eliminar")
	private String eliminar(@RequestParam("codigoEliminar") Integer codEli,
										  RedirectAttributes redirect) {
		busesServicio.eliminarBuses(codEli);		
		redirect.addAttribute("MENSAJE","Bus Eliminado");
		return "redirect:/bus/lista";
	}
}
