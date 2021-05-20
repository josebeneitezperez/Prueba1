package curso.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contactos")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//el (strategy = GenerationType.AUTO) igual sobra
	private long id;
	@Column(name="nombre_contacto") 
	private String nombre;
	private String apellidos;
	private String telefono;

	public Contacto() {
		// telefono = "";
	}

	public Contacto(String nombre, String apellidos, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
