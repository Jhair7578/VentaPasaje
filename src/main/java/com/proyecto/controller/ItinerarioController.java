package com.proyecto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Buses;
import com.proyecto.entity.Horarios;
import com.proyecto.entity.Itinerario;
import com.proyecto.entity.Marca;
import com.proyecto.entity.Rutas;
import com.proyecto.entity.Usuario;
import com.proyecto.services.BusesServices;
import com.proyecto.services.CargoServices;
import com.proyecto.services.HorariosServices;
import com.proyecto.services.ItinerarioServices;
import com.proyecto.services.MarcaServices;
import com.proyecto.services.UsuarioServices;

@Controller
@RequestMapping("/itinerario")
public class ItinerarioController {

	@Autowired
	private ItinerarioServices itiServicio;
	
	@Autowired
	private UsuarioServices usuServicio;
	@Autowired
	private HorariosServices horasServicio;
	@Autowired
	private MarcaServices marcaServicio;
	@Autowired
	private BusesServices busesServicioHH;
	@Autowired
	private CargoServices cargoServicio;
	
	@RequestMapping("/listaUno")
	private String lista1(Model model) {		
		model.addAttribute("bhh", itiServicio.listarItinerarios());
		model.addAttribute("horario", horasServicio.listarHorarios());
		model.addAttribute("usuarioU", usuServicio.listaChoferesSeis());
		model.addAttribute("cargo", cargoServicio.listarCargo());
		model.addAttribute("marca", marcaServicio.listaMarcas());
		model.addAttribute("buse", busesServicioHH.listarBuses());
		return "itinerario";
	}
	@RequestMapping("/consultaBuses")
	@ResponseBody
	public List<Buses> consultaBusesHH(@RequestParam("placa")String np){
		return busesServicioHH.listarBusesUno(np);
	}
	
	@RequestMapping("/consultaMarca")
	@ResponseBody
	public List<Buses> consultaBusesMarca(@RequestParam("codigoMarca")int cod){
		return busesServicioHH.listaBM(cod);
	}
	@RequestMapping("/consultaChofer")
	@ResponseBody
	public List<Usuario> consultaChoferHH(@RequestParam("nombre")String n){
		return usuServicio.listarUsuarioUno(n);
	}
	@RequestMapping("/consultaBrevete")
	@ResponseBody
	public List<Usuario> consultaBrevete(@RequestParam("codigoBrevete")int cb){
		return usuServicio.listaCodigoBrevete1(cb);
	}
	//Cuando salga un error de hibernate con insert con nombre en los valores que no existan Alter a la table y colocar ese valor
		@RequestMapping("/grabarDos")
		private String grabarHH(@RequestParam("codigoBH") Integer codBH,
								  @RequestParam("codigoBus") int codBus,
								  @RequestParam("horas") int hrs,
								  @RequestParam("dia") String dia,
								  @RequestParam("codigoChofer") int codChofer,	 								RedirectAttributes redirect) {
			try {
				Itinerario i = new Itinerario();
				
				Buses b = busesServicioHH.buscarBuses(codBus);
				
				Horarios h=new Horarios();
				h.setCodigo(hrs);
				
				i.setDia(LocalDate.parse(dia));
				
				Usuario u=new Usuario();
				u.setCodigo(codChofer);
				
				
				i.setBuses(b);
				i.setHorario(h);
				i.setUsuarioU(u);
				 
				
				if(codBH == 0) {
					itiServicio.registarItinerario(i);
					redirect.addFlashAttribute("MENSAJE","Itinerario Registrado");
				}else {
					i.setCodigoBH(codBH);
					itiServicio.actualizarItinerario(i);
					redirect.addFlashAttribute("MENSAJE","Itinerario Actualizado");
				}
				 // Cambiar el estado del bus
		        b.setEstadobus("En Uso"); // Reemplaza "Nuevo estado" con el estado deseado
		        
		        // Guardar los cambios en el estado del bus
		        busesServicioHH.actualizarBuses(b);
			} catch (Exception e) {
				e.printStackTrace();
				redirect.addFlashAttribute("MENSAJE","ERROR EN EL REGISTRO");
			}
			return "redirect:/itinerario/listaUno";
		}
			
		@RequestMapping("buscarDos")
		@ResponseBody
		private Itinerario buscarUsuario(@RequestParam("codigoBH")  Integer cod) {
			return itiServicio.buscarItinerario(cod);
		}
		
		@RequestMapping("eliminarDos")
		private String eliminar(@RequestParam("codigoEliminar") Integer codEli,
											  RedirectAttributes redirect) {
			itiServicio.eliminarItinerario(codEli);
			redirect.addAttribute("MENSAJE","Bus Eliminado");
			return "redirect:/itinerario/listaUno";
		}
		@RequestMapping("usu")
		@ResponseBody
		public List<Usuario>  listarChoferesUno() {
			return usuServicio.listaChoferesSeis();
		}	
}
