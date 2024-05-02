package imb.progra3.grupo2.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity
	public class Cliente {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_Cliente;
	    private String nombre;
	    private String apellido;
	    private String telefono;
	    private String email;

	    // Constructor vacío requerido por JPA
	    public Cliente() {
	    }

	    // Constructor con parámetros
	    public Cliente(String nombre, String apellido, String telefono, String email) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.telefono = telefono;
	        this.email = email;
	    }

	    // Getters y setters
	    public Long getId_Cliente() {
	        return id_Cliente;
	    }

	    public void setId_Cliente(Long id_Cliente) {
	        this.id_Cliente = id_Cliente;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Método toString para representación de cadena
	    @Override
	    public String toString() {
	        return "Cliente{" +
	                "id_Cliente=" + id_Cliente +
	                ", nombre='" + nombre + '\'' +
	                ", apellido='" + apellido + '\'' +
	                ", telefono='" + telefono + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
	}


