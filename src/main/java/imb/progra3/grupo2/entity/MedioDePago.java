package imb.progra3.grupo2.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity
	public class MedioDePago {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_MedioDePago;
	    private String nombre;

	    // Constructor vacío requerido por JPA
	    public MedioDePago() {
	    }

	    // Constructor con parámetros
	    public MedioDePago(String nombre) {
	        this.nombre = nombre;
	    }

	    // Getters y setters
	    public Long getId_MedioDePago() {
	        return id_MedioDePago;
	    }

	    public void setId_MedioDePago(Long id_MedioDePago) {
	        this.id_MedioDePago = id_MedioDePago;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    // Método toString para representación de cadena
	    @Override
	    public String toString() {
	        return "MedioDePago{" +
	                "id_MedioDePago=" + id_MedioDePago +
	                ", nombre='" + nombre + '\'' +
	                '}';
	    }

		public void setId(Long id) {
			// TODO Auto-generated method stub
			
		}

	}


