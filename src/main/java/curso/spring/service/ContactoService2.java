package curso.spring.service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.model.Contacto;
import curso.spring.repository.ContactoRepository;

@Service
public class ContactoService2 {

    @Autowired
    private ContactoRepository contactoRepository;

    public Iterable getListaContactos() {
        return contactoRepository.findAll();
    }

    public void addContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
    
    public void borrarContacto(long id) {
    	
    	contactoRepository.deleteById(id);
    }
    
    public Contacto obtenerContacto(long id) {
    	return contactoRepository.findById(id); //NUNCA DEVOLVERÁ NULL
    }
    
    public Contacto actualizarContacto(Contacto contacto) {
    	return contactoRepository.save(contacto);
    }
    
    /*
	public ArrayList<Contacto> listadoContactos() {
		ArrayList<Contacto> listado = new ArrayList<Contacto>();
		Contacto c = new Contacto("Pepe", "Perez", "123123123");
		listado.add(c);
		c = new Contacto("Juan", "Almaraz", "900900900");
		listado.add(c);
		listado.add(new Contacto("Sandra", "Vazquez", "111222333"));
		
		return listado;
	}
	*/
	
}
