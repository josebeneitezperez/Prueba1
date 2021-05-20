package curso.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import curso.spring.model.Contacto;

@Service
public class ContactoService {

	private ArrayList<Contacto> listaContactos = listadoContactos();
	
	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}
	
	public void addContacto(Contacto contacto) {
		listaContactos.add(contacto);
	}
	
	public ArrayList<Contacto> listadoContactos() {
		ArrayList<Contacto> listado = new ArrayList<Contacto>();
		Contacto c = new Contacto("Pepe", "Perez", "123123123");
		listado.add(c);
		c = new Contacto("Juan", "Almaraz", "900900900");
		listado.add(c);
		listado.add(new Contacto("Sandra", "Vazquez", "111222333"));
		
		return listado;
	}
	
}
