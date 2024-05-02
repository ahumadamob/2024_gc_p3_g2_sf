package imb.progra3.grupo2.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity
	public class MediodePago {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_MediodePago;
	    private String nombre;

	    // Constructor vacío requerido por JPA
	    public MediodePago() {
	    }

	    // Constructor con parámetros
	    public MediodePago(String nombre) {
	        this.nombre = nombre;
	    }

	    // Getters y setters
	    public Long getId_MedioDePago() {
	        return id_MediodePago;
	    }

	    public void setId_MedioDePago(Long id_MediodePago) {
	        this.id_MediodePago = id_MediodePago;
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
	        return "MediodePago{" +
	                "id_MediodePago=" + id_MediodePago +
	                ", nombre='" + nombre + '\'' +
	                '}';
	    }
	}


