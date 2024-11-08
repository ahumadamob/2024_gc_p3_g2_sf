package imb.progra3.grupo2.entity;

	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

	@Entity
	public class MedioDePago extends BaseEntity{
	    
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
	    

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public String getTipo() {
	        return tipo;
	    }

	    

		public void setId(Long id) {
			// TODO Auto-generated method stub
			
		}

		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

	}


