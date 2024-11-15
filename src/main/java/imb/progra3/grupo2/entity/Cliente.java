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
	    private String domicilio;
	    private Integer codigoPostal;

	    private boolean enabled;  // Agregar esta propiedad

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

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		public Integer getCodigoPostal() {
			return codigoPostal;
		}

		public void setCodigoPostal(Integer codigoPostal) {
			this.codigoPostal = codigoPostal;
		}
	    
		public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        
	    
	this.enabled = enabled;
	    
	    }
	    
	}


