package com.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Asiento;
import com.proyecto.entity.Buses;
import com.proyecto.entity.Cliente;
import com.proyecto.entity.Detalle;
import com.proyecto.entity.Itinerario;
import com.proyecto.entity.PasajeHasAsiento;
import com.proyecto.entity.Pasajes;
import com.proyecto.entity.Usuario;
import com.proyecto.services.AsientoServices;
import com.proyecto.services.AsientoServicesSecundario;
import com.proyecto.services.BusesServices;
import com.proyecto.services.ClienteServices;
import com.proyecto.services.HorariosServices;
import com.proyecto.services.ItinerarioServices;
import com.proyecto.services.PasajeHasAsientoServices;
import com.proyecto.services.PasajesServices;
import com.proyecto.services.TipoAsientoServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pasaje")
public class PasajesController {


	@Autowired
	private PasajesServices pasajeServicio;
	
	@Autowired
	private AsientoServicesSecundario asientoServicioSecundario;
	
	@Autowired
	private AsientoServices asientoServicio;
	
	@Autowired
	private ClienteServices clienteServicio;
	
	@Autowired
	private ItinerarioServices itinerarioServicio;
	
	@Autowired
	private HorariosServices horServicio;
	
	@Autowired
	private TipoAsientoServices tipoAsiServicio;
	
	@Autowired
	private PasajeHasAsientoServices PasajeAsientoServicio;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("pasaj",pasajeServicio.listarPasajes());
		return "pasajes";
	}
	
	@RequestMapping("/venta")
	public String venta(Model model) {
		model.addAttribute("horario", horServicio.listarHorarios());
		model.addAttribute("tipoAsiento", tipoAsiServicio.listarTipoAsiento());
		model.addAttribute("cliente",clienteServicio.listarCliente());
		model.addAttribute("itinerario",itinerarioServicio.listarItinerarios());
		model.addAttribute("pasaj",pasajeServicio.listarPasajes());
		return "ventas";
	}
	
	//-----CLIENTE------//
	@RequestMapping("/listaClienteJSON")
	@ResponseBody
	public List<Cliente> listaClienteJSON(){
		return clienteServicio.listarCliente();
	}
	
	@RequestMapping("/listaClienteNombreJSON")
	@ResponseBody
	public List<Cliente> listaClienteNombreJSON(@RequestParam("nombre") String nom){
		return clienteServicio.buscarClienteNombre(nom);
	}
	
	@RequestMapping("/listaClienteDniJSON")
	@ResponseBody
	public List<Cliente> listaClienteDniJSON(@RequestParam("dni") int dni){
		return clienteServicio.buscarClienteDNI(dni);
	}
	
	@RequestMapping("/consultaClientes")
	@ResponseBody
	public List<Cliente> consultaClientes(@RequestParam("nombre") String nom,
											@RequestParam("dni") int dni){
		return clienteServicio.consultaClientes(nom,dni);
	}
	
	//-----FIN CLIENTE------//

	//-----ASIENTOS------//
	@RequestMapping("/ListarAsientosxPlacaJSON")
	@ResponseBody
	public List<Asiento> ListarAsientosxPlacaJSON(String placa,
			RedirectAttributes redirect){
		if (placa == null) {
	        redirect.addFlashAttribute("MENSAJE", "Ingrese una placa");
	        // Redirigir a la página de error o a la página principal
	        return null; // o lanza una excepción, dependiendo del flujo de tu aplicación
	    } else {
	        return asientoServicio.listarAsientosXPlaca(placa);
	    }
	}
	//-----FIN ASIENTOS------//
	
	
	//-----ITINERARIO------//
	@RequestMapping("/ListarItinerarioJSON")
	@ResponseBody
	public List<Itinerario> ListarItinerariosJSON(){
		return itinerarioServicio.listarItinerarios();
	}
	@RequestMapping("/ConsultaItinerarioInicio")
	@ResponseBody
	public List<Itinerario> ConsultaItinerarioInicio(@RequestParam("inicio") String ini){
		return itinerarioServicio.buscarItinerarioPorInicio(ini);
	}
	
	@RequestMapping("/ConsultaItinerarioFinal")
	@ResponseBody
	public List<Itinerario> ConsultaItinerarioFinal(@RequestParam("final") String fin){
		return itinerarioServicio.buscarItinerarioPorFinal(fin);
	}
	
	@RequestMapping("/ConsultaItinerarioHora")
	@ResponseBody
	public List<Itinerario> ConsultaItinerarioHora(@RequestParam("hora") int codHora){
		return itinerarioServicio.buscarItinerarioPorHora(codHora);
	}
	@RequestMapping("/ConsultaItinerarioInicioFinal")
	@ResponseBody
	public List<Itinerario> ConsultaItinerarioInicioFinal(@RequestParam("inicio") String ini,
															@RequestParam("final") String fin){
		return itinerarioServicio.buscarItinerarioPorInicioFinal(ini,fin);
	}
	@RequestMapping("/ConsultaItinerarioInicioHora")
	@ResponseBody
	public List<Itinerario> ConsultaItinerarioInicioHora(@RequestParam("inicio") String ini,
														@RequestParam("hora") int codHora){
		return itinerarioServicio.buscarItinerarioPorInicioHora(ini,codHora);
	}
	
	@RequestMapping("/ConsultaItinerario")
	@ResponseBody
	public List<Itinerario> ConsultaItinerario(@RequestParam("inicio") String ini,
											@RequestParam("final") String fin,
											@RequestParam("hora") int codHora){
		return itinerarioServicio.listarItinerarioXRutaXhorario(ini,fin,codHora);
	}	
	
	//-----FIN ITINERARIO------//
	
	//-----ADICIONAR-----//
	@RequestMapping("adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,
								 @RequestParam("numAsiento") int nroAsi,
								 @RequestParam("tipo") String tipoAsi,
								 @RequestParam("precio") double pre,
								 HttpSession session){
		List<Detalle> lista=null;
		try {
			if(session.getAttribute("data")==null)
				lista=new ArrayList<Detalle>();
			else
				lista = (List<Detalle>) session.getAttribute("data"); 
			
				Detalle d = new Detalle();
				d.setCodigo(cod);
				d.setNumAsiento(nroAsi);
				d.setTipoAsiento(tipoAsi);
				d.setPrecio(pre);
				
				lista.add(d);
				
			session.setAttribute("data",lista);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return lista;
	}
	//-----FIN ADICIONAR-----//
	
	//-----ELIMINAR-----//
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo") int cod,
						HttpSession session) {
		List<Detalle> datos= (List<Detalle>) session.getAttribute("data");
		try {
			for(Detalle d:datos) {
				if(d.getCodigo()==cod) {
					datos.remove(d);
					break;
				}
			}
			session.setAttribute("data",datos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datos;
	}
	
	//-----FIN ELIMINAR-----//
	
	//-----GRABAR-----//
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigoCliente") int cliente,
						@RequestParam("codigoItinerario") int itinerario,
						@RequestParam("importe") String monto,
						@SessionAttribute("CODIGO_USUARIO") int codUsu,
						HttpSession session,
						RedirectAttributes redirect){
		try {
			//crear objeto de la entidad Boleta
			Pasajes pas= new Pasajes();
			Date currentDate = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String day = dateFormat.format(currentDate);

			pas.setMonto(Double.parseDouble(monto));
			pas.setDia(new SimpleDateFormat("yyyy-MM-dd").parse(day));
			
			Usuario u = new Usuario();
			Itinerario i = new Itinerario();			
			Cliente c = new Cliente();
			u.setCodigo(codUsu);
			i.setCodigoBH(itinerario);
			c.setCodigo(cliente);
			pas.setUsuario(u);
			pas.setItinerario(i);
			pas.setCliente(c);
			
			List<PasajeHasAsiento> lista =new ArrayList<PasajeHasAsiento>();
			List<Detalle> datos= (List<Detalle>) session.getAttribute("data");
			//bucle para realizar 
			for(Detalle det:datos) {
				PasajeHasAsiento pha= new PasajeHasAsiento();
				Asiento asi = asientoServicio.buscarAsientosID(det.getCodigo());
				asi.setCodigo(det.getCodigo());
				asi.setEstado("Vendido");
				pha.setAsiento(asi);
				pha.setPrecio(det.getPrecio());
				
				asientoServicio.actualizarAsientos(asi);
				lista.add(pha);
			}
			pas.setListaPasajesAsiento(lista);
			pasajeServicio.registrar(pas);
			redirect.addFlashAttribute("MENSAJE","Venta Exitosa");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la Venta");
		}
		return "redirect:/pasaje/venta";
	}
	//-----FIN GRABAR-----//
//	PasajeAsientoServicio
	@RequestMapping("buscarPasaje")
	@ResponseBody
	private Pasajes buscarPasaje(@RequestParam("codigo") Integer cod) {
		return pasajeServicio.listarPasajesPorID(cod);
	}	
	/*
	@RequestMapping("buscarAsientos")
	@ResponseBody
	private List<Detalle> buscarAsientos(@RequestParam("codigo") int cod) {
		return pasajeServicio.listarAsientosP(cod);
	}*/
	
	@RequestMapping("pruebas")
	@ResponseBody
	private List<PasajeHasAsiento> prueba(@RequestParam("codigo") int cod){
		return PasajeAsientoServicio.listarA(cod);
	}
}






















