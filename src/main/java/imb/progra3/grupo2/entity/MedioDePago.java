package imb.progra3.grupo2.entity;

	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

	@Entity
	@Table(name = "mediodepago")
	public class MedioDePago {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_MediodePago")
	    private Long id_MediodePago;
	    @NotBlank(message = "El nombre del medio de pago es obligatorio")
	    
	    @Column (name = "nombre")
	    private String nombre;
	    
	    @Column (name = "tipo")
	    private String tipo;
	    

	    // Constructor vacío requerido por JPA
	    public MedioDePago() {
	    }

	    // Constructor con parámetros
	    public MedioDePago(String nombre) {
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
	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }
	    // Método toString para representación de cadena
	    @Override
	    public String toString() {
	        return "MedioDePago{" +
	                "id_MedioDePago=" + id_MediodePago +
	                ", nombre='" + nombre + '\'' +
	                '}';
	    }

		public void setId(Long id) {
			// TODO Auto-generated method stub
			
		}

		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

	}


