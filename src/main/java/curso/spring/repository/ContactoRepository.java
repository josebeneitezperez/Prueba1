package curso.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import curso.spring.model.Contacto;

public interface ContactoRepository extends CrudRepository<Contacto, Long> {

	public Contacto findByNombre(String nombre);
	//..ById existe, byNombre no, ¿lo de arriba funciona?
	
	public Contacto findById(long id);
	
	//public List<Contacto> findAllByNombre(String nombre);
}
