package curso.spring.controller;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.spring.model.Contacto;
import curso.spring.service.ContactoService;
import curso.spring.service.ContactoService2;

@Controller
@RequestMapping("")
public class ContactoController {

	@Autowired
	private ContactoService2 sc;
	
	@GetMapping("")
	public String index(Model model) {
		//System.out.println("dentro"); 
		//carga de datos inicial
		model.addAttribute("lista", sc.getListaContactos());
		return "index";
	}
	
	@PostConstruct	//cargar al inicio. SOLO al inicio de la app
	public void cargarContactos() {
		sc.addContacto(new Contacto("Pepe", "perez", "555666777"));
		sc.addContacto(new Contacto("Maria", "Hernandez", "555333111"));
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "new";
	}
	
	@PostMapping("/new/submit")		//el del form crear
	public String nuevoSubmit(Model model, @ModelAttribute Contacto contacto) {
		sc.addContacto(contacto);
		//model.addAttribute("lista", sc.getListaContactos());
		//return "index";
		return "redirect:/";
	}
	
	//del/${contact.id}
	@GetMapping("/del/{idString}")
	public String borrar(@PathVariable String idString, Model model) {
		
		sc.borrarContacto(Long.parseLong(idString));
		return "redirect:/"; //"redirect:/new"
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizar(@PathVariable long id, Model model) {
		
		Contacto contacto = sc.obtenerContacto(id);
		model.addAttribute("contacto", contacto);
		
		return "Usuario/actualizar";
	}
	
	@PostMapping("/actualizar/confirmar")
	public String actualizarConfirmar(@ModelAttribute Contacto contacto, Model model) {
		System.out.println(contacto.getId());
		System.out.println(contacto.getNombre());
		
		sc.actualizarContacto(contacto);
		return "redirect:/";
	}
	
}











